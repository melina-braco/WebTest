package com.DemoQAPage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author MB_E90695
 *
 */

public  class DriversBrowser {


	public static WebDriver Chrome(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions(); 
		
	    options.setHeadless(true);
		
		WebDriver webDriver = new ChromeDriver(options);

		webDriver.manage().window().maximize();

		webDriver.get(url);
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return webDriver;
	}
	
	
	public static WebDriver HtmlUnit(String url)
	{	
		ChromeOptions options = new ChromeOptions(); 
				
		
		WebDriver webDriver = new HtmlUnitDriver(options);
		
		webDriver.get(url);
		
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return webDriver;
	}
}
