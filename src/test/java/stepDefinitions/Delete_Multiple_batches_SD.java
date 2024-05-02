package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LoggerLoad;

import PageLayer.Batch_page;
import PageLayer.Program_Page;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_Multiple_batches_SD {
	private WebDriver driver;
	login_Page login= new login_Page(DriverFactory.getDriver());
	Batch_page BatchPage=new Batch_page(DriverFactory.getDriver());
	Program_Page ProgramPage=new Program_Page();
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {
	    Assert.assertEquals(BatchPage.checkboxSelected(),false);
	}
	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {
		Assert.assertEquals(BatchPage.validateDeleteIcon(),false);
		LoggerLoad.info("Admin can see Disabled Delete Icon");
	}

	@Given("One of the checkbox/row is selected")
	public void one_of_the_checkbox_row_is_selected() {
	    BatchPage.singleRowClick();
	}

	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) {
	    BatchPage.clickDeleteIcon();
	    BatchPage.clickYes();
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() {
		Assert.assertTrue(ProgramPage.successPopup());
	}

	@Given("Two or more checkboxes\\/row is selected")
	public void two_or_more_checkboxes_row_is_selected() throws InterruptedException {
	    BatchPage.multiRowClick();
	}


}
