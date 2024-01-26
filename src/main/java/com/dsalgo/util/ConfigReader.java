package com.dsalgo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	private final static String propertyFilePath = "./src/test/resources/config/config.properties";

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {

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
	
	public static String getApplicationUrl() {
		String url = prop.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getHomeUrl() {
		String url = prop.getProperty("homeURL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("homeURL"
					+ " not specified in the Configuration.properties file.");
	}
	
	public static String getHomePageTitle() {
		String url = prop.getProperty("homePageTitle");
		if (url != null)
			return url;
		else
			throw new RuntimeException("homeURL"
					+ " not specified in the Configuration.properties file.");
	}
	
	public static String getLoginUrl() {
		String url = prop.getProperty("LoginURL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("LoginURL"
					+ " not specified in the Configuration.properties file.");
	}
	
	public static String getRegisterUrl() {
		String url = prop.getProperty("RegisterURL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("RegisterURL"
					+ " not specified in the Configuration.properties file.");
	}
	public static String getArrayUrl() {
		String url = prop.getProperty("ArrarURL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("RegisterURL"
					+ " not specified in the Configuration.properties file.");
	}
	
	public static String getexcelfilepath() {
		String excelfilelpath = prop.getProperty("excelfilepath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}
	
	
}