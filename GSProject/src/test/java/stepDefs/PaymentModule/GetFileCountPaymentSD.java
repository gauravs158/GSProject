package stepDefs.PaymentModule;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Base64Operations;
import utils.Heart;
//import static io.restassured.RestAssured.given;
import static Utils.RestUtils.performGet;
import java.util.HashMap;
import java.util.Map;
import org.testng.asserts.SoftAssert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import coreImplmtn.PaymentModule.Pojo.GetPaymentFileCountPojo;

public class GetFileCountPaymentSD {
	String authToken;
	String url;
	Heart heart;
	String paymentGetFilePathParam = "govtapi/v0.2/payment";
	Map<String, String> headersMap = new HashMap<String, String>();
	Map<String, String> paramsMap = new HashMap<String, String>();
	Response response;
	String stringResponse;
	String fileCount;
	String data;
	String decodedData;
	String eod_closed;
	String date;
	String num_files;
	JsonPath jsonPath;
	Base64Operations bo = new Base64Operations();
	ObjectMapper objectMapper = new ObjectMapper();
	GetPaymentFileCountPojo getPaymentFileCountPojo;
	SoftAssert sa = new SoftAssert();
	String className;
	public GetFileCountPaymentSD(Heart heart) {
		this.heart = heart;
		this.url = heart.url;
		this.authToken = heart.govtAuthToken;
	}

	@When("the user hits PaymentGetFileCountAPI")
	public void the_user_hits_get_file_count_api() {
		className = "Payment - Get File Count";
		headersMap.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		headersMap.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		headersMap.put("username", "GSTG2G99");
		headersMap.put("state-cd", "99");
		headersMap.put("auth-token", authToken);
		paramsMap.put("action", "FILECNT");
		paramsMap.put("state_cd", "99");
		paramsMap.put("file_type", "CIN");
		paramsMap.put("date", "12-12-2023");
		response = performGet(className, "https://devapi.gst.gov.in/govtapi/v0.2/payment", paramsMap, headersMap);
//		heart.response = heart.blood.getPaymentGetFileCountOpsObject().getPaymentGetFileCountResponse(heart.govtAuthToken, paymentGetFilePathParam, heart);
		//----------------------------------------------------------------------------------------------------------------------------------------
//		response = given().log().all().baseUri("https://devapi.gst.gov.in/").headers(headersMap).params(paramsMap).when().get(paymentGetFilePathParam);
//		System.out.println("Response: " + response);
		stringResponse = response.then().log().all().extract().asString();
		System.out.println("Response: " + stringResponse);
		jsonPath = new JsonPath(stringResponse);
		data = jsonPath.getString("data");
		decodedData = bo.getDecodedData(data);
		System.out.println("decodedData is: "+decodedData);
	}
	
	@And("the user validates the fileCount")
	public void the_user_validates_the_fileCount() {				
				try {
					getPaymentFileCountPojo = objectMapper.readValue(decodedData, GetPaymentFileCountPojo.class);
					eod_closed = getPaymentFileCountPojo.getEod_closed();
					date = getPaymentFileCountPojo.getDate();
					num_files = getPaymentFileCountPojo.getNum_files();
					System.out.println("eod_closed is: "+eod_closed);
					System.out.println("date is: "+date);
					System.out.println("num_files is: "+num_files);
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				sa.assertAll();
	}
}
