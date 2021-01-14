package com.DemoQAPage;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @author MB_E90695
 *
 */

public class Elements {

	private WebDriver webDriver;
	
	@Before
	public void setUp() throws Exception {
		
		try {
			
		    webDriver = DriversBrowser.Chrome("https://demoqa.com/elements");
			
		} catch (Exception e) {

			System.out.println(e.getMessage());		
		}
	}

	
	@After
	public void tearDown() throws Exception {
		
		webDriver.close();
	}

	@Test
	public void TextBoxTest() {
			
		WebElement textBoxMenu = webDriver.findElement(By.xpath("//span[.='Text Box']"));
		
		textBoxMenu.click();
		
		WebElement inputName = webDriver.findElement(By.id("userName"));
		
		WebElement inputEmail = webDriver.findElement(By.id("userEmail"));
		
		WebElement inputCurrentAddress = webDriver.findElement(By.id("currentAddress"));
		
		WebElement inputPermanentAddress = webDriver.findElement(By.id("permanentAddress"));				
		
		WebElement submit = webDriver.findElement(By.id("submit"));				
		
		inputName.clear();
		
		inputEmail.clear();
		
		inputCurrentAddress.clear();
		
		inputPermanentAddress.clear();
		
		inputName.sendKeys("PRUEBA");

		inputEmail.sendKeys("melina_braconaro@hotmail.com");

		inputCurrentAddress.sendKeys("PRUEBA");

		inputPermanentAddress.sendKeys("PRUEBA");		
		
		((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", submit);
		
		submit.click();
		
		assertNotNull(webDriver.findElement(By.id("name")));
	}
}
