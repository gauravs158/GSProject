package utils;

import java.util.Base64;

public class Base64Operations {

	String decodedData;
	String encodedData;
	Base64.Decoder decoder = Base64.getDecoder(); 
	Base64.Encoder encoder = Base64.getEncoder();
	public String getDecodedData(String s) {
		
		decodedData = new String(decoder.decode(s));  
		return decodedData;
	}
	public String getEncodedData(String s) {
		encodedData = encoder.encodeToString(s.getBytes());
		return encodedData;
	}
}
