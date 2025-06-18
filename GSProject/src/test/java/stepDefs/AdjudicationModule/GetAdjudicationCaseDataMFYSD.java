package stepDefs.AdjudicationModule;

import java.util.HashMap;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetAdjudicationCaseDataMFYSD {
	Heart heart;
	GSTProjectUtils gstpu;
	String authToken;
	HashMap<String, String> paramMap = new HashMap<>();
	String getAdjudicationCaseDataMFYPath = "govtapi/v0.1/adj";
	public GetAdjudicationCaseDataMFYSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create GetCaseDataMFY parameter list with (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String crn, String casetypcd, String action) {
		paramMap.put("state_cd", state_cd);
		paramMap.put("casetypcd", casetypcd);
		paramMap.put("crn", crn);
		paramMap.put("action", action);
	}
	
	@When("the user hits GetCaseDataMFY")
	public void the_user_hits_GetCaseDataMFYAPI() {
		heart.response = heart.blood.getGetAdjudicationCaseDataMFYOpsObject().getAdjudicationCaseDataMFYResponse(authToken, paramMap, getAdjudicationCaseDataMFYPath, heart);
		System.out.println("In SD");		
	}
	
	@Then("the user gets success statusCode for GetCaseDataMFY")
	public void the_user_receives_success_statusCode() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}

}
