package es.skeleton.Utils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
/**
* <h1> Action KeyWords Class</h1>
* 
* <p>
* On this class we store the differents actions that selenium will execute to do the test.
* @author  Navio Cabanillas, Joaquin
* @version 1.2
* @since   2016-09-05
*/
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class KeywordsAction {
	
	public static WebDriverWait wait;
	
	
	/**
	 * Method used to make the sendKeys action of selenium webdriver
	 * @param driver -> current web driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement where the action click() will be done
	 * @param value -> value of the webelement where the action click() will be done
	 * @param sendKey -> value inserted on the field
	 */
	public static WebElement input(WebDriver driver, String type, String value, String sendKey){
		wait = new WebDriverWait(driver, 20);
		try{
			WebElement wE = null ;
			wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			wE = getWebElementByType(driver, type, value);
			wE.sendKeys(sendKey);
			return wE ;
		 }
		catch(Exception e)
		{
			System.out.println("Unable to do input() action");
			Log.error("Not able to sendKey()--- " + e.getMessage());
		}
		return null;
	}

	public static WebElement getWebElement(WebDriver driver, String ficheroXML, String nameOfField){
		String[] resultXML = ReadXML2.readXML(ficheroXML, nameOfField);
		return getWebElementByType(driver,  resultXML[0], resultXML[1]);
	}
	
	public static WebElement getWebElementByType(WebDriver driver, String type, String value){
		if ( wait == null ){
			wait = new WebDriverWait(driver, 50);
		}
		
		WebElement wE = null ;
		if(type.equals("id"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			wE = driver.findElement(By.id(value));
		}
		else if(type.equals("class"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
			wE =  driver.findElement(By.className(value));
		}
		else if(type.equals("name"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			wE =  driver.findElement(By.name(value));
		}
		else if(type.equals("xpath"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
			wE =  driver.findElement(By.xpath(value));
		}
		else if(type.equals("src"))
		{
			WebElement temp = driver.findElement(By.xpath(value));
			wE =  driver.findElement(By.xpath(value));
		}
		return wE ;
	}
	
	/**
	 * Method used to make the click button of selenium webdriver
	 * @param driver -> current driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement where the action click() will be done
	 * @param value -> value of the webelement where the action click() will be done
	 */
	public static void click(WebDriver driver, String type, String value)
	{
		wait = new WebDriverWait(driver, 50);
		
		try
		{		
			if(type.equals("id"))
			{
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				element.click();
			}
			else if(type.equals("class"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
				driver.findElement(By.className(value)).click();
			}
			else if(type.equals("name"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
				driver.findElement(By.name(value)).click();
			}
			else if(type.equals("xpath"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				driver.findElement(By.xpath(value)).click();
			
			}
			else if(type.equals("linkText"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				driver.findElement(By.linkText(value)).click();
			}
			else if(type.equals("css"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
				driver.findElement(By.cssSelector(value)).click();
			}


		}
		catch(Exception e)
		{ 			
			System.out.println("Unable to do click() action");
			Log.error("Not able to click--- " + e.getMessage());
        }
	}
	


	/**
	 * Method to check if any webelement exists
	 * @param driver -> current web driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement where the action click() will be done
	 * @param value -> value of the webelement 
	 * @return boolean value about if the webelement exists or appears on the screen
	 */
	public static boolean existElement (WebDriver driver , String type, String value)
	{
		@SuppressWarnings("unused")
		WebElement exists; 
		if(type.equals("id"))
		{
			try
			{
				driver.findElement(By.id(value));
				return true;
			}
			catch(Exception e)
			{
				return false;
			}	
		}
		else if(type.equals("class"))
		{	
			try
			{
				driver.findElement(By.className(value));
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else if(type.equals("name"))
		{
			exists = driver.findElement(By.name(value));
			return true;
		}
		else if(type.equals("xpath"))
		{
			try
			{
				driver.findElement(By.xpath(value));
				return true;
			}
			catch(Exception e)
			{
				return false;
			}			
		}
		else if(type.equals("linkText"))
		{

			try
			{
				driver.findElement(By.linkText(value));
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else if(type.equals("css"))
		{
//			exists = driver.findElement(By.linkText(value));
//			return true;	
			try
			{
				driver.findElement(By.cssSelector(value));
				return true;
			}
			catch(Exception e)
			{
				return false;
			}

		}
		return false;
	}
	
	/**
	 * Method to put the focus on a determinate webelement
	 * @param driver -> current web driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement where the action click() will be done
	 * @param value -> value of the webelement 
	 */
	public static void actionMovetoElement(WebDriver driver, String type, String value)
	{
		WebElement element;
		Actions action;
		if(type.equals("id"))
		{
			element = driver.findElement(By.linkText(value));
			action = new Actions(driver);		 
	        action.moveToElement(element).build().perform();			
		}
		else if(type.equals("class"))
		{
			element = driver.findElement(By.className(value));
			action = new Actions(driver);
			action.moveToElement(element).build().perform();			
			
		}
		else if(type.equals("name"))
		{
			element = driver.findElement(By.name(value));
			action = new Actions(driver);
	        action.moveToElement(element).build().perform();
		
		}
		else if(type.equals("xpath"))
		{
			element = driver.findElement(By.xpath(value));
			action = new Actions(driver); 
	        action.moveToElement(element).build().perform();
			
		}
		else if(type.equals("linkText"))
		{
			element = driver.findElement(By.linkText(value));
			action = new Actions(driver);			 
	        action.moveToElement(element).build().perform();				
		}	
	}
	
	/**
	 * Method to select one option of a select element
	 * @param driver -> current web driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement where the action click() will be done
	 * @param value -> value of the webelement 
	 * @param sendkey -> Option selected
	 */
	public static void SelectOption(WebDriver driver, String type, String value, String sendkey)
	{
		wait = new WebDriverWait(driver, 50);
		try
		{
			if(type.equals("id"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				Select oSelect = new Select(driver.findElement(By.id(value)));
				oSelect.selectByValue(sendkey);		
			}
			else if(type.equals("class"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
				Select oSelect = new Select(driver.findElement(By.className(value)));
				oSelect.selectByValue(sendkey);	
			}
			else if(type.equals("name"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
				Select oSelect = new Select(driver.findElement(By.name(value)));
				oSelect.selectByValue(sendkey);	
			}
			else if(type.equals("xpath"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				Select oSelect = new Select(driver.findElement(By.xpath(value)));
				oSelect.selectByValue(sendkey);	
			}
			else if(type.equals("linkText"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				Select oSelect = new Select(driver.findElement(By.linkText(value)));
				oSelect.selectByValue(sendkey);	
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to do selectOption() action");
			Log.error("Not able to select the option()--- " + e.getMessage());
		}
	}
	
	/**
	 * The method clickJavaScriptButton (WebDriver driver, String type, String value) is used to click on javascripts buttons
	 * @param driver -> current web driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement 
	 * @param value -> value of the webelement 
	 */
	public static void clickJavaScriptButton(WebDriver driver, String type, String value)
	{
		wait = new WebDriverWait(driver, 50);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement element;
		try
		{
			if(type.equals("id"))
			{
				element = driver.findElement(By.id(value));
			    executor.executeScript("arguments[0].click();", element);
			}
			else if(type.equals("class"))
			{
				element = driver.findElement(By.className(value));
			    executor.executeScript("arguments[0].click();", element);
			}
			else if(type.equals("name"))
			{
				element = driver.findElement(By.name(value));
			    executor.executeScript("arguments[0].click();", element);
			}
			else if(type.equals("xpath"))
			{
				element = driver.findElement(By.xpath(value));
			    executor.executeScript("arguments[0].click();", element);
			}
			else if(type.equals("linkText"))
			{
				element = driver.findElement(By.linkText(value));
			    executor.executeScript("arguments[0].click();", element);
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to do clickOnJavascriptButton() action");
			Log.error("Not able to click on javascript button--- " + e.getMessage());
		}
	}
	
	/**
	 * The method AcceptAlert is used to accept the confirmation messages
	 * @param driver Current driver
	 */
	public static void AcceptAlert(WebDriver driver)
	{
		Alert simpleAlert = driver.switchTo().alert();		
		simpleAlert.accept();
		
	}
	
	/**
	 * The method DismissAlert is used to dismiss the confirmation messages
	 * @param driver Current driver
	 */
	public static void DismissAlert(WebDriver driver)
	{
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.dismiss();
	}
	
	/**
	 * The method: getTextFromWebElement returns the text of an especific webelement
	 * @param driver -> current web driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement 
	 * @param value -> value of the webelement 
	 * @return returns the string with the text value
	 */
	public static String getTextFromWebElement(WebDriver driver, String type, String value)
	{
		WebElement element;
		try
		{
			if(type.equals("id"))
			{
				element = driver.findElement(By.id(value));
			   return element.getText();
			}
			else if(type.equals("class"))
			{
				element = driver.findElement(By.className(value));
				return element.getText();
			}
			else if(type.equals("name"))
			{
				element = driver.findElement(By.name(value));
				return element.getText();
			}
			else if(type.equals("xpath"))
			{
				element = driver.findElement(By.xpath(value));
				return element.getText();
			}
			else if(type.equals("linkText"))
			{
				element = driver.findElement(By.linkText(value));
				return element.getText();
			}
			else if(type.equals("css"))
			{
				element = driver.findElement(By.cssSelector(value));
				return element.getText();
			}
			return null;
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to getTextFromWebElement() action");
			Log.error("Not able to get the text of the webelement--- " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * The method: clear() cleans the fields of any data
	 * @param driver -> current web driver
	 * @param type -> type {id, class, name, xpath, linkText} of the webelement 
	 * @param value -> value of the webelement 
	 */
	public static void clear(WebDriver driver, String type, String value)
	{
		wait = new WebDriverWait(driver, 50);
		
		try
		{		
			if(type.equals("id"))
			{
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				element.clear();
			}
			else if(type.equals("class"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
				driver.findElement(By.className(value)).clear();
			}
			else if(type.equals("name"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
				driver.findElement(By.name(value)).clear();
			}
			else if(type.equals("xpath"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				driver.findElement(By.xpath(value)).clear();
			
			}
			else if(type.equals("linkText"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				driver.findElement(By.linkText(value)).clear();
			}
			else if(type.equals("css"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
				driver.findElement(By.cssSelector(value)).clear();
			}


		}
		catch(Exception e)
		{ 			
			System.out.println("Unable to clear() action");
			Log.error("Not able to clear--- " + e.getMessage());
        }
	}
	
	/**
	 * FluentWait to click on a webelement. Every 3 seconds until 30 seconds (timeout), the driver is
	 * searching an specific webelement
	 * @param driver
	 * @param type
	 * @param value
	 */
	public static void fluentClick(WebDriver driver, String type, String value)
	{
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(3,  TimeUnit.SECONDS);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
		
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
				{
					public WebElement apply(WebDriver arg0) {
						
						By mySelector = By.id(value);
						if(type.equals("id")) { mySelector = By.id(value);}
						else if(type.equals("class")) { mySelector = By.className(value);}
						else if(type.equals("name")){ mySelector = By.name(value);}
						else if(type.equals("xpath")){ mySelector = By.xpath(value);}
						else if(type.equals("linkText")){ mySelector = By.linkText(value);}
						else if(type.equals("css")){ mySelector = By.cssSelector(value);}
						
						System.out.println("Checking for the element!!");
						WebElement element = arg0.findElement(mySelector);
						if(element != null)
						{
							System.out.println("Element found");
						}
						return element;
					}
				};
 
		WebElement element = wait.until(function);
		
		 element.click();
	}
	
	/**
	 * FluentWait to enter text on a webelement. Every 3 seconds until 30 seconds (timeout), the driver is
	 * searching an specific webelement
	 * @param driver
	 * @param type
	 * @param value
	 * @param inputValue
	 */
	public static void fluentInput(WebDriver driver, String type, String value, String inputValue)
	{
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(3,  TimeUnit.SECONDS);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
		
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
				{
					public WebElement apply(WebDriver arg0) {
						
						By mySelector = By.id(value);
						if(type.equals("id")) { mySelector = By.id(value);}
						else if(type.equals("class")) { mySelector = By.className(value);}
						else if(type.equals("name")){ mySelector = By.name(value);}
						else if(type.equals("xpath")){ mySelector = By.xpath(value);}
						else if(type.equals("linkText")){ mySelector = By.linkText(value);}
						else if(type.equals("css")){ mySelector = By.cssSelector(value);}
						
						System.out.println("Checking for the element!!");
						WebElement element = arg0.findElement(mySelector);
						if(element != null)
						{
							System.out.println("Element found");
						}
						return element;
					}
				};
 
		WebElement element = wait.until(function);
		
		 element.sendKeys(inputValue);
	}



}
	

