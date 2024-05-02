package stepDefinitions;

import static com.LMS.utility.LMSConstants.PROGRAM_SHEET_NAME;
import static com.LMS.utility.LMSConstants.applicationData;

import java.util.Map;

import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.ConfigReader;

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
	
	private String headerName = "";
	private int currentPage = 1;
	private String nextAction="";
	
	private Map<String,String> testRow;
	
	
	@Given("Admin is on Manage Program page for {string}")
	public void admin_is_on_manage_program_page_for(String testcase) {
		testRow = applicationData.getData(PROGRAM_SHEET_NAME,testcase);
		if(!applicationData.isUserLoggedIn()) {
			programPage.userlogin();
		}
	//	programPage.addProgram(testRow.get("programName"),testRow.get("programDescription"), testRow.get("status"));
		if(testcase != null && !"".equals(testcase) ) {
		programPage.addProgram(PROGRAM_SHEET_NAME,testcase); 
		}
	
	}

	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
		
	//	programPage.deleteBtn(testRow.get("programName"));
		programPage.searchanddeleteBtn(applicationData.getProgramName());
	
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
		
		Assert.assertEquals(programPage.getAlertPageTitle(),true);
		Assert.assertEquals(programPage.getAlertBtnText(),true);
	}
	
	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String string) {
	
		//string = string.replace("{Program name}", testRow.get("programName"));
		string = string.replace("{Program name}", applicationData.getProgramName());
		
		//Assert.assertEquals(programPage.getAlertPageContent(string),true);
	
	}
	
	@Given("Admin is on Confirm Deletion alert for {string}")
	public void admin_is_on_confirm_deletion_alert_for(String testcase) {
		
		testRow = applicationData.getData(PROGRAM_SHEET_NAME,testcase);
		if(!programPage.getAlertPageTitle()) {
			System.out.println("In Title Page:"+ programPage.getAlertPageTitle());
			programPage.searchanddeleteBtn(applicationData.getProgramName());
		}
		//Assert.assertTrue(programPage.getAlertPageTitle());
	}

	@When("Admin clicks {string} button on the alert")
	public void admin_clicks_button_on_the_alert(String string) {
		programPage.alertClick(string);
		
	}
	
	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {
		programPage.sleep();
		Assert.assertTrue(programPage.successPopup());
		Assert.assertTrue(programPage.searchProgram(applicationData.getProgramName()));
		programPage.clearSearchBox();
		
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		
		boolean programHeadervalidation = false;
		if(ConfigReader.getProperty("dashboardHeader").equalsIgnoreCase(programPage.getProgramHeader())) {
			
			programHeadervalidation = true; 
		}
		
		Assert.assertTrue(programHeadervalidation);
	}
	
	@When("Admin clicks {string} checkbox in the data table")
	public void admin_clicks_checkbox_in_the_data_table(String type) {
		
		programPage.clearSearchBox();
		programPage.checkboxClick(type);
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {

		Assert.assertTrue(programPage.ValidateDeleteIconsEnabled());
		
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {

		programPage.multideleteBtn();
	
	}
	
	@When("Admin clicks on common delete button")
	public void admin_clicks_on_common_delete_button() {

		programPage.multideleteBtn();
	
	}

	@When("Admin clicks {string} link at {string}")
	public void admin_clicks_link_at(String headerName, String order) {
		programPage.clickSortLink(headerName);
		this.headerName = headerName;
		
	}
	
	@Then("Datatable should be arranged in {string}")
	public void datatable_should_be_arranged_in(String order) {
		int result = programPage.validateOrder(headerName, order);
		System.out.println("RESULT "  + result);
		if("dsc".equalsIgnoreCase(order)) {
			Assert.assertTrue(result >= 0);
		}else {
			Assert.assertTrue(result <= 0);
		}
		
	}

	@When("Admin clicks {string} pagelink at {int}")
	public void admin_clicks_link_at(String nextAction, int currentPage) {
		this.currentPage= currentPage;
		this.nextAction = nextAction;
		programPage.clickPagination(currentPage, nextAction);
	}
	
	@Then("{int} should be enabled and {string} should be disabled")
	public void should_be_enabled_and_should_be_disabled(int currentPage, String nextAction) {
		
		programPage.validatePagination(currentPage, nextAction);
	}
	
	@When("Admin clicks on {string} link")
	public void admin_clicks_on_link(String navigation) {
		
		programPage.clickNavigation(navigation);
	}
	
	@Then("Admin redirected to {string} page")
	public void admin_redirected_to_page(String target) {
		
		Assert.assertTrue(programPage.validateNavigation(target));
	}



}
