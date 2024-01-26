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
import com.dsalgo.util.LoggerLoad;
import com.dsalgo.util.testUtil;

import PageLayer.DataStructurePage;
import PageLayer.HomePage;
import PageLayer.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class dataStructure_SD {
	
	private WebDriver driver;
	DataStructurePage datastructure = new DataStructurePage(DriverFactory.getDriver());
	HomePage home= new HomePage (DriverFactory.getDriver());
	LoginPage login = new LoginPage(DriverFactory.getDriver());
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	
	@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
	   login.SignInPageURL();
	}
	
	@When("The user enters valid username {string} and password {string} and clicks {string} button")
	public void the_user_enters_valid_username_and_password_and_clicks_button(String username, String password, String Btnlogin) throws InvalidFormatException, IOException {
		
		List<Map<String, String>> testdata = excel.getData(Excelpath, "Login");
		username = testdata.get(0).get("username");
		password = testdata.get(0).get("password");
		//Loggerload.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
		if (username != null || password != null)
			login.LoginUser(username, password);
	}

	@Then("The user is redirected to homePage")
	public void the_user_is_redirected_to_home_page() {
		String actualPageTitle = home.HomepageTitle();	
		Assert.assertEquals(actualPageTitle,ConfigReader.getHomePageTitle());
		LoggerLoad.info("The user is on : " + actualPageTitle +" Home page");
	}
	@When("The user clicks Get Started button below the {string} option")
	public void the_user_clicks_get_started_button_below_the_option(String Datastructures) {
		home.getStarted_home(Datastructures);
	}

	@Then("The user should land on {string}")
	public void the_user_should_land_on(String string) {
		Assert.assertEquals( datastructure.DSPageTitle(),string);
		LoggerLoad.info("Title of current page is : " + datastructure.DSPageTitle());
	}
	@When("The user clicks Get Started button below the {string} and then clicks Time Complexity button")
	public void the_user_clicks_get_started_button_below_the_and_then_clicks_time_complexity_button(String Datastructures) {
		home.getStarted_home(Datastructures);
	    datastructure.clickOnTimeComplexitylink();
	}

	@Then("The user is redirected to {string} page")
	public void the_user_is_redirected_to_page(String string) {
		Assert.assertEquals(datastructure.DSPageTitle(),string);
		LoggerLoad.info("Title of current page is : " + datastructure.DSPageTitle());
	}
	
	
}
