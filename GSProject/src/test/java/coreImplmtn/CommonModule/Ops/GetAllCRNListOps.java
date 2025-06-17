package coreImplmtn.CommonModule.Ops;

import java.util.HashMap;

import io.restassured.response.Response;
import utils.Heart;

public class GetAllCRNListOps {
	public Response getAllCRNListResponse(String authToken, HashMap<String, String> paramMap, String pathParam, Heart heart) {
		heart.response = heart.getReqResSpecBuildersObject().getCreatedGovtReqSpecBuilder(paramMap, heart.url, authToken)
				.when().log().all().get(pathParam);
		return heart.response;
	}

}
