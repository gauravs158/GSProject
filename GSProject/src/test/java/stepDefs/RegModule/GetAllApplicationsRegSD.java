package stepDefs.RegModule;

import java.util.HashMap;
import java.util.Map;
import io.cucumber.java.en.*;
import utils.Heart;

public class GetAllApplicationsRegSD {
	Map<String, String> header = new HashMap<>() ;
	String authToken;
	String GetAllAppPathParam = "govtapi/v2.0/application";
	Heart heart;
	public GetAllApplicationsRegSD(Heart heart) {
		this.heart = heart;
	}

	@When("the user hits GetAllApplication")
	public void the_user_hits_get_all_application_api() {
		heart.response = heart.blood.getGetAlertRegOpsObject().getRegAlertResponse(heart.govtAuthToken, GetAllAppPathParam, heart);
		System.out.println("In SD");
		}
//	}
	
}
