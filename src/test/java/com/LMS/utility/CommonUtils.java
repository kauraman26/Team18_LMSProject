package com.LMS.utility;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LMS.factory.DriverFactory;


public class CommonUtils {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static WebDriver driver = DriverFactory.getDriver() ;
	
	public static boolean webElement_Click(WebElement element) {
		try {
			WebElement ele_toclick = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
				
				if(ele_toclick.isEnabled()) {
					try {
						ele_toclick.click();
						return true;
					}
					catch(Exception e) {
						e.printStackTrace();
						return false;
					}	
				}
				else {
					throw new Exception("Element is not enabled");
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean webSendKeys(WebElement element, String text) {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
		
				if(ele.isEnabled()) {
					try {
						ele.clear();
						ele.sendKeys(text);	
						return true;
					}
					catch(Exception e) {
						e.printStackTrace();
						return false;
					}	
				}
				else {
					throw new Exception("Element is not enabled");
				}
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	
	public static String getElementText(WebElement element) {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(element));
		return textElement.getText();
	}

	public static boolean verifyElementText(String expectedMsg, WebElement element) {
		if (getElementText(element).equals(expectedMsg)) {
			return true;
		}

		return false;
	}
	
	public static String ActualPageTitle() {
		return driver.getTitle();
	}

	
}

