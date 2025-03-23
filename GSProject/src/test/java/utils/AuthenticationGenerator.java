package utils;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class AuthenticationGenerator {

	String authToken;
	String statusCode;
	Map<String, String> govtAPIHeader = new HashMap<>();
	Brain b = new Brain();
	Map<String, String> commonAPIHeader = new HashMap<>();
	String govtAPIBody = "{\r\n" + "    \"action\": \"ACCESSTOKEN\",\r\n" + "    \"username\": \""+b.getPropertiesData("govtAPIusername")+"\",\r\n"
			+ "    \"password\": \""+b.getPropertiesData("govtAPIpassword")+"\",\r\n"
			+ "    \"app_key\": \""+b.getPropertiesData("govtAPIapp_key")+"\"\r\n"
			+ "}";
	String commonAPIBody = "{\r\n" + "    \"action\": \"ACCESSTOKEN\",\r\n" + "    \"username\": \""+b.getPropertiesData("commonAPIusername")+"\",\r\n"
			+ "    \"password\":\""+b.getPropertiesData("commonAPIpassword")+"\",\r\n"
			+ "	\"app_key\":\""+b.getPropertiesData("commonAPIapp_key")+"\"\r\n"
			+ "}";
	public String getGovtAPIAuthToken() {
		govtAPIHeader.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		govtAPIHeader.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		govtAPIHeader.put("username", "GSTG2G99");
		govtAPIHeader.put("state-cd", "99");
		govtAPIHeader.put("Content-Type", "application/json");
		RestAssured.baseURI = Brain.url;
		String response = given().headers(govtAPIHeader).body(govtAPIBody).when().post("govtapi/v0.2/authenticate")
				.then().extract().asString();
		JsonPath js = new JsonPath(response);
		statusCode = js.getString("status_cd");
		if (statusCode.equalsIgnoreCase("1")) {
			authToken = js.getString("auth_token");
			//System.out.println("GovtAPIAuthToken is :" + authToken);
		} else {
			System.out.println(response);
		}
		return authToken;
	}

	public String getCommonAPIAuthToken() {
		commonAPIHeader.put("clientid", "l7xxa0330a9b1a4a4811a17ad376c80c06bc");
		commonAPIHeader.put("client-secret", "eed5bffc5cf5458aa5ac681356b7f091");
		commonAPIHeader.put("Content-Type", "application/json");
		String response = given().headers(commonAPIHeader).body(commonAPIBody).when()
				.post("commonapi/v0.2/authenticate").then().extract().asString();

		JsonPath js = new JsonPath(response);
		statusCode = js.getString("status_cd");
		if (statusCode.equalsIgnoreCase("1")) {
			authToken = js.getString("auth_token");
			//System.out.println("CommonAPIAuthToken is :" + authToken);
		} else {
			System.out.println(response);
		}
		return authToken;
	}
}
