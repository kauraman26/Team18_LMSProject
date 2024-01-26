package PageLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStructurePage {
	
	WebDriver driver;
	
	@FindBy (xpath="//a[@href='time-complexity']")WebElement LnktimeComplexity;
	@FindBy(xpath ="//a[@ href ='/tryEditor']")WebElement LnktryHere;
	@FindBy (xpath="//textarea[@tabindex='0']")WebElement editorInput;
	@FindBy(xpath ="//button[text()='Run']")WebElement runBtn;
	@FindBy(xpath="//pre[@id='output']")WebElement OutputConsole;
	@FindBy (xpath="//*[@href='/data-structures-introduction/practice']")WebElement practiceQuestionLnk;
	
	//Constructor
	public DataStructurePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	} 
		
	//Methods
	public String DSPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void clickPracticeQuestionLink() {
		practiceQuestionLnk.click();
		
	}
	public void clickOnTimeComplexitylink() {
		LnktimeComplexity.click();
	}
	
	public void clickTryHereButton() {
		LnktryHere.isDisplayed();
		LnktryHere.click();
	}
	
	public boolean enterCode(String code,String result) {
		
		try {
			new Actions(driver).sendKeys(editorInput, code).perform();
		} catch(Exception e) {
			editorInput.sendKeys(code);
		}
		return true;
	}
	
	public void clickBtnRun() {
		runBtn.click();
	}
	
	public String validatePythonCodeGotPrinted() {
		return OutputConsole.getText();
	}
	
	public void deletePythonCode() {
		Actions actions = new Actions(driver);
		actions.click(editorInput).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
	}
	
}

