package stepDefs.RfndModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetBankValidationStatusSD {
	String getBankValidationStatusPath = "govtapi/v3.0/refunds";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> paramMap = new HashMap<>();
	public GetBankValidationStatusSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has GetBankValidationStatus authToken")
	public void the_user_has_GetBankValidationStatus_authToken() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@Given("^the user create GetBankValidationStatus parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String stcd, String crn, String action) {
		paramMap.put("stcd", stcd);
		paramMap.put("crn", crn);
		paramMap.put("action", action);
	}

	@When("the user hits GetBankValidationStatus")
	public void the_user_hits_get_all_application_list_api() {
		heart.response = heart.blood.getBankValidationStatusOpsObject().getBankValidationStatusResponse(govtAuthToken, paramMap, getBankValidationStatusPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets GetBankValidationStatus success statusCode")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
	
}