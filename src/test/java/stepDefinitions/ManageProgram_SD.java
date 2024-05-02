package stepDefinitions;

import static com.LMS.utility.LMSConstants.applicationData;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LoggerLoad;

import PageLayer.Program_Page;
import PageLayer.login_Page;
//import PageLayer.program_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageProgram_SD {
	
	//private WebDriver driver;
	login_Page login = new login_Page(DriverFactory.getDriver());
	private Program_Page programPage = new Program_Page(); 
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	
	/*@Given("user is logged on the LMS portal")
	public void user_is_logged_on_the_LMS_portal() throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
		login.openLMSHomePage();
		login.fillvalidAndInvalidCredentials("Login", 0);
	}
	*/
	
	@Given("Admin is on dashboard page after Login for program module")
	public void admin_is_on_dashboard_page_after_login_for_program_module() {
		LoggerLoad.info("Admin landed on Dashboaed page.");
		 System.err.println("Admin landed on Dashboaed page.");
		 
		 if(!applicationData.isUserLoggedIn()) {
				programPage.userlogin();
			} 
	}

	@When("Admin clicks {string} on the navigation bar for program module")
	public void admin_clicks_on_the_navigation_bar_for_program_module(String string) {
	   programPage.clickprogrambtn();
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		System.err.println("Url of current page is* **** " + programPage.getProgramUrl() + " ****");
	    Assert.assertTrue(programPage.getProgramUrl().contains(string));
	    LoggerLoad.info("Url of current page is* **** " + programPage.getProgramUrl() + " ****");
	    
	}

	@Then("Admin should see a heading with text {string} on the page for program module")
	public void admin_should_see_a_heading_with_text_on_the_page_for_program_module(String string) {
		System.err.println("program header ->>>>>>" + programPage.getProgramHeader());
		System.err.println("expectedValue ->>>>>>" + string);
	   Assert.assertEquals(programPage.getProgramHeader(), string);
	   //Log.info("Header of current page is ****" + programPage.validateProgramHeader() + "*****");
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
	//	System.err.println("program pagination ->>>>>>" + programPage.clickPagination());
	//	Assert.assertEquals(programPage.clickPagination(), string);
		
	}

	/*@Then("{string}{string}{string}")
	public void string_string_string(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
*/
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		Assert.assertTrue(programPage.verifyDelIcon());

	}

	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
	//	Assert.assertEquals(manageprogramPage.ValidateNewProgrambutton(), string);
		Assert.assertTrue(programPage.ValidateNewProgrambutton().isDisplayed());
		
	}

	/*
	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
	    
	}
*/
	@Then("Admin should see data table on the Manage Program Page with following column headers\\(Program Name, Program Description, Program Status, Edit,Delete)")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
		String ExpectedHeader = "Program Name Program Description Program Status Edit / Delete";
		String actualheader = programPage.getTableHead();
		System.out.print("actual ***" +actualheader);
		Assert.assertEquals(actualheader,ExpectedHeader);
	
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		//Assert.Equals(programPage.clickSortLink());
	}

	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
		 assertTrue(programPage.verifycheckBox());
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		boolean allEditIconsEnabled = programPage.ValidateEditIconsEnabled();
        Assert.assertTrue(allEditIconsEnabled);
        boolean allDeleteIconsEnabled = programPage.ValidateDeleteIconsEnabled();
        Assert.assertTrue(allDeleteIconsEnabled);
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
		Assert.assertTrue(programPage.searchBox().isDisplayed());
	}

}
