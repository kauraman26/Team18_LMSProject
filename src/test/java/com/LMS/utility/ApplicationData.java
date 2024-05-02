package com.LMS.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplicationData {
	
	private Map<String, List<Map<String,String>>> applicationData;
	private String programName;
	
	private String batchName;
	
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

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
	
	
	
	

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
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
