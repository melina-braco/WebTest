package com.quality;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class BasicCalculatorPage {

	private WebDriver webDriver;
		
	private WebElement ValorA; 
	
	private WebElement ValorB; 
	
	private WebElement submit; 

	private WebElement Resultado;
	
	private WebElement TipoOperacion;
	
	private Select ComboTipoOperacion;

	@Before
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");

		webDriver = new ChromeDriver();

		webDriver.manage().window().maximize();

		webDriver.get("https://testsheepnz.github.io/BasicCalculator.html");
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		ValorA = webDriver.findElement(By.id("number1Field"));
		
		ValorB = webDriver.findElement(By.id("number2Field"));
		
		submit = webDriver.findElement(By.id("calculateButton"));

	    Resultado = webDriver.findElement(By.id("numberAnswerField"));
	    
	    TipoOperacion = webDriver.findElement(By.id("selectOperationDropdown"));
	    
        ComboTipoOperacion = new Select(TipoOperacion);
		
		System.out.println("Title WebDrive: " + webDriver.getTitle());
		
		System.out.println("URL: " + webDriver.getCurrentUrl());
	}
	
	@After
	public void tearDown() {

		webDriver.quit();
		
		System.out.println("Close Browser");

	}

	@Test
	public void Add() {

		ValorA.clear();
		
		ValorB.clear();
		
		ValorA.sendKeys("4");
		
		ValorB.sendKeys("2");
		
		ComboTipoOperacion.selectByVisibleText("Add");
		
		submit.click();
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		assertEquals("6", Resultado.getAttribute("value"));
		
	}	
	
	@Test
	public void Subtract() {

		ValorA.clear();
		
		ValorB.clear();
		
		ValorA.sendKeys("4");
		
		ValorB.sendKeys("2");
		
		ComboTipoOperacion.selectByVisibleText("Subtract");
		
		submit.click();
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		assertEquals("2", Resultado.getAttribute("value"));
		
	}	
	
	@Test
	public void Multiply() {

		ValorA.clear();
		
		ValorB.clear();
		
		ValorA.sendKeys("4");
		
		ValorB.sendKeys("2");
		
		ComboTipoOperacion.selectByVisibleText("Multiply");
		
		submit.click();
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		assertEquals("8", Resultado.getAttribute("value"));
		
	}	

	@Test
	public void Divide() {

		ValorA.clear();
		
		ValorB.clear();
		
		ValorA.sendKeys("10");
		
		ValorB.sendKeys("2");
		
		ComboTipoOperacion.selectByVisibleText("Divide");
		
		submit.click();
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		assertEquals("5", Resultado.getAttribute("value"));
		
	}	
}
