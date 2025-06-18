package stepDefs.TransitionModule;

import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetTranCaseDetailsSD {
	Heart heart;
	GSTProjectUtils gstpu;
	String authToken;
	HashMap<String, String> paramMap = new HashMap<>();
	String getReturnFileCountPath = "govtapi/v1.1/tran/getTranDetails";
	public GetTranCaseDetailsSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create GetTranCaseDetails parameter list with (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String stateCd, String crn, String caseTypeCd, String action) {
		paramMap.put("stateCd", stateCd);
		paramMap.put("crn", crn);
		paramMap.put("caseTypeCd", caseTypeCd);
		paramMap.put("action", action);
	}
	
	@When("the user hits GetTranCaseDetailsAPI")
	public void the_user_hits_GetReturnFileCountAPI() {
		heart.response = heart.blood.getGetReturnFileCountOpsObject().getReturnFileCountResponse(authToken, paramMap, getReturnFileCountPath, heart);
		System.out.println("In SD");		
	}
	
	@Then("the user receives success statusCode for GetTranCaseDetailsAPI")
	public void the_user_receives_success_statusCode() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}

}
