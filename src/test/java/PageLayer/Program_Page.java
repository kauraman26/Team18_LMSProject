package PageLayer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.CommonUtils;
import com.LMS.utility.LMSConstants;

public class Program_Page{
	
	WebDriver driver = DriverFactory.getDriver();
	login_Page programLogin = new login_Page(driver);
	
		@FindBy(id="deleteProgram")WebElement deletebtn;
		@FindBy(id="filterGlobal")WebElement searchbtn;
		@FindBy(xpath="//span[text()='Confirm']")WebElement confirmlabel;
		@FindBy(xpath="//span[text()='Yes']")WebElement yesBtn;
		@FindBy(xpath="//span[text()='No']")WebElement noBtn;
		@FindBy(xpath="//*[contains(text(),'Are you sure you want to delete')]")WebElement contentTxt;
		@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-4']")WebElement closeBtn;
		@FindBy(xpath="//div[contains(@class,'p-toast-summary')]")WebElement successPopupTitle;
		@FindBy(xpath="//div[contains(@class,'p-toast-detail')]")WebElement successPopupContent;
	
		Map<String,WebElement> buttonMap = new HashMap<>();
		
	public Program_Page() {
		PageFactory.initElements(driver, this);
		buttonMap.put("Yes", yesBtn);
		buttonMap.put("No", noBtn);
		buttonMap.put("Close", closeBtn);
		
	}
	
	public void userlogin() {
		programLogin.openLMSHomePage();
		
		userLogin(LMSConstants.LOGIN_SHEET_NAME,0);
	}
	
	public void userLogin(String Sheetname,int row){
		
		Map<String, String> testdata = LMSConstants.applicationData.getData(Sheetname, row);
		String username=testdata.get("username");
		String password=testdata.get("password");
		programLogin.loginUsingValidDetails(username,password);
		LMSConstants.applicationData.setUserLoggedIn(true);		
	}
	
	public void deleteBtn(String pname) {
		
		CommonUtils.webSendKeys(searchbtn,pname);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonUtils.webElement_Click(deletebtn);
		
	}
	
	public void alertClick(String buttonName) {
		
		CommonUtils.webElement_Click(buttonMap.get(buttonName));
	}
	
	public boolean successPopup() {
		
		return CommonUtils.verifyElementText("Successful", successPopupTitle);
	}
	
	public boolean getAlertPageTitle() {
		try {
		return CommonUtils.verifyElementText("Confirm", confirmlabel);
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean getAlertBtnText() {
		
		return CommonUtils.verifyElementText("Yes", yesBtn) && CommonUtils.verifyElementText("No", noBtn);
	
	}
	
	public boolean getAlertPageContent(String string) {
		
		return CommonUtils.verifyElementText(string,contentTxt);
	}
}
