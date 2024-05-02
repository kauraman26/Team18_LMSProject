package PageLayer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;

public class dashBoard_Page {
	WebDriver driver;
	String url=com.LMS.utility.ConfigReader.getApplicationUrl();
	String title = com.LMS.utility.ConfigReader.getHomePageTitle();
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	CommonUtils CommUtil = new CommonUtils();
	@FindBy(xpath="//span[text()=' LMS - Learning Management System ']") WebElement LMSTitle;	
	@FindBy(xpath="//span[text()='Program']") WebElement programLink;	
	@FindBy(xpath="//span[text()='Batch']") WebElement Batchlink;	
	@FindBy(xpath="//span[text()='User']") WebElement Userlink;	
	@FindBy(xpath="//span[text()='Logout']") WebElement Logoutlink;	
	@FindBy(xpath="//*[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']") WebElement navigationBar;	

	public dashBoard_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getLMSTitle()
	{
		return LMSTitle.getText();
	}
	public String getLeftAllignment()
	{
		String elementLocation = LMSTitle.getCssValue("text-align");
		return elementLocation;
	}
	public String getRightAllignment()
	{
		String elementLocation = programLink.getCssValue("text-align");
		return elementLocation;
	}
	public String getNavigationBar()
	{
		return navigationBar.getText();
	}
	public String getProgram()
	{
		return programLink.getText();
	}

	public String getProgramFieldText() {
		return programLink.getText();

	}
	public String getBatchFieldText() {
		return Batchlink.getText();

	}
	public String getUserFieldText() {
      return Userlink.getText();

	}
	public String getLogoutFieldText() {
      return Logoutlink.getText();

	}
	public String getAllFields(String fieldname)
	{
		WebElement fields = driver.findElement(By.xpath("//span[text()='"+fieldname+"']"));
		return fields.getText();
	}
}