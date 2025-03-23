package stepDefs.PaymentModule;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.Log4jLoggerFile;
import utils.Base64Operations;
import utils.Heart;

public class GetFileDtlsPaymentSD {

	Map<String, String> header = new HashMap<>() ;
	String decodedData = null;
	String authToken;
	String url;
	Heart heart;
	String s;
	String status_cd;
	SoftAssert sa = new SoftAssert();
//	public Logger log;
	public GetFileDtlsPaymentSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
		this.authToken = heart.govtAuthToken;
//		this.log = LogManager.getLogger(GetFileDtlsPaymentSD.class);
	}
	@When("the user hits PaymentGetFileDetailsAPI")
	public void the_user_hits_get_file_details_api() {
		header.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		header.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		header.put("username", "GSTG2G99");
		header.put("state-cd", "99");
		header.put("auth-token", authToken);
//		Log4jLoggerFile.info("Hitting the Payment GetFileDetails API");
		RestAssured.baseURI = url;
		String response = given().queryParam("state_cd", "99").queryParam("file_type", "EODCIN")
				.queryParam("date", "12-12-2023").queryParam("action", "FILEDTLS").queryParam("file_num", "3")
				.headers(header).when().get("govtapi/v0.2/payment").then().extract().asString();

//		Log4jLoggerFile.info("Payment GetFileCount API response received.");
		JsonPath js = new JsonPath(response);
		s = js.getString("data");
		status_cd = js.getString("status_cd");
//		Log4jLoggerFile.info(response);
		decodedData  = Base64Operations.getDecodedData(s);
//		Log4jLoggerFile.info("Decoded data is: "+decodedData);
//		Log4jLoggerFile.info("Completed the_user_hits_GetFileCount method of Payment module");
	}
}
