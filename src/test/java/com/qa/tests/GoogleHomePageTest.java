package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleHomePageTest {
	
	WebDriver driver;
	String appURL = "http://google.com";
	
	
	@BeforeMethod
	@Parameters({ "browser" })
	  public void openBrowser(String browser) {
		
		    
		if (browser.equalsIgnoreCase("Firefox"))
		  {
		  
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\satya\\Desktop\\resumes_2\\drivers\\geckodriver.exe");
		  
		  driver = new FirefoxDriver();
		  
		  }else if (browser.equalsIgnoreCase("chrome")) 
		     {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\satya\\Desktop\\resumes_2\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\satya\\Desktop\\resumes_2\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		  
		  
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.manage().deleteAllCookies();
		  
		  driver.manage().window().maximize();
		  
		 
	}
	
			@Test
			public void verifyGooglePageTittle() {
				driver.navigate().to(appURL);
				String getTitle = driver.getTitle();
				Assert.assertEquals(getTitle, "Google");
			}
			
			
			
			
			
			
			
			
			@AfterMethod
			public void closeBrowser() {
				driver.quit();
			}
	
	
	  

}
