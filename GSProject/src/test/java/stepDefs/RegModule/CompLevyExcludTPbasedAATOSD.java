package stepDefs.RegModule;

import java.util.HashMap;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class CompLevyExcludTPbasedAATOSD {

	String getCompLevyExcludTPbasedAATOPath = "govtapi/v1.0/compositionwithdraw";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> CompLevyExcludTPbasedAATOMap = new HashMap<>();
	public CompLevyExcludTPbasedAATOSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has CompLevyExcludTPbasedAATO authToken")
	public void the_user_has_CompLevyExcludTPbasedAATO_auth_token() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@And("^the user create CompLevyExcludTPBasedAATO parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String arn, String action) {
		CompLevyExcludTPbasedAATOMap.put("state_cd", state_cd);
		CompLevyExcludTPbasedAATOMap.put("arn", arn);
		CompLevyExcludTPbasedAATOMap.put("action", action);
	}

	@When("the user hits CompLevyExcludTPBasedAATO API")
	public void the_user_hits_CompLevyExcludTPBasedAATO_api() {
		heart.response = heart.blood.getCompLevyExcludTPBasedAATORegOpsObject().compLevyExcludTPBasedAATOResponse(govtAuthToken, CompLevyExcludTPbasedAATOMap, getCompLevyExcludTPbasedAATOPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets CompLevyExcludTPbasedAATO success statusCode")
	public void the_user_gets_CompLevyExcludTPbasedAATO_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
