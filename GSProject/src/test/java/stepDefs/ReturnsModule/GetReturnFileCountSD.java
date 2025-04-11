package stepDefs.ReturnsModule;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base64Operations;
import utils.Heart;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import coreImplmtn.ReturnsModule.Pojo.GetReturnFileCountPojo;

public class GetReturnFileCountSD {
	Map<String, String> headerMap = new HashMap<String, String>();
	Map<String, String> paramsMap = new HashMap<String, String>();
	String response;
	Heart heart;
	Response responses;
	int statusCode;
	String status;
	JsonPath js;
	String responseData;
	String decodedData;
	String govtAuthToken;
	SoftAssert sa = new SoftAssert();
	GetReturnFileCountPojo GRFCount;
	String date;
	String eod_closed;
//	String num_files;
	
	public GetReturnFileCountSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
		System.out.println("heart reference in returns:"+heart);
	}
	@When("the user hits GetReturnFileCountAPI")
	public void the_user_hits_GetReturnFileCountAPI() {
		govtAuthToken = heart.govtAuthToken;
		System.out.println(govtAuthToken);
		headerMap.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		headerMap.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		headerMap.put("username", "GSTG2G99");
		headerMap.put("state-cd", "99");
		headerMap.put("auth-token", govtAuthToken);
		headerMap.put("Content-Type", "application/json");
		paramsMap.put("type", "R8");
		paramsMap.put("state_cd", "36");
		paramsMap.put("date", "07-02-2025");
		paramsMap.put("action", "FILECNT");
		responses = given().log().all().baseUri("https://devapi.gst.gov.in/").headers(headerMap).params(paramsMap).when().get("govtapi/v1.0/returns");
	}
	@Then("the user receives success statusCode")
	public void the_user_receives_success_statusCode() {
		statusCode = responses.getStatusCode();
		System.out.println("statusCode is: "+statusCode);
		sa.assertEquals(statusCode, 200);
	}
	@And("the user validates the responseData for number of fileCounts")
	public void the_user_validates_responseData_for_number_of_files() {
		response = responses.then().log().all().extract().asPrettyString();
		js = new JsonPath(response);
		responseData = js.getString("data");
		Base64Operations bo = new Base64Operations();
		decodedData = bo.getDecodedData(responseData);
		System.out.println(decodedData);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			GRFCount = objectMapper.readValue(decodedData, GetReturnFileCountPojo.class);
			date = GRFCount.getDate();
			eod_closed = GRFCount.getEod_closed();
			heart.num_files = GRFCount.getNum_files();
			System.out.println("Date is: "+date);
			sa.assertEquals(date, "07-02-2025");
			System.out.println("eod_closed is: "+eod_closed);
			sa.assertEquals(eod_closed, "N");
			System.out.println("num_files is: "+heart.num_files);
			sa.assertEquals(heart.num_files, "1");
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		sa.assertAll();
	}
}
