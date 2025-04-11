package stepDefs.ReturnsModule;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import coreImplmtn.ReturnsModule.Pojo.GetReturnFileCountPojo;
import coreImplmtn.ReturnsModule.Pojo.GetReturnFileDetailsPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Base64Operations;
import utils.Heart;

public class GetReturnFileDetailsSD {
	Map<String, String> headerMap = new HashMap<String, String>();
	Map<String, String> paramsMap = new HashMap<String, String>();
	String response;
	Heart heart;
	String govtAuthToken;
	Response responses;
	String fileCount;
	int statusCode;
	String status;
	JsonPath js;
	SoftAssert sa = new SoftAssert();
	String responseData;
	String decodedData;
	GetReturnFileDetailsPojo grfd;
	String cnt;
	String file_num;
	String url;
	String hash;
	public GetReturnFileDetailsSD(Heart heart) {
		this.heart = Heart.returnHeartObject();
	}
	@And("the user gets the fileCount")
	public void the_user_gets_the_fileCount() {
		govtAuthToken = heart.govtAuthToken;
		System.out.println(govtAuthToken);
		fileCount = heart.num_files;
		System.out.println("fileCount in ReturnFileDetails is: "+ fileCount);
		headerMap.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		headerMap.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		headerMap.put("username", "GSTG2G99");
		headerMap.put("state-cd", "99");
		headerMap.put("auth-token", govtAuthToken);
		headerMap.put("Content-Type", "application/json");
		paramsMap.put("type", "R8");
		paramsMap.put("state_cd", "36");
		paramsMap.put("date", "07-02-2025");
		paramsMap.put("action", "FILEDET");
		paramsMap.put("file_num", heart.num_files);
	}
	@When("the user hits GetReturnFileDetailsAPI")
	public void the_user_hits_GetReturnFileDetailsAPI() {
		responses = given().log().all().baseUri("https://devapi.gst.gov.in/").headers(headerMap).params(paramsMap).when().get("govtapi/v1.0/returns");
	}
	@And("the user validates the responseData for fileNumber and url")
	public void the_user_validates_responseData_for_fileNumber_and_url() {
		statusCode = responses.getStatusCode();
		System.out.println("statusCode is: "+statusCode);
		sa.assertEquals(statusCode, 200);
		response = responses.then().log().all().extract().asPrettyString();
		js = new JsonPath(response);
		responseData = js.getString("data");
		Base64Operations bo = new Base64Operations();
		decodedData = bo.getDecodedData(responseData);
		System.out.println(decodedData);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			grfd = objectMapper.readValue(decodedData, GetReturnFileDetailsPojo.class);
			cnt = grfd.getCnt();
			file_num = grfd.getFile_num();
			url = grfd.getUrl();
			hash = grfd.getHash();
			System.out.println("cnt is: "+cnt);
			System.out.println("file_num is: "+file_num);
			System.out.println("url is: "+url);
			System.out.println("hash is: "+hash);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		sa.assertAll();
	}

}
