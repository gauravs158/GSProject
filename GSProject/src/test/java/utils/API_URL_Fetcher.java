package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class API_URL_Fetcher {
	
	Properties properties = new Properties();
	public String getURL(String propName) {
		try {
			FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/url-config.properties");
			properties.load(f);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		//Registration Module URLs
			 if(propName.equalsIgnoreCase("Registration_Get_Entity")) {return properties.getProperty("Registration_Get_Entity");}
		else if(propName.equalsIgnoreCase("Registration_Get_Alert")) {return properties.getProperty("Registration_Get_Alert");}
		else if(propName.equalsIgnoreCase("Registration_Get_Taxpayer_Electricity_Board_Details")) {return properties.getProperty("Registration_Get_Taxpayer_Electricity_Board_Details");}
			 
		//Return Module URLs
			 
		else if(propName.equalsIgnoreCase("Return_Get_File_Count")) {return properties.getProperty("Return_Get_File_Count");}
		else if(propName.equalsIgnoreCase("Return_Get_File_Details")) {return properties.getProperty("Return_Get_File_Details");}
		else if(propName.equalsIgnoreCase("Return_GET_AATO")) {return properties.getProperty("Return_GET_AATO");}
		else if(propName.equalsIgnoreCase("Return_Get_Acknowledgement_Report")) {return properties.getProperty("Return_Get_Acknowledgement_Report");}
		else if(propName.equalsIgnoreCase("Return_Get_Comparison_Report")) {return properties.getProperty("Return_Get_Comparison_Report");}
		else if(propName.equalsIgnoreCase("Return_Get_Record_File")) {return properties.getProperty("Return_Get_Record_File");}
		else if(propName.equalsIgnoreCase("Return_Get_Filed_Return_Details")) {return properties.getProperty("Return_Get_Filed_Return_Details");}
		else if(propName.equalsIgnoreCase("Return_Get_Returns_Recon_Summary")) {return properties.getProperty("Return_Get_Returns_Recon_Summary");}
		else if(propName.equalsIgnoreCase("Return_GSTR_3A_Return_Defaulter_List")) {return properties.getProperty("Return_GSTR_3A_Return_Defaulter_List");}
			 
		//Payment Module URLs
			 
		else if(propName.equalsIgnoreCase("Payment_Get_File_Count")) {return properties.getProperty("Payment_Get_File_Count");}
		else if(propName.equalsIgnoreCase("Payment_Get_File_Details")) {return properties.getProperty("Payment_Get_File_Details");}
		else if(propName.equalsIgnoreCase("Payments_PaymentRecon")) {return properties.getProperty("Payments_PaymentRecon");}
			 
		//SettlementLedger Module URLs
			 
		else if(propName.equalsIgnoreCase("SettlementLedger_Get_File_Count")) {return properties.getProperty("SettlementLedger_Get_File_Count");}
		else if(propName.equalsIgnoreCase("SettlementLedger_Get_File_Details")) {return properties.getProperty("SettlementLedger_Get_File_Details");}
		else if(propName.equalsIgnoreCase("SettlementLedger_Get_Center_Summary")) {return properties.getProperty("SettlementLedger_Get_Center_Summary");}
		else if(propName.equalsIgnoreCase("SettlementLedger_Get_State_Summary")) {return properties.getProperty("SettlementLedger_Get_State_Summary");}
			 
		//Refunds Module URLs
			 
		else if(propName.equalsIgnoreCase("Refunds_Get_All_Application_List")) {return properties.getProperty("Refunds_Get_All_Application_List");}
		else if(propName.equalsIgnoreCase("Refunds_Get_Application_Detail")) {return properties.getProperty("Refunds_Get_Application_Detail");}
		else if(propName.equalsIgnoreCase("Refunds_Get_Statement_Detail")) {return properties.getProperty("Refunds_Get_Statement_Detail");}
		else if(propName.equalsIgnoreCase("Refunds_Refund_Risk_Score")) {return properties.getProperty("Refunds_Refund_Risk_Score");}
		else if(propName.equalsIgnoreCase("Refunds_Get_Bank_Validation_Status")) {return properties.getProperty("Refunds_Get_Bank_Validation_Status");}
			 
		//Common Module URLs
			 
		else if(propName.equalsIgnoreCase("Common_Get_All_CRN_List")) {return properties.getProperty("Common_Get_All_CRN_List");}
		else if(propName.equalsIgnoreCase("Common_Get_All_Alert")) {return properties.getProperty("Common_Get_All_Alert");}
		else if(propName.equalsIgnoreCase("Common_Get_CRN_List")) {return properties.getProperty("Common_Get_CRN_List");}
		else if(propName.equalsIgnoreCase("Common_Get_Standalone_Order")) {return properties.getProperty("Common_Get_Standalone_Order");}
			 
		//Audit Module URLs
		else if(propName.equalsIgnoreCase("Audit_Get_Audit_Case_Details")) {return properties.getProperty("Audit_Get_Audit_Case_Details");}
		else if(propName.equalsIgnoreCase("Audit_Get_Payment_Acknowledgement")) {return properties.getProperty("Audit_Get_Payment_Acknowledgement");}
		else if(propName.equalsIgnoreCase("Audit_Get_Payment_Details")) {return properties.getProperty("Audit_Get_Payment_Details");}
		else if(propName.equalsIgnoreCase("Audit_Fetch_Notices")) {return properties.getProperty("Audit_Fetch_Notices");}
			 
		else return null;
	}
}
