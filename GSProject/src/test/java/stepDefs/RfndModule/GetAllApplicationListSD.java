package stepDefs.RfndModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetAllApplicationListSD {
	String getAllApplicationListPath = "govtapi/v2.0/refunds";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> paramMap = new HashMap<>();
	public GetAllApplicationListSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has refund authToken")
	public void the_user_has_refund_authToken() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@Given("^the user create GetAllApplicationList parameter list with (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String stcd, String start_tm, String end_tm, String action) {
		paramMap.put("stcd", stcd);
		paramMap.put("start_tm", start_tm);
		paramMap.put("end_tm", end_tm);
		paramMap.put("action", action);
	}

	@When("the user hits GetAllApplicationList")
	public void the_user_hits_get_all_application_list_api() {
		heart.response = heart.blood.getAllApplicationListOpsObject().getAllApplicationListResponse(govtAuthToken, paramMap, getAllApplicationListPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets refund success statusCode")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
	
}