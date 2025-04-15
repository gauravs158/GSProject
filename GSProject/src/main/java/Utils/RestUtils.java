package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {
	public static String className;
    public static RequestSpecification getRequestSpecification(String endPoint, Map<String, String> paramList, Map<String, String> headers){

        return RestAssured.given()
                .baseUri(endPoint)
                .queryParams(paramList)
                .headers(headers)
                .contentType(ContentType.JSON);

    }

    public static RequestSpecification postRequestSpecification(String endPoint, Object payload, Map<String, String> headers){
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .body(payload)
                .contentType("application/JSON");
    }

    public static RequestSpecification putRequestSpecification(String endPoint, Object payload, Map<String, String> headers){
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .body(payload)
                .contentType("application/JSON");
    }

    public static void printRequestLogInReport(String className, RequestSpecification requestSpecification) {
    	RestUtils.className = className;
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Testcase name ::===> " + className.toUpperCase());
        ExtentReportManager.logInfoDetails("Endpoint is: " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    public static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }
    public static Response performGet(String className, String endPoint, Map<String, String> paramList, Map<String, String> headers){

        RequestSpecification requestSpecification = getRequestSpecification(endPoint, paramList, headers);
        Response response =  requestSpecification.get();
        printRequestLogInReport(className, requestSpecification);
        System.out.println("****************");
        printResponseLogInReport(response);
        System.out.println("****************");

        return response;
    }
    public static Response performPost(String endPoint, String body, Map<String, String> headers){
        return RestAssured.given()
                .body(body)
                .baseUri(endPoint)
                .headers(headers)
                .contentType("application/JSON")
                .post()
                .then().extract().response();
    }
    
    public static String getClassName() {
		return RestUtils.className;    	
    }
}
