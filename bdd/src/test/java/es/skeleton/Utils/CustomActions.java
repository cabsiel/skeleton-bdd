package es.skeleton.Utils;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
 



public class CustomActions {
	
	//static String resultXML[];
	static Boolean existe;
	

	
		//new
		public static void rightClick(WebDriver driver, String className, Properties properties, String field){
			String typeField = properties.getProperty(field + "Type");
			String valueField = properties.getProperty(field + "Value");
			try{
				Thread.sleep(1000);
				WebElement element = KeywordsAction.getWebElementByType(driver, typeField, valueField);
				Actions actions = new Actions(driver);
				actions.contextClick(element).build().perform(); 
			}catch(Exception e){
				Log.error("The element " + field +" doesn`t exist");
				Methods.createScreenshot(driver, className);
				Assert.assertEquals(false, true);
			}	
		}


		/**
		 * method to verify that there is the element
		 */		
		public static boolean existElement(WebDriver driver, String className, Properties properties, String field, boolean throwIfNotExist) throws Throwable
		{
			String typeField = properties.getProperty(field + "Type");
			String valueField = properties.getProperty(field + "Value");
			try{
				//Thread.sleep(2000);
				Log.info("Read the element type " + typeField + " and its value is: " + valueField);
				existe = KeywordsAction.existElement(driver, typeField, valueField);
		    
				if (existe){
//						Thread.sleep(2000);
					Log.info("The element " + valueField + " exist");
					return true ;
				}
				else {
					Log.error("The element " + valueField + " does not exist");
			    	
			    	if ( throwIfNotExist ){
			    		Methods.createScreenshot(driver, className);
			    		Assert.assertEquals(existe, true);
			    	}else{
			    		return false ;
			    	}
					
				}
			}
			catch (Exception e){
				Log.error("Something went wrong: " + e.getMessage());
				Methods.createScreenshot(driver, className);
				Assert.assertEquals(false, true);
			}
			return false ;
		}
	//new
	/**
	* method to 
	*/		
		/*public static boolean existElementBySrcPath(WebDriver driver, String className, Properties properties, String field, boolean throwIfNotExist) throws Throwable
		{
			String typeField = properties.getProperty(field + "Type");
			String valueField = properties.getProperty(field + "Value");
			try{
				//Thread.sleep(2000);
				Log.info("Read the element " + typeField + " and its value " + valueField);
				WebElement element;
				if ( typeField.compareTo("src") == 0){
					try{
						element = driver.findElements(By.xpath(".//*[@src='"+ valueField +"']")).get(0);
					}
					catch (Exception e){
						existe = false;
					}
					existe =true;
				//If detect xpath then find by XPATH				
				}else if ( typeField.compareTo("xpath") == 0){
					try{
						element = driver.findElements(By.xpath(valueField)).get(0);
					}
						catch (Exception e){
						existe = false;
					}	
					existe =true;
				}
				else{
					try{
						element = driver.findElements(By.xpath("//*[contains(text(),'"+ valueField +"')]")).get(0);
					}
					catch (Exception e){
					existe = false;
				}	
				existe =true;
				}

				if (existe){
//					Thread.sleep(2000);
					Log.info("The element " + valueField + " exist");
					return true ;
				}
				else {
					Log.error("The element " + valueField + " does not exist");
					if ( throwIfNotExist ){
						Methods.createScreenshot(driver, className);
					    Assert.assertEquals(existe, true);
					}else{
					    return false ;
					}
							
				}
			}
			catch (Exception e){
				Log.error("Something went wrong: " + e.getMessage());
				Methods.createScreenshot(driver, className);
				Assert.assertEquals(false, true);
			}
			return false ;
		}*/				
		

		public static void click(WebDriver driver, String className, Properties properties, String field) throws InterruptedException{
			String typeField = properties.getProperty(field + "Type");
			String valueField = properties.getProperty(field + "Value");
			Thread.sleep(1000);
			try{
				boolean existe = KeywordsAction.existElement(driver, typeField, valueField);
				
				if (existe){
					Log.info("The element " + valueField + " exist");
					KeywordsAction.click(driver, typeField, valueField);
				}
				else {
					Log.error("The element " + valueField + " does not exist");
					Methods.createScreenshot(driver, className);
					Assert.assertEquals(existe, true);
				}
			}
			catch (Exception e){
				Log.error("Something went wrong: " + e.getMessage());
				Methods.createScreenshot(driver, className);
				Assert.assertEquals(false, true);
			}
		}	


	public static void clickXPath(WebDriver driver, String className, Properties properties, String field){
		clickXPath(driver, className, properties, field, null);
	}
	public static void clickXPath(WebDriver driver, String className, Properties properties, String field, String value){
		String typeField ;
		String valueField ;
		String iframeField = null ;

		if ( value == null ){
			typeField = properties.getProperty(field + "Type");
			valueField = properties.getProperty(field + "Value");
			iframeField = properties.getProperty(field + "Iframe");
		}else{
			valueField = value;
			typeField = "containText" ;
		}
		
		try{
			
			Thread.sleep(1000);
			
			//Detect if must change iframe
			boolean changeIframe = iframeField != null && iframeField.compareTo("") != 0  ;
			if ( changeIframe ){
				driver.switchTo().frame(iframeField);
			}

			//If detect type SRC then find by SRC
			if ( typeField.compareTo("src") == 0){
				driver.findElements(By.xpath(".//*[@src='"+ valueField +"']")).get(0).click();
			//If detect xpath then find by XPATH				
			}else if ( typeField.compareTo("xpath") == 0){
				driver.findElements(By.xpath(valueField)).get(0).click();
			}else{
				driver.findElements(By.xpath("//*[contains(text(),'"+ valueField +"')]")).get(0).click();
			}
			
			if ( changeIframe ){
				driver.switchTo().defaultContent();
			}
			
			Log.info("The text " + valueField +" exists");
		}catch(Exception e){
			Log.error("The text " + valueField + " doesn`t exist");
			Methods.createScreenshot(driver, className);
			//throw new Error();
			Assert.assertEquals(false, true);
		}
	}
	
	//TODO: Revisar con Albert.
	/*public static void clickXPath(WebDriver driver, String className, String[] properties){
		try{
			Thread.sleep(1000);
			
			//Detect if must change iframe
			boolean changeIframe = properties.length > 2 && properties[2] != null && properties[2].compareTo("") != 0  ;
			if ( changeIframe ){
				driver.switchTo().frame(properties[2]);
			}

			//If detect type SRC then find by SRC
			if ( properties[0].compareTo("src") == 0){
				driver.findElements(By.xpath(".//*[@src='"+properties[1]+"']")).get(0).click();
			//If detect xpath then find by XPATH				
			}else if ( properties[0].compareTo("xpath") == 0){
				driver.findElements(By.xpath(properties[1])).get(0).click();
			}else{
				driver.findElements(By.xpath("//*[contains(text(),'"+properties[1]+"')]")).get(0).click();
			}
			
			if ( changeIframe ){
				driver.switchTo().defaultContent();
			}
			
			Log.info("The text " + properties[1] +" exists");
		}catch(Exception e){
			Log.error("The text " + properties[1] +" doesn`t exist");
			Methods.createScreenshot(driver, className);
			//throw new Error();
			Assert.assertEquals(false, true);
		}
	}*/
	

	// NEW
	public static String getValue(WebDriver driver, String className, Properties properties, String field){
		String typeField = properties.getProperty(field + "Type");
		String valueField = properties.getProperty(field + "Value");
		
		return KeywordsAction.getTextFromWebElement(driver, typeField, valueField); 
	}
	
	
	
	//NEW
	public static void putValueAndEnter(WebDriver driver, String className, Properties properties, String field, String valueData){
		String typeField = properties.getProperty(field + "Type");
		String valueField = properties.getProperty(field + "Value");
		try{
			WebElement wE = (putValue(driver,className, properties, field, valueData));
			Thread.sleep(1000);
			wE.sendKeys(Keys.ENTER);
		}
		catch (Exception e)
		{
			Log.error("Something went wrong: " + e.getMessage());
			Methods.createScreenshot(driver, className);
			Assert.assertEquals(false, true);
		}
	}
	
	
	
	//TODO: RENOMBRAR A PUTVALUE
	public static WebElement putValue(WebDriver driver, String className,  Properties  properties, String field, String valueData){
		String typeField = properties.getProperty(field + "Type");
		String valueField = properties.getProperty(field + "Value");
		
		try
		{
			Thread.sleep(1000);
			//If exist elemeent
			if (KeywordsAction.existElement(driver, typeField, valueField))
			{
				Log.info("The element " + valueField + " exist");
				return KeywordsAction.input(driver, typeField, valueField, valueData);
			}
			else 
			{
				Log.error("The element " + valueField + " does not exist");
				Methods.createScreenshot(driver,className);
				Assert.assertEquals(false, true);
			}
		}
		catch (Exception e)
		{
			Log.error("Something went wrong: " + e.getMessage());
			Methods.createScreenshot(driver, className);
			Assert.assertEquals(false, true);
		}
		return null ;
	}

	

	//NEW
//	public static void popupCompareText(WebDriver driver, String className, Properties properties, String field, String TexMessageExpected){
//		try{	
//			//Thread.sleep(2000);
//			Log.info("Reading PopUp Text");
//			String TexMessage = CustomActions.getValueNew(driver, className, properties, field);
//				
//			Log.info("Comparing the PopUp Text");
//			if (TexMessage.equalsIgnoreCase(TexMessageExpected)) {
//				Log.info("[OK]   Text message is the expected");
//				Log.info("The user in Not logged in the application");
//			} else {
//				Log.error("[KO]   The error message NOT appear, or the user is logged in the application");
//				Methods.createScreenshot(driver, "loginTest");
//				Assert.assertEquals(false, true);
//			}
//		}
//		catch (Exception e){
//			Log.error("Something went wrong: " + e.getMessage());
//			Assert.assertEquals(false, true);
//		}
//		//driver.quit();
//		//driver.close();
//
//	}
	
//	public static boolean popupCompareText(WebDriver driver, String className, Properties properties, String field, String TexMessageExpected){
//		try{	
//			//Thread.sleep(2000);
//			Log.info("Reading PopUp Text");
//			String TexMessage = CustomActions.getValueNew(driver, className, properties, field);
//				
//			Log.info("Comparing the PopUp Text");
//			if (TexMessage.equalsIgnoreCase(TexMessageExpected)) {
//				return true;
//			} else {
//				Methods.createScreenshot(driver, className);
//				Assert.assertEquals(false, true);
//				return false;
//			}
//		}
//		catch (Exception e){
//			Log.error("Something went wrong: " + e.getMessage());
//			Assert.assertEquals(false, true);
//			return false;
//		}
//		//driver.quit();
//		//driver.close();
//	}	
	
//NEW
public static void compareText(WebDriver driver, String className, Properties properties, String field, String TexMessageExpected){
	try{	
		//Thread.sleep(2000);
		Log.info("Reading Text");
		String texMessage = CustomActions.getValue(driver, className, properties, field);
			
		Log.info("Comparing the Text ["+texMessage+"]");
		if (texMessage.equalsIgnoreCase(TexMessageExpected)) {
			Log.info("Text message ["+texMessage+"] is the expected");
		} else {
			Log.error("The expected message is: "+TexMessageExpected+" ande the Read message is: "+texMessage);
			Methods.createScreenshot(driver, "loginTest");
			Assert.assertEquals(false, true);
		}
	}
	catch (Exception e){
		Log.error("Something went wrong: " + e.getMessage());
		Assert.assertEquals(false, true);
	}
	//driver.quit();
	//driver.close();

}
	
}


