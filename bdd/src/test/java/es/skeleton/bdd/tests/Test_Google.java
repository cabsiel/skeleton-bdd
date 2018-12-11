package es.skeleton.bdd.tests;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import es.skeleton.BasicTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 


/**
 * <p>Features: Indicates the features file Path</p>
 * <p>Glue: Indicate the Step Definition Package</p>
 * <p>Tags: Indicates the scenarios that will be executed</p>
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "resources/features/",
//		glue={"es.skeleton.bdd.steps.Steps_Google"}
//		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
		format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
//		,tags = {"@Search_Google"}
		)
//########################################################################################
//########################################################################################

public class Test_Google {
	public WebDriver driver;


		
	@BeforeClass
    public static void setup()
 	{
		BasicTest.setup();
 	}
	
	public void initDriver(){
		driver = BasicTest.getDriver() ;
	}
	
}
