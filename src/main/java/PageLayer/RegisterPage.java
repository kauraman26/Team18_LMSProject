package PageLayer;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.util.ConfigReader;
import com.dsalgo.util.ExcelUtils;
import com.dsalgo.util.testUtil;



public class RegisterPage {
	
	WebDriver driver;
	String registerPageURL = ConfigReader.getRegisterUrl();
	
	@FindBy(xpath="//input[@type='submit' and @value='Register']")WebElement Btnregister;
	@FindBy(xpath="//input[@name='username']")WebElement txtboxusername;
	@FindBy (xpath="//*[@id='id_password1']") WebElement txtboxpassword;
	@FindBy (xpath="//*[@id='id_password2']")WebElement txtboxconfirmpwd;
	@FindBy (xpath="//*[@class='alert alert-primary']")WebElement alertMsg;
	@FindBy(xpath = "//div[@role='alert']")WebElement accountCreatedSuccess;
	
	
	//Constructor ,initializing the PageObjects
		public RegisterPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this); 
		} 
		
		
	public void RegisterPageURL() {
		driver.get(registerPageURL);
	}
	public void clickRegisterButton()  {
		Btnregister.click();	
		//testUtil.webElement_Click(Btnregister);
	}
	
	public void enterUserName(String uname) {
		//txtboxusername.sendKeys(testUtil.getRandomNum()+uname);
		//testUtil.webSendKeys(txtboxusername, testUtil.getRandomNum()+uname);
		txtboxusername.sendKeys(uname);
	}
	
	public void enterPassword(String pswrd) {
		txtboxpassword.sendKeys(pswrd);
		//testUtil.webSendKeys(txtboxpassword, pswrd);
	}
	
	public void enterConfirmPassword(String Confirmpswrd) {	
		txtboxconfirmpwd.sendKeys(Confirmpswrd);
		//testUtil.webSendKeys(txtboxconfirmpwd, Confirmpswrd);
	}
	
	public String registerSucessMessageRegisterPage() {
		return accountCreatedSuccess.getText();		
	}
	
	public String getEmptyfieldErrormsgUser() {
		return txtboxusername.getAttribute("validationMessage");
	}
	
	public String getEmptyfieldErrormsgPassword() {
		return txtboxpassword.getAttribute("validationMessage");
	}
	
	public String getEmptyfieldErrormsgPasswordConf() {
		return txtboxconfirmpwd.getAttribute("validationMessage");
	}
	
	public String passwordMismatchErrormsg() {
		return alertMsg.getText();
	}	
	
	
	
	
}


