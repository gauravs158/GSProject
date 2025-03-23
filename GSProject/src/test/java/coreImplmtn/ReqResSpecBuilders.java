package coreImplmtn;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ReqResSpecBuilders {

	public RequestSpecification getCreatedReqSpecBuilder(String url, String authToken) {
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(url)
				.addQueryParams(CreateParamMap.getRegAlertQueryParams())
				.addHeaders(CreateHeaders.getRegAlertHeader(authToken)).build();
		RequestSpecification request = given().log().all().spec(reqSpec);
		return request;
	}
//	public void getCreatedResSpecBuilder() {
//		
//	}
}
