package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LoggerLoad;

import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageLayer.Batch_page;

public class Batch_page_validation_SD {

	private WebDriver driver;
	login_Page login = new login_Page(DriverFactory.getDriver());
	Batch_page Batchpage = new Batch_page(DriverFactory.getDriver());
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	

	@Given("user is logged on the LMS portal")
	public void user_is_logged_on_the_lms_portal() throws InvalidFormatException, IOException {
		login.openLMSHomePage();
		login.fillvalidAndInvalidCredentials("Login", 0);

	}

	@Given("Admin is on dashboard page after Login for Batch")
	public void admin_is_on_dashboard_page_after_login_for_batch() throws InterruptedException {
		Thread.sleep(1000);
		//Assert.assertEquals(login.validateDashboardlandingPage(), "Manage Program");
		LoggerLoad.info("Admin landed on Dashboard page");
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
		Batchpage.clickBatch();

	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {
		Batchpage.getCurrentUrl();
		// Assert.assertEquals(Batchpage.getCurrentUrl(),ConfigReader.getBatchUrl());
		Assert.assertTrue(Batchpage.getCurrentUrl().contains("batch"));
		LoggerLoad.info("Admin landed on Batch page");
	}

	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
		Assert.assertEquals(Batchpage.validateBatchHeader(), string);
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		Assert.assertEquals(Batchpage.validatePagination(), true);
	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		Assert.assertEquals(Batchpage.validateDataTableHead(), true);
		// Assert.assertEquals(Batchpage.validateDataTableHead(), "Batch Name");
		LoggerLoad.info("Admin can see data table with Headers");
	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
		Assert.assertEquals(Batchpage.validateDeleteIcon(), false);
		LoggerLoad.info("Admin can see Disabled Delete Icon");
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
		Assert.assertEquals(Batchpage.aNewBatchDisplayed(), true);
	}

	@Then("Each row in the data table should have a checkbox and edit icon and delete icon enabled")
	public void each_row_in_the_data_table_should_have_a_checkbox_and_edit_icon_and_delete_icon_enabled() {

		Assert.assertEquals(true,Batchpage.chkboxEnabled()>0);
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) throws InterruptedException {
		Batchpage.clickBatch();
		Thread.sleep(2000);
		Batchpage.clickNewBatchButton();
		Thread.sleep(2000);
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
		Assert.assertEquals(Batchpage.dialogBatchDetailsDisplayed(), true);
		LoggerLoad.info("Admin is on Batch details Page");
	}

}
