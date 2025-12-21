package stepDefs.RfndModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetAllApplicationDetailsRFD10SD {
	String getAllApplicationdetailsRFD10Path = "govtapi/v0.1/refunds";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> paramMap = new HashMap<>();
	public GetAllApplicationDetailsRFD10SD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has GetAllApplicationDetailsRFD10 authToken")
	public void the_user_has_GetAllApplicationDetailsRFD10_authToken() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@Given("^the user create GetAllApplicationDetailsRFD10 parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String stcd, String arn, String action) {
		paramMap.put("stcd", stcd);
		paramMap.put("arn", arn);
		paramMap.put("action", action);
	}

	@When("the user hits GetAllApplicationDetailsRFD10")
	public void the_user_hits_get_all_application_details_api() {
		heart.response = heart.blood.getAllApplicationDetailsRFD10OpsObject().getAllApplicationDetailsRFD10Response(govtAuthToken, paramMap, getAllApplicationdetailsRFD10Path, heart);
		System.out.println("In SD");
	}

//	@Then("the user gets refund success statusCode")
//	public void the_user_gets_success_status_code() {
//		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
//	}
	
}