package com.DemoQAPage;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.logging.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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

	private static Logger LOGGER;
	
	private static Handler fileHandler;
		
	private WebDriver webDriver;
	
	private WebElement textBoxMenu;
	
	private WebElement checkBoxMenu;
	
	private WebElement radioButtonMenu;

	
	@BeforeClass
	public static void SetLogger()
	{
		LOGGER = Logger.getLogger(Class.class.getName());
		
		String FechaActual = Fecha.getDate();
		
		try {
			
			fileHandler = new FileHandler("C:/Users/MB_E90695/Desktop/Logs/Logs" + FechaActual + ".txt");
			
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
/*
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
									
		assertNotNull(webDriver.findElement(By.id("name")));
		
		LOGGER.log(Level.INFO, "FB: TEXT BOX TEST  \n" + webDriver.findElement(By.id("output")).getText());
	
	}	
	
	
	@Test
	public void CheckBoxTest() {
		
		//FB: SE SELECCIONAN LOS CB CORRESPONDIENTES		
		
		checkBoxMenu = webDriver.findElement(By.xpath("//span[.='Check Box']"));

		checkBoxMenu.click();
		
		WebElement checkBox = webDriver.findElement(By.cssSelector(".rct-icon-uncheck"));
		    
		checkBox.click();
				
		assertNotNull(webDriver.findElement(By.id("result")));
		
		LOGGER.log(Level.INFO, "FB: CHECK BOX TEST  \n" + webDriver.findElement(By.id("result")).getText());

	}	*/
	
	@Test
	public void RadioButtonTest() {
		
		//FB: SE SELECCIONA RADIO BUTTON = Yes		
		
		radioButtonMenu = webDriver.findElement(By.xpath("//span[.='Radio Button']"));

		radioButtonMenu.click();
		
		WebElement radioButton = webDriver.findElement(By.cssSelector("[for='yesRadio']"));
		    			
		radioButton.click();					
		
		WebElement resultado = webDriver.findElement(By.cssSelector(".text-success"));
		
		assertNotNull(resultado);
		
		//LOGGER.info(resultadoTest == true ? "PASS" : "FAIL");					    

		
 	}	
}
