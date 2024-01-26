package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.ConfigReader;
import com.dsalgo.util.ExcelUtils;
import com.dsalgo.util.testUtil;

import PageLayer.HomePage;
import PageLayer.LoginPage;
import PageLayer.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registerPage_SD {

	//private WebDriver driver = DriverFactory.getDriver();
	//LoginPage login;
	HomePage home = new HomePage(DriverFactory.getDriver());
	RegisterPage register = new RegisterPage(DriverFactory.getDriver());
	String Excelpath = ConfigReader.getexcelfilepath();
	String username;
	String password;
	String confirmpassword;

	/*
	 * public registerPage_SD() {
	 * 
	 * driver = DriverFactory.getDriver(); 
	 * home = new HomePage (driver); 
	 * register = new RegisterPage(driver); }
	 */

	@Given("The user opens Register page")
	public void the_user_opens_register_page() {
		register.RegisterPageURL();
	}

	@When("The user clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) {
		register.clickRegisterButton();
	}

	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String string) {
		Assert.assertEquals(register.getEmptyfieldErrormsgUser(), string);
	}

	@When("The user enters username {string} with other fields empty and then clicks Register button.")
	public void the_user_enters_username_with_other_fields_empty_and_then_clicks_register_button(String uname) {
		register.enterUserName(uname);
		register.clickRegisterButton();
	}

	@Then("It should throws an error {string}")
	public void it_should_throws_an_error(String string) {
		Assert.assertEquals(register.getEmptyfieldErrormsgPassword(), string);
	}

	@When("The user clicks Register button after giving the username {string} and password {string} with password confirmation field empty")
	public void the_user_clicks_register_button_after_giving_the_username_and_password_with_password_confirmation_field_empty(String username, String password) {
		register.enterUserName(username);
		register.enterPassword(password);
		register.clickRegisterButton();
	}

	@Then("The user can see the error message {string}")
	public void the_user_can_see_the_error_message(String string) {
		Assert.assertEquals(register.getEmptyfieldErrormsgPasswordConf(), string);
	}

	@When("The user enters {string}, {string}, and {string}")
	public void the_user_enters_and(String username, String password, String password1) {
		register.enterUserName(username);
		register.enterPassword(password);
		register.enterConfirmPassword(password1);
	}

	@When("the user clicks the register button")
	public void the_user_clicks_the_register_button() {
		register.clickRegisterButton();
	}

	@Then("the user should see the error message indicating {string}")
	public void the_user_should_see_the_error_message_indicating(String string) {
		Assert.assertEquals(register.passwordMismatchErrormsg(),string);
	}

	@Given("The user is on Register page")
	public void the_user_is_on_register_page() {
	   
	}

	@When("The user enters sheetname {string} and rownumber {int}")
	public void the_user_enters_sheetname_and_rownumber(String Sheetname, Integer RowNumber) throws InvalidFormatException, IOException {
		
		ExcelUtils excel = new ExcelUtils();
		List<Map<String, String>> testdata = excel.getData(Excelpath, Sheetname);
		username = testdata.get(RowNumber).get("username");
		password = testdata.get(RowNumber).get("password");
		confirmpassword = testdata.get(RowNumber).get("confirmpassword");
		
		register.enterUserName(username);
		register.enterPassword(password);
		register.enterConfirmPassword(confirmpassword);
		register.clickRegisterButton();
	}

	@Then("click the Register button and verify success message {string}")
	public void click_the_register_button_and_verify_success_message(String string) {
		
	}
}
