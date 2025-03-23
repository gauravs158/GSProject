package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public  Map<String, Object> readExcelData(String excelPath) {
		Map<String, Object> m1 = new HashMap<>();
		try {
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("Sheet2");
			int rowCounter;
			int columnCounter;

			rowCounter = sheet.getLastRowNum();
			columnCounter = sheet.getRow(0).getLastCellNum();
			m1 = getCellDataWithHeader(sheet, rowCounter, columnCounter);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return m1;
	}
	private static HashMap<String, Object> getCellDataWithHeader(XSSFSheet sheet, int rowCounter, int columnCounter) {
		HashMap<String, Object> mainHM = new HashMap<>();
		List<HashMap<String, Object>> colData = new LinkedList<>();
		List<String> rowList = new LinkedList<>();
		rowList = getFirstColData(sheet, rowCounter);		
		for (int rowNum = 1; rowNum <= rowCounter; rowNum++) {

			colData = getData(sheet, rowNum, columnCounter);
			mainHM.put(rowList.get(rowNum-1), colData);
		}
		 System.out.println("HashMap is: "+mainHM);
		 return mainHM;
	}

	private static List<String> getFirstColData(XSSFSheet sheet, int rowCounter) {
		List<String> list = new LinkedList<>();
		for(int rowNum=1;rowNum<=rowCounter;rowNum++) {
			list.add(sheet.getRow(rowNum).getCell(0).getStringCellValue());
		}
		return list;
	}

	private static List<HashMap<String, Object>> getData(XSSFSheet sheet, int rowNum, int columnCounter) {
		HashMap<String, Object> hm = new HashMap<>();
		List<HashMap<String, Object>> colData = new LinkedList<>();
		for (int col = 1; col < columnCounter; col++) {
			switch (sheet.getRow(rowNum).getCell(col).getCellType()) {
			case STRING:
				hm.put(sheet.getRow(0).getCell(col).getStringCellValue(),
						sheet.getRow(rowNum).getCell(col).getStringCellValue());
				break;
			case NUMERIC:
				hm.put(sheet.getRow(0).getCell(col).getStringCellValue(),
						(int) (sheet.getRow(rowNum).getCell(col).getNumericCellValue()));
				break;
			case BOOLEAN:
				hm.put(sheet.getRow(0).getCell(col).getStringCellValue(),
						sheet.getRow(rowNum).getCell(col).getBooleanCellValue());
				break;
			default:
				break;
			}
		}
		colData.add(hm);
		return colData;
	}

}
