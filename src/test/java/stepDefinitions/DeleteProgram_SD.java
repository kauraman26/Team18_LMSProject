package stepDefinitions;

import static com.LMS.utility.LMSConstants.PROGRAM_SHEET_NAME;
import static com.LMS.utility.LMSConstants.applicationData;

import java.util.Map;

import org.testng.Assert;

import com.LMS.factory.DriverFactory;

import PageLayer.Program_Page;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class DeleteProgram_SD {
	
	private login_Page programLogin = new login_Page(DriverFactory.getDriver());
	private Program_Page programPage = new Program_Page(); 
	
	private Map<String,String> testRow;
	
	@Given("Admin is on Manage Program page for {string}")
	public void admin_is_on_manage_program_page_for(String testcase) {
		testRow = applicationData.getData(PROGRAM_SHEET_NAME,testcase);
		if(!applicationData.isUserLoggedIn()) {
			programPage.userlogin();
		}
	
	}

	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
		
		programPage.deleteBtn(testRow.get("programName"));
	
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
		
		Assert.assertEquals(programPage.getAlertPageTitle(),true);
		Assert.assertEquals(programPage.getAlertBtnText(),true);
	}
	
	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String string) {
		string = string.replace("{Program name}", testRow.get("programName"));
		Assert.assertEquals(programPage.getAlertPageContent(string),true);
	
	}
	
	@Given("Admin is on Confirm Deletion alert for {string}")
	public void admin_is_on_confirm_deletion_alert_for(String testcase) {
		
		testRow = applicationData.getData(PROGRAM_SHEET_NAME,testcase);
		if(!programPage.getAlertPageTitle()) {
			programPage.deleteBtn(testRow.get("programName"));
		}
		//Assert.assertTrue(programPage.getAlertPageTitle());
	}

	@When("Admin clicks {string} button on the alert")
	public void admin_clicks_button_on_the_alert(String string) {
		programPage.alertClick(string);
		
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {

		Assert.assertTrue(programPage.successPopup());
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {

	
	
	}


}
