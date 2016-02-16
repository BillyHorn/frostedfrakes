package com.catalyst.springboot.selenium.modal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GUIAutomation_Properties {
	//loading the configuration file
	static Logger slf4jLogger = LoggerFactory.getLogger(GUIAutomation_Properties.class);
	static Properties _properties = new Properties();
	public  final static String PROPERTY_FILENAME = "C:\\Wholesale\\Workspace\\AssetsGradle\\src\\test\\resources\\nike\\Wholesale\\Config.Properties";
	public static String URL = null;
	public static String BROWSER = null;
	public static String NoofThreads = null;
	
	/**
	 * Loads the properties file
	 */
	public GUIAutomation_Properties(){
		try {
			FileInputStream propfile = new FileInputStream(PROPERTY_FILENAME);
			try {
				_properties.load(propfile);				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assert !_properties.isEmpty();
	}
	
	/**
	 * returns the value of the property denoted by PropertyKey
	 * @param PropertyKey
	 * @return
	 */
	public String getpropertyvalue(final String PropertyKey){
		String propertyvalue = _properties.getProperty(PropertyKey);
		if (propertyvalue != null){
			propertyvalue.trim();
		}
		else{
			System.out.println("The property "+PropertyKey+"value is not present");
		}
		return propertyvalue;
		}

	/**
	 * build up the URL using the property key
	 */
	public String getURL(){
		if (URL == null){
			try{
				URL = _properties.getProperty("URL");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			assert URL.contains("http");
		}
		return URL;		
	}
	
	/**
	 * Build the Browser name from the Properties file
	 */
	public String getBrowser(){
		if (BROWSER == null){
			try{
				BROWSER = _properties.getProperty("Browsername");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return BROWSER;		
	}	
	
	/**
	 * Build the Browser name from the Properties file
	 */
	public String getNumberofThreads(){
		if (NoofThreads == null){
			try{
				NoofThreads = _properties.getProperty("NumberOfThreads");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return NoofThreads;		
	}
}

