package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.ConfigReader;
import com.dsalgo.util.ExcelUtils;
import com.dsalgo.util.LoggerLoad;

import AppHooks.ApplicationHooks;
import PageLayer.HomePage;
import PageLayer.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPage_SD {
	
	private WebDriver driver;
	
	LoginPage login= new LoginPage(DriverFactory.getDriver());
	HomePage home= new HomePage (DriverFactory.getDriver());
	static String username;
	static String password;
	static String message;
	Boolean isRequired;
	String Excelpath = ConfigReader.getexcelfilepath();
	
	/*public loginPage_SD()
	{
		
		driver = DriverFactory.getDriver();
		//driver=ApplicationHooks.getDriver();
		login = new LoginPage(driver);
		home = new HomePage (driver);
	}*/
	
	@Given("User is on Signin Page")
	public void user_is_on_signin_page() {
		login.SignInPageURL();
	}

	@When("The user clicks on register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() {
		login.clickRegisterLnkLoginPage();
	}

	@Then("The user redirected to Registration page from signin page")
	public void the_user_redirected_to_registration_page_from_signin_page() {
		String pageTitle = login.RegisterPageTitle();
		Assert.assertEquals(pageTitle, "Registration");
		LoggerLoad.info("The title of page is "+ pageTitle);
	}

	@Given("The user is on signin page")
	public void the_user_is_on_signin_page() {
		login.SignInPageURL();
	}

	@When("The user enters username {string} and click Login button")
	public void the_user_enters_username_and_click_login_button(String string) {
	   login.enterUsername(string);
	   login.clickLoginBtnLoginPage();   
	}

	@Then("It should display an error {string} below password textbox")
	public void it_should_display_an_error_below_password_textbox(String string) {
		String actualErrorMessage = login.getEmptyfieldErrormsgPassword();
		Assert.assertEquals(actualErrorMessage, string);
		LoggerLoad.info("The actualerror is- "  +actualErrorMessage);
	}

	@When("The user enters password {string} and click Login button")
	public void the_user_enters_password_and_click_login_button(String string) {
	    login.enterPassword(string);
	}

	@Then("It should display an error {string} below username textbox")
	public void it_should_display_an_error_below_username_textbox(String string) {
	   String actualErrrMessage = login.getEmptyfieldErrormsgUserName();
	   Assert.assertEquals(actualErrrMessage, string);
	   LoggerLoad.info("The actualerror is- "  +actualErrrMessage);
	}

	@When("The user enters an invalid username {string} and  password {string} combination")
	public void the_user_enters_an_invalid_username_and_password_combination(String username, String password) {
	    login.LoginUser(username, password);
	}

	@Then("It should display an error {string}")
	public void it_should_display_an_error(String string) {
	    String ErrorMessage = login.AlertMessageLoginPage();
	    System.out.println("the actualerror is- "  +ErrorMessage);
		Assert.assertEquals(ErrorMessage, string);
	}

	@When("The user enters valid username {string} and password {string} and click on SignIn button")
	public void the_user_enters_valid_username_and_password_and_click_on_sign_in_button(String username, String password) {
		login.LoginUser(username, password);
		
	}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage() {
	    Assert.assertTrue(home.VerifySignoutLnk());
	}
	
	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String sheetname, Integer RowNumber) throws InvalidFormatException, IOException {

		ExcelUtils excel = new ExcelUtils();
		List<Map<String, String>> testdata = excel.getData(Excelpath, sheetname);
		username = testdata.get(RowNumber).get("username");
		password = testdata.get(RowNumber).get("password");
		//Loggerload.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
		if (username != null || password != null)
			login.LoginUser(username, password);
	}

	@Then("click login button")
	public void click_login_button() {
		Assert.assertTrue(home.VerifySignoutLnk());
		 String LoginMessage = login.AlertMessageLoginPage();
		    System.out.println("the Login message is- "  +LoginMessage);
			Assert.assertEquals(LoginMessage, "You are logged in");
		
	}
}
