package utils;

import java.util.Random;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.JsonPath;

public class GSTProjectUtils {
	SoftAssert sa = new SoftAssert();
	String responseStatusCode;
	JsonPath js;
	String strResponse;
	String className;
//	WriteDataToTextFile writeDataToTextFile;
//	public static void main(String[] args) {
//		System.out.println(getFileCounter(53));
//	}
	
	public int getFileCounter(int fileCount) {
		Random r = new Random();
		return r.nextInt(1, fileCount+1);
	}
	
	public void validateResponseStatusCode(String className, Heart heart) {
//		writeDataToTextFile = new WriteDataToTextFile();
		System.out.println("In validateResponseStatusCode checking heart.response: "+ heart.response.asPrettyString());
		if(heart.response.getStatusCode()>=300) {
			sa.assertEquals(heart.response.getStatusCode(), 200);
		}
		else {
			strResponse = heart.response.asString();
			js = new JsonPath(strResponse);
			responseStatusCode = js.getString("status_cd");
			if(responseStatusCode.equalsIgnoreCase("1")) {
				Heart.responseData = js.getString("data");
				System.out.println("heart.responseData is : "+Heart.responseData);
				Heart.decodedData = heart.getBase64OperationsObject().getDecodedData(Heart.responseData);
				System.out.println("heart.decodedData is : "+Heart.decodedData);
				Heart.setContext("data", Heart.decodedData);
//				writeDataToTextFile.writeToTextFile(className, heart.decodedData);
				sa.assertEquals(responseStatusCode, "1");
			}else {
				Heart.responseData = js.getString("error");
//				writeDataToTextFile.writeToTextFile(className, heart.responseData);
				sa.assertEquals(responseStatusCode, "1");
				}
		}
	}

}
