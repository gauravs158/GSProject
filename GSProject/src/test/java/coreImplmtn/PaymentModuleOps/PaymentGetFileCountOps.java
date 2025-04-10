package coreImplmtn.PaymentModuleOps;

import java.util.HashMap;

import coreImplmtn.CreateParamMap;
import io.restassured.response.Response;
import utils.Heart;

public class PaymentGetFileCountOps {
	HashMap<String, String> paramMap = CreateParamMap.getPaymentFileCountQueryParams();
	public Response getPaymentGetFileCountResponse(String authToken, String paymentGetFilePathParam, Heart heart) {
			heart.response = heart.getReqResSpecBuildersObject().getCreatedGovtReqSpecBuilder(paramMap, heart.url, authToken)
					.when().log().all().get(paymentGetFilePathParam);
			return heart.response;
	}
}
