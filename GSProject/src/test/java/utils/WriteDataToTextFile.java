//package utils;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class WriteDataToTextFile {
//	FileOutputStream outputStream;
//	String workspacePath;
//	String folderPath = "target/outputFolder";
//	String dateFormat = "yyyy-MM-dd_HH-mm-ss";
//	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
//    String dateTimeString = sdf.format(new Date());
//	public void writeToTextFile(String fileName, String decodedData) {
//			workspacePath = System.getProperty("user.dir");
//			File folder = new File(workspacePath+ File.separator + folderPath);
//			File myFile = new File( folder, dateTimeString + "_" + fileName + ".txt");
//			if (!folder.exists()) {
//	            if (folder.mkdir()) {
//	            	createFile(myFile, decodedData);
//	            } else {
//	                System.out.println("Failed to create folder.");
//	                return;
//	            }
//	        } else {
//	        	if (myFile.exists()) {
//	        	overWriteFile(myFile, decodedData);}
//	        	else createFile(myFile, decodedData);}
//	}
//	private void createFile(File myFile, String decodedData) {
//		if (!myFile.exists()) {
//            try (FileOutputStream fos = new FileOutputStream(myFile)) {
//                fos.write(decodedData.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            return;
//        }
//	}
//	private void overWriteFile(File myFile, String decodedData) {
//		if (!myFile.exists()) {
//            try (FileOutputStream fos = new FileOutputStream(myFile)) {
//                fos.write(decodedData.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//		}
//	}
//}
