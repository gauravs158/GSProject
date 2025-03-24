package stepDefs.commonsModule;

import io.cucumber.java.en.When;
import utils.Heart;

public class GetAllCRNListComSD {
	String authToken;
	String url;
	Heart heart;
	String commonGetCRNListPathParam = "govtapi/v1.0/caselst";
	public GetAllCRNListComSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
		this.authToken = heart.govtAuthToken;
	}

	@When("the user hits GetAllCRNList")
	public void the_user_hits_GetCRNListAPI() {
		heart.response = heart.blood.getAllCRNListOpsObject().getAllCRNListResponse(heart.govtAuthToken, commonGetCRNListPathParam, heart);
	}
}
