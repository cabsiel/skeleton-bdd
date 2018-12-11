package es.skeleton.bdd.steps;

import org.apache.log4j.xml.DOMConfigurator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.skeleton.Utils.Constants;
import es.skeleton.Utils.Log;
import es.skeleton.UtilsByPage.UtilsMainGoogle;
import es.skeleton.bdd.tests.Test_Google;

public class Steps_Google extends Test_Google{

	/**
	 * @driver, webdriver driver
	 * @result, result of the XML search
	 */
	
	String className = Steps_Google.class.getName() ;
	//String ficheroXML = "Login.xml" ;
	Boolean existe;
	String resultXML[];
	
	
	@Before("@Entry on page Google")
	public void init() {
		DOMConfigurator.configure(Constants.Log4j_FILE);
		Log.startTestCase(className);
	}

	
	@Given("^Open web browser for SearchContentInGoogle")
	public void open_web_browser() throws Throwable {
		Log.info("Open web browser and access to the enviroment");
		initDriver();
		Log.info("Entry values on search box");
		UtilsMainGoogle.putValueToSearch(driver, className,"Test de buscador");
	}

	@When("^Entry values on search box")
	public void entry_values() throws Throwable {
		Log.info("Entry values on search box");
		UtilsMainGoogle.putValueToSearch(driver, className,"Test de buscador");
	}


//	@When("^Click on button Search")
//	public void click_button_search() throws Throwable {
//		Log.info("Click on button Search");
//	}
	@Before("^Success")
	public void success() throws Throwable {
	
	}

	
	@Given("^Google redirect to other page with the results")
	public void redirect_page() throws Throwable {
		Log.info("Google redirect to other page with the results");
	}


}