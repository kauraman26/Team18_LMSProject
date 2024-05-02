package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.ApplicationData;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LMSConstants;
import com.LMS.utility.LoggerLoad;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	//ConfigReader configReader = new ConfigReader();
	static Properties prop;
	DriverFactory driverFactory = new DriverFactory();
	public static WebDriver driver;
	
	@BeforeAll
	public static void before_all() {
		prop= ConfigReader.init_prop();
		ApplicationData appData = new ApplicationData();
		appData.setApplicationData(ExcelReader.loadExcelData());
		LMSConstants.applicationData = appData;
	}
	
	
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
	
	
	//private static final Logger LOG=LogManager.getLogger(Hooks.class);
	
    @Before
    public void beforeScenario() {
    	
    	try {
    		//CommonUtils.loadProperties();
    		//prop = configReader.init_prop();
    	
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
    
   @AfterStep
    public void addScreenShot(Scenario scenario)
    {
    	
    	if(scenario.isFailed())
    	{
    		//LOG.error("Scenario failed");
    		String ScreenShotName = scenario.getName().replaceAll(" ", "_");
    		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(sourcePath, "image/png", ScreenShotName);
    		
    	}
    }
    
    public static WebDriver getDriver() {
        return driver;
    }

    


}
