package es.skeleton.UtilsByPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import es.skeleton.Utils.CustomActions;
import es.skeleton.Utils.Log;
import es.skeleton.Utils.Methods;


public class UtilsMainGoogle {
	static InputStream iS ;
	static Properties  properties;
	
	public static void open() throws IOException{
		iS = new FileInputStream("resources\\PropertiesPages\\main_google.properties");
		properties = new Properties();
		properties.load(iS);
	}
	
	public static void close() throws IOException{
		iS.close();
	}
	
	
	/**Is developing **/
//	public static void acceptPopupCenterNotes(WebDriver driver, String className) throws Throwable{
//		UtilsMainGoogle.open();
//		try{
//	    	Log.info("Check if there appears the popup Notes Center");
//	    	//existe = CustomActions.ExistElement(driver, className, ficheroXML, "AceptarPopupNotasCentro",false);
//	    	boolean existe = CustomActions.existElement(driver, className, properties, "aceptarPopupNotasCentro", false);	
//	    	if (existe){
//	    		Log.info("Click on Accept buttom on the popup Notas de centro");
//	    		CustomActions.click(driver, className, properties, "aceptarPopupNotasCentro");
//	    	}
//	    	else{
//	    		Log.info("The popup Center Notes it is not configurated");
//	    	}	    	
//	    }
//	    catch (Exception e){
//			Log.error("Something went wrong: " + e.getMessage());
//			Methods.createScreenshot(driver, className);	
//		}			
//		UtilsMainGoogle.close();
//	}
	
	/**
	 * 
	 * @param driver
	 * @param className
	 * @param username
	 * @param password
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void putValueToSearch(WebDriver driver, String className, String valueSearch) throws IOException, InterruptedException{
		UtilsMainGoogle.open();
		CustomActions.putValue(driver, className, properties, "selectSearch", valueSearch);
		UtilsMainGoogle.close();
	}
	
	
	public static void clickButton_ChangeProfile(WebDriver driver, String className) throws IOException{
		UtilsMainGoogle.open();
		CustomActions.clickXPath(driver, className, properties, "iconChangeProfile");
		UtilsMainGoogle.close();
	}
	
		
	
}

