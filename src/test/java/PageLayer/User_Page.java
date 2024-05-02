package PageLayer;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.LMS.utility.CommonUtils;
import com.LMS.utility.ConfigReader;
import com.LMS.utility.ExcelUtils;
import com.LMS.utility.LMSConstants;

public class User_Page {
	
	WebDriver driver;
	String Excelpath = ConfigReader.getexcelfilepath();
	ExcelUtils excel = new ExcelUtils();
	CommonUtils CommUtil = new CommonUtils();
	Program_Page p=new Program_Page();
	
		
	@FindBy(xpath="(//div[@class='box'])[1]")WebElement heading;
	@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")WebElement delIcon;
	WebElement 	textBox_present;
	@FindBy(id="filterGlobal")WebElement txt;
	@FindBy(xpath="(//table//tr//td)[3]")WebElement username;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']") WebElement zerorecord;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-warn']")WebElement popup_close;
	
	@FindBy(xpath="//input[@data-placeholder='First name']")WebElement FirstName;
	@FindBy(xpath="//input[@data-placeholder='Middle name']")WebElement MiddleName;
	@FindBy(xpath="//input[@data-placeholder='Last name']")WebElement LastName;
	@FindBy(xpath="//input[@data-placeholder='Location']")WebElement Location;
	@FindBy(xpath="//input[@data-placeholder='Phone no']")WebElement PhoneNo;
	@FindBy(xpath="//input[@data-placeholder='LinkedIn Url']")WebElement LinkedIn;
	@FindBy(xpath="//input[@data-placeholder='Email address']")WebElement Email;
	@FindBy(xpath="//input[@data-placeholder='Under Graduate']")WebElement UG;
	@FindBy(xpath="//input[@data-placeholder='Post Graduate']")WebElement PG;
	@FindBy(xpath="//input[@data-placeholder='Time Zone']")WebElement TimeZone;
	@FindBy(xpath="//input[@data-placeholder='User Comments']")WebElement UserComments;
	@FindBy(xpath="//span[text()='Select Role']")WebElement UserRole;
	@FindBy(xpath="//span[text()='Select Role Status']")WebElement UserRoleStatus;
	@FindBy(xpath="//span[text()='Select Visa Status']")WebElement UserVisaStatus;
	@FindBy(xpath="//span[text()='Submit']")WebElement Submit;
	@FindBy(xpath="//span[text()='Cancel']")WebElement Cancel;
	@FindBy(xpath="//div[contains(@class,'p-toast-detail')]")WebElement successPopupTitle;
	@FindBy(xpath="//div[@class='ng-tns-c91-232 p-toast p-component p-toast-top-right']")WebElement FailPopupTitle;
	
	
	
public void addUser(String sheetname, String testcase) {
		
		Map<String, String> testdatabyTC = LMSConstants.applicationData.getData(sheetname, testcase);
		
		long d = System.currentTimeMillis();
		String usrName = testdatabyTC.get("FirstName");
		String usrMName = testdatabyTC.get("MiddleName");
		String usrLName = testdatabyTC.get("LastName");
		String location=testdatabyTC.get("Location");
		//String phone=testdatabyTC.get("PhoneNo").replaceAll("[^0-9]","");
		//long phoneno=Long.parseLong(phone);
		String linked=testdatabyTC.get("LinkedIn");
		String email=testdatabyTC.get("Email");
		String[] emailarray=email.split("@");
		String e=emailarray[0]+d+"@"+emailarray[1];
		String under=testdatabyTC.get("UnderGraduate");
		String post=testdatabyTC.get("PostGraduate");
		String time=testdatabyTC.get("TimeZone");
		String cmt=testdatabyTC.get("UserComment");
		//CommonUtils.webElement_Click(newpgmbtn);
		System.out.println("Firstname " +usrName);
		CommonUtils.webSendKeys(FirstName,usrName);
		CommonUtils.webSendKeys(MiddleName,usrMName);
		CommonUtils.webSendKeys(LastName,usrLName);
		CommonUtils.webSendKeys(Location,location);
		Random rand=new Random();
		int x=rand.nextInt(9000) + 1000;
		String phone="614707"+x;
		CommonUtils.webSendKeys(PhoneNo,String.valueOf(phone));
		CommonUtils.webSendKeys(LinkedIn,linked);
		UserRole.click();
		UserRole.findElement(By.xpath("//span[text()='R01']")).click();
		UserRoleStatus.click();
		UserRoleStatus.findElement(By.xpath("//span[text()='Active']")).click();
		UserVisaStatus.click();
		UserVisaStatus.findElement(By.xpath("//span[text()='H4']")).click();
		CommonUtils.webSendKeys(Email,e);
		CommonUtils.webSendKeys(UG,under);
		CommonUtils.webSendKeys(PG,post);
		CommonUtils.webSendKeys(TimeZone,time);
		CommonUtils.webSendKeys(UserComments,cmt);
		p.sleep();
		
		CommonUtils.webElement_Click(Submit);
		LMSConstants.applicationData.setUserName(usrName);
	
	}
	
	
	public User_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void click_User(String modulename)
	{
		WebElement m_name=driver.findElement(By.id(modulename));
		CommonUtils.webElement_Click(m_name);
		
	}
	public String URL() throws ArrayIndexOutOfBoundsException
	{
		String url=driver.getCurrentUrl();
		String[] splited=url.split(".com/");
		String url_user=splited[1];
		return url_user;
	}
	public String verifyHeading()
	{
		
		String h=heading.getText();
		return h;
		
	}
	
	public String verifyTableHeaders(int position)
	{

			WebElement table_header=driver.findElement(By.xpath("(//table//tr//th)["+position+"]"));
			String header_name=table_header.getText();
			return header_name;
	}
	
	public boolean verifyDelIcon()
	{
		boolean delIsPresent=delIcon.isDisplayed();
		return delIsPresent;
	}
	
	public boolean verifyAddbutton(String buttonIcon,int position )
	{
		
		WebElement plusIcon=driver.findElement(By.xpath("(//button[@id='"+buttonIcon+"'])["+position+"]//span[1]"));
		//WebElement plusIcon=driver.findElement(By.xpath("//button[@id='"+buttonIcon+"']//span[1]"));
		boolean icon=plusIcon.isDisplayed();
		return icon;
		
	}
	public String verifyTextButton(String buttonName,int position)
	{
		WebElement buttonText=driver.findElement(By.xpath("(//button[@id='"+buttonName+"'])["+position+"]//span[2]"));
		String button_text=buttonText.getText();
		return button_text;
	}
	
	
	public boolean textBoxPresent(String textBox)
	{
		textBox_present= driver.findElement(By.id(textBox));
		boolean txt_ispresent= textBox_present.isDisplayed();
		return  txt_ispresent;
		
	}
	public boolean tableRecords(Integer position)
	{
		boolean x=false;
		
		WebElement records=driver.findElement(By.xpath("(//table//tr)["+position+"]"));
	
		if(records.isDisplayed())
		{
			return x=true;
		}
		else {
			return x;
		}
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
	
			
			public boolean verifyIcons(String icon)
			{
				List<WebElement> tablerows=driver.findElements(By.xpath("//button[@class='"+icon+"']"));
				int s=tablerows.size();
				boolean IconsIsEnable=false;
				for(int i=1;i<=s;i++)
				{
					
					WebElement Icons=driver.findElement(By.xpath("(//button[@class='"+icon+"'])["+i+"]"));
					if(Icons.isEnabled()==true)
					{
						return IconsIsEnable=true;
					}
					else
					{
						
						break;
					}
						
					
				}
				return IconsIsEnable ;
				
						
			}
			
			public void enterTextBox(String username)
			{
				
				txt.sendKeys(username);
				
			}
			public void cls()
			{
				txt.clear();
			}
			
			public String  usernameValidation()
			{
				return username.getText();
				
			}

public String ZeroRecord()
{
	return zerorecord.getText();
	
}


public void addNewUser(String addbutton)
{
	WebElement popup_labels=driver.findElement(By.id(addbutton));
	CommonUtils.webElement_Click(popup_labels);
}

public String popup_labels(String fieldname)
{
	WebElement popup_labels=driver.findElement(By.xpath("//span[text()='"+fieldname+"']"));
	return popup_labels.getText();
}

public String popup_labels2(String labelname)
{
	WebElement popup_labels=driver.findElement(By.xpath("//label[text()='"+labelname+"']"));
	return popup_labels.getText();
}			
public boolean popup_text_field(String txtfield)
{
	WebElement popup_labels=driver.findElement(By.xpath("//input[@data-placeholder='"+txtfield+"']"));
	return popup_labels.isDisplayed();
}	

public void closePopup()
{
	popup_close.click();
}
public boolean listboxPresent(String list)
{
	WebElement listbox=driver.findElement(By.xpath("//span[text()='"+list+"']"));
	return listbox.isDisplayed();
	
}





public String successPopup() {
	
	return successPopupTitle.getText();
}

public String errormsg(String content1)
{
	
	WebElement errorcon=driver.findElement(By.xpath("//mat-error[text()='"+content1+"']"));
	String x=errorcon.getText();
	return x;
	
}
public void clickSubmit()
{
	CommonUtils.webElement_Click(Submit);
}

public void clickCancel()
{
	CommonUtils.webElement_Click(Cancel);
}
public void addRepeatedData(String FN, String MN, String LN , String location, String phone, String linkedin, String email, String ug, String pg,String TZ,String cmt)
{
	CommonUtils.webSendKeys(FirstName,FN);
	CommonUtils.webSendKeys(MiddleName,MN);
	CommonUtils.webSendKeys(LastName,LN);
	CommonUtils.webSendKeys(Location,location);
	
	CommonUtils.webSendKeys(PhoneNo,phone);
	CommonUtils.webSendKeys(LinkedIn,linkedin);
	UserRole.click();
	UserRole.findElement(By.xpath("//span[text()='R01']")).click();
	UserRoleStatus.click();
	UserRoleStatus.findElement(By.xpath("//span[text()='Active']")).click();
	UserVisaStatus.click();
	UserVisaStatus.findElement(By.xpath("//span[text()='H4']")).click();
	CommonUtils.webSendKeys(Email,email);
	CommonUtils.webSendKeys(UG,ug);
	CommonUtils.webSendKeys(PG,pg);
	CommonUtils.webSendKeys(TimeZone,TZ);
	CommonUtils.webSendKeys(UserComments,cmt);
	p.sleep();
	
	CommonUtils.webElement_Click(Submit);
	//LMSConstants.applicationData.setUserName(usrName);

}

public boolean fail()
{
	return successPopupTitle.isDisplayed();
}




}