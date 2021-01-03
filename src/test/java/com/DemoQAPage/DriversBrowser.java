package com.DemoQAPage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 * @author MB_E90695
 *
 */

public  class DriversBrowser {


	public static WebDriver Chrome()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");

		WebDriver webDriver = new ChromeDriver();

		webDriver.manage().window().maximize();

		webDriver.get("https://demoqa.com/");
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return webDriver;
	}
	
	
	public static WebDriver HtmlUnit()
	{
		WebDriver webDriver = new HtmlUnitDriver();

		webDriver.get("https://demoqa.com/");
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return webDriver;
	}
}
