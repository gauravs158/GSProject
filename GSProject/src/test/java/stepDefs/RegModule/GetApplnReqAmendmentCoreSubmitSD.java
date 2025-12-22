package stepDefs.RegModule;

import java.util.HashMap;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetApplnReqAmendmentCoreSubmitSD {
	String getApplnReqAmendmentCoreSubmitPath = "govtapi/v1.0/application";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> GetApplnReqAmendmentCoreSubmitMap = new HashMap<>();
	public GetApplnReqAmendmentCoreSubmitSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has GetApplnReqAmendmentCoreSubmit authToken")
	public void the_user_has_GetApplnReqAmendmentCoreSubmit_auth_token() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@And("^the user create GetApplnReqAmendmentCoreSubmit parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String arn, String action) {
		GetApplnReqAmendmentCoreSubmitMap.put("state_cd", state_cd);
		GetApplnReqAmendmentCoreSubmitMap.put("arn", arn);
		GetApplnReqAmendmentCoreSubmitMap.put("action", action);
	}

	@When("the user hits GetApplnReqAmendmentCoreSubmit API")
	public void the_user_hits_CompLevyExcludTPBasedAATO_api() {
		heart.response = heart.blood.getApplnReqAmendmentCoreSubmitRegOpsObject().getApplnReqAmendmentCoreSubmitResponse(govtAuthToken, GetApplnReqAmendmentCoreSubmitMap, getApplnReqAmendmentCoreSubmitPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets GetApplnReqAmendmentCoreSubmit success statusCode")
	public void the_user_gets_GetApplnReqAmendmentCoreSubmit_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
