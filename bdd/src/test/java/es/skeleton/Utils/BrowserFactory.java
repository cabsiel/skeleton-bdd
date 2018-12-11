package es.skeleton.Utils;
/**
* <h1> Browser Factory Class</h1>
* <p>This class is used to instance a driver in function of the browser where we want</p>
* @author  Navio Cabanillas, Joaquin
* @version 1.0
* @since   2016-06-05
*/
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserFactory {
	
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	 
	/**
	 * This method is used to define the browser where we want to do the test. 
	 * @param browserNameis the parameter that indicates the browser selecte
	 */
	protected static WebDriver driver;
	public static WebDriver getBrowser(String browserName) {
	
		switch (browserName)
		{
			case "Firefox":
				Log.info("On browser factory class, the browser selected is Firefox");
				driver = drivers.get("Firefox");
				if (driver == null) 
				{
					DesiredCapabilities capabilities;
					capabilities = DesiredCapabilities.firefox();
					System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
			        driver = new FirefoxDriver(capabilities);
					drivers.put("Firefox", driver);
				}
				break;
			case "IE":
				Log.info("On browser factory class, the browser selected is Internet Explorer");
				driver = drivers.get("IE");
				if (driver == null)
				{
					System.setProperty("webdriver.ie.driver",
							"Drivers//IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					drivers.put("IE", driver);
				}
				break;
			case "Chrome":
				driver = drivers.get("Chrome");
				Log.info("On browser factory class, the browser selected is Chrome");
				if (driver == null)
				{
					System.setProperty("webdriver.chrome.driver",
							"Drivers//chromedriver.exe");
					driver = new ChromeDriver();
					drivers.put("Chrome", driver);
				}
				break;
		}
		
		return driver;
	}


	/**
	 * Method: closeAllDriver(),used to close and quit all drivers when the test is finished
	 */
	public static void closeAllDriver() 
	{
		for (String key : drivers.keySet()) 
		{
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}

}
