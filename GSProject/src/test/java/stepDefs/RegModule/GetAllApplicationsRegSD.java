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

public class GetAllApplicationsRegSD {
	Map<String, String> header = new HashMap<>() ;
	String authToken;
	String url;
	Heart heart;
	public GetAllApplicationsRegSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
	}

	@When("the user hits GetAllApplication")
	public void the_user_hits_get_all_application_api() {

		}
//		Log4jLoggerFile.info("Decoded data is: "+decodedData);
//		Log4jLoggerFile.info("Completed the_user_hits_GetAllApplication method");
//	}
	
}
