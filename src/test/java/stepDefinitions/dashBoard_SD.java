package stepDefinitions;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.LMS.factory.DriverFactory;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LoggerLoad;
import PageLayer.dashBoard_Page;
import PageLayer.login_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dashBoard_SD {
	//private WebDriver driver;
	login_Page login= new login_Page(DriverFactory.getDriver());
	dashBoard_Page dashBoard_PageObj = new dashBoard_Page(DriverFactory.getDriver());
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	long startTime;
	
	@When("The Admin enter valid username and password from excel {string} and {int} and clicks login button")
	public void the_admin_enter_valid_username_and_password_from_excel_and_and_clicks_login_button(String sheetname, Integer Rownum) throws IOException, Exception 
	{
		login.openLMSHomePage();
		login.fillvalidAndInvalidCredentials(sheetname, Rownum);
	}
	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer expectedTime) 
	{
	    LoggerLoad.info("Admin validating page response time");
		long actualNavigTime = login.navigationTime();
		int actualNavigationTime = (int)actualNavigTime;
		Assert.assertEquals(actualNavigationTime, expectedTime);
	}
	@Then("Admin should see {string}  as title")
	public void admin_should_see_as_title(String ExpecLMSTitle) {
	    LoggerLoad.info("Admin validating page title");
		Assert.assertEquals(dashBoard_PageObj.getLMSTitle(), ExpecLMSTitle);
	}
	@Then("Admin should see correct spelling Program in navigation bar text")
	public void admin_should_see_correct_spelling_program_in_navigation_bar_text() {
	    LoggerLoad.info("Admin can see correct spelling for program");
		Assert.assertEquals(dashBoard_PageObj.getProgramFieldText(),"Program");
	}
	@Then("Admin should see correct spelling Batch in navigation bar text")
	public void admin_should_see_correct_spelling_batch_in_navigation_bar_text() {
	    LoggerLoad.info("Admin can see correct spelling for Batch");
		Assert.assertEquals(dashBoard_PageObj.getBatchFieldText(),"Batch");
	}
	@Then("Admin should see correct spelling User in navigation bar text")
	public void admin_should_see_correct_spelling_user_in_navigation_bar_text() {
	    LoggerLoad.info("Admin can see correct spelling for User");
		Assert.assertEquals(dashBoard_PageObj.getUserFieldText(),"User");
	}
	@Then("Admin should see correct spelling Logout in navigation bar text")
	public void admin_should_see_correct_spelling_logout_in_navigation_bar_text() {
	    LoggerLoad.info("Admin can see correct spelling for Logout");
		Assert.assertEquals(dashBoard_PageObj.getLogoutFieldText(),"Logout");
	}
	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	    LoggerLoad.info("Admin can see correct spelling in navigation bar text");
		String actualNavi=dashBoard_PageObj.getNavigationBar();
		Assert.assertEquals(actualNavi, "LMS - Learning Management System\n"
				+ "Program\n"
				+ "Batch\n"
				+ "User\n"
				+ "Logout");
	}
	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
	    LoggerLoad.info("Admin validating LMS title on top left corner of page");
		Assert.assertEquals(dashBoard_PageObj.getLeftAllignment(),"left");
	}
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	    LoggerLoad.info("Admin validating navigation bar text on the top right side");
		Assert.assertEquals(dashBoard_PageObj.getRightAllignment(),"right");
	}
	@Then("Admin should see correct spelling {string}  in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text(String fieldname) {
		Assert.assertEquals(dashBoard_PageObj.getAllFields(fieldname), fieldname);
	}
}