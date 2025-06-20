package coreImplmtn;

import java.util.HashMap;

public class CreateParamMap {
	static HashMap<String, String> queryParams = new HashMap<>() ;
	
	public static HashMap<String, String> getRegAlertQueryParams(){

		queryParams.put("state_cd", "99");
		queryParams.put("start_tm", "2023-03-02:17:00");
		queryParams.put("end_tm", "2023-03-02:18:00");
		queryParams.put("action", "ALERT");
		
		return queryParams;
	}
	public static HashMap<String, String> getAllApplQueryParams(){

		queryParams.put("state_cd", "07");
		queryParams.put("start_tm", "2025-03-08:15:30");
		queryParams.put("end_tm", "2025-03-08:16:15");
		queryParams.put("aplty", "APLRG");
		queryParams.put("action", "LST");
		
		return queryParams;
	}
	public static HashMap<String, String> getEntityQueryParams(){

		queryParams.put("state_cd", "07");
		queryParams.put("idty", "GSTIN");
		queryParams.put("id", "07QPXXA1220A1ZN");
		queryParams.put("action", "ENT");
		
		return queryParams;
	}
	public static HashMap<String, String> getCommonAllAlertQueryParams(){

		queryParams.put("state_cd", "07");
		queryParams.put("start_tm", "2025-03-10:09:16");
		queryParams.put("end_tm", "2025-03-10:10:16");
		queryParams.put("iseod", "Y");
		queryParams.put("action", "ALERT");
		
		return queryParams;
	}
	public static HashMap<String, String> getCommonAllCRNListQueryParams(){

		queryParams.put("state_cd", "07");
		queryParams.put("start_tm", "2025-03-10:09:16");
		queryParams.put("end_tm", "2025-03-10:10:16");
		queryParams.put("iseod", "Y");
		queryParams.put("casetyp", "ADJDT");
		queryParams.put("action", "CRNLST");
		
		return queryParams;
	}
	public static HashMap<String, String> getPaymentFileCountQueryParams(){

		queryParams.put("state_cd", "99");
		queryParams.put("file_type", "CIN");
		queryParams.put("date", "12-12-2023");
		queryParams.put("action", "FILECNT");
		
		return queryParams;
	}
}
