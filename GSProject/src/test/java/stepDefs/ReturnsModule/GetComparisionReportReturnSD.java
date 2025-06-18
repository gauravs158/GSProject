package stepDefs.ReturnsModule;

import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetComparisionReportReturnSD {
	Heart heart;
	GSTProjectUtils gstpu;
	String authToken;
	HashMap<String, String> paramMap = new HashMap<>();
	String getReturnFileCountPath = "govtapi/v2.1/returns/getcompdata";
	public GetComparisionReportReturnSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create ComparisionReport parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String gstin, String fy, String action) {
		paramMap.put("gstin", gstin);
		paramMap.put("fy", fy);
		paramMap.put("action", action);
	}
	
	@When("the user hits GetComparisionReportAPI")
	public void the_user_hits_GetReturnFileCountAPI() {
		heart.response = heart.blood.getGetReturnComparisionReportOpsObject().getReturnComparisionReportResponse(authToken, paramMap, getReturnFileCountPath, heart);
		System.out.println("In SD");		
	}
	
	@Then("the user gets success statusCode for GetComparisionReportAPI")
	public void the_user_receives_success_statusCode() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
