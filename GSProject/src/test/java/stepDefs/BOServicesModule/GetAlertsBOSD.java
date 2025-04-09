package stepDefs.BOServicesModule;

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

public class GetAlertsBOSD {
	String authToken;
	String url;
	Heart heart;
//	public Logger log;
	public GetAlertsBOSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
		this.authToken = heart.govtAuthToken;
	}
	
	@When("the user hits GetAlertBOAPI")
	public void the_user_hits_get_BOalert_api() {
//		String response = given().queryParam("state_cd", "07").queryParam("start_tm", "2025-03-10:09:16")
//				.queryParam("end_tm", "2025-03-10:10:16").queryParam("iseod", "Y").queryParam("action", "ALERT")
//				.headers(header).when().get("govtapi/v1.0/case").then().extract().asString();
//
//		heart.response = heart.blood.getAllCRNListOpsObject().getAllCRNListResponse(heart.govtAuthToken, commonGetCRNListPathParam, heart);
	}	
}
