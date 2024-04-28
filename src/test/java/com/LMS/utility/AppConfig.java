package com.LMS.utility;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {
	
	
	private static final String CONFIG_PATH = "/config/config.properties";
	public static Properties prop = loadProperties();
	
	
	private static Properties loadProperties() {
		Properties prop = new Properties();
		try {
			prop.load(ExcelReader.class.getResourceAsStream(CONFIG_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getProperty(String propName) {
		
	
		return prop.getProperty(propName);
	}
	

}
