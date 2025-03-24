package stepDefs.RegModule;

import io.cucumber.java.en.*;
import utils.Heart;

public class GetEntityRegSD {
	String authToken;
	Heart heart;
	String GetEntityPathParam = "govtapi/v1.1/entity";
	public GetEntityRegSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}

	@When("the user hits GetEntityAPI")
	public void the_user_hits_get_entity_api() {
		heart.response = heart.blood.getGetEntityOpsObject().getEntityResponse(heart.govtAuthToken, GetEntityPathParam, heart);
		System.out.println("In SD");
	}
	
}
