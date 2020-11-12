package com.quality;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Autor: melinaBraco
 * Git: github.com/melina-braco
 * Tema: Localizadores
 */

public class Guru99TestPage {

	private WebDriver driver;

	By registerLinkLocator = By.linkText("REGISTER");

	By registerPageLocator = By.xpath("//img[@src='images/banner2.gif']");

	By usernameLocator = By.id("email");

	By passwordLocator = By.name("password");

	By confirmPassworLocator = By.cssSelector("input[name='confirmPassword']");

	By registerBtnLocator = By.name("submit");
	
	By userLocator = By.name("userName");
	
	By passLocator = By.name("password");
	
	By signInBtnLocator = By.name("submit");
	

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/newtours/");

		System.out.print("INICIALIZA WEBDRIVE TEST PAGE /n");
	}

	@After
	public void tearDown() throws Exception {

		// driver.quit();

		System.out.print("CLOSE BROWSER /n");
	}

	@Test
	public void registerUser() throws InterruptedException {

		driver.findElement(registerLinkLocator).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.print("Time /n");

		// isDisplayer() verifica si un determinado elemento se encuentra presente
		
		if (driver.findElement(registerPageLocator).isDisplayed()) {
		
			driver.findElement(usernameLocator).sendKeys("qualityadmin");
	
			driver.findElement(passwordLocator).sendKeys("pass1");
	
			driver.findElement(confirmPassworLocator).sendKeys("pass1");
	
			driver.findElement(registerBtnLocator).click();
	
			System.out.print("OK ");
		}
		else
		{
			System.out.print("NO_OK ");
		}

		WebElement confirmacion = driver.findElement(By.xpath("//body[1]//tr[4]//tr[3]/td[1]"));
	
		assertTrue(confirmacion.getText().contains("Thank you for registering."));

	}
	
	@Test
	public void signIn() throws InterruptedException {
		
		By LogeoExitoso = By.xpath("//h3[.='Login Successfully']");

		
		if(driver.findElement(userLocator).isDisplayed()){
			
			driver.findElement(userLocator).sendKeys("qualityadmin");
			
			driver.findElement(passLocator).sendKeys("pass1");
			
			driver.findElement(signInBtnLocator).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			System.out.print("Time ");
			
			//si encuentra el locator "homePageLocator" es que se logeo correctamente
			
			assertTrue(driver.findElement(LogeoExitoso).isDisplayed());
		}
		
	}
}
