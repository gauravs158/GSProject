package stepDefs.RegModule;

import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetARNUpdateApproveRegSD {
	Heart heart;
	GSTProjectUtils gstpu;
	String authToken;
	HashMap<String, String> paramMap = new HashMap<>();
	String getARNUpdateApprovePath = "govtapi/v0.2/taxpayer";
	public GetARNUpdateApproveRegSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create ApprovedARNUpdate parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String arn, String action) {
		paramMap.put("state_cd", state_cd);
		paramMap.put("arn", arn);
		paramMap.put("action", action);
	}
	
	@When("the user hits ApprovedARNUpdateAPI")
	public void the_user_hits_GetReturnFileCountAPI() {
		heart.response = heart.blood.getGetARNUpdateApproveRegOpsObject().getARNUpdateApproveResponse(authToken, paramMap, getARNUpdateApprovePath, heart);
		System.out.println("In SD");		
	}
	
	@Then("the user receives success statusCode on ApprovedARNUpdateAPI")
	public void the_user_receives_success_statusCode() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}

}
