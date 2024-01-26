package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.ConfigReader;
import com.dsalgo.util.LoggerLoad;

import PageLayer.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homePage_SD {
	
	private WebDriver driver;
	//HomePage homePage;
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	/*public homePage_SD() {
		
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	}*/
	
	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() {
	
		homePage.dsalgopage();	   
	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		homePage.getStarted_link(string);
	
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		
		String actualPageTitle = homePage.LandedHomePage();	
		//Assert.assertEquals(actualPageTitle, "https://dsportalapp.herokuapp.com/home");
		Assert.assertEquals(actualPageTitle,ConfigReader.getHomeUrl());
		LoggerLoad.info("The user is on "+ actualPageTitle +" page");
	}

	@Given("The user is on Home page")
	public void the_user_is_on_home_page() {
	    homePage.homepage();
	}

	@When("The user clicks on Get Started link on homepage {string} without login")
	public void the_user_clicks_on_get_started_link_on_homepage_without_login(String string) {
		homePage.getStarted_home(string);
	}

	@Then("The user get warning message {string}")
	public void the_user_get_warning_message(String string) {
		String alert = homePage.alert();
		LoggerLoad.info("Actual Message : " + alert);
		Assert.assertEquals(alert, string, "Title do not match");
	}

	@When("The user clicks on dropdown {string}")
	public void the_user_clicks_on_dropdown(String string) {
		homePage.dropdown(string);
	}

	@When("The user clicks on signin link")
	public void the_user_clicks_on_signin_link() {
		homePage.signin_link();
	}

	@Then("The user redirected to login page")
	public void the_user_redirected_to_login_page() {
		String Title = homePage.login_page();
		Assert.assertEquals(Title, "Login");
		LoggerLoad.info("Title of current page is : " + Title);
	}

	@When("The user clicks on register link")
	public void the_user_clicks_on_register_link() {
		homePage.register_link();
	}

	@Then("The user redirected to Registration page")
	public void the_user_redirected_to_registration_page() {
		String Title = homePage.register_page();
		Assert.assertEquals(Title, "Registration");
		LoggerLoad.info("Title of current page is : " + Title);
	}


}
