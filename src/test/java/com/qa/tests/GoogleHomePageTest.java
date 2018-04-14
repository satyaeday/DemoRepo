package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHomePageTest {
	
	WebDriver driver;
	String appURL = "http://google.com";
	
	
	@BeforeMethod
	  public void beforeMethod() {
		  
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\satya\\workspace\\testSelenium\\drivers\\geckodriver.exe");
		  
		  driver = new FirefoxDriver();
		  
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
			
			@AfterClass
			public void tearDown() {
				driver.quit();
			}
	
	
	  

}
