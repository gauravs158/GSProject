package stepDefs.PaymentModule;

import io.cucumber.java.en.*;
import utils.Heart;

public class GetFileCountPaymentSD {
	String authToken;
	String url;
	Heart heart;
	String paymentGetFilePathParam = "govtapi/v0.2/payment";
	public GetFileCountPaymentSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
		this.authToken = heart.govtAuthToken;
	}
	@Given("the paymentuser has the authToken")
	public void the_paymentuser_has_the_auth_token() {
	}

	@When("the user hits PaymentGetFileCountAPI")
	public void the_user_hits_get_file_count_api() {
		heart.response = heart.blood.getPaymentGetFileCountOpsObject().getPaymentGetFileCountResponse(heart.govtAuthToken, paymentGetFilePathParam, heart);
	}
}
