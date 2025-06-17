package stepDefs.ReturnsModule;


import java.util.HashMap;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GSTProjectUtils;
import utils.Heart;

public class GetReturnFileDetailsSD {
	Heart heart;
	GSTProjectUtils gstpu;
	String authToken;
	HashMap<String, String> paramMap = new HashMap<>();
	String getReturnFileCountPath = "govtapi/v2.0/common";
	public GetReturnFileDetailsSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
		this.authToken = heart.govtAuthToken;
	}

	@Given("^the user create ReturnFileDetails parameter list with (.+), (.+), (.+), (.+), (.+)$")
	public void create_parameter_list(String state_cd, String type, String date, String action, String file_num) {
		paramMap.put("state_cd", state_cd);
		paramMap.put("type", type);
		paramMap.put("date", date);
		paramMap.put("action", action);
		paramMap.put("file_num", file_num);
	}
	
	@When("the user hits GetReturnFileDetailsAPI")
	public void the_user_hits_GetReturnFileCountAPI() {
		heart.response = heart.blood.getGetReturnFileDetailsOpsObject().getReturnFileDetailsResponse(authToken, paramMap, getReturnFileCountPath, heart);
		System.out.println("In SD");		
	}
	
	@Then("the user receives success statusCode on GetReturnFileDetailsAPI")
	public void the_user_receives_success_statusCode() {
		heart.getGSTProjectUtilsObject().validateResponseStatusCode(this.getClass().getName(), heart);
	}

}
