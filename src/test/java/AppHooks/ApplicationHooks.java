package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	ConfigReader configReader = new ConfigReader();
	Properties prop;
	DriverFactory driverFactory = new DriverFactory();
	
	/*private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}*/
	
	public static WebDriver driver;
	//private static final Logger LOG=LogManager.getLogger(Hooks.class);
	
    @Before
    public void beforeScenario() {
    	
    	try {
    		//CommonUtils.loadProperties();
    		prop = configReader.init_prop();
    	
    	if(driver== null) {
    		String browserName = prop.getProperty("browser");
    		//driver = DriverManager.launchBrowser();
    		driver = driverFactory.init_driver(browserName);
    		
    	
    	}
    	//LOG.info("Browser is launched");
    }
    catch (Exception e) {
    	e.printStackTrace();
    }
    }
    
   /*@AfterStep
    public void addScreenShot(Scenario scenario)
    {
    	
    	if(scenario.isFailed())
    	{
    		LOG.error("Scenario failed");
    		String ScreenShotName = scenario.getName().replaceAll(" ", "_");
    		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(sourcePath, "image/png", ScreenShotName);
    		
    	}
    }*/
    
    public static WebDriver getDriver() {
        return driver;
    }

//    @AfterAll
//    public static void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//            LOG.info("Browser session closed.");
//        }
//    }



}
