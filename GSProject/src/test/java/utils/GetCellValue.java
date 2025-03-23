package utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class GetCellValue {

	static ExcelReader er = new ExcelReader();
	static Map<String, Object> m = new HashMap<>();
	static String state_Cd;
	static String PAN;
	static String TPName;
	static String TPType;
	public static void main(String[] args) {
		String GSTIN = "10DD";
		PAN = getString(GSTIN);
		System.out.println(PAN);
	}
	
	private static String getString(String GSTIN){
		String PAN = null;
		String requestedData = "PAN";
		
		m = er.readExcelData("C:\\Users\\gaurav.samantaray\\Desktop\\Basic Folder\\TrailXCEL.xlsx");
		
		PAN = getRequestedDetails(m, requestedData, GSTIN);
		
		return PAN;
	}

	private static String getRequestedDetails(Map<String, Object> m2, String requestedData, String GSTIN) {
		LinkedList<Object> ll = getList(m2, GSTIN);
		HashMap<String,Object> hm = getMap(ll);
		String ob = getRequestedData(hm, requestedData);
		return ob;
	}

	@SuppressWarnings("unused")
	private static String getRequestedData(HashMap<String, Object> hm, String requestedData) {
		String finalValue = null;
		for( Map.Entry<String, Object> entry : hm.entrySet()){
			finalValue = (String) hm.get(requestedData);
		}
		System.out.println("finalValue is: "+finalValue);
		return finalValue;
	}

	@SuppressWarnings("unchecked")
	private static HashMap<String, Object> getMap(LinkedList<Object> ll) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm=(HashMap<String, Object>) ll.get(0);
		System.out.println(hm);
		return hm;
	}

	@SuppressWarnings("unchecked")
	private static LinkedList<Object> getList(Map<String, Object> m2, String GSTIN) {
		LinkedList<Object> list = new LinkedList<>();
		for(Entry<String, Object> entry : m2.entrySet()) {
			if(entry.getKey().equals(GSTIN)) {
				list= (LinkedList<Object>) entry.getValue(); 
				}
		}
		System.out.println(list);
		return list;
	}
	
	
}
