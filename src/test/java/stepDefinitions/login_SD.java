package stepDefinitions;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import com.LMS.factory.DriverFactory;
import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LoggerLoad;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class login_SD {
	
	login_Page login= new login_Page(DriverFactory.getDriver());
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	static String username;
	static String password;
	
	@Given("Admin launch the browser")
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() throws InterruptedException {
	  login.openinvalidLMSHomePage();	
	  //Thread.sleep(3000);
	}
	  
	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) throws InterruptedException {
		
		Assert.assertTrue(login.validateerrorinvalidURL(),"Admin recieved page not found error");	   
		LoggerLoad.info("Admin recieved page not found error");
	}
	
	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	   login.openLMSHomePage();
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {

		Assert.assertEquals(CommonUtils.ActualPageTitle(),ConfigReader.getHomePageTitle());
	    LoggerLoad.info("Admin landed on Home page");
	}
	
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
	    
	}
	
	@When("Admin enter invalid credentials  from excel {string} and {int} and clicks login button")
	public void admin_enter_invalid_credentials_from_excel_and_and_clicks_login_button(String sheetname, Integer rownum) throws InvalidFormatException, IOException, InterruptedException {		
		login.fillvalidAndInvalidCredentials(sheetname, rownum);	
	}

	@Then("Error Message {string}")
	public void error_message(String expError) {
		
	    String actualErr=login.loginErrorMsg();
	    Assert.assertEquals(actualErr, expError);
	    LoggerLoad.info("Admin received the error message on entering invalid credentials");	    
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer statuscode) {
		
	    String Act_response=login.verifyURLNotBroken(statuscode);
	    Assert.assertEquals(Act_response,"URL is broken link." );
	    LoggerLoad.info("Link is broken");
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {	
		String bodytext = login.validatelmsappText();
		
		Assert.assertTrue(bodytext.contains("Please login to LMS application"), "Text not found!");
		Assert.assertTrue(bodytext.contains("User *"), "Text not found!");
		Assert.assertTrue(bodytext.contains("Password *"), "Text not found!");
		Assert.assertTrue(bodytext.contains("Login"), "Text not found!");

		LoggerLoad.info("Correct spellings are displayed in all fields");
	}

	@Then("Admin should see logo on the left  side")
	public void admin_should_see_logo_on_the_left_side() {
	    
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		
		 
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
	    
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String expectedString) {	
		String bodytext = login.validatelmsappText();	
		Assert.assertTrue(bodytext.contains("Please login to LMS application"), expectedString);
		LoggerLoad.info("Admin see message Please login to LMS application");
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {	
	   Assert.assertTrue(login.verifytextboxLMSHome(),"Admin cannot see two field");
	   LoggerLoad.info("Admin see 2 text fields - username and password");
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String usertext) {		
		Assert.assertTrue(login.isUserTextPresent(usertext));
		LoggerLoad.info("Admin see User in first text field");
	}

	@Then("Admin should see {string} symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text(String userAstrick) {			
		Assert.assertTrue(login.isUserTextPresent(userAstrick));
		LoggerLoad.info("Admin see * symbol next to user text");
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String passwordtext) {		
		Assert.assertTrue(login.isPasswordTextPresent(passwordtext));
		LoggerLoad.info("Admin see Password as second text field");
	}

	@Then("Admin should see {string} symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text(String passwordAstrick) {		
		Assert.assertTrue(login.isPasswordTextPresent(passwordAstrick));
		LoggerLoad.info("Admin see * symbol next to password text");
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {    
	    Assert.assertTrue(login.validateLoginBtn(), "Login button is displayed");
	    LoggerLoad.info("Admin see Login button on Home Page");
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
	    
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	    String color =login.verifyColor();
	    Assert.assertEquals(color, "#000000");	
	    LoggerLoad.info("Admin see user in gray color");
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		String color1 = login.verifyPasswordColor();
		Assert.assertEquals(color1, "#000000");
		LoggerLoad.info("Admin see password in gray color");
	}

	@When("Admin enter {string} value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button(String password) throws InterruptedException {
		
		login.enterPasswrdClickLogin();
	}

	@When("Admin enter {string} value only in username and clicks login button")
	public void admin_enter_value_only_in_username_and_clicks_login_button(String string) throws InterruptedException {
		
		login.enterUsernameClickLogin(ConfigReader.getUsername());				
	}
	
	@Then("User gets Error message {string}")
	public void user_gets_error_message(String string) {	
	    Assert.assertTrue(login.validateusernameerror());
	    Assert.assertTrue(login.validateenterPasswordError());
	    LoggerLoad.info("User get error message for null username and password");
	}
	
	@When("Admin enter valid credentials  from excel {string} and {int} and clicks login button using mouse")
	public void admin_enter_valid_credentials_from_excel_and_and_clicks_login_button_using_mouse(String sheetname, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
		//login.openLMSHomePage();
		login.fillvalidAndInvalidCredentials(sheetname, rownumber);
	}
	
	@When("Admin enter valid credentials from excel {string} and {int}  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_from_excel_and_and_clicks_login_button_through_keyboard(String sheetname, Integer rownum) throws InvalidFormatException, IOException, InterruptedException {
		login.openLMSHomePage();
		login.loginUsingKeyboardKey(sheetname,rownum);	
	}
	
	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {	
		 Assert.assertEquals(login.validateDashboardlandingPage(),ConfigReader.getDashboardHeader());
		 LoggerLoad.info("Admin landed on Dashboard page after Login");
	}
	
	    
	}	

	
	

