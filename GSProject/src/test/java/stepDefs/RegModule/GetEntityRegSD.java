package stepDefs.RegModule;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.Log4jLoggerFile;
import utils.Base64Operations;
import utils.Heart;

public class GetEntityRegSD {
	Map<String, String> header = new HashMap<>() ;
	String decodedData = null;
	String authToken;
	String url;
	Heart heart;
	String s;
	String status_cd;
	SoftAssert sa = new SoftAssert();
	public GetEntityRegSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
		this.authToken = heart.govtAuthToken;
	}

	@When("the user hits GetEntityAPI")
	public void the_user_hits_get_entity_api() {
		header.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		header.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		header.put("username", "GSTG2G99");
		header.put("state-cd", "99");
		header.put("auth-token", authToken);
		
		RestAssured.baseURI = url;
		String response = given()
				.queryParam("state_cd", "07").queryParam("idty", "GSTIN")
				.queryParam("action", "ENT").queryParam("id", "07DYWPS8891G2Z5")
				.headers(header).when().get("govtapi/v1.1/entity").then().extract().asString();

//		Log4jLoggerFile.info("GetEntity API response received.");
		JsonPath js = new JsonPath(response);
		s = js.getString("data");
		status_cd = js.getString("status_cd");
//		Log4jLoggerFile.info(response);
		decodedData  = Base64Operations.getDecodedData(s);
//		Log4jLoggerFile.info("Decoded data is: "+decodedData);
//		Log4jLoggerFile.info("Completed the_user_hits_getEntity_api method");
	}
	
}
