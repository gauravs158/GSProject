package stepDefs.PaymentModule;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.Heart;
import java.util.HashMap;
import java.util.Map;

public class GetFileCountPaymentSD {
	String authToken;
	HashMap<String, String> PayFileCountMap = new HashMap<>();
	Heart heart;
	String pathParam = "govtapi/v0.2/payment";
	Map<String, String> paramsMap = new HashMap<String, String>();
	Response response;
	public GetFileCountPaymentSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create PaymentGetFileCount parameter list with (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String file_type, String date, String state_cd, String action) {
		PayFileCountMap.put("file_type", file_type);
		PayFileCountMap.put("date", date);
		PayFileCountMap.put("state_cd", state_cd);
		PayFileCountMap.put("action", action);
	}

	@When("the user hits PaymentGetFileCountAPI")
	public void the_user_hits_get_file_count_api() {
		heart.response = heart.blood.getPaymentGetFileDetailsOpsObject().getPaymentGetFileDetailsResponse(heart.govtAuthToken, PayFileCountMap, pathParam, heart);
	}
	
	@And("the user validates the fileCount")
	public void the_user_validates_the_fileCount() {	
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
