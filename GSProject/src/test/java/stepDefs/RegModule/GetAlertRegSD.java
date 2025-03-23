package stepDefs.RegModule;

import io.cucumber.java.en.*;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetAlertRegSD {
	String authToken;
	String url;
	Heart heart;
	GSTProjectUtils gstpu;
	public GetAlertRegSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
	}
	
	@Given("the user has the authToken")
	public void the_user_has_the_auth_token() {
		authToken = heart.govtAuthToken;
	}

	@Given("the user has the url")
	public void the_user_has_the_url() {
	}

	@When("the user hits GetAlertAPI")
	public void the_user_hits_get_alert_api() {
		heart.response = heart.blood.getGetAlertRegOpsObject().getRegAlertResponse(authToken, url, heart);
		System.out.println("In SD");
	}

	@Then("the user gets success statusCode")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
	
}
