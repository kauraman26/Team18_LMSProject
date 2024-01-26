package PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.ConfigReader;
import com.dsalgo.util.ExcelUtils;


public class LoginPage {
	
	//private WebDriver driver=DriverFactory.getDriver();
	WebDriver driver;
	String loginURL=ConfigReader.getLoginUrl();
	String excelURL=ConfigReader.getexcelfilepath();
	
	@FindBy (xpath="//*[@id='id_username']")WebElement usernametxtbox;	
	@FindBy (xpath="//*[@id='id_password']")WebElement passwordtxtbox;
	@FindBy (xpath="//*[@value='Login']")WebElement loginBtn;
	@FindBy (xpath="//div[@class='alert alert-primary']")WebElement alertmsg;
	@FindBy (xpath="//a[@href='/register']")WebElement lnkregister;
	@FindBy (xpath="//a[@href='/logout']")WebElement Btnsignout;	
	@FindBy(xpath="//a[@href='/register']")WebElement RegisterLnk;
	@FindBy (xpath="//a[@href='/logout']")WebElement signout;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions		
		public void enterUsername(String username) {
			usernametxtbox.clear();
			usernametxtbox.sendKeys(username);
		}
		
		public void enterPassword(String password) {
			passwordtxtbox.clear();
			passwordtxtbox.sendKeys(password);
		}
		
		public void clickLoginBtnLoginPage(){
			loginBtn.click();
		}
		
		/*public void CorrectUsernameAndPassword()
	 	{
	 
			String path=System.getProperty("user.dir");
			ExcelUtils excel= new ExcelUtils(path+excelURL,"Login");
			String sUsername= excel.getCellDataString(1,0);
			String sPassword= excel.getCellDataNumber(1,1);
			usernametxtbox.sendKeys(sUsername);
			passwordtxtbox.sendKeys(sPassword);
			loginBtn.click();
	 	}*/
		
		public void signout() {
			if (signout.isDisplayed()) {
				signout.click();
			} 
			else {
				System.out.println("Signout Btn is not displayed");
			}
		}
		
		public void LoginUser(String username,String password) {
			enterUsername(username);
			enterPassword(password);
			clickLoginBtnLoginPage();	
			
		}
		
		public void clickRegisterLnkLoginPage() {
			lnkregister.click();
		}
		
		public String RegisterPageTitle() {
			return driver.getTitle();
		}
		
		public String AlertMessageLoginPage() {
			return alertmsg.getText();
		}
		
		public void SignInPageURL() {
			 driver.get(loginURL);
		}
		
		public String getEmptyfieldErrormsgPassword() {
			return passwordtxtbox.getAttribute("validationMessage");
		}
		
		public String getEmptyfieldErrormsgUserName() {
			return usernametxtbox.getAttribute("validationMessage");
		}

}
