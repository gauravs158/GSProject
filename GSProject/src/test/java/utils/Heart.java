package utils;

import coreImplmtn.Blood;
import coreImplmtn.CreateHeaders;
import coreImplmtn.ReqResSpecBuilders;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
public class Heart {

	public String url;
	public String govtAuthToken;
	public String commonAuthToken;
	public AuthenticationGenerator ag;
	public Blood blood;
	public Scenario scenario;
	public Response response;
	Brain brain;
	String decodedData;
	String responseData;
	public Heart() {
		this.brain = new Brain();
		blood = new Blood();
		ag = new AuthenticationGenerator();
		this.url = brain.getPropertiesData("APIURL");
		this.govtAuthToken = ag.getGovtAPIAuthToken();
		this.commonAuthToken = ag.getCommonAPIAuthToken();
	}
	public GSTProjectUtils getGSTProjectUtilsObject() {
		return new GSTProjectUtils();		
	}
	public CreateHeaders getCreateHeadersObject() {
		return new CreateHeaders();
	}
	public ReqResSpecBuilders getReqResSpecBuildersObject() {
		return new ReqResSpecBuilders();
	}
	public Base64Operations getBase64OperationsObject() {
		return new Base64Operations();
	}
}
