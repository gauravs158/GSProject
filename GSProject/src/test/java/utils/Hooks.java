package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
	public static PrintStream logStream;
	 
    static {
        try {
            File logFile = new File("target/api_logs.txt");
            logStream = new PrintStream(new FileOutputStream(logFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
 
//    @Before
//    public void setupLogging() {
//        RestAssured.filters(new RequestLoggingFilter(logStream), new ResponseLoggingFilter(logStream));
//    }
//    
//    @After
//    public void attachLogsToReport(Scenario scenario) {
//        try {
//            String logs = new String(Files.readAllBytes(Paths.get("target/api_logs.txt")));
//            scenario.attach(logs, "text/plain", "API Logs");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
	
	  String url; 
	  private static final Logger logger = LogManager.getLogger(Hooks.class); 
	  private Scenario scenario;
	  FileOutputStream outputStream; 
	  String workspacePath; 
	  String folderPath ="target/outputFolder"; 
	  String dateFormat = "yyyy-MM-dd_HH-mm-ss";
	  SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); 
	  String dateTimeString = sdf.format(new Date()); 
	  File folder; 
	  File myFile; 
	  private Filter logFilter; 
	  private RequestSpecification req; 
//	  Heart heart = new Heart();
	  
	  @Before 
	  public void setUp(Scenario scenario) { 
		  this.scenario = scenario;
		  System.out.println(scenario.getName()); 
		  }
	  
	  @After public void afterMethod() { Heart.decodedData = (String)
	  Heart.getContext("data"); workspacePath = System.getProperty("user.dir");
	  folder = new File(workspacePath+ File.separator + folderPath); myFile = new
	  File( folder, dateTimeString + "_" + scenario.getName() + ".txt");
	  System.out.println(myFile); if (scenario.isFailed()) {
	  logger.error("Scenario Failed: " + scenario.getName());
	  System.out.println("isFailed"); if (!folder.exists()) { if (folder.mkdir()) {
	  createFile(myFile, Heart.decodedData); } else {
	  System.out.println("Failed to create folder."); return; } } else { if
	  (myFile.exists()) { overWriteFile(myFile, Heart.decodedData);} else
	  createFile(myFile, Heart.decodedData);} } else {
	  logger.info("Scenario Passed: " + scenario.getName());
	  System.out.println("isPassed"); if (!folder.exists()) { if (folder.mkdir()) {
	  createFile(myFile, Heart.decodedData); } else {
	  System.out.println("Failed to create folder."); return; } } else { if
	  (myFile.exists()) { overWriteFile(myFile, Heart.decodedData);
	  
	  System.out.println("Reached afterMethod after creating file in Hooks");} else
	  createFile(myFile, Heart.decodedData);} } }
	  
	  private void createFile(File myFile, String decodedData) { if
	  (!myFile.exists()) { try (FileOutputStream fos = new
	  FileOutputStream(myFile)) { fos.write(decodedData.getBytes()); } catch
	  (IOException e) { e.printStackTrace(); } } else { return; } } private void
	  overWriteFile(File myFile, String decodedData) { if (!myFile.exists()) { try
	  (FileOutputStream fos = new FileOutputStream(myFile)) {
	  fos.write(decodedData.getBytes()); } catch (IOException e) {
	  e.printStackTrace(); } } }
	 
}
