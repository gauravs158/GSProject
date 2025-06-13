package stepDefs.RegModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetAlertRegSD {
	String getAlertPath = "govtapi/v0.2/alert";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> alertMap = new HashMap<>();
	public GetAlertRegSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has the authToken")
	public void the_user_has_the_auth_token() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@Given("^the user create alert parameter list with (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String start_tm, String end_tm, String action) {
		alertMap.put("state_cd", state_cd);
		alertMap.put("start_tm", start_tm);
		alertMap.put("end_tm", end_tm);
		alertMap.put("action", action);
	}

	@When("the user hits GetAlertAPI")
	public void the_user_hits_get_alert_api() {
		heart.response = heart.blood.getGetAlertRegOpsObject().getRegAlertResponse(govtAuthToken, alertMap, getAlertPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets success statusCode")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
	
}
