package stepDefs.RegModule;

import java.util.HashMap;
import io.cucumber.java.en.*;
import utils.Heart;

public class GetAllApplicationsRegSD {
	HashMap<String, String> parameterMapping = new HashMap<>() ;
	String authToken;
	String GetAllAppPathParam = "govtapi/v2.0/application";
	Heart heart;
	public GetAllApplicationsRegSD(Heart heart) {
		System.out.println("GetAllApplicationsRegSD constructor");
		this.heart = heart;
	}
	
	@And("^the user create GetAllApplicationRequests parameter list with (.+), (.+), (.+), (.+), (.+)$")
	public void create_GetAllApplicationRequests_parameter_list(String state_cd, String start_tm, String end_tm, String aplty, String action) {
		parameterMapping.put("state_cd", state_cd);
		parameterMapping.put("start_tm", start_tm);
		parameterMapping.put("end_tm", end_tm);
		parameterMapping.put("aplty", aplty);
		parameterMapping.put("action", action);
	}

	@When("the user hits GetAllApplication")
	public void the_user_hits_get_all_application_api() {
		System.out.println("the_user_hits_get_all_application_api method");
		heart.response = heart.blood.getGetAllApplOpsObject().getRegAllApplResponse(heart.govtAuthToken, parameterMapping, GetAllAppPathParam, heart);
		System.out.println("In SD");
		}	

	@Then("the user gets success statusCode for GetAllApplicationRequests API")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
