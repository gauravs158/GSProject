package coreImplmtn.RegModule.Ops;

import java.util.HashMap;

import io.restassured.response.Response;
import utils.Heart;

public class GetAlertRegOps {
		public Response getRegAlertResponse(String authToken, HashMap<String, String> paramMap, String pathParam, Heart heart) {
			heart.response = heart.getReqResSpecBuildersObject().getCreatedGovtReqSpecBuilder(paramMap, heart.url, authToken)
					.when().log().all().get(pathParam);
			return heart.response;
		}
}