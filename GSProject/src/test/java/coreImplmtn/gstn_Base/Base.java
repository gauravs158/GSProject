package coreImplmtn.gstn_Base;

import Utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> url;
    public static String endPoint;

    public static String alerts(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v0.2/alert";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String Get_RegAllApplicationRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v2.0/application";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String newRegSubmitAllApplicationRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v1.0/application";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String GSTPSubmitRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v0.2/application";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String RegAllGreivanceRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v0.2/grievance";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String regStockDetailsIntimationRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v0.2/application";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String BOCashLedgerRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v0.3/ledgers";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String NRFTSubmitRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v1.0/application";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String CancellationSubmitRequests(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v0.2/application";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String AmendNonCoreOIDAR(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v0.2/application";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String CompositionLevyExcludedTPBasedAATO(){
        try {
            url = JsonUtils.getJsonDataAsMap("/BaseURL.json");
            endPoint = (String) url.get("BaseURL")+"v1.0/compositionwithdraw";
            return endPoint;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
