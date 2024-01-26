package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.LoggerLoad;

import PageLayer.ArrayPage;
import PageLayer.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class arrayPage_SD {
	
	//private WebDriver driver;
	ArrayPage Array = new ArrayPage(DriverFactory.getDriver());
	HomePage Home = new HomePage(DriverFactory.getDriver());
	
	@Given("The user is on the home page after logged in")
	public void the_user_is_on_the_home_page_after_logged_in() {
	    Home.homepage();
	}

	@When("The user clicks Get Started button under Array")
	public void the_user_clicks_get_started_button_under_array() {
	    Array.ClickGetStartedBtnArray();
	}

	@Then("The user be directed to {string} Data Structure Page")
	public void the_user_be_directed_to_data_structure_page(String pagename) {
		
		String Title = Array.getArrayPageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		Assert.assertEquals(Title, pagename, "Title do not match");
	}
	
	@Given("The user is on the Array Page after logged in")
	public void the_user_is_on_the_array_page_after_logged_in() {
	   
	}

	@When("The user clicks {string} link")
	public void the_user_clicks_link(String string) {
	   Array.ClickArraysInPython();
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {
		
		String Title = Array.getArrayPageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		Assert.assertEquals(Title, string, "Title do not match");
	}
	
	@Given("The user is on the Arrays in Python after logged in")
	public void the_user_is_on_the_arrays_in_python_after_logged_in() {
	   
	}

	@When("The user clicks {string} button on {string} page")
	public void the_user_clicks_button_on_page(String string, String string2) {
		
	    Array.clickOnTryHereLink();
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		
		String Title = Array.getArrayPageTitle();
		LoggerLoad.info("Title of current page is : " + Title);
		Assert.assertEquals(Title, "Assessment", "Title do not match");
	}

	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() {
	    
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	    Array.enterPythonCode(SheetName, RowNumber);
	   String expectedMsg = Array.getExpectedResult(SheetName, RowNumber);
	   System.out.println(expectedMsg);
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
	   Array.clickOnRunButton();
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		String actualMsg =  Array.validatePythonCodeGotPrinted();
		LoggerLoad.info("Actual result  : " + actualMsg);
		Assert.assertEquals(actualMsg, "hello World", "Result do not match");
	}

	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		 Array.enterPythonCode(SheetName, RowNumber);
		   String expectedMsg = Array.getExpectedResult(SheetName, RowNumber);
		   System.out.println(expectedMsg);
	}

	@Then("The user should be presented with error message as {string}")
	public void the_user_should_be_presented_with_error_message_as(String string) {
	    
	}

}
