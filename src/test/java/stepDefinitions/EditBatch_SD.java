package stepDefinitions;

import static com.LMS.utility.LMSConstants.BATCH_SHEET_NAME;
import static com.LMS.utility.LMSConstants.applicationData;

import java.util.Map;

import org.testng.Assert;

import com.LMS.factory.*;

import PageLayer.Batch_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditBatch_SD {
	
	Batch_page BatchPage=new Batch_page(DriverFactory.getDriver());
	
	private Map<String,String> testRow;

	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() throws InterruptedException {
		BatchPage.searchAndVerify(applicationData.getBatchName());
		Assert.assertEquals(BatchPage.searchAndVerify(applicationData.getBatchName()), true);
	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
	    BatchPage.clickRowRdit();
	}

	@Given("Admin clicks the edit icon for {string}")
	public void admin_clicks_the_edit_icon_for(String testcase) throws InterruptedException {
//	    testRow = applicationData.getData(BATCH_SHEET_NAME,testcase);
//	    BatchPage.searchAndEdit(applicationData.getBatchname());
//	    
	   }

	@When("Update the fields with valid values and click save")
	public void update_the_fields_with_valid_values_and_click_save() {
	   
	}
	@When("Update the fields {string} and click save")
	public void update_the_fields_and_click_save(String testcase) {
		BatchPage.editBatch(BATCH_SHEET_NAME,testcase);
		BatchPage.closePop();
	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() {

	}
	@When("Update the fields for {string} and click save")
	public void update_the_fields_for_and_click_save(String testcase) {
		BatchPage.editBatch(BATCH_SHEET_NAME,testcase);
	}
	@When("Erase data from mandatory field for {string}")
	public void erase_data_from_mandatory_field_for(String testcase) throws InterruptedException {
		BatchPage.editBatch(BATCH_SHEET_NAME,testcase);
		Thread.sleep(3000);
		//BatchPage.closePop();
	}
	

	


}
