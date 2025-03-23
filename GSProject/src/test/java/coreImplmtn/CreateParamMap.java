package coreImplmtn;

import java.util.HashMap;

public class CreateParamMap {
	static HashMap<String, String> queryParams = new HashMap<>() ;
	
	public static HashMap<String, String> getRegAlertQueryParams(){

		queryParams.put("state_cd", "99");
		queryParams.put("start_tm", "2025-03-10:09:16");
		queryParams.put("end_tm", "2025-03-10:10:16");
		queryParams.put("action", "ALERT");
		
		return queryParams;
	}
}
