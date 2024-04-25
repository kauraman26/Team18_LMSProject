package PageLayer;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;




public class login_Page {
	
	WebDriver driver;
	String url=com.LMS.utility.ConfigReader.getApplicationUrl();
	String title = com.LMS.utility.ConfigReader.getHomePageTitle();
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	CommonUtils CommUtil = new CommonUtils();
	
	@FindBy(xpath="//input[@id='username']")WebElement usernametxtbox;	
	@FindBy(xpath="//input[@id='password']")WebElement passwordtxtbox;
	@FindBy(xpath="//span[text()='Login']")WebElement loginbtn;
	@FindBy(xpath="//*[@label= 'A New Program']") WebElement newProgramBtn;
	@FindBy(xpath="//div[@class='box' and text() = ' Manage Program']") WebElement manageProgramHeader;
	@FindBy(xpath="//div[@class='image-container']") WebElement lmsImage;
	
	
	public login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openLMSHomePage() {
		driver.get(url);
	}
	
	public String ActualPageTitle() {
		return driver.getTitle();
	}
	
	public void loginUsingValidDetails(String validUsrName,String validPassword){
		usernametxtbox.sendKeys(validUsrName);
		passwordtxtbox.sendKeys(validPassword);
		loginbtn.click();
	}
	
	public void fillvalidAndInvalidCredentials(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException {
		//List<Map<String,String>> testData = excelReader.getData(ExcelFilePath, Sheetname);
		List<Map<String, String>> testdata = excel.getData(Excelpath, Sheetname);
		String username=testdata.get(rownumber).get("username");
		String password=testdata.get(rownumber).get("password");
		loginUsingValidDetails(username,password);
				
	}
		
	
	
	
	public String validateDashboardlandingPage() {
		return CommUtil.getElementText(manageProgramHeader);
	}
	
	public String validateApplicationName() {
		return lmsImage.getText();
	}
}
