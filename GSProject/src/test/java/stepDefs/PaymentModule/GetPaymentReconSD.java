package stepDefs.PaymentModule;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.Heart;

public class GetPaymentReconSD {
	String authToken;
	HashMap<String, String> PayFileCountMap = new HashMap<>();
	Heart heart;
	String pathParam = "govtapi/v1.0/payment";
	Map<String, String> paramsMap = new HashMap<String, String>();
	Response response;
	public GetPaymentReconSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create PaymentGetPaymentRecon parameter list with (.+), (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String file_type, String date, String state_cd, String file_num, String action) {
		PayFileCountMap.put("file_type", file_type);
		PayFileCountMap.put("date", date);
		PayFileCountMap.put("state_cd", state_cd);
		PayFileCountMap.put("file_num", file_num);
		PayFileCountMap.put("action", action);
	}

	@When("the user hits PaymentGetPaymentReconAPI")
	public void the_user_hits_get_file_count_api() {
		heart.response = heart.blood.getPaymentGetFileDetailsOpsObject().getPaymentGetFileDetailsResponse(heart.govtAuthToken, PayFileCountMap, pathParam, heart);
	}
	
	@And("the user validates the success status code for PaymentGetPaymentReconAPI")
	public void the_user_validates_the_fileCount() {	
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}

}
