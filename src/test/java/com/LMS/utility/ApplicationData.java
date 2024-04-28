package com.LMS.utility;

import java.util.List;
import java.util.Map;

public class ApplicationData {
	
	private Map<String, List<Map<String,String>>> applicationData;
	
	private  boolean userLoggedIn;
	

	public Map<String, List<Map<String, String>>> getApplicationData() {
		return applicationData;
	}

	public void setApplicationData(Map<String, List<Map<String, String>>> applicationData) {
		this.applicationData = applicationData;
	}

	public boolean isUserLoggedIn() {
		return userLoggedIn;
	}


	public void setUserLoggedIn(boolean userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}


	public Map<String,String> getData(String sheetName, String testCase){
		for(Map<String,String> row : applicationData.get(sheetName)) {
			if(testCase.equalsIgnoreCase(row.get("testcase"))) {
				return row;
			}
		}
		return null;
	}
	
	public Map<String,String> getData(String sheetName, int rowNumber){
		return applicationData.get(sheetName).get(rowNumber);
	}
	

}
