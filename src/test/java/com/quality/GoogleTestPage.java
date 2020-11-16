package com.quality;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Autor: melinaBraco
 * Git: github.com/melina-braco
 * Repositorio: WebTest
 * Tema: webdriver
 */

public class GoogleTestPage {
	
	private WebDriver webDriver;

	@Before
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");

		webDriver = new ChromeDriver();

		webDriver.manage().window().maximize();

		webDriver.get("http://google.com/");
		
		System.out.println("Title WebDrive: " + webDriver.getTitle());
		
		System.out.println("URL: " + webDriver.getCurrentUrl());
	}

	@Test
	public void TestPage() {

		WebElement searchBox = webDriver.findElement(By.name("q"));

		searchBox.clear();

		searchBox.sendKeys("https://github.com/melina-braco");

		searchBox.submit();

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(webDriver.getTitle());


		assertEquals("https://github.com/melina-braco - Buscar con Google", webDriver.getTitle());
	}
	
	@After
	public void tearDown() {

		webDriver.quit();
		
		System.out.println("Close Browser");

	}
}
