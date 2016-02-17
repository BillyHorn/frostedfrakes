package com.catalyst.springboot.selenium.modal;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URL;


public class GUIAutomation_Base {

	static Logger slf4jLogger = LoggerFactory.getLogger(GUIAutomation_Base.class);
	public static WebDriver _driver;
	protected String BROWSER;
	private String GridMode;
	private String GridURL;
	private String URL;
	static GUIAutomation_Properties _GUIproperties = new GUIAutomation_Properties();	
	
	public void initializedriver(String browsername) throws MalformedURLException, IOException{
		
		BROWSER = browsername;
		//BROWSER = _GUIproperties.getBrowser();
		//BROWSER = _testparameters.getBrowser();		
		GridMode = _GUIproperties.getpropertyvalue("GridMode");
		GridURL = _GUIproperties.getpropertyvalue("GridHubUrl");
		slf4jLogger.info("The Selenium grid mode on this script is {}", GridMode);
		slf4jLogger.info("The Selenium hub URL on this script is{} ", GridURL);
		URL HubURL = new URL(GridURL);
		
		 if (BROWSER.contentEquals("firefox")){
			 FirefoxProfile ff = new FirefoxProfile();
			 ff.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
			 ff.setPreference("browser.download.folderList",2);
			 ff.setPreference("browser.helperApps.alwaysAsk.force", false);
			 ff.setPreference("browser.download.manager.showWhenStarting",false);
			 ff.setPreference("browser.download.dir", _GUIproperties.getpropertyvalue("Outputfilepath"));
			 System.out.println(_GUIproperties.getpropertyvalue("Outputfilepath"));
			 ff.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
			 DesiredCapabilities capability = DesiredCapabilities.firefox();
			 capability.setCapability(FirefoxDriver.PROFILE, ff);
			 if (GridMode.equalsIgnoreCase("ON")){
				 capability.setCapability("platform", "Windows 2008");
				 capability.setCapability("version", "18");
				 capability.setCapability("name", "vicky");
				 capability.setCapability("passed", true);				 
				 _driver = new RemoteWebDriver(HubURL,capability);
			 }		
			 else
				 _driver = new FirefoxDriver(capability);
			 
		 }else if (BROWSER.contentEquals("internetExplorer")){
			System.setProperty("webdriver.ie.driver","C:\\Wholesale\\IEDriverServer\\IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.
	                  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
			 if (GridMode.equalsIgnoreCase("ON"))
				 _driver = new RemoteWebDriver(HubURL,capability);
			 else
				 _driver = new InternetExplorerDriver(capability);
			 
		 }else if (BROWSER.contentEquals("chrome")){
			 System.setProperty("webdriver.chrome.driver", _GUIproperties.getpropertyvalue("chromedriverpath"));
			 ChromeOptions options = new ChromeOptions();
			 DesiredCapabilities capability = DesiredCapabilities.chrome();
			 capability.setBrowserName("chrome");
			 capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);	
			 capability.setCapability(ChromeOptions.CAPABILITY, options);
			 
			 if (GridMode.equalsIgnoreCase("ON"))
				 _driver = new RemoteWebDriver(HubURL,capability);
			 else
			 	_driver = new ChromeDriver(capability);		
		 }else if (BROWSER.contentEquals("htmlunit")){
			  _driver = new HtmlUnitDriver();			 
		 }
		 URL = _GUIproperties.getURL();
		 slf4jLogger.info("The URL of the Application is{} ", URL);		 
		 _driver.get(URL);
		 _driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 _driver.manage().window().maximize();
		 slf4jLogger.info(_driver.getTitle());
	}
}
