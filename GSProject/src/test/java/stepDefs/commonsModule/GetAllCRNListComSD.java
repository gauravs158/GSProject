package stepDefs.commonsModule;

import java.util.HashMap;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.Heart;

public class GetAllCRNListComSD {
	String authToken;
	Heart heart;
	HashMap<String, String> paramMap = new HashMap<>();
	String commonGetCRNListPathParam = "govtapi/v1.0/caselst";
	public GetAllCRNListComSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}
	
	@Given("^the user create CommonAPIAllCRNList parameter list with (.+), (.+), (.+), (.+), (.+), (.+)$")
	public void createParamMapping(String state_cd, String start_tm, String end_tm, String action, String iseod, String casetyp) {
		paramMap.put("state_cd", state_cd);
		paramMap.put("start_tm", start_tm);
		paramMap.put("end_tm", end_tm);
		paramMap.put("action", action);
		paramMap.put("iseod", iseod);
		paramMap.put("casetyp", casetyp);
	}

	@When("the user hits GetAllCRNList")
	public void the_user_hits_GetCRNListAPI() {
		heart.response = heart.blood.getAllCRNListOpsObject().getAllCRNListResponse(heart.govtAuthToken, paramMap, commonGetCRNListPathParam, heart);
	}
	
	@And("the user gets success statusCode on CommonAPIAllCRNList")
	public void the_user_validates_the_statusCode() {	
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
