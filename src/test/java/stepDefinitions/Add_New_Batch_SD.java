package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LoggerLoad;

import PageLayer.Batch_page;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Add_New_Batch_SD {

	private WebDriver driver;
	login_Page login= new login_Page(DriverFactory.getDriver());
	Batch_page Batchpage=new Batch_page(DriverFactory.getDriver());
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	@Given("A new pop up with a Batch details appears")
	public void a_new_pop_up_with_a_batch_details_appears() {
	    LoggerLoad.info("Admin is on Batch Details Page");
	}

	@Then("The pop up should include all {string}")
	public void the_pop_up_should_include_all(String string) {
	 Assert.assertEquals(Batchpage.validateNameInPopup(), true);
	 Assert.assertEquals(Batchpage.validateDescriptionInPopup(), true);
	 Assert.assertEquals(Batchpage.validateNameFieldAsText(), true);
	 Assert.assertEquals(Batchpage.validateDescFieldAsText(), true);
	// Assert.assertEquals(Batchpage.validateNoOfClassAsText(), true);
	// Assert.assertEquals(Batchpage.validateStatusAsRadio(), true);
	  
	}
	@When("Fill in all the fields except description with valid values from excel {string} and {int} and click save")
	public void fill_in_all_the_fields_except_description_with_valid_values_from_excel_and_and_click_save(String sheetname, Integer Rownumber) throws InvalidFormatException, IOException, InterruptedException {
	    Batchpage.addBatchValidExceptDesc(sheetname, Rownumber);
	}
	
	@Given("A new pop up with Batch details appear")
	public void a_new_pop_up_with_batch_details_appear() {
		Batchpage.clickNewBatchButton();
	}

	@When("Fill in all the fields with valid values from excel {string} and {int} and click save")
	public void fill_in_all_the_fields_with_valid_values_from_excel_and_and_click_save(String sheetname, Integer RowNumber) throws InvalidFormatException, IOException {
	    Batchpage.fillFieldsValidBatch(sheetname, RowNumber);
	}



	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
	    
	}
	@When("Any of the fields have invalid values from excel {string} and {int}")
	public void any_of_the_fields_have_invalid_values_from_excel_and(String sheetname, Integer Rownumber) throws InvalidFormatException, IOException {
		Batchpage.fillFieldsInValidBatch(sheetname, Rownumber);
	}

	@Then("Error message should appear")
	public void error_message_should_appear() {
	    
	}
	
	@Given("A new pop up Batch details appear")
	public void a_new_pop_up_batch_details_appear() {
	    Batchpage.batchDetailDialog();
	}



	@When("Any of the mandatory fields are blank from excel {string} and {int}")
	public void any_of_the_mandatory_fields_are_blank_from_excel_and(String sheetname, Integer Rownumber) throws InvalidFormatException, IOException {
		Batchpage.fillFieldsInValidBatch(sheetname, Rownumber);
		Batchpage.closePop();
	}



}




