package es.skeleton ;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.ExtentCucumberFormatter;

import es.skeleton.Utils.BrowserFactory;
import es.skeleton.Utils.Constants;
import es.skeleton.Utils.Log;


public class BasicTest {
	private static  WebDriver driver;
	
	static String browser;
	static String browserversion;
	static String seleniumVersion;
	static String junitVersion;
	static String cucumberVersion;
	static	String cucumberExtReportVersion;
	static String environment;
	static Properties  propiedadesEntorno;
	static Properties  propiedadesComunes;
	
	public static String userName ; 
	public static String password ;
	public static String centerCode;
	public static String profileCode;
	public static String speciality;
	
	public static String paciente01nombre;
	public static String paciente01Apellido1;
	public static String paciente01documeentoId;

	
	@BeforeClass
    public static void setup()
 	{
		//INDICATE 
		String environmentSelected = "test" ;
		browser= "Chrome" ;
	
		String reportDir = "output/report.html";
	 	ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File(reportDir), false);		 
        ExtentCucumberFormatter.loadConfig(new File("resources/features/extent-config.xml"));
        propiedadesComunes = new Properties();
        propiedadesEntorno = new Properties();
        
        try
        {
        	InputStream is = new FileInputStream("resources/envirorment/basic/environment.properties");
        	        	
        	propiedadesComunes.load(is);
//        	browser = propiedadesComunes.getProperty("browser");
        	browserversion = propiedadesComunes.getProperty("browserVersion");
        	seleniumVersion = propiedadesComunes.getProperty("seleniumVersion");
        	junitVersion = propiedadesComunes.getProperty("junitVersion");
        	cucumberVersion = propiedadesComunes.getProperty("cucumberVersion");
        	cucumberExtReportVersion = propiedadesComunes.getProperty("cucumberExtReportVersion");
        	

        	ExtentCucumberFormatter.addSystemInfo("Browser Name", browser);
        	ExtentCucumberFormatter.addSystemInfo("Browser version", browserversion);
        	ExtentCucumberFormatter.addSystemInfo("Selenium version", seleniumVersion);
        	ExtentCucumberFormatter.addSystemInfo("JUNIT", junitVersion);
        	
        	InputStream  isEntorno = new FileInputStream("resources/envirorment/clients/environment_" +environmentSelected.toLowerCase() + ".properties");
        	
        	propiedadesEntorno.load(isEntorno);
        	environment = propiedadesEntorno.getProperty("environment");
        	userName = propiedadesEntorno.getProperty("userName");
        	password = propiedadesEntorno.getProperty("password");
        	profileCode = propiedadesEntorno.getProperty("profileCode");
        	speciality = propiedadesEntorno.getProperty("speciality");
        	
        	
        	Map systemInfo = new HashMap();
        	systemInfo.put("Cucumber version", cucumberVersion);
        	systemInfo.put("Extent Cucumber Reporter version", cucumberExtReportVersion);
        	ExtentCucumberFormatter.addSystemInfo(systemInfo);
        } 
        catch (IOException e) 
        {
        	System.out.println("Error: " + e.getMessage());
        }

        //System.out.println("Starting test case: " + TestCreateAppointment.class.getName());
        DOMConfigurator.configure(Constants.Log4j_FILE);
        //Log.startTestCase(TestCreateAppointment.class.getName());
        Log.info("Instantiate and open the web browser: " +browser);
 	}
	
	/**
	 * Method to return a driver instance created
	 * @return
	 */
	public static WebDriver getDriver()
	{
		setup();
		driver = BrowserFactory.getBrowser(browser);
		driver.get(environment);
		driver.manage().window().setSize(new Dimension(1920,1080));
		return driver;
	}
}