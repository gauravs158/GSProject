package stepDefs.PaymentModule;

import static Utils.RestUtils.performGet;
//import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import coreImplmtn.CreateEndpoints;
import coreImplmtn.PaymentModule.Pojo.GetPaymentFileDetailsPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Base64Operations;
import utils.Heart;

public class GetFileDtlsPaymentSD {
	String authToken;
	Heart heart;
	String paymentGetFilePathParam = "govtapi/v0.2/payment";
	Map<String, String> headersMap = new HashMap<String, String>();
	Map<String, String> paramsMap = new HashMap<String, String>();
	Response response;
	String stringResponse;
	String fileCount;
	String data;
	String decodedData;
	String url;
	String cnt;
	String file_num;
	String hash;
	JsonPath jsonPath;
	Base64Operations bo = new Base64Operations();
	ObjectMapper objectMapper = new ObjectMapper();
	CreateEndpoints createEndpoints = new CreateEndpoints();
	GetPaymentFileDetailsPojo getPaymentFileDetailsPojo;
	SoftAssert sa = new SoftAssert();
	String className;
	String endpoint;
	public GetFileDtlsPaymentSD(Heart heart) {
		this.heart = heart;
		this.authToken = heart.govtAuthToken;
	}
	@When("the user hits PaymentGetFileDetailsAPI")
	public void the_user_hits_get_file_details_api() {
		className = "Payment - Get File Details";
		headersMap.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		headersMap.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		headersMap.put("username", "GSTG2G99");
		headersMap.put("state-cd", "99");
		headersMap.put("auth-token", authToken);
		paramsMap.put("action", "FILEDTLS");
		paramsMap.put("state_cd", "99");
		paramsMap.put("file_type", "CIN");
		paramsMap.put("date", "12-12-2023");
		paramsMap.put("file_num", "32");
		endpoint = createEndpoints.getCompleteURL("Payment_Get_File_Details");
		response = performGet(className, endpoint, paramsMap, headersMap);
//		response = given().log().all().baseUri("https://devapi.gst.gov.in/").headers(headersMap).params(paramsMap).when().get(paymentGetFilePathParam);
//		System.out.println("Response: " + response);
		stringResponse = response.then().log().all().extract().asString();
		System.out.println("Response: " + stringResponse);
		jsonPath = new JsonPath(stringResponse);
		data = jsonPath.getString("data");
		decodedData = bo.getDecodedData(data);
		System.out.println("decodedData is: "+decodedData);
	}
	@And("the user validates the fileDetails")
	public void the_user_validates_the_fileDetails() {
		try {
			getPaymentFileDetailsPojo = objectMapper.readValue(decodedData, GetPaymentFileDetailsPojo.class);
			cnt = getPaymentFileDetailsPojo.getCnt();
			url = getPaymentFileDetailsPojo.getUrl();
			file_num = getPaymentFileDetailsPojo.getFile_num();
			hash = getPaymentFileDetailsPojo.getHash();
			System.out.println("cnt is: "+cnt);
			System.out.println("url is: "+url);
			System.out.println("file_num is: "+file_num);
			System.out.println("hash is: "+hash);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		sa.assertAll();
	}
}
