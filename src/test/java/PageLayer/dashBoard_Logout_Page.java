package PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LMS.utility.CommonUtils;

public class dashBoard_Logout_Page {
	WebDriver driver;
	String dashBoardurl = com.LMS.utility.ConfigReader.getcorrepondingUrl("dashBoard_url");
	@FindBy(xpath="//span[text()='Logout']") WebElement logoutButton;	
	@FindBy(xpath="//span[text()='Login']") WebElement loginButton;
	public dashBoard_Logout_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPage() {
		return loginButton.getText();
	}
	public void ClickLogoutBtn()
	{
		//logoutButton.click();
		CommonUtils.webElement_Click(logoutButton);
	}
}