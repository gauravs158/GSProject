package coreImplmtn;

import java.util.HashMap;
import utils.Heart;

public class CreateHeaders {
	static HashMap<String, String> header = new HashMap<>() ;
	static Heart heart;
	static String authToken;
	
	public static HashMap<String, String> getRegAlertHeader(String authToken){

		header.put("clientid", "l7xx0db0b857f0794c7b8de1e67f4cc71bb2");
		header.put("client-secret", "1a95c07cb91e4e42ba58bccac5aa7b5a");
		header.put("username", "GSTG2G99");
		header.put("state-cd", "99");
		header.put("auth-token", authToken);
		
		return header;
	}

}
