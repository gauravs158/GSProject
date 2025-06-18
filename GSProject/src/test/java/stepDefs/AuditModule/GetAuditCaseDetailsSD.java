package stepDefs.AuditModule;

import java.util.HashMap;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetAuditCaseDetailsSD {
	Heart heart;
	GSTProjectUtils gstpu;
	String authToken;
	HashMap<String, String> paramMap = new HashMap<>();
	String getAuditCaseDetailsPath = "govtapi/v1.0/audit";
	public GetAuditCaseDetailsSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create Get Audit Case Details parameter list with (.+), (.+)$")
	public void create_parameter_list(String crn, String action) {
		paramMap.put("crn", crn);
		paramMap.put("action", action);
	}
	
	@When("the user hits Get Audit Case Details API")
	public void the_user_hits_GetReturnFileCountAPI() {
		heart.response = heart.blood.getAuditCaseDetailsOpsObject().getAuditCaseDetailsResponse(authToken, paramMap, getAuditCaseDetailsPath, heart);
		System.out.println("In SD");		
	}
	
	@Then("the user gets success statusCode for Get Audit Case Details")
	public void the_user_receives_success_statusCode() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}
}
