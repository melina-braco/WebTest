package com.DemoQAPage;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author MB_E90695
 *
 */

public class Elements {

	private WebDriver webDriver;

	
	@Before
	public void setUp() throws Exception {
		
		try {
		    webDriver = DriversBrowser.HtmlUnit();
			
		} catch (Exception e) {

			System.out.println(e.getMessage());		
		}
	}

	
	@After
	public void tearDown() throws Exception {
		
		/**
		 * cerrar driver
		 * cerrar BD
		 */
	}

	@Test
	public void test() {
		
		WebElement submit = webDriver.findElement(By.id("app"));

		submit.click();
		
		assertTrue(true);
		
	}
}
