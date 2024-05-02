package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static com.LMS.utility.LMSConstants.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;

import PageLayer.User_Page;
import PageLayer.login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User_SD {

	User_Page user = new User_Page(DriverFactory.getDriver());
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();

	@Then("Wait for {int} ms")
	public void wait_for_ms(Integer seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {

	}

	@When("Admin clicks on {string} from navigation bar")
	public void admin_clicks_on_from_navigation_bar(String modulename) {
		user.click_User(modulename);
		
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String User) throws InterruptedException {

		String url = user.URL();

		Assert.assertEquals(url, User);

	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String manageUser) {
		String h = user.verifyHeading();
		Assert.assertEquals(manageUser, h);

	}
	
	

	
	@Then("Admin Should see the data table with column name {string} at postition {int}")
	public void admin_should_see_the_data_table_with_column_name_at_postition(String header, Integer position)
			throws InterruptedException {

		String tableHeader = user.verifyTableHeaders(position);
		Assert.assertEquals(tableHeader, header);

	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		Assert.assertTrue(user.verifyDelIcon());

	}

	@Then("Admin should be able to see the {string} button at position {int} with text {string} button above the data table")
	public void admin_should_be_able_to_see_the_button_at_position_with_text_button_above_the_data_table
	(
		String buttonid, Integer position, String expected) {
		assertTrue(user.verifyAddbutton(buttonid, position));
		boolean button_name = user.verifyTextButton(buttonid, position).equalsIgnoreCase(expected);
		assertTrue(button_name);
	}

	@Then("Admin should be able to see the search text box {string} above the data table")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table(String textBox)
	{
		assertTrue(user.textBoxPresent(textBox));
		
	}
	@Then("Admin should see two records at position {int} and {int} displayed on the data table")
	public void admin_should_see_two_records_at_position_and_displayed_on_the_data_table(Integer record1, Integer record2) {
	    
		assertTrue(user.tableRecords(record1));
		
		assertTrue(user.tableRecords(record2));
		
	}
	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		assertTrue(user.verifycheckBox());
	}

	
	@Then("Each row in the data table should have a {string} that is enabled")
	public void each_row_in_the_data_table_should_have_a_that_is_enabled(String icon) 
	{
	    assertTrue(user.verifyIcons(icon));
	}
	
	
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
	    
	}

	
	
	
	@When("Admin enters {string} into search box")
	public void admin_enters_into_search_box(String username) {
		user.enterTextBox(username);
	}

	@Then("Admin should see {string} displayed with the entered name")
	public void admin_should_see_displayed_with_the_entered_name(String username) {
		 Assert.assertEquals(user.usernameValidation(),username);
		 user.cls();
		 }
	
	
	@When("Admin clear data in search box")
	public void admin_clear_data_in_search_box() {
	    user.cls();
	}

	@Then("Admin should see {string} on the data table")
	public void admin_should_see_on_the_data_table(String exp) {
		Assert.assertEquals(user.ZeroRecord(), exp);
		user.cls();
	}
	
	@When("Admin clicks {string} button")
	public void admin_clicks_button(String addbutton) {
	    user.addNewUser(addbutton);
	}

	@Then("Admin should see pop up open for user details with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void admin_should_see_pop_up_open_for_user_details_with(String fname, String mname, String lname, String location, String pno, String lin, String ug, String pg, String timezone, String cmt, String cancel, String submit) {
		 System.out.println(user.popup_labels(fname));
		 Assert.assertEquals(user.popup_labels(fname), "First name");
		 Assert.assertEquals(user.popup_labels(mname), "Middle name");
		 Assert.assertEquals(user.popup_labels(lname), "Last name");
		 Assert.assertEquals(user.popup_labels(location), "Location");
		 Assert.assertEquals( user.popup_labels(pno), "Phone no");
		 Assert.assertEquals(user.popup_labels(lin), "LinkedIn Url");
		 Assert.assertEquals(user.popup_labels(ug), "Under Graduate");
		 Assert.assertEquals(user.popup_labels(pg), "Post Graduate");
		 Assert.assertEquals(user.popup_labels(timezone), "Time Zone");
		 Assert.assertEquals(user.popup_labels(cmt), "User Comments");
		 Assert.assertEquals(user.popup_labels(cancel), "Cancel");
		 Assert.assertEquals(user.popup_labels(submit), "Submit");
		 }
	
	@Then("Admin should see pop up open for user details with labels {string} {string} {string}")
	public void admin_should_see_pop_up_open_for_user_details_with_labels(String ur, String urs, String uvs) {
		
		
		Assert.assertEquals(user.popup_labels2(ur), "User Role");
		Assert.assertEquals(user.popup_labels2(urs), "User Role Status");
		Assert.assertEquals(user.popup_labels2(uvs), "User Visa Status");
		}


	
	
	@Then("Admin close the popup")
	public void admin_close_the_popup() {
	    user.closePopup();
	}
	
	@Then("Admin should see txtfields {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void admin_should_see_txtfields(String fname, String mname, String lname, String location, String pno, String lin, String ug, String pg, String timezone, String cmt) {
		boolean f= user.popup_text_field(fname);
		 boolean m= user.popup_text_field(mname);
		 boolean l= user.popup_text_field(lname);
		 boolean loc= user.popup_text_field(location);
		 boolean p= user.popup_text_field(pno);
		 boolean li= user.popup_text_field(lin);
		 boolean under= user.popup_text_field(ug);
		 boolean post= user.popup_text_field(pg);
		 boolean t= user.popup_text_field(timezone);
		 boolean c= user.popup_text_field(cmt);
		 assertTrue(f);
		 assertTrue(m);
		 assertTrue(l);
		 assertTrue(loc);
		 assertTrue(p);
		 assertTrue(li);
		 assertTrue(under);
		 assertTrue(post);
		 assertTrue(t);
		 assertTrue(c);
	}


	@Then("Admin should see drop downs for the fields {string},{string}, {string} on user details pop up")
	public void admin_should_see_drop_downs_for_the_fields_on_user_details_pop_up(String ur, String urs, String uvs) {
	   assertTrue(user.listboxPresent(ur)); 
	   assertTrue(user.listboxPresent(urs)); 
	   assertTrue(user.listboxPresent(uvs)); 
	}
	
	
	@Given("Admin is on  User details pop up")
	public void admin_is_on_user_details_pop_up() {
	    
	}

	

	@Then("Admin gets message {string}")
	public void admin_gets_message(String success) {
		System.out.println("tttttttttttttttttttttttttt"+user.successPopup());
		Assert.assertEquals(user.successPopup(), success);
	}
	@When("Admin enters mandatory fields from exel {string} in the form and clicks on submit button")
	public void admin_enters_mandatory_fields_from_exel_in_the_form_and_clicks_on_submit_button(String testcase) {
	    user.addUser(USER_SHEET_NAME, testcase);
	}
	
	
	@Then("Admin should see {string} below the test field {string}")
	public void admin_should_see_below_the_test_field(String con1, String exp) {
		 String actual= user.errormsg(con1);
		   System.out.println(actual);
		   Assert.assertEquals(actual, exp);
		   user.clickCancel();
	}
	
	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() {
		
	    user.clickSubmit();
	}


	@When("Admin enters mandatory fields and same email and same phone number {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}in the form and clicks on submit button")
	public void admin_enters_mandatory_fields_and_same_email_and_same_phone_number_hhdhfhfdhhf_in_the_form_and_clicks_on_submit_button(String FN, String MN, String LN , String Location, String phone, String linkedin, String email, String ug, String pg,String TZ,String cmt) {
	     user.addRepeatedData(FN,MN,LN,Location,phone,linkedin,email,ug,pg,TZ,cmt);
	}

@Then("Admin gets fail popup")
public void admin_gets_fail_popup() {
	assertTrue(user.fail());
}

}

