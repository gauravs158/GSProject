package stepDefs.RegModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.Heart;

public class GetEntityRegSD {
//	String authToken;
	HashMap<String, String> parameterMapping = new HashMap<>() ;
	Heart heart;
	String GetEntityPathParam = "govtapi/v1.1/entity";
//	public GetEntityRegSD(Heart heart) {
//		this.heart = heart;
//		this.authToken = heart.govtAuthToken;
//	}
	
	@And("^the user create GetEntity parameter list with (.+), (.+), (.+), (.+)$")
	public void create_GetAllApplicationRequests_parameter_list(String state_cd, String idty, String id, String action) {
		parameterMapping.put("state_cd", state_cd);
		parameterMapping.put("idty", idty);
		parameterMapping.put("id", id);
		parameterMapping.put("action", action);
	}

	@When("the user hits GetEntityAPI")
	public void the_user_hits_get_entity_api() {
		heart = Heart.returnHeartObject();
		System.out.println("heart object reference value in getEntity is : "+heart);
		heart.response = heart.blood.getGetEntityOpsObject().getEntityResponse(heart.govtAuthToken, parameterMapping, GetEntityPathParam, heart);
		System.out.println("In SD");
	}

	@Then("the user gets success statusCode for GetEntityAPI")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
	
}
