package stepDefinitions;
import org.testng.Assert;
import com.LMS.factory.DriverFactory;
import PageLayer.dashBoard_Logout_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dashBoard_Logout_SD {
	dashBoard_Logout_Page dashBoard_Logout_PageObj= new dashBoard_Logout_Page(DriverFactory.getDriver());
	@Given("Admin is in dashboard page")
	public void Admin_is_in_dashboard_page()
	{
		
		//dashBoard_Logout_PageObj.openDashBoardPage();
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		dashBoard_Logout_PageObj.ClickLogoutBtn();
	}
	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
		String actual=dashBoard_Logout_PageObj.validateLoginPage();
		System.out.println("*******"+actual);
		Assert.assertEquals(actual, "Login");
	}
}
