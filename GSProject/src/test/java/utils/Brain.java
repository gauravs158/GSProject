package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Brain {

	Properties prop = new Properties();
	public static String url;
	String govtAPIpassword;
	String commonAPIpassword;
	String govtAPIapp_key;
	String commonAPIapp_key;
	String govtAPIusername;
	String commonAPIusername;
	
	public String getPropertiesData(String propName) {
		try {
			FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(f);
			url = prop.getProperty("APIURL");
			govtAPIusername = prop.getProperty("govtAPIusername");
			govtAPIpassword = prop.getProperty("govtAPIpassword");
			govtAPIapp_key = prop.getProperty("govtAPIapp_key");
			commonAPIusername = prop.getProperty("commonAPIusername");
			commonAPIpassword = prop.getProperty("commonAPIpassword");
			commonAPIapp_key = prop.getProperty("commonAPIapp_key");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

			 if(propName.equalsIgnoreCase("APIURL")) {return url;}
		else if(propName.equalsIgnoreCase("govtAPIusername")) {return govtAPIusername;}
		else if(propName.equalsIgnoreCase("govtAPIpassword")) {return govtAPIpassword;}
		else if(propName.equalsIgnoreCase("govtAPIapp_key")) {return govtAPIapp_key;}
		else if(propName.equalsIgnoreCase("commonAPIusername")) {return commonAPIusername;}
		else if(propName.equalsIgnoreCase("commonAPIpassword")) {return commonAPIpassword;}
		else if(propName.equalsIgnoreCase("commonAPIapp_key")) {return commonAPIapp_key;}
		else return null;
	}
}
