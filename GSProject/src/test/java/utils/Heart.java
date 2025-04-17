package utils;

import java.util.HashMap;
import java.util.Map;

import coreImplmtn.Blood;
import coreImplmtn.CreateHeaders;
import coreImplmtn.ReqResSpecBuilders;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
public class Heart {

	public static final Heart heart = new Heart();
	public String url;
	public String govtAuthToken;
	public String commonAuthToken;
	public AuthenticationGenerator ag;
	public Blood blood;
	public Scenario scenario;
	public Response response;
	public String num_files;
	Brain brain;
	static String decodedData;
	static String responseData;
	public Heart() {
		this.brain = new Brain();
		this.blood = new Blood();
		this.ag = new AuthenticationGenerator();
		this.url = brain.getPropertiesData("APIURL");
		this.govtAuthToken = ag.getGovtAPIAuthToken();
//		this.commonAuthToken = ag.getCommonAPIAuthToken();
	}
	
	public static Heart returnHeartObject() {
		return heart;
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
//	private static final ThreadLocal<Map<String, Object>> scenarioContext = new ThreadLocal<>() {
//        @Override
//        protected Map<String, Object> initialValue() {
//            return new HashMap<>();
//        }
//    };
//
//    public static void setContext(String key, Object value) {
//        scenarioContext.get().put(key, value);
//    }
//
//    public static Object getContext(String key) {
//        return scenarioContext.get().get(key);
//    }
}
