package es.skeleton.Utils;


/**
* <h1> Methods Class</h1>
* On this class will be created common methods for the other classes
* 
*
* @author  Navio Cabanillas, Joaquin
* @version 1.1
* @since   2016-07-04
*/
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Methods {

	/**
	 * Method to create a screenshot
	 * @param driver -> Current driver
	 * @param testCaseName -> name of the test case to create the screenshot
	 */
	public static void createScreenshot(WebDriver driver, String testCaseName)
	{
		
		if (Constants.flagBlockCreateFolder == false)
		{
			Constants.folderName = CreateFolderName(testCaseName);
			SaveScreenshot(driver, Constants.folderName , "sFileName");
		}
		else
		{
			SaveScreenshot(driver, Constants.folderName , "sFileName");
		}
	}
	
	/**
	 * Method to create a random string
	 * @return a string created with a random function
	 */
	public static String sRandom()
	{
		char n; 
    	Random rnd = new Random(); 
    	String cadena = new String(); 
		for (int i=0; i < 11 ; i++) 
    	{ 
    		n = (char)(rnd.nextDouble() * 26.0 + 65.0 ); 
    		cadena += n; 
    	} 
		return cadena;
	}
	
	/**
	 * 
	 * @param testcase The method receives the test case name to create de folder name
	 * @return the method returns the folder name in formato testcase_dd_mm_yyyy_hh_mm_ss
	 */
	private static String CreateFolderName(String testcase) 
	{
		Calendar date = new GregorianCalendar();
       
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);
        int hour = date.get(Calendar.HOUR_OF_DAY);
        int minute = date.get(Calendar.MINUTE);
        int second = date.get(Calendar.SECOND);

		String folderName = testcase + day + (month+1)  + year + "_" + hour+ "." + minute + "." + second;
        return folderName;
	}
	
	/**
	 * Method SaveScreenshot(). This method is the owner to save the screenshot on a folder. This folder must be unique per test case execute.
	 * For  this reason, until to save the file, check if any folder has been created for this test case, else create te folder, and put the variable flagBlockCreateFolder on true, and no more fodlers will be created 
	 * for these screenshots
	 * @param driver -> current driver
	 * @param folderName -> the folder name is created on other method
	 * @param fileName -> file name 
	 * @param Constants.flagBlockCreateFolder -> this local variable is to control the creation of the folder per test case executed.
	 */
	private static void SaveScreenshot(WebDriver driver, String folderName, String fileName)
	{
		//TO DO: pending to implement the method to generate the file name. When automation team will have a data base, the file name will be a autonumeric number
		File folder = new File("Screenshots\\"+folderName);
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		if(folder.exists())
		{
			
		    try
		    {
		    	String rand = sRandom();
		        FileUtils.copyFile(scrFile1, new File("Screenshots\\"+folderName+"\\"+rand+".jpg"));
		    } 
		    catch (IOException e)
		    {
		    	Log.error("Error while generating screenshot:\n" + e.toString());
		    }
		}
		else
		{
			folder.mkdir();
			Constants.flagBlockCreateFolder=true;
		
		    try
		    {
		    	String rand = sRandom();
		        FileUtils.copyFile(scrFile1, new File("Screenshots\\"+folderName+"\\"+rand+".jpg"));
		    } 
		    catch (IOException e)
		    {
		    	Log.error("Error while generating screenshot:\n" + e.toString());
		    }
		}
	}
	
	
}
