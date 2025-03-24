package coreImplmtn;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ReqResSpecBuilders {

	public RequestSpecification getCreatedGovtReqSpecBuilder(HashMap<String, String> paramMap, String url, String authToken) {
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(url)
				.addQueryParams(paramMap)
				.addHeaders(CreateHeaders.getGovtHeader(authToken)).build();
		RequestSpecification request = given().log().all().spec(reqSpec);
		return request;
	}

	public RequestSpecification getCreatedCommonReqSpecBuilder(String url, String authToken) {
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(url)
				.addQueryParams(CreateParamMap.getRegAlertQueryParams())
				.addHeaders(CreateHeaders.getCommonHeader(authToken)).build();
		RequestSpecification request = given().log().all().spec(reqSpec);
		return request;
	}
//	public void getCreatedResSpecBuilder() {
//		
//	}
}
