package com.qa.tests.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {
	
	public static RemoteWebDriver getDriver(String browser) throws MalformedURLException 
	{
		return new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub"), getBrowserCapabilities(browser));
	}
	
	
	private static DesiredCapabilities getBrowserCapabilities(String browserType) 
	{
		if (browserType.equalsIgnoreCase("Firefox"))
		{
			System.out.println("Opening firefox driver");
			return DesiredCapabilities.firefox();
		}else if (browserType.equalsIgnoreCase("chrome"))
		{
		
			System.out.println("Opening chrome driver");
			return DesiredCapabilities.chrome();
		}
		else if (browserType.equalsIgnoreCase("IE"))
		{
		
			System.out.println("Opening IE driver");
			return DesiredCapabilities.internetExplorer();
		}else {
			
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			return DesiredCapabilities.firefox();
			
		}
			
			
			
	}

}
