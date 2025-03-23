//package utilities;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import io.restassured.RestAssured;
//import io.restassured.filter.Filter;
//
//public class Hooks {
//
//	private Response response;
//	String url;
//	private static final Logger logger = LogManager.getLogger(Hooks.class);
//    private Scenario scenario;
//    private Filter logFilter;
//    private RequestSpecification req;
//	@Before
//    public void setUp(Heart heart) {
//		this.scenario = scenario;
//		logger.info("Setting up API test environment for the scenario: " + scenario.getName());
//        logFilter = new CustomLogFilter();
//        req = RestAssured.with();
//	}
//	
//	@After
//    public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//            logger.error("Scenario Failed: " + scenario.getName());
//        } else {
//            logger.info("Scenario Passed: " + scenario.getName());
//        }
//	}
//	
//	public Response getResponse() {
//        return response;
//    }
//	
////	@AfterStep
//    public void setResponse(Response response) {
//        this.response = response;
//        logger.info("API Response: " + response.getBody().asString());
//    }
//}
