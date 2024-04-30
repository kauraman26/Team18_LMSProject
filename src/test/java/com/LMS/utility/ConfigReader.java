package com.LMS.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = init_prop();
	private final static String propertyFilePath = "./src/test/resources/config/config.properties";

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public static Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(propertyFilePath);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	public static String getProperty(String propName) {
		
		
		return prop.getProperty(propName);
	}
	
	public static String getApplicationUrl() {
		String url = prop.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	
	public static String getwrongApplicationUrl() {
		String url = prop.getProperty("wrongurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("wrongurl not specified in the Configuration.properties file.");
	}
	
	public static String getHomePageTitle() {
		String url = prop.getProperty("homePageTitle");
		if (url != null)
			return url;
		else
			throw new RuntimeException("homeURL"
					+ " not specified in the Configuration.properties file.");
	}
	
	public static String getDashboardHeader() {
		String url = prop.getProperty("dashboardHeader");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	
	public static String getexcelfilepath() {
		String excelfilelpath = prop.getProperty("excelfilepath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}
	
	public static String getexcelfilepath1() {
		String excelfilelpath = prop.getProperty("excelfilepath1");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}
	
	public static String getUsername() {
		String url = prop.getProperty("username");
		if (url != null)
			return url;
		else
			throw new RuntimeException("username"
					+ " not specified in the Configuration.properties file.");
	}
	
	public static String getPassword() {
		String url = prop.getProperty("password");
		if (url != null)
			return url;
		else
			throw new RuntimeException("password"
					+ " not specified in the Configuration.properties file.");
	}	
}
