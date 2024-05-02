package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;

import PageLayer.Batch_page;
import PageLayer.Program_Page;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_Batch_SD {
	
	private WebDriver driver;
	login_Page login= new login_Page(DriverFactory.getDriver());
	Batch_page Batchpage=new Batch_page(DriverFactory.getDriver());
	Program_Page ProgramPage=new Program_Page();
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();

	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
		Batchpage.clearSearchBox();
		
	   Assert.assertEquals(true,Batchpage.verifyDeletebtnEnabled()); 
	}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
	    Batchpage.clickRowDeleteicon();
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
	    Assert.assertEquals(Batchpage.getAlertBtnText(), true);
	}
	
//	@Given("Admin is on confirm Deletetion alert")
//	public void admin_is_on_confirm_deletetion_alert() {
//	    
//	}

	@When("You click yes option")
	public void you_click_yes_option() {
	    Batchpage.clickYes();
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
		Assert.assertTrue(ProgramPage.successPopup());
	}

	@When("you click No option")
	public void you_click_no_option() {
	    Batchpage.clickNo();
	    	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() {
	    
	}


}
