package PageLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.LMS.factory.DriverFactory;
import com.LMS.utility.CommonUtils;
import com.LMS.utility.LMSConstants;

public class Program_Page{
	
	WebDriver driver = DriverFactory.getDriver();
	login_Page programLogin = new login_Page(driver);
	
		@FindBy(id="deleteProgram")WebElement deletebtn;
		@FindBy(id="filterGlobal")WebElement searchbtn;
		@FindBy(xpath="//span[text()='Confirm']")WebElement confirmlabel;
		@FindBy(xpath="//span[text()='Yes']")WebElement yesBtn;
		@FindBy(xpath="//span[text()='No']")WebElement noBtn;
		@FindBy(xpath="//*[contains(text(),'Are you sure you want to delete')]")WebElement contentTxt;
		@FindBy(xpath="//span[@class='pi pi-times ng-tns-c133-4']")WebElement closeBtn;
		@FindBy(xpath="//div[contains(@class,'p-toast-summary')]")WebElement successPopupTitle;
		@FindBy(xpath="//div[contains(@class,'p-toast-detail')]")WebElement successPopupContent;
		@FindBy(id="new")WebElement newpgmbtn;
		@FindBy(id="programName")WebElement programName;
		@FindBy(id="programDescription")WebElement programDesc;
		@FindBy(id="Active")WebElement programstatus;
		@FindBy(id="saveProgram")WebElement saveProgramBtn;
		@FindBy(xpath="//div[@role='checkbox']")List<WebElement> checkboxList;
		@FindBy(xpath="//mat-card-title/div[2]/div[1]/button")WebElement multiDeleteBtn;
		@FindBy(id="program")WebElement programLink;
		@FindBy(id="batch")WebElement batchLink;
		@FindBy(id="user")WebElement userLink;
		@FindBy(id="logout")WebElement logoutLink;

		@FindBy(xpath="//span[text()='Cancel']")WebElement cancelbtn;
		@FindBy(xpath="//span[text()='Save']")WebElement savebtn;
		@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']")WebElement crossbtn;
		@FindBy(xpath="//*[contains(text(),'Successful Program Created')]") WebElement pgmPopSuccessTxt;

		
		@FindBy(xpath="//button[contains(@class, 'p-highlight')]")WebElement current;
		@FindBy(xpath="//button[contains(@class, 'p-paginator-next')]")WebElement next;
		@FindBy(xpath="//button[contains(@class, 'p-paginator-prev')]")WebElement previous;
		@FindBy(xpath="//button[contains(@class, 'p-paginator-first')]")WebElement first;
		@FindBy(xpath="//button[contains(@class, 'p-paginator-last')]")WebElement last;
		
		Map<String,WebElement> buttonMap = new HashMap<>();
		Map<String,WebElement> pageMap = new HashMap<>();
		Map<String,WebElement> navigationMap = new HashMap<>();
		
	public Program_Page() {
		PageFactory.initElements(driver, this);
		buttonMap.put("Yes", yesBtn);
		buttonMap.put("No", noBtn);
		buttonMap.put("Close", closeBtn);
		
		pageMap.put("current", current);
		pageMap.put("next", next);
		pageMap.put("previous", previous);
		pageMap.put("first", first);
		pageMap.put("last", last);
		
		navigationMap.put("batchLink",batchLink);
		navigationMap.put("userLink",userLink);
		navigationMap.put("logoutLink",logoutLink);
		
	}
	
	public void userlogin() {
		programLogin.openLMSHomePage();
		
		userLogin(LMSConstants.LOGIN_SHEET_NAME,0);
	}
	
	public void userLogin(String Sheetname,int row){
		
		Map<String, String> testdatabyrow = LMSConstants.applicationData.getData(Sheetname, row);
		String username=testdatabyrow.get("username");
		String password=testdatabyrow.get("password");
		try {
			programLogin.loginUsingValidDetails(username,password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LMSConstants.applicationData.setUserLoggedIn(true);		
	}
	
	public void addProgram(String sheetname, String testcase) {
		
		Map<String, String> testdatabyTC = LMSConstants.applicationData.getData(sheetname, testcase);
		
		long d = System.currentTimeMillis();
		String pgmName = testdatabyTC.get("programName")!= null? testdatabyTC.get("programName")+" "+d:null;
		String pgmDesc = testdatabyTC.get("programDescription");
		CommonUtils.webElement_Click(newpgmbtn);
		System.out.println("programName " +pgmName);
		if(pgmName != null) {
			CommonUtils.webSendKeys(programName,pgmName);
		}
		CommonUtils.webSendKeys(programDesc,pgmDesc);
		sleep();
		programDesc.sendKeys(Keys.TAB);
		driver.findElement(By.id("Active")).sendKeys(Keys.SPACE);
		CommonUtils.webElement_Click(saveProgramBtn);
		LMSConstants.applicationData.setProgramName(pgmName);
	
	}
	public void searchanddeleteBtn(String pname) {
		clearSearchBox();
		CommonUtils.webSendKeys(searchbtn,pname);
		sleep();
		CommonUtils.webElement_Click(deletebtn);
		
	}

	public void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clearSearchBox() {
		CommonUtils.webSendKeys(searchbtn, "A");
		CommonUtils.webSendKeys(searchbtn, Keys.CONTROL + "a" + Keys.DELETE);
	}
	
	public void multideleteBtn() {
		
		CommonUtils.webElement_Click(multiDeleteBtn);
	}
	
	public void checkboxClick(String type) {
		sleep();
		CommonUtils.webElement_Click(checkboxList.get(1));
		if(!"Single".equalsIgnoreCase(type)) {
		CommonUtils.webElement_Click(checkboxList.get(2));
		}
		
		
	}
	public void alertClick(String buttonName) {
		sleep();
		CommonUtils.webElement_Click(buttonMap.get(buttonName));
	}
	
	public boolean successPopup() {
		
		return CommonUtils.verifyElementText("Successful", successPopupTitle);
	}
	
	public boolean getAlertPageTitle() {
		try {
			return CommonUtils.verifyElementText("Confirm", confirmlabel);
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean getAlertBtnText() {
		sleep();
		return CommonUtils.verifyElementText("Yes", yesBtn) && CommonUtils.verifyElementText("No", noBtn);
	
	}
	
	public boolean getAlertPageContent(String string) {
		
		return CommonUtils.verifyElementText(string,contentTxt);
	}
	
	public boolean searchProgram(String pname) {
		
		CommonUtils.webSendKeys(searchbtn,pname); 
		return true;
	}
	
	public void clickSortLink(String linkname) {
		WebElement we = driver.findElement(By.xpath("//th[@psortablecolumn='"+linkname + "']"));
		CommonUtils.webElement_Click(we);
	}
	
	public int validateOrder(String linkName, String orderType) {
		int columnIndex = 2;
		if("programName".equalsIgnoreCase(linkName)) {
			columnIndex = 2;
		}else if("programDescription".equalsIgnoreCase(linkName)) {
			columnIndex = 3;
		}else {
			columnIndex = 4;
		}
		WebElement firstElement = driver.findElement(By.xpath("//tbody/tr[1]/td["+ columnIndex + "]"));
		WebElement secondElement = driver.findElement(By.xpath("//tbody/tr[2]/td[" + columnIndex + "]"));
		System.out.println(firstElement.getText() + "VS " + secondElement.getText());
	    return firstElement.getText().toUpperCase().compareTo(secondElement.getText().toUpperCase());
	}
	
	public void clickPagination(int currentPage, String nextAction) {
		pageMap.get(nextAction).click();
	//	CommonUtils.webElement_Click(pageMap.get(nextAction));
	}
	
	public void validatePagination(int currentPage, String nextAction) {
		System.out.println( currentPage + "   AAA " + Integer.parseInt(pageMap.get("current").getText()));
		
		if("previous".equalsIgnoreCase(nextAction)){
			currentPage--;
		}else if("next".equalsIgnoreCase(nextAction)) {   
			currentPage++;
		}else if("first".equals(nextAction)) {
			currentPage = 1;
		}else {
			String text = driver.findElement(By.xpath("//div[contains(text(),'In total there are')]")).getText();
			text = text.replace("In total there are", "").replace("programs.", "").trim();
			currentPage =Integer.parseInt(text); //driver.findElements(By.xpath("//p-paginator/div/button")).size()+1;
			currentPage =  (int) Math.ceil(currentPage/5D);
		}
		System.out.println( currentPage + "   BBBAA " + Integer.parseInt(pageMap.get("current").getText()));
		 Assert.assertTrue(currentPage == Integer.parseInt(pageMap.get("current").getText()));
	}
	
	public void clickNavigation(String navigationLink) {
		
		CommonUtils.webElement_Click(navigationMap.get(navigationLink));
		
	}
	
	public boolean validateNavigation(String target) {
		if(!target.equalsIgnoreCase("home")) {
			String resultPage = driver.findElement(By.xpath("//div[contains(text(),'" + target +"')]")).getText();
			return resultPage.equalsIgnoreCase(target);
		}else 
			return target.equalsIgnoreCase("home");
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Program')]")WebElement Programbtn;
    	@FindBy(xpath="//div[contains(text(),'Manage Program')]")WebElement Programheader;
	@FindBy(xpath="//*[contains(@class, 'p-datatable-thead')]")WebElement tablehead;
   	@FindBy(id="filterGlobal")WebElement searchbox;
    	@FindBy(xpath="//thead[contains(text(),' Edit / Delete ')]")WebElement editdeletebtn;
    	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")WebElement programpagination;
    	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']")WebElement rightarrowbtn;
	@FindBy(xpath = "//tbody[contains(@class, 'p-datatable-tbody')]") List<WebElement> program_table;
    	@FindBy(xpath = "//button[contains(@class,'p-button-danger p-button p-component p-button-icon-only')]") WebElement dltbtn;
   	//@FindBy(xpath = "//button[@label='A New Program'] and [@id='pi pi-plus']") WebElement NewProgrambtn;
   
   	@FindBy(xpath = "//span[contains(text(),'A New Program')]") WebElement NewProgrambtn;
    
   	@FindBy(xpath = "//table/tbody/tr//div[@role='checkbox']") List<WebElement> rows;
   	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-pencil')]") List<WebElement> editicons;
   	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") List<WebElement> deleteIcons;
   	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement programPopup; 
   	
   	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement ProgramPopup; 
   	@FindBy(xpath = "//span[contains(text(), 'Program Details')]") WebElement Popuptitle;
   	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")WebElement delIcon;
   	@FindBy(xpath="//div/label[(text(),'Name')]")WebElement namepopupvaldiation;
	@FindBy(xpath="//div[contains(text(),'Description')]")WebElement descvaldiation;
	@FindBy(xpath="//div[contains(text(),'Status')]")WebElement activecheckvalidation;
	@FindBy(xpath="//*[contains(text(),'Name')]")WebElement programNameLabel;
	@FindBy(xpath="//*[contains(text(),'Description')]")WebElement programDescLabel;
	@FindBy(xpath="//small[@class='p-invalid ng-star-inserted']") List<WebElement> requiredAlerts;
	@FindBy(id="category")List<WebElement> radioBtns;	
	
//    public program_Page(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//    	 }
    
    public String dashboardtitile() {
    	String curr_window_title = driver.getTitle();
		//return driver.getTitle();
		return curr_window_title;
	}
   
    public void clickprogrambtn() {
    //	Programbtn.click();
    	CommonUtils.webElement_Click(Programbtn);
    }
   
    
    public String getProgramUrl() {
    	String programUrl = driver.getCurrentUrl();
    	return programUrl;
    }
    
    public String getProgramHeader() {
    	if (Programheader.isDisplayed()) {
    		return Programheader.getText().trim();
    	}else {
    		return "";
    	}
    	
    }
    
    public String getTableHead() {
    	if (tablehead.isDisplayed()) {
    		String thead = tablehead.getText();
    		System.out.println("table head text is: " +thead);
    		return tablehead.getText();
    	} else {
    		return "";
    	}
    }
 
	public WebElement ValidateDeletebutton() {
		return dltbtn;
		
	}
	
	public WebElement ValidateNewProgrambutton() {
		return NewProgrambtn;
	}
		
	public boolean ValidateCheckboxes() {
		boolean allCheckboxesDisplayed = true;
        for (WebElement row : rows) {
            if (!row.isDisplayed()) {
                System.out.println("Checkbox not present in row: " + row.getText());
                allCheckboxesDisplayed = false;
            }
        }
        return allCheckboxesDisplayed;
    }
	
	public boolean ValidateEditIconsEnabled() {
        boolean allEditIconsEnabled = true;
        for (WebElement editIcon : editicons) {
            if (!editIcon.isEnabled()) {
                System.out.println("Edit icon is not enabled: " + editIcon.getText());
                allEditIconsEnabled = false;
            }
        }
        return allEditIconsEnabled;
    }
    
	public boolean ValidateDeleteIconsEnabled() {
        boolean allDeleteIconsEnabled = true;
        for (WebElement deleteIcon : deleteIcons) {
            if (!deleteIcon.isEnabled()) {
                System.out.println("Delete icon is not enabled: " + deleteIcon.getText());
                allDeleteIconsEnabled = false;
            }
        }
        return allDeleteIconsEnabled;
    }
	
	public void AddnewProgrambtnclick() {
		CommonUtils.webElement_Click(NewProgrambtn);
		
	}
	
	public void cancelBtnPgmPopup()
	{
		CommonUtils.webElement_Click(cancelbtn);
		
	}

	/**
	 * validate new program popup and return true if and only if all of the below are true
	 * 1) program name input box is empty
	 * 2) program description ipput box is empty
	 * 3) cancel button is displayed
	 * 4) save button is displayed
	 * 5) cross button is displayed
	 * 
	 */

	public Boolean verifyNewProgramPopupDetails() {
		Boolean result = Boolean.FALSE;
	    if (programPopup.isDisplayed()) {
	    	String pgmNameInputBoxValue = programName.getAttribute("value");
	    	String pgmDescInputBoxValue = programDesc.getAttribute("value");
	    	if (pgmNameInputBoxValue.isEmpty() 
	    			&& pgmDescInputBoxValue.isEmpty()
	    			&& cancelbtn.isDisplayed()
	    			&& savebtn.isDisplayed()
	    			&& crossbtn.isDisplayed()) {
	    		result = Boolean.TRUE;
	    	}
		}
	    return result;
	}

	public Boolean verifyNameAndDescInPopupDetails() {
		Boolean result = Boolean.FALSE;
		String pgmNameInputBoxType = programName.getAttribute("type");
    	String pgmDescInputBoxType = programDesc.getAttribute("type");
 
	    if (programPopup.isDisplayed()) {
	    	if (programNameLabel.isDisplayed() && pgmNameInputBoxType.equals("text")
	    			&& programDescLabel.isDisplayed() && pgmDescInputBoxType.equals("text")) {
	    		result = Boolean.TRUE;
	    	}
		}
	    return result;
	}

	public Boolean verifyRadioButtonsInPopupDetails() {
		Boolean result = Boolean.FALSE;
	    if (programPopup.isDisplayed()) {
	    	if (radioBtns != null 
	    			&& !radioBtns.isEmpty()
	    			&& radioBtns.size() == 2) {
	    		result = Boolean.TRUE;
	    	}
		}
	    return result;
	}

	public Boolean verifyNewProgramPopupRequiredFields() {
		Boolean result = Boolean.FALSE;
	    if (programPopup.isDisplayed()) {
	    	if (requiredAlerts != null 
	    				&& !requiredAlerts.isEmpty() 
	    				&& requiredAlerts.size() == 3) {
		    	WebElement pgmNameReqAlert = requiredAlerts.get(0);
		    	WebElement pgmDescReqAlert = requiredAlerts.get(1);
		    	WebElement pgmStatusReqAlert = requiredAlerts.get(2);
		    	if (pgmNameReqAlert.isDisplayed()
		    			&& pgmDescReqAlert.isDisplayed()
		    			&& pgmStatusReqAlert.isDisplayed()) {
		    		result = Boolean.TRUE;
		    	}
	    	} else {
	    		result = Boolean.FALSE;
	    	}
		}
	    return result;
	}

	public Boolean verifyNewProgramPopupNameEntered() {
		Boolean result = Boolean.FALSE;
	    if (programPopup.isDisplayed()) {
	    	if (requiredAlerts != null 
	    			&& !requiredAlerts.isEmpty()
	    			&& requiredAlerts.size() == 2) {
	    		WebElement pgmDescReqAlert = requiredAlerts.get(0);
		    	WebElement pgmStatusReqAlert = requiredAlerts.get(1);
		    	if (pgmDescReqAlert.isDisplayed()
		    			&& pgmStatusReqAlert.isDisplayed()) {
		    		result = Boolean.TRUE;
		    	}
	    	} else {
	    		result = Boolean.FALSE;
	    	}
		}
	    return result;
	}

	public Boolean verifyNewProgramPopupDescEntered() {
		Boolean result = Boolean.FALSE;
	    if (programPopup.isDisplayed()) {
	    	if (requiredAlerts != null 
	    			&& !requiredAlerts.isEmpty()
	    			&& requiredAlerts.size() == 2) {
	    		WebElement pgmNameReqAlert = requiredAlerts.get(0);
		    	WebElement pgmStatusReqAlert = requiredAlerts.get(1);
		    	if (pgmNameReqAlert.isDisplayed()
		    			&& pgmStatusReqAlert.isDisplayed()) {
		    		result = Boolean.TRUE;
		    	}
	    	} else {
	    		result = Boolean.FALSE;
	    	}
		}
	    return result;
	}

	public Boolean verifyNewProgramPopupStatusEntered() {
		Boolean result = Boolean.FALSE;
	    if (programPopup.isDisplayed()) {
	    	
	    	if (requiredAlerts != null 
	    			&& !requiredAlerts.isEmpty()
	    			&& requiredAlerts.size() == 2) {
	    		WebElement pgmNameReqAlert = requiredAlerts.get(0);
		    	WebElement pgmDescReqAlert = requiredAlerts.get(1);
		    	if (pgmNameReqAlert.isDisplayed()
		    			&& pgmDescReqAlert.isDisplayed()) {
		    		result = Boolean.TRUE;
		    	}
	    	} else {
	    		result = Boolean.FALSE;
	    	}
		}
	    return result;
	}


	public String ValidateNewProgramPopup() {
	    if (programPopup.isDisplayed()) {
	    	String poptitle = Popuptitle.getText();
	    	System.out.println("popup title text is: " +poptitle);
	        return Popuptitle.getText();
	    } else {
	        return "";
	    	}
		}
	
	   public String validateNameInPopup() {
		   if (namepopupvaldiation.isDisplayed()) {
	   		String namef = namepopupvaldiation.getText();
	   		System.out.println("program name input field is: " +namef);
	   		return namepopupvaldiation.getText();
	   	} else {
	   		return "";
	   	}
	   }
	    
	     public String VerifyPagination() {
	    	int lowIndex = 0;
	    	int highIndex = 0;
	    	List<String> programs = new ArrayList<String>();
	    	// find the web element for the next page
	    	// TODO:
	    	System.out.println("I am here in verify pagination");
	    	// loop until the last page
	    	while (rightarrowbtn.isEnabled()) {
	    		System.out.println("I am in the outer loop ....");
		    	// get the program table displayed on the browser
		    	//List<WebElement> program_table = driver.findElements(By.cssSelector(".<class p-datatable-tbody>"));
		    	if (program_table != null && highIndex ==5) {
		    		highIndex = program_table.size();
		    	}
		    	// loop the program table
		    	for (WebElement ele : program_table) {
		    		System.out.println("I am in the inner loop ....");
		    		programs.add(ele.getText());
		    	}
		    	System.out.println("programs size: " + programs.size());
		    	rightarrowbtn.click();
		    	// TODO: click on the next page
	    	}
	    	
	    	int totalRecords = programs.size();
	    	System.out.println("programs size: " + totalRecords);
			
	    	String p=programpagination.getText();
			return p;
		}
	    
	    public WebElement searchBox() {
	    /*	String stxt = searchbox.getText();
	    	System.out.println("search box text" +stxt);
	    	String stxt1 = searchbox.getAttribute("innerText");
	    	System.out.println("search box text using attribute" +stxt1);*/
			return searchbox;
			
			
		}
	    
	    public WebElement editDeleteBtn() {
			return editdeletebtn;
			
		}
		
	 public boolean verifyDelIcon()
		{
			boolean delIsPresent=delIcon.isDisplayed();
			return delIsPresent;
		}
	    
	 public boolean verifycheckBox()
	{
		List<WebElement> tablerows=driver.findElements(By.xpath("//table//tr"));
		int s=tablerows.size();
		boolean checkBoxISpresent=false;
		for(int i=1;i<=s;i++)
		{
			WebElement checkBox=driver.findElement(By.xpath("(//table//tr)["+i+"]"));
			if(checkBox.isDisplayed()==true)
			{
				return checkBoxISpresent=true;
			}
			else
			{
				
				break;
			}
				
	     }
		return checkBoxISpresent ;
	}
	public boolean textBoxPresent(String textBox)
	{
		WebElement textBox_present= driver.findElement(By.id(textBox));
		boolean txt_ispresent= textBox_present.isDisplayed();
		 return  txt_ispresent;
		
	}

	}



