package coreImplmtn.CommonModule.Ops;

import java.util.HashMap;

import coreImplmtn.CreateParamMap;
import io.restassured.response.Response;
import utils.Heart;

public class GetAllCRNListOps {
	HashMap<String, String> paramMap = CreateParamMap.getCommonAllCRNListQueryParams();
	public Response getAllCRNListResponse(String authToken, String pathParam, Heart heart) {
		heart.response = heart.getReqResSpecBuildersObject().getCreatedGovtReqSpecBuilder(paramMap, heart.url, authToken)
				.when().log().all().get(pathParam);
		return heart.response;
	}

}
