package com.DemoQAPage;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
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

	static Logger LOGGER;
	
	private Handler fileHandler;
		
	private WebDriver webDriver;
	
	private WebElement textBoxMenu;
	
	public Elements()
	{
		LOGGER = Logger.getLogger(Class.class.getName());
		
		String FechaActual = Fecha.getDate();
		
		try {
			
			fileHandler = new FileHandler("C:/Users/MB_E90695/Desktop/prueba" + FechaActual + ".txt");
			
		} catch (SecurityException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//TO REMOVE THE CONSOLE HANDLER
		
		LOGGER.setUseParentHandlers(false);
		
		fileHandler.setLevel(Level.ALL);
		
	    LOGGER.addHandler(fileHandler);
	}
	
	
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
		
		//FB: SE COMPLETA TEXTBOX DE MANERA CORRERTA Y SE ENVIAN LOS DATOS
		
	    textBoxMenu = webDriver.findElement(By.xpath("//span[.='Text Box']"));
		
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
		
		LOGGER.log(Level.INFO, "FB: TEXT BOX - " + webDriver.findElement(By.id("output")).getText());	
				
		assertNotNull(webDriver.findElement(By.id("name")));
	}	
}
