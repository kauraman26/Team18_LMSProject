package stepDefinitions;

import static com.LMS.utility.LMSConstants.PROGRAM_SHEET_NAME;
import static com.LMS.utility.LMSConstants.applicationData;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LoggerLoad;
import PageLayer.Program_Page;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;


@Log4j2


public class AddNewProgram_SD {
	
	private WebDriver driver;
	login_Page login = new login_Page(DriverFactory.getDriver());
	private Program_Page programPage = new Program_Page(); 
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	
	//private Map<String,String> testRow;
	
	@Given("Admin is on Manage Program page for {string} for Program")
	public void admin_is_on_manage_program_page_for_for_program(String string) {
	     LoggerLoad.info("Admin is on Manage Program Page");
	//	 testRow = applicationData.getData(PROGRAM_SHEET_NAME,testcase);
			if(!applicationData.isUserLoggedIn()) {
				programPage.userlogin();
			} 
	}
	

	@When("Admin clicks <A New Program> button")
	public void admin_clicks_a_new_program_button() {
		programPage.AddnewProgrambtnclick();
		
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		Assert.assertEquals(programPage.verifyNewProgramPopupDetails(), Boolean.TRUE);
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
		Assert.assertEquals(programPage.verifyNameAndDescInPopupDetails(), Boolean.TRUE);
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(programPage.verifyRadioButtonsInPopupDetails(), Boolean.TRUE);
	}

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {
		if(!programPage.verifyNewProgramPopupDetails()) {
			programPage.AddnewProgrambtnclick();
		}
	//	Assert.assertTrue(programPage.verifyNewProgramPopupDetails());
		
	}

	@When("Admin clicks <Save> button without entering any data from {string}")
	public void admin_clicks_save_button_without_entering_any_data_from_and(String testcase) {
		programPage.addProgram(PROGRAM_SHEET_NAME,testcase); 
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		Assert.assertTrue(programPage.verifyNewProgramPopupRequiredFields());
		programPage.cancelBtnPgmPopup();
	}

	@When("Admin enters only<Program Name> in text box from {string} and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_from_and_clicks_save_button(String testcase) {
		programPage.addProgram(PROGRAM_SHEET_NAME,testcase); 
	}

	@Then("Admin gets a message alert {string} for name")
	public void admin_gets_a_message_alert_for_name(String string) {
		Assert.assertTrue(programPage.verifyNewProgramPopupNameEntered());
		programPage.cancelBtnPgmPopup();
	}

	@When("Admin enters only<Program description> in text box from {string} and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_from_and_clicks_save_button(String testcase) {
		programPage.addProgram(PROGRAM_SHEET_NAME,testcase); 
	}
	
	@Then("Admin gets a message alert {string} for description")
	public void admin_gets_a_message_alert_for_description(String string) {
	   Assert.assertTrue(programPage.verifyNewProgramPopupDescEntered());
	   programPage.cancelBtnPgmPopup();
	}

	@When("Admin selects only Status and clicks Save button {string}")
	public void admin_selects_only_status_and_clicks_save_button(String testcase) {
		programPage.addProgram(PROGRAM_SHEET_NAME,testcase); 
	}
	
	@Then("Admin gets a message alert {string} for status")
	public void admin_gets_a_message_alert_for_status(String string) {
		Assert.assertTrue(programPage.verifyNewProgramPopupStatusEntered());
		programPage.cancelBtnPgmPopup();
	    }

	@When("Admin enters only numbers or special char in name and desc column from {string}")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_from_and(String testcase) {
		programPage.addProgram(PROGRAM_SHEET_NAME,testcase); 
	}
	
	@When("Admin clicks Close Icon on Program Details form for program details")
	public void admin_clicks_close_icon_on_program_details_form_for_program_details() {
	//	programPage.cancelBtnPgmPopup();
		
		 }

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	/**
	 * Scenario Outline: Validate Save button on Program Details form
	 */
	@When("Enter all the required fields with valid values and click Save button from excel {string}")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button_from_excel(String testcase) {
		programPage.addProgram(PROGRAM_SHEET_NAME,testcase); 
	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
		Assert.assertTrue(programPage.successPopup());
	}

	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {
		programPage.cancelBtnPgmPopup();
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
