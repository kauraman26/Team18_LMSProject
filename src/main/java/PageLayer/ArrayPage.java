package PageLayer;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.ConfigReader;
import com.dsalgo.util.elementUtils;

public class ArrayPage {

	WebDriver driver;
	String ArrayURL=ConfigReader.getArrayUrl();
	elementUtils elementUtils = new elementUtils();
	
	//Homepage
		@FindBy (xpath="//a[@href='array']")WebElement getstart_array;
			
		//ArrayPage
		@FindBy (xpath="//a[@href='arrays-in-python']")WebElement arraysInPythonLink;
		@FindBy (xpath="//a[@href='arrays-using-list']")WebElement arraysUsingListLink;
		@FindBy (xpath="//a[@href='basic-operations-in-lists']")WebElement basicOpinListsLink;
		@FindBy (xpath="//a[@href='applications-of-array']")WebElement appOfArrayLink;
		
		@FindBy (xpath="//a[@href='/array/practice']")WebElement practiceQueLink;
		@FindBy (xpath="//a[@href='/question/1']")WebElement searchArrayLink;
		@FindBy (xpath="//a[@href='/question/2']")WebElement mostConOnesLink;
		@FindBy (xpath="//a[@href='/question/3']")WebElement findEvenNumLink;
		@FindBy (xpath="//a[@href='/question/4']")WebElement sqOfSortedArrayLink;
		
		@FindBy (xpath="//a[@href='/tryEditor']")WebElement TryHereLink;
		@FindBy (xpath="//*[@id='answer_form']")WebElement answerform;
		@FindBy (xpath="//textarea[@tabindex='0']")WebElement editorInput;
		@FindBy (xpath="//*[@id='answer_form']/button")WebElement runButton;
		@FindBy (xpath="//*[@class='button']")WebElement submitButton;
		@FindBy (id="output")WebElement output; 
	
	//Constructor
		public ArrayPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this); 
		} 
		
	//Methods
		
		public void ClickGetStartedBtnArray() {
			getstart_array.click();
		}
		
		public String getArrayPageTitle() {
			String title = driver.getTitle();
			return title;
		}
		
		public void ClickArraysInPython() {
			arraysInPythonLink.click();
		}
		
		public void clickOnTryHereLink() {
			TryHereLink.click();
		}
		
		public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException {
			String code = elementUtils.getCodefromExcel(sheetname, rownumber);
			elementUtils.enterCode(code, editorInput);

		}
		
		public String getExpectedResult(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
			String expectedResult = elementUtils.getResultfromExcel(sheetName, rowNum);
			return expectedResult;
		}
		
		public void clickOnRunButton() {
			runButton.click();

		}
		
		public String validatePythonCodeGotPrinted() {
			return outputproject from eclipse to github.getText();
		}
}
