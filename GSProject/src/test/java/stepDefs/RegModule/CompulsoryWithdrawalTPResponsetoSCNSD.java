package stepDefs.RegModule;

import java.util.HashMap;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class CompulsoryWithdrawalTPResponsetoSCNSD {
	String compulsoryWithdrawalTPResponsetoSCNPath = "govtapi/v0.2/application";
	Heart heart;
	GSTProjectUtils gstpu;
	String govtAuthToken;
	HashMap<String, String> compulsoryWithdrawalTPResponsetoSCNMap = new HashMap<>();
	public CompulsoryWithdrawalTPResponsetoSCNSD() {
		this.heart = Heart.returnHeartObject();
	}
	
	@Given("the user has CompulsoryWithdrawalTPResponsetoSCN authToken")
	public void the_user_has_CompulsoryWithdrawalTPResponsetoSCN_auth_token() {
		System.out.println("heart object reference value is : "+heart);
		govtAuthToken = heart.govtAuthToken;
		System.out.println("Govt Auth token issss: "+ govtAuthToken);
	}

	@And("^the user create CompulsoryWithdrawalTPResponsetoSCN parameter list with (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String arn, String action) {
		compulsoryWithdrawalTPResponsetoSCNMap.put("state_cd", state_cd);
		compulsoryWithdrawalTPResponsetoSCNMap.put("arn", arn);
		compulsoryWithdrawalTPResponsetoSCNMap.put("action", action);
	}

	@When("the user hits CompulsoryWithdrawalTPResponsetoSCN API")
	public void the_user_hits_CompulsoryWithdrawalTPResponsetoSCN_api() {
		heart.response = heart.blood.compulsoryWithdrawalTPResponsetoSCNRegOpsObject().compulsoryWithdrawalTPResponsetoSCNResponse(govtAuthToken, compulsoryWithdrawalTPResponsetoSCNMap, compulsoryWithdrawalTPResponsetoSCNPath, heart);
		System.out.println("In SD");
	}

	@Then("the user gets CompulsoryWithdrawalTPResponsetoSCN success statusCode")
	public void the_user_gets_CompulsoryWithdrawalTPResponsetoSCN_success_status_code() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
