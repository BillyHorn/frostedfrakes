package com.catalyst.springboot.selenium;

public class SeleniumSettings {
	
	public static String FIREFOX = "firefox";
	public static String CHROME = "chrome";
	public static String IE = "ie";

	private static String _browser = CHROME;
	
	private static int _defaultTimeout = 5;
	private static String _logDirectory = "C:\\Users\\"+System.getProperty("user.name")+"\\Selenium\\Logs\\";
	private static String _seleniumLog = "SeleniumLog";
	private static String _actionLog = "Actions";
	private static boolean _logAllActions = true;
	
	private static String _chromeDriver = "src/main/java/org/catalystitservices/PageObjectFramework/Drivers/chromedriver.exe";
	private static String _ieDriver = "src/main/java/org/catalystitservices/PageObjectFramework/Drivers/IEDriverServer.exe";

    public static String getActionLogName()
    {
    	return _actionLog;
    }
	
    public static String getBrowser()
    {
    	return _browser;
    }
    
    public static int getDefaultTimeout()
    {
    	return _defaultTimeout;
    }

    public static String getDriver(String browser)
    {
    	if (browser == CHROME)
    	{
    		return _chromeDriver;
    	}
    	else if (browser == IE)
    	{
    		return _ieDriver;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    public static String getLogDirectory()
    {
    	return _logDirectory;
    }
    
    public static String getSeleniumLogName()
    {
    	return _seleniumLog;
    }
    
    public static boolean logAllActions()
    {
    	return _logAllActions;
    }
}
