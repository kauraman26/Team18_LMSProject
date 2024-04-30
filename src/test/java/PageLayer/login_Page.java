package PageLayer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;

public class login_Page {
	
	WebDriver driver;
	private final static Logger LOG = LogManager.getLogger(login_Page.class);
	String url=com.LMS.utility.ConfigReader.getApplicationUrl();
	String wrongurl=com.LMS.utility.ConfigReader.getwrongApplicationUrl();
	String title = com.LMS.utility.ConfigReader.getHomePageTitle();
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	CommonUtils CommUtil = new CommonUtils();
	String errorMessage="";
	HttpURLConnection urlConnectioCheck = null;
	long navigationTime;
	
	
	@FindBy(xpath="//input[@id='username']")WebElement usernametxtbox;	
	//@FindBy(xpath="//label[@for ='username']")WebElement labelUsername;
	@FindBy(xpath="//*[@id ='mat-form-field-label-1']")WebElement usernameAstrick;
	@FindBy(xpath="//*[@id='mat-form-field-label-3']")WebElement passwordAstrick;
	@FindBy(xpath="//input[@id='password']")WebElement passwordtxtbox;
	@FindBy(xpath="//span[text()='Login']")WebElement loginbtn;
	@FindBy(xpath="//*[@label= 'A New Program']") WebElement newProgramBtn;
	@FindBy(xpath="//div[@class='box' and text() = ' Manage Program']") WebElement manageProgramHeader;
	@FindBy(xpath="//*[@src='assets/img/LMS-logo.jpg']") WebElement lmsImage;
	@FindBy(xpath="//*[@class='signin-content']")WebElement lmsPage;
	@FindBy(xpath="//*[@id='errormessage']") WebElement invalidLoginError;
	@FindBy(xpath="//*[@id='mat-error-0']")WebElement enterUserNameError;
	@FindBy(xpath="//*[@id='mat-error-1']")WebElement enterPasswordError;
	//*[@src='assets/img/LMS-logo.jpg']
	
	public login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openLMSHomePage() {
		driver.get(url);
	}
	
	public String validatelmsappText() {
		return lmsPage.getText();
	}
	
	public void openinvalidLMSHomePage() {
		driver.get(wrongurl);
	}
	
	public String loginErrorMsg() {
		return invalidLoginError.getText();
		
	}
	public void loginUsingValidDetails(String validUsrName,String validPassword) throws InterruptedException{
		usernametxtbox.clear();
		CommonUtils.webSendKeys(usernametxtbox, validUsrName);
		passwordtxtbox.clear();
		CommonUtils.webSendKeys(passwordtxtbox,validPassword);
		long startTime = System.currentTimeMillis();
		CommonUtils.webElement_Click(loginbtn);
		Thread.sleep(3000);
		long endTime = System.currentTimeMillis();
		navigationTime = (endTime - startTime);
	}
	
	
	public long navigationTime() {
		return navigationTime;
	}
	
	
	public void loginUsingKeyboardKey(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException, InterruptedException
	{
		
		List<Map<String, String>> testdata = excel.getData(Excelpath, Sheetname);
		String username=testdata.get(rownumber).get("username");
		String password=testdata.get(rownumber).get("password");
		usernametxtbox.clear();
		CommonUtils.webSendKeys(usernametxtbox, username);
		passwordtxtbox.clear();
		Actions actions = new Actions(driver);
		CommonUtils.webSendKeys(passwordtxtbox,password);
		actions.sendKeys(Keys.ENTER).perform();
		//Thread.sleep(3000);
	}
	
	
	
	public void fillvalidAndInvalidCredentials(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
		//List<Map<String,String>> testData = excelReader.getData(ExcelFilePath, Sheetname);
		List<Map<String, String>> testdata = excel.getData(Excelpath, Sheetname);
		String username=testdata.get(rownumber).get("username");
		String password=testdata.get(rownumber).get("password");
		loginUsingValidDetails(username,password);
				
	}
		

	public String validateDashboardlandingPage() {
		return CommUtil.getElementText(manageProgramHeader);
	}
	

	
	public void enterUsernameClickLogin(String username) throws InterruptedException {
		CommonUtils.webElement_Click(usernametxtbox);
		CommonUtils.webSendKeys(usernametxtbox,username);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(3000);
		//CommonUtils.webSendKeys(usernametxtbox, username);
		CommonUtils.webElement_Click(loginbtn);	
	}
	
	public void enterPasswrdClickLogin(String password) throws InterruptedException{
		CommonUtils.webElement_Click(passwordtxtbox);
		CommonUtils.webSendKeys(passwordtxtbox,password);
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(3000);
		CommonUtils.webElement_Click(loginbtn);	
		
	}
	
	public void enterPasswrdClickLogin() throws InterruptedException{
		//usernametxtbox.clear();
		CommonUtils.webElement_Click(passwordtxtbox);	
		Thread.sleep(3000);
		//CommonUtils.webSendKeys(passwordtxtbox, password);
		CommonUtils.webElement_Click(loginbtn);		
	}
	
	public boolean validateusernameerror() {
		return enterUserNameError.getText().contains("Please enter your user name");	
	}
	
	public boolean validateenterPasswordError() {
		return enterPasswordError.getText().contains("Please enter your password");	
	}
	
	
	public boolean isUserTextPresent(String text) {	
		return usernameAstrick.getText().contains(text);	
	}
	
	public boolean isPasswordTextPresent(String pwdtext) {	
		return passwordAstrick.getText().contains(pwdtext);	
	}
	
	
	public boolean validateLoginBtn() {
		 return loginbtn.isDisplayed();	
	}
	
	public boolean verifyButtonAlignment()
	{
		String script = "arguments[0].style.textAlign='center';";
	       boolean loginButtonAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, loginbtn);
	       return loginButtonAlignment;
	}
	
	public String verifyURLNotBroken(int statusCode){
		try
		{
			HttpURLConnection con= (HttpURLConnection) (new URL(wrongurl).openConnection());//using this url opened the connection to the server
			con.connect(); //now request will be sent to the server
			if(con.getResponseCode()>=400) //here server will send the response
			{
				System.out.println(url+ "---------"+ con.getResponseMessage()+" --- is broken");
				errorMessage="URL is broken link.";
			}
			else
			{
				System.out.println(url+"---------"+con.getResponseMessage()+" ---- is valid");
				errorMessage="URL is valid link.";
			}
			//return errorMessage;
		}
		catch(MalformedURLException e)
		{
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		return errorMessage;
	}
	
	public String verifyColor()
	{
	      String userTextColor = usernameAstrick.getCssValue("color");
	      String UserColorinHex = Color.fromString(userTextColor).asHex();
	      return UserColorinHex;
	}
	
	public String verifyPasswordColor()
	{
		//The color black with hexadecimal color code #000000 / #000 is a very dark shade of gray. 
	      String passwordTextColor = passwordAstrick.getCssValue("color");
	      String passwordColorinHex = Color.fromString(passwordTextColor).asHex();
	      return passwordColorinHex;
	}
		
	
	public boolean verifytextboxLMSHome() {
		if (usernametxtbox.isDisplayed()&& passwordtxtbox.isDisplayed())
			 return true;
		else
			return false;	 
		}
	
	
	
	
}
	
	

