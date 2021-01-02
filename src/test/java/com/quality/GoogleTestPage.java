package com.quality;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Autor: melinaBraco
 * Git: github.com/melina-braco
 * Repositorio: WebTest
 * Tema: webdriver + Loggers
 */

public class GoogleTestPage {
	
	static Logger logger = Logger.getLogger(Class.class.getName());

	private WebDriver webDriver;

	@Before
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");

		webDriver = new ChromeDriver();

		webDriver.manage().window().maximize();

		webDriver.get("http://google.com/");
		
		logger.log(Level.INFO, "Title WebDrive: " + webDriver.getTitle());		
		
	}

	@Test
	public void TestPage() {

		WebElement searchBox = webDriver.findElement(By.name("q"));

		searchBox.clear();

		searchBox.sendKeys("https://github.com/melina-braco");

		searchBox.submit();

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger.log(Level.INFO,  "Se realizo el testPage01");

		assertEquals("https://github.com/melina-braco - Buscar con Google", webDriver.getTitle());
	}
	
	@After
	public void tearDown() {

		webDriver.close();
		
		webDriver.quit();
		
		logger.log(Level.INFO,  "Close Browser");

	}
}
