package stepDefinitions;

import org.testng.Assert;

import com.LMS.factory.DriverFactory;

import PageLayer.dashBoard_Logout_Page;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dashBoard_Logout_SD {
	
	dashBoard_Logout_Page dashBoard_Logout_PageObj= new dashBoard_Logout_Page(DriverFactory.getDriver());
	login_Page login= new login_Page(DriverFactory.getDriver());
	@Given("Admin is in dashboard page")
	public void Admin_is_in_dashboard_page()
	{
		
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() throws InterruptedException {
		dashBoard_Logout_PageObj.ClickLogoutBtn();
		Thread.sleep(3000);
	}
	
	@Then("Admin should land on the home page after logout")
	public void admin_should_land_on_the_home_page_after_logout() {
		String actual=dashBoard_Logout_PageObj.validateLoginPage();
		Assert.assertEquals(actual,"Login");
	}
}