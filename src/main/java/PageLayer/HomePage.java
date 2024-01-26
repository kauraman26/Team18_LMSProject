package PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dsalgo.factory.DriverFactory;
import com.dsalgo.util.ConfigReader;


public class HomePage {
	
	String url=ConfigReader.getApplicationUrl();
	String homeURL=ConfigReader.getHomeUrl();
	WebDriver driver;
	
 //private WebDriver driver=DriverFactory.getDriver();
 
 			//Dsalgo page
			@FindBy (xpath="//a[@href='/home']")WebElement getstart_link;
			@FindBy (xpath="//a[contains(text(),'Get Started')]")WebElement getstart;
			//Sign-in button
			@FindBy(xpath="//a[@href='/login']")WebElement loginLnk;		
			//Register button
			@FindBy(xpath="//a[@href='/register']")WebElement registerLnk;		
			//Logout button
			@FindBy(xpath= "//a[@href='/logout']")WebElement signoutBtn;	
			//Dropdown option
			@FindBy (xpath="//a[@href='#']")WebElement dropdown;		
			@FindBy (xpath="//a[@class='dropdown-item' and @href='/array']")
			WebElement dropdown_array;
			@FindBy (xpath="//a[@class='dropdown-item' and @href='/linked-list']")
			WebElement dropdown_linkedlist;
			@FindBy (xpath="//a[@class='dropdown-item' and @href='/stack']")
			WebElement dropdown_stack;
			@FindBy (xpath="//a[@class='dropdown-item' and @href='/queue']")
			WebElement dropdown_queue;
			@FindBy (xpath="//a[@class='dropdown-item' and @href='/tree']")
			WebElement dropdown_tree;
			@FindBy (xpath="//a[@class='dropdown-item' and @href='/graph']")
			WebElement dropdown_graph;
			
			
			//DropDownOptions
			@FindBy(xpath= "//div[@class='dropdown-menu show']")
			WebElement HomePageDropdwn;
			
			//GetStarted button under DataStructure
			@FindBy(xpath = "//a[@href='data-structures-introduction']")
			WebElement GetStartedDSBtn;
			
			//You are logged in message
			@FindBy(xpath="//div[@class='alert alert-primary']")
			//@FindBy(xpath="//div[contains (text(),'You are logged in')]")
			WebElement loginSuccessMsg;
				
			//You are not logged in message
			@FindBy(xpath="//div[contains (text(),'You are not logged in')]")
			WebElement WithoutloginErrorMsg;
			
			//Get Started button for datastructure
			@FindBy (xpath="//a[text()='Get Started' and @href='data-structures-introduction']")
			WebElement getstartBtn_dataStructures;
			//Get Started button for array
			@FindBy (xpath="//a[text()='Get Started' and @href='array']")
			WebElement getstartBtn_array;
			//Get Started button for Linked List
			@FindBy (xpath="//a[text()='Get Started' and @href='linked-list']")
			WebElement getstartBtn_linkedlist;
			//Get Started button for Stack
			@FindBy (xpath="//a[text()='Get Started' and @href='stack']")
			WebElement getstartBtn_stack;
			//Get Started button for Queue
			@FindBy (xpath="//a[text()='Get Started' and @href='queue']")
			WebElement getstartBtn_queue;
			//Get Started button for tree
			@FindBy (xpath="//a[text()='Get Started' and @href='tree']")
			WebElement getstartBtn_tree;
			//Get Started button for graph
			@FindBy (xpath="//a[text()='Get Started' and @href='graph']")
			WebElement getstartBtn_graph;
			
			//Constructor of the Page Class			
			public HomePage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
				//this.driver = driver;
			}
			
			//Page Actions
			
			public void dsalgopage() {
				//DriverFactory.getDriver().get(url);
				driver.get(url);
			}

			public void getStarted_link(String str) {
				getstart_link.click();
			}
			
			public String LandedHomePage() {
				 return driver.getCurrentUrl();
			}
			
			public String getPageTitle() {
				String title = driver.getTitle();
				return title;
			}
			
			public void homepage() {
				driver.get(homeURL);
			}
					
			public void ClickSignoutBtn() {
				signoutBtn.click();
			}
			
			public boolean VerifySignoutLnk() {
				return signoutBtn.isDisplayed();
			}
			
			public String alert() {

				String msg = WithoutloginErrorMsg.getText();
				return msg;
			}
			
			public void getStarted_home(String string) {

				switch (string) {
				case "Datastructures":
					//Loggerload.info("click " + getstart_datastructures.getText() + "link on  DataStructures ");
					getstartBtn_dataStructures.click();
					break;
				case "Arrays":
					//Loggerload.info("click " + getstart_array.getText() + "link on Array ");
					getstartBtn_array.click();
					break;
				case "Linkedlist":
					//Loggerload.info("click " + getstart_linkedlist.getText() + "link on LinkedList");
					getstartBtn_linkedlist.click();
					break;
				case "Stack":
					//Loggerload.info("click " + getstart_stack.getText() + "link on stack");
					getstartBtn_stack.click();
					break;
				case "Queue":
					//Loggerload.info("click " + getstart_queue.getText() + "link on queue ");
					getstartBtn_queue.click();
					break;
				case "Tree":
					//Loggerload.info("click " + getstart_tree.getText() + "link on Tree ");
					getstartBtn_tree.click();
					break;
				case "Graph":
					//Loggerload.info("click " + getstart_graph.getText() + "link on Graph ");
					getstartBtn_graph.click();
					break;
				}
			}
			
			// Dropdown
			public void dropdown(String string) {

				dropdown.click();
				switch (string) {
				case "Arrays":
					//Loggerload.info("User click on " + string);
					dropdown_array.click();
					break;
				case "Linkedlist":
					//Loggerload.info("User click on " + string);
					dropdown_linkedlist.click();
					break;
				case "Stack":
					//Loggerload.info("User click on " + string);
					dropdown_stack.click();
					break;
				case "Queue":
					//Loggerload.info("User click on " + string);
					dropdown_queue.click();
					break;
				case "Tree":
					//Loggerload.info("User click on " + string);
					dropdown_tree.click();
					break;
				case "Graph":
					//Loggerload.info("User click on " + string);
					dropdown_graph.click();
					break;
				}

			}

			// Signin
			public void signin_link() {
				loginLnk.click();
			}

			public String login_page() {
				String title = driver.getTitle();
				return title;
			}

			// Register
			public void register_link() {

				registerLnk.click();

			}

			public String register_page() {
				String title = driver.getTitle();
				return title;
			}
			
			public String HomepageTitle() {
				return driver.getTitle();			
			}

			
}
