package coreImplmtn.RegModule.Ops;
import java.util.HashMap;

import io.restassured.response.Response;
import utils.Heart;

public class GetAlertRegOps {
	HashMap<String, String> header = new HashMap<>() ;
	String status_cd;
	String decodedData;
	String s;
	public Response getRegAlertResponse(String authToken, String url, Heart heart) {
		heart.response = heart.getReqResSpecBuildersObject().getCreatedReqSpecBuilder(url, authToken)
				.when().log().all().get("govtapi/v0.2/alert");
		return heart.response;
	}
}
