package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

	String url;
	private static final Logger logger = LogManager.getLogger(Hooks.class);
    private Scenario scenario;
    FileOutputStream outputStream;
	String workspacePath;
	String folderPath = "target/outputFolder";
	String dateFormat = "yyyy-MM-dd_HH-mm-ss";
	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    String dateTimeString = sdf.format(new Date());
    File folder;
    File myFile;
//    private Filter logFilter;
//    private RequestSpecification req;
    Heart heart = new Heart();
	@Before
    public void setUp(Scenario scenario) {
		this.scenario = scenario;
		System.out.println(scenario.getName());
//		heart.scenario = scenario;
//		logger.info("Setting up API test environment for the scenario: " + scenario.getName());
//        logFilter = new CustomLogFilter();
//        req = RestAssured.with();
	}
	
	@After
    public void afterMethod() {
		System.out.println("Reached afterMethod in Hooks");
		Heart.decodedData = (String) Heart.getContext("data");
		workspacePath = System.getProperty("user.dir");
		folder = new File(workspacePath+ File.separator + folderPath);
		myFile = new File( folder, dateTimeString + "_" + scenario.getName() + ".txt");
		System.out.println(myFile);
		if (scenario.isFailed()) {
            logger.error("Scenario Failed: " + scenario.getName());
            System.out.println("isFailed");
            if (!folder.exists()) {
	            if (folder.mkdir()) {
	            	createFile(myFile, Heart.decodedData);
	            } else {
	                System.out.println("Failed to create folder.");
	                return;
	            }
	        } else {
	        	if (myFile.exists()) {
	        	overWriteFile(myFile, Heart.decodedData);}
	        	else createFile(myFile, Heart.decodedData);}
        } else {
            logger.info("Scenario Passed: " + scenario.getName());
            System.out.println("isPassed");
            if (!folder.exists()) {
	            if (folder.mkdir()) {
	            	createFile(myFile, Heart.decodedData);
	            } else {
	                System.out.println("Failed to create folder.");
	                return;
	            }
	        } else {
	        	if (myFile.exists()) {
	        	overWriteFile(myFile, Heart.decodedData);}
	        	else createFile(myFile, Heart.decodedData);}
        }
	}
	
	private void createFile(File myFile, String decodedData) {
		if (!myFile.exists()) {
            try (FileOutputStream fos = new FileOutputStream(myFile)) {
                fos.write(decodedData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
	}
	private void overWriteFile(File myFile, String decodedData) {
		if (!myFile.exists()) {
            try (FileOutputStream fos = new FileOutputStream(myFile)) {
                fos.write(decodedData.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
//	public Response getResponse() {
//        return response;
//    }
//	
////	@AfterStep
//    public void setResponse(Response response) {
//        this.response = heart.response;
//        logger.info("API Response: " + response.getBody().asString());
//    }
}
