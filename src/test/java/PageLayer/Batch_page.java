package PageLayer;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LMSConstants;

public class Batch_page {

	WebDriver driver;
	String url = com.LMS.utility.ConfigReader.getApplicationUrl();
	String title = com.LMS.utility.ConfigReader.getHomePageTitle();
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	// CommonUtils CommUtil = new CommonUtils();

	// Batch page locators
	private By locateBatchinheader = By.xpath("//button[@id='batch']/span[1]");
	private By locateManageBatch = By.xpath("//mat-card-title[@class='mat-card-title']/div[1]");
	private By locatepagination = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']");
	private By locateDataTableHead = By.xpath("//thead[@class='p-datatable-thead']");
	private By locateBatchNameHeader = By.xpath("//thead[@class='p-datatable-thead']/tr/th[2]");
	private By locateBatchDescriptionHeader = By.xpath("//thead[@class='p-datatable-thead']/tr/th[3]");
	private By locateBatchStatusHeader = By.xpath("//thead[@class='p-datatable-thead']/tr/th[4]");
	private By locateNoOfClassesHeader = By.xpath("//thead[@class='p-datatable-thead']/tr/th[5]");
	private By locateProgramNameHeader = By.xpath("//thead[@class='p-datatable-thead']/tr/th[6]");
	private By locateDeletedisabled = By
			.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	private By locateANewBatchButton = By.xpath("//span[text()='A New Batch']");
	private By locateBatchDetailsDialog = By.xpath("//div[@role='dialog']");
	private By locateNameinPopup = By.xpath("//label[text()='Name']");
	private By locateDescriptionInpopup = By.xpath("//label[text()='Description ']");
	private By locateProgNameInPopup = By.xpath("Program Name ");
	private By locateStatusInPopup = By.xpath("//lable[text()='Status : ']");
	private By locateNoOfClassesInPopup = By.xpath("//label[text()='Number of Classes ']");
	private By locateNameFieldinPopup = By.id("batchName");
	private By locateDescriptionFieldInpopup = By.id("batchDescription");
	private By locateProgNamedropInPopup = By.xpath("//div[@role='button']");
	private By locateDropdownOption = By.xpath("//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[1]/li");
	private By locateStatusFieldInPopup = By.id("batchStatus");
	private By locateNoOfClassField = By.id("batchNoOfClasses");
	private By locateBatchPopupClose = By.xpath("//div[@class='p-dialog-header-icons ng-tns-c132-15']/button");
	private By locateBatchPopupSave = By.xpath("//span[text()='Save']");
	private By locateBatchPopupCancel = By.xpath("//span[text()='Cancel']");
	private By locateNewlyAddBatch = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[2]");
	private By locateDeleteBtn = By.xpath("//tbody[@class='p-datatable-tbody']/tr[1]/td[7]/div/span[2]/button");
	private By locateyesBtn = By.xpath("//span[text()='Yes']");
	private By locateNoBtn = By.xpath("//span[text()='No']");
	private By successPopUpContent = By.xpath("//div[@class='p-toast-detail ng-tns-c90-8']");
	private By allChkBox = By.xpath("//div[@role='checkbox']");
	private By singleChkBox = By.xpath("//table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]");
	private By editIcon = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[7]/div/span[1]/button/span[1]");
	private By search = By.xpath("//input[@id='filterGlobal']");
	private By closePopBtn = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c132-6 pi pi-times']");
	private By batchDialog = By.xpath("//div[@class='ng-tns-c132-6 p-dialog-mask p-component-overlay p-dialog-mask-scrollblocker ng-star-inserted']");
    private By deletedialog=By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c133-7 p-dialog p-confirm-dialog p-component ng-star-inserted']");
	public Batch_page(WebDriver d) {
		this.driver = d;

	}

	// methods

	public String getCurrentUrl() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

	public void clickBatch() {
		WebElement Batch = driver.findElement(locateBatchinheader);
		CommonUtils.webElement_Click(Batch);
	}

	public String validateBatchHeader() {
		WebElement BatchHeader = driver.findElement(locateManageBatch);
		return CommonUtils.getElementText(BatchHeader);
	}

	public void clickNewBatchButton() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			WebElement NewBatch = driver.findElement(locateANewBatchButton);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locateBatchDetailsDialog));
//	        if(invisible) {
//	        	WebElement NewBatch = driver.findElement(locateANewBatchButton);
			CommonUtils.webElement_Click(NewBatch);
			// NewBatch.click();

			// CommonUtils.webElement_Click(NewBatch);
		} catch (StaleElementReferenceException e) {
			WebElement NewBatch = driver.findElement(locateANewBatchButton);
			CommonUtils.webElement_Click(NewBatch);
		}
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", NewBatch);
	}

	public boolean validatePagination() {
		boolean PaginationCtrldisplayed = driver.findElement(locatepagination).isDisplayed();
		if (PaginationCtrldisplayed = true) {
			System.out.println("PaginationCtrl is visible. Return: " + PaginationCtrldisplayed);

		} else {
			System.out.println("PaginationCtrl is not visible. Return: " + PaginationCtrldisplayed);
		}
		return PaginationCtrldisplayed;

	}

	public boolean validateDataTableHead() {
		boolean DatatableHeaddisplayed = driver.findElement(locateDataTableHead).isDisplayed();
		if (DatatableHeaddisplayed = true) {
			System.out.println("DatatableHeaddisplayed is visible. Return: " + DatatableHeaddisplayed);

		} else {
			System.out.println("DatatableHeaddisplayed is not visible. Return: " + DatatableHeaddisplayed);
		}
		return DatatableHeaddisplayed;

	}

	public boolean validateDeleteIcon() {
		boolean DeleteIconvisibility = driver.findElement(locateDeletedisabled).isEnabled();
		if (DeleteIconvisibility = false) {
			System.out.println("DeleteIconvisibility is not visible. Return: " + DeleteIconvisibility);

		} else {
			System.out.println("DeleteIconvisibility is visible. Return: " + DeleteIconvisibility);
		}
		return DeleteIconvisibility;

	}

	public boolean aNewBatchDisplayed() {
		boolean ANewBatchdisplayed = driver.findElement(locateANewBatchButton).isDisplayed();
		if (ANewBatchdisplayed = true) {
			System.out.println("Add New Batch Button is visible. Return: " + ANewBatchdisplayed);

		} else {
			System.out.println("Add New Batch Button is not visible. Return: " + ANewBatchdisplayed);
		}
		return ANewBatchdisplayed;
	}

	public boolean dialogBatchDetailsDisplayed() {
		boolean BatchDetailsDisplayed = driver.findElement(locateBatchDetailsDialog).isDisplayed();
		return BatchDetailsDisplayed;
	}

	public boolean validateNameInPopup() {
		boolean validateName = driver.findElement(locateNameinPopup).isEnabled();
		return validateName;
	}

	public boolean validateNameFieldAsText() {
		boolean validateNameField = driver.findElement(locateNameFieldinPopup).getAttribute("type").equals("text");
		return validateNameField;
	}

	public boolean validateDescriptionInPopup() {
		boolean validateDescription = driver.findElement(locateDescriptionInpopup).isEnabled();
		return validateDescription;
	}

	public boolean validateDescFieldAsText() {
		boolean validateDescField = driver.findElement(locateDescriptionFieldInpopup).getAttribute("type")
				.equals("text");
		return validateDescField;
	}

	public boolean validateProgNameAsDropdown() {
		boolean validateDescField = driver.findElement(locateProgNamedropInPopup).getAttribute("aria-haspopup")
				.equals("listbox");
		return validateDescField;

	}

	public boolean validateNoOfClassAsText() {
		boolean validateNoOfClassField = driver.findElement(locateNoOfClassField).getAttribute("type").equals("text");
		return validateNoOfClassField;
		
	}

	public boolean validateStatusAsRadio() {
		boolean validateStatusField = driver.findElement(locateNoOfClassField).getAttribute("type").equals("radio");
		return validateStatusField;

	}

	public void addBatchValidExceptDesc(String Sheetname, Integer rownumber)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testdata = excel.getData(Excelpath, Sheetname);
		String Name = testdata.get(rownumber).get("Name");
		String Desc = testdata.get(rownumber).get("Description");
		String NoOfClasses = testdata.get(rownumber).get("NoOfClasses");
		WebElement SendName = driver.findElement(locateNameFieldinPopup);
		SendName.sendKeys(Name);
		WebElement SendDesc = driver.findElement(locateDescriptionFieldInpopup);
		SendDesc.sendKeys(Desc);
		WebElement SendClasses = driver.findElement(locateNoOfClassField);
		SendClasses.sendKeys(NoOfClasses);
		WebElement ProgNamedropdown = driver.findElement(locateProgNamedropInPopup);
		CommonUtils.webElement_Click(ProgNamedropdown);
		// Select prognameele = new Select(ProgNamedropdown);
		// prognameele.selectByIndex(1);
		WebElement selectDropdownOption = driver.findElement(locateDropdownOption);
		CommonUtils.webElement_Click(selectDropdownOption);
		WebElement Status = driver.findElement(locateStatusFieldInPopup);
		CommonUtils.webElement_Click(Status);
		WebElement savebatch = driver.findElement(locateBatchPopupSave);
		CommonUtils.webElement_Click(savebatch);
		Thread.sleep(1000);
	}

	public String batchNameInDataTable() {
		String NewAddBatch = driver.findElement(locateNewlyAddBatch).getText();
		System.out.println(NewAddBatch);
		return NewAddBatch;

	}

	public void fillFieldsValidBatch(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testdata = excel.getData(Excelpath, Sheetname);
		String Name = testdata.get(rownumber).get("Name");
		String Desc = testdata.get(rownumber).get("Description");
		String NoOfClasses = testdata.get(rownumber).get("NoOfClasses");
		WebElement SendName = driver.findElement(locateNameFieldinPopup);
		CommonUtils.webSendKeys(SendName, Name);
		WebElement SendDesc = driver.findElement(locateDescriptionFieldInpopup);
		CommonUtils.webSendKeys(SendDesc, Desc);
		WebElement SendClasses = driver.findElement(locateNoOfClassField);
		CommonUtils.webSendKeys(SendClasses, NoOfClasses);
		WebElement ProgNamedropdown = driver.findElement(locateProgNamedropInPopup);
		CommonUtils.webElement_Click(ProgNamedropdown);
		// Select prognameele = new Select(ProgNamedropdown);
		// prognameele.selectByIndex(1);
		WebElement selectDropdownOption = driver.findElement(locateDropdownOption);
		CommonUtils.webElement_Click(selectDropdownOption);
		WebElement Status = driver.findElement(locateStatusFieldInPopup);
		CommonUtils.webElement_Click(Status);
		WebElement savebatch = driver.findElement(locateBatchPopupSave);
		CommonUtils.webElement_Click(savebatch);
		LMSConstants.applicationData.setBatchname(Name);
	}

	public void fillFieldsInValidBatch(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testdata = excel.getData(Excelpath, Sheetname);
		String Name = testdata.get(rownumber).get("Name");
		String Desc = testdata.get(rownumber).get("Description");
		String NoOfClasses = testdata.get(rownumber).get("NoOfClasses");
		WebElement SendName = driver.findElement(locateNameFieldinPopup);
		CommonUtils.webSendKeys(SendName, Name);
		WebElement SendDesc = driver.findElement(locateDescriptionFieldInpopup);
		CommonUtils.webSendKeys(SendDesc, Desc);
		WebElement SendClasses = driver.findElement(locateNoOfClassField);
		CommonUtils.webSendKeys(SendClasses, NoOfClasses);
		WebElement ProgNamedropdown = driver.findElement(locateProgNamedropInPopup);
		CommonUtils.webElement_Click(ProgNamedropdown);
		// Select prognameele = new Select(ProgNamedropdown);
		// prognameele.selectByIndex(1);
		WebElement selectDropdownOption = driver.findElement(locateDropdownOption);
		CommonUtils.webElement_Click(selectDropdownOption);
		WebElement Status = driver.findElement(locateStatusFieldInPopup);
		CommonUtils.webElement_Click(Status);
		WebElement savebatch = driver.findElement(locateBatchPopupSave);
		CommonUtils.webElement_Click(savebatch);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
      public void closePop() {
    	  
    	  try {
    		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	 		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(closePopBtn)));
  			driver.findElement(closePopBtn).click();
  		} catch (StaleElementReferenceException e) {
  			WebElement NewBatch = driver.findElement(closePopBtn);
  			CommonUtils.webElement_Click(NewBatch);
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
      }
	public boolean verifyDeletebtnEnabled() {

		boolean deleteBtnEnabled = driver.findElement(locateDeleteBtn).isEnabled();
		return deleteBtnEnabled;
	}

	public void clickRowDeleteicon() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(deletedialog));
		
		CommonUtils.webElement_Click(driver.findElement(locateDeleteBtn));
	}

	public boolean getAlertBtnText() {

		return CommonUtils.verifyElementText("Yes", driver.findElement(locateyesBtn))
				&& CommonUtils.verifyElementText("No", driver.findElement(locateNoBtn));

	}

	public void clickYes() {
		CommonUtils.webElement_Click(driver.findElement(locateyesBtn));
	}

	public void clickNo() {
		CommonUtils.webElement_Click(driver.findElement(locateNoBtn));
	}
	

	public boolean checkboxSelected() {
		boolean result = false;
		List<WebElement> checkboxes = driver.findElements(allChkBox);
		for (WebElement chkbox : checkboxes) {
			String isSelect = chkbox.getAttribute("aria-checked");
			if ("true".equals(isSelect)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void chkTableElements() {

	}

	public void singleRowClick() {
		CommonUtils.webElement_Click(driver.findElement(singleChkBox));
	}

	public void clickDeleteIcon() {
		if(driver.findElement(locateDeletedisabled).isEnabled()){
			CommonUtils.webElement_Click(driver.findElement(locateDeletedisabled));
		} else {
			System.out.println("No items selected to delete!!");
		}
	}

	public void multiRowClick() throws InterruptedException {
		boolean result = false;
		int count=0;
		List<WebElement> checkboxes = driver.findElements(allChkBox);
		System.out.println("Total checkboxes -"+checkboxes.size());
		for (int i = 1; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
			if (i>3) {
				break;
			}
			Thread.sleep(1000);
			System.out.println(i);
		}
		System.out.println("MultiRow deletion completed!!");
	}

	public void editBatch(String sheetname, String testcase) {
		System.out.println("editBatch sheetname" + sheetname);
		Map<String, String> testdata = LMSConstants.applicationData.getData(sheetname, testcase);

		String Desc = testdata.get("Description");
		String NoOfClass = testdata.get("NoOfClasses");
		WebElement SendDesc = driver.findElement(locateDescriptionFieldInpopup);
		CommonUtils.webSendKeys(SendDesc, Desc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement SendClasses = driver.findElement(locateNoOfClassField);
		CommonUtils.webSendKeys(SendClasses, NoOfClass);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement savebatch = driver.findElement(locateBatchPopupSave);
		CommonUtils.webElement_Click(savebatch);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	}

	public void clickRowRdit() {
		WebElement editSelectRow = driver.findElement(editIcon);
		CommonUtils.webElement_Click(editSelectRow);
	}

	public void searchAndEdit(String batchname) throws InterruptedException {

		WebElement searchBtn = driver.findElement(search);
		CommonUtils.webSendKeys(searchBtn, batchname);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(1000);
		WebElement editSelectRow = driver.findElement(editIcon);
		CommonUtils.webElement_Click(editSelectRow);
	}

	public boolean searchAndVerify(String batchname) throws InterruptedException {

		WebElement searchBtn = driver.findElement(search);
		CommonUtils.webSendKeys(searchBtn, batchname);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(1000);
		WebElement editSelectRow = driver.findElement(editIcon);
		return editSelectRow.isEnabled();
	}

	public void batchDetailDialog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(locateBatchDetailsDialog));
		if (invisible) {
			WebElement NewBatch = driver.findElement(locateANewBatchButton);
			CommonUtils.webElement_Click(NewBatch);
		}
		
	}
	public int chkboxEnabled() {
		int chkboxEnableCount = 0;
		List<WebElement> checkboxes = driver.findElements(allChkBox);
		for(WebElement ch:checkboxes) {
			ch.isEnabled();
			chkboxEnableCount++;
		}return chkboxEnableCount;
	}
	public void clearSearch() {
		WebElement searchBtn = driver.findElement(search);
		//searchBtn.sendKeys("s");
		searchBtn.clear();
		
	}
	public void clearSearchBox() {
		WebElement searchBtn = driver.findElement(search);
		CommonUtils.webSendKeys(searchBtn, "A");
		CommonUtils.webSendKeys(searchBtn, Keys.CONTROL + "a" + Keys.DELETE);
	}
	

}
