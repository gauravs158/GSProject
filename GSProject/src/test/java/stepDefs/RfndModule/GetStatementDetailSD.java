package stepDefs.RfndModule;

import java.util.HashMap;

import io.cucumber.java.en.*;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetStatementDetailSD {
	String getStatementDetailPath = "govtapi/v0.1/refunds";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> paramMap = new HashMap<>();
	public GetStatementDetailSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has GetStatementDetail authToken")
	public void the_user_has_GetStatementDetail_authToken() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@Given("^the user create GetStatementDetail parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String stcd, String arn, String action) {
		paramMap.put("stcd", stcd);
		paramMap.put("arn", arn);
		paramMap.put("action", action);
	}

	@When("the user hits GetStatementDetail")
	public void the_user_hits_get_statement_detail_api() {
		heart.response = heart.blood.getStatementDetailOpsObject().getStatementDetailResponse(govtAuthToken, paramMap, getStatementDetailPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets GetStatementDetail success statusCode")
	public void the_user_gets_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
	
}