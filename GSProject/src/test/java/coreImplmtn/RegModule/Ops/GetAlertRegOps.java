package coreImplmtn.RegModule.Ops;

import io.restassured.response.Response;
import utils.Heart;

public class GetAlertRegOps {
	public Response getRegAlertResponse(String authToken, String pathParam, Heart heart) {
		heart.response = heart.getReqResSpecBuildersObject().getCreatedReqSpecBuilder(heart.url, authToken)
				.when().log().all().get(pathParam);
		return heart.response;
	}
}
