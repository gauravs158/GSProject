package stepDefs.commonsModule;

import io.cucumber.java.en.*;
import utils.Heart;

public class GetAllAlertComSD {
	
	String authToken;
	String url;
	String commonGetAllAlertPathParam = "govtapi/v1.0/case";
	Heart heart;
	public GetAllAlertComSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}
	@When("the user hits GetAllAlertComAPI")
	public void the_user_hits_GetAllAlertCom_api() {
//		heart.response = heart.blood.getGetEntityOpsObject().getEntityResponse(heart.govtAuthToken, commonGetAllAlertPathParam, heart);
	}
	
}
