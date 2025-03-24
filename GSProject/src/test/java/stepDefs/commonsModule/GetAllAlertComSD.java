package stepDefs.commonsModule;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.Log4jLoggerFile;
import utils.Base64Operations;
import utils.Heart;

public class GetAllAlertComSD {
	
	String authToken;
	String url;
	Heart heart;
	public GetAllAlertComSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}
	@When("the user hits GetAllAlertComAPI")
	public void the_user_hits_GetAllAlertCom_api() {
		
		String response = given().queryParam("state_cd", "07").queryParam("start_tm", "2025-03-10:09:16")
				.queryParam("end_tm", "2025-03-10:10:16").queryParam("iseod", "Y").queryParam("action", "ALERT")
				.headers(header).when().get("govtapi/v1.0/case").then().extract().asString();

	}
	
}
