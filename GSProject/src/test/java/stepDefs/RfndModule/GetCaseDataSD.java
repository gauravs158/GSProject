package stepDefs.RfndModule;

import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetCaseDataSD {
	String getStatementDetailPath = "govtapi/v4.0/refunds";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> paramMap = new HashMap<>();
	public GetCaseDataSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has GetCaseData authToken")
	public void the_user_has_GetCaseData_authToken() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@Given("^the user create GetCaseData parameter list with (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String crn, String itemrefid, String action) {
		paramMap.put("state_cd", state_cd);
		paramMap.put("crn", crn);
		paramMap.put("itemrefid", itemrefid);
		paramMap.put("action", action);
	}

	@When("the user hits GetCaseData")
	public void the_user_hits_get_case_data_api() {
		heart.response = heart.blood.getCaseDataOpsObject().getCaseDataResponse(govtAuthToken, paramMap, getStatementDetailPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets GetCaseData success statusCode")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
