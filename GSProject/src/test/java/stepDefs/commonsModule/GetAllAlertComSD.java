package stepDefs.commonsModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.Heart;

public class GetAllAlertComSD {
	
	String authToken;
	HashMap<String, String> paramMap = new HashMap<>();
	String commonGetAllAlertPathParam = "govtapi/v1.0/case";
	Heart heart;
	public GetAllAlertComSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}
	
	@Given("^the user create CommonAPIAlerts parameter list with (.+), (.+), (.+), (.+), (.+)$")
	public void createParamMapping(String state_cd, String start_tm, String end_tm, String action, String iseod) {
		paramMap.put("state_cd", state_cd);
		paramMap.put("start_tm", start_tm);
		paramMap.put("end_tm", end_tm);
		paramMap.put("action", action);
		paramMap.put("iseod", iseod);
	}
	
	@When("the user hits GetAllAlertComAPI")
	public void the_user_hits_GetAllAlertCom_api() {
		heart.response = heart.blood.getGetAllAlertComOpsObject().getAllAlertResponse(heart.govtAuthToken, paramMap, commonGetAllAlertPathParam, heart);
	}
	
	@And("the user gets success on GetAllAlertCom")
	public void the_user_validates_the_fileCount() {	
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
	
}
