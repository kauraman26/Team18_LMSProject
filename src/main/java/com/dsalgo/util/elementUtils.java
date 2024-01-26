package com.dsalgo.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.factory.DriverFactory;

public class elementUtils {
	
	public  WebDriver driver = DriverFactory.getDriver();
	String Excelpath = ConfigReader.getexcelfilepath();
	String code;
	String result;


	public  String getCodefromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
		ExcelUtils excel = new ExcelUtils();
		List<Map<String, String>> testdata = excel.getData(Excelpath, sheetname);
		code = testdata.get(rownumber).get("pythonCode");
		result = testdata.get(rownumber).get("Result");
		return code;
	}
	
	public String getResultfromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
		ExcelUtils excel = new ExcelUtils();
		List<Map<String, String>> testdata = excel.getData(Excelpath, sheetname);
		result = testdata.get(rownumber).get("Result");
		LoggerLoad.info("Expected result from Excel sheetname " + sheetname + " and " + rownumber + " : " + result);
		return result;
	}
	
	public void enterCode(String code, WebElement element) {

		new Actions(driver).sendKeys(element, code).perform();
	}
	
	public void enterCodePractice(String code, WebElement element) {
		new Actions(driver).keyDown(Keys.COMMAND).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.COMMAND).perform();
		String[] str1 = code.split("\n");
		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equalsIgnoreCase("\\b")) {
				element.sendKeys(Keys.BACK_SPACE);
			} else {
				element.sendKeys(str1[i]);
				element.sendKeys(Keys.RETURN);
			}
		}
	}
		
	}
	
