package stepDefs.RfndModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetAllApplicationDetailsSD {
	String getAllApplicationdetailsPath = "govtapi/v2.0/refunds";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> paramMap = new HashMap<>();
	public GetAllApplicationDetailsSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has GetAllApplicationDetails authToken")
	public void the_user_has_GetAllApplicationDetails_authToken() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@Given("^the user create GetAllApplicationDetails parameter list with (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String stcd, String arn, String formtype, String action) {
		paramMap.put("stcd", stcd);
		paramMap.put("arn", arn);
		paramMap.put("formtype", formtype);
		paramMap.put("action", action);
	}

	@When("the user hits GetAllApplicationDetails")
	public void the_user_hits_get_all_application_details_api() {
		heart.response = heart.blood.getAllApplicationDetailsOpsObject().getAllApplicationDetailsResponse(govtAuthToken, paramMap, getAllApplicationdetailsPath, heart);
		System.out.println("In SD");
	}

//	@Then("the user gets refund success statusCode")
//	public void the_user_gets_success_status_code() {
//		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
//	}
	
}