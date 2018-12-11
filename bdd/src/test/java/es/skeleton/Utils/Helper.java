package es.skeleton.Utils;

import org.junit.Assert;
/**
 * <h1>This class contains  common methods that help to the developer to create preconditions and actions to do after the test like, create patient or disable patient</h1>
 * This class is used to store the Constants used on Test.
 * <p>
 * 
 *
 * @author  Navio Cabanillas, Joaquin
 * @version 1.0
 * @since   2016-07-15
 */
import org.openqa.selenium.WebDriver;


public class Helper {
	/**
	 * @result, array to store the results  of read the xml file
	 */
	static String result[];

	/**
	 * <p>Method to create a new patient</p>
	 * @param driver, current webdriver
	 * @param newPatientName, name of the patient taht will be created
	 * @param XMLFILE, path of the xml file to read
	 */
	public static void newRandomPatient(WebDriver driver, String newPatientName, String XMLFILE)
	{
		try
		{
			Log.info("Create patient");
			Log.info("Read XML file and insert on name field");
			result=ReadXML2.readXML(XMLFILE, "lastName");
			KeywordsAction.input(driver,result[0] ,result[1], newPatientName);

			Log.info("Read XML file and insert on first name field");
			result=ReadXML2.readXML(XMLFILE, "firstName");
			KeywordsAction.input(driver,result[0] ,result[1], newPatientName);

			Log.info("Read XML file and select female sex");
			result=ReadXML2.readXML(XMLFILE, "sex");
			KeywordsAction.SelectOption(driver, result[0] ,result[1], "F");

			Log.info("Read XML file and insert on birth date field");
			result=ReadXML2.readXML(XMLFILE, "birthDate");
			KeywordsAction.input(driver, result[0] ,result[1], "14/02/2010");

			Log.info("Read XML file and click save button");
			result=ReadXML2.readXML(XMLFILE, "save");
			KeywordsAction.click(driver, result[0] ,result[1]);
		}
		catch(Exception e)
		{
			Log.error("Somethinf was wrong on create the patient: " + e.getMessage());
			Assert.assertEquals(false, true);
		} 



	}

	/**
	 * Method to seach a patient
	 * @param driver
	 * @param newPatientName
	 * @param newPatientFirstname
	 * @param XMLFILE
	 * @param status
	 */
	public static void searchPatient (WebDriver driver, String newPatientName, String newPatientFirstname, String XMLFILE, String status)
	{

		String [] name;
		String [] firstname;
		String [] searchButton;
		String [] patientListStatus;


		try
		{ 
			//alert, the tags name have to be the same on thje XML used
			Log.info("Search the patient: " + newPatientName+ " " + newPatientFirstname + "on status " + status + " 1->ACTIVE, 0->INACTIVE" );
			name=ReadXML2.readXML(XMLFILE, "patientListName");
			firstname=ReadXML2.readXML(XMLFILE, "patientListFirstname");
			searchButton=ReadXML2.readXML(XMLFILE, "patientListSearchButton");
			patientListStatus=ReadXML2.readXML(XMLFILE, "patientListStatus");


			KeywordsAction.clear(driver, name[0],  name[1]);
			KeywordsAction.clear(driver, firstname[0],  firstname[1]);


			KeywordsAction.input(driver, name[0],  name[1], newPatientName);
			KeywordsAction.input(driver, firstname[0],  firstname[1], newPatientFirstname);

			KeywordsAction.SelectOption(driver, patientListStatus[0],  patientListStatus[1], status);

			KeywordsAction.click(driver, searchButton[0],  searchButton[1]);



		}
		catch (Exception e)
		{
			Log.error("Error on search patient" + e.getMessage());


		}
	}
	
	/**
	 * MEthod to do logout action from other test
	 * @param driver
	 * @param XMLFILE
	 * @param testName
	 */
	/*public static void logoutAction (WebDriver driver, String XMLFILE, String testName)
	{
		try
		{
			result=ReadXML2.readXML(XMLFILE, "logoutbutton");	
			KeywordsAction.fluentClick(driver, result[0] ,result[1]);
			Log.info("Logout action on test: " + testName);
			System.out.println("Logout action on test: " + testName);


		}
		catch (Exception e)
		{
			Log.error("Error on logout action on test: " + testName);
			System.out.println("Error on logout action on test: " + testName);

		}

	}*/

}
