package coreImplmtn.RegModule.Ops;

import java.util.HashMap;

//import coreImplmtn.CreateParamMap;
import io.restassured.response.Response;
import utils.Heart;

public class GetAllApplicationsOps {
//	HashMap<String, String> paramMap = CreateParamMap.getAllApplQueryParams();
	public Response getRegAllApplResponse(String authToken, HashMap<String, String> paramMap, String pathParam, Heart heart) {
		heart.response = heart.getReqResSpecBuildersObject().getCreatedGovtReqSpecBuilder(paramMap, heart.url, authToken)
				.when().log().all().get(pathParam);
		return heart.response;
	}
}
