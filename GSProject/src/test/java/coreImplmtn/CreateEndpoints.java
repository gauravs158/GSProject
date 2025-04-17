package coreImplmtn;

import utils.API_URL_Fetcher;
import utils.Brain;

public class CreateEndpoints {
	String url;
	API_URL_Fetcher auf = new API_URL_Fetcher();
	Brain brainInstance = new Brain();
	public String getCompleteURL(String FetchUrl) {
		url = Brain.url+auf.getURL(FetchUrl);
		System.out.println(url);
		return url;
	}

	
}
