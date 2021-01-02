/**
 * 
 */
package com.DemoQAPage;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.DemoQAPage.DriversBrowser;

/**
 * @author MB_E90695
 *
 */

public class Elements {

	private  WebDriver webDriver;
	
	public Elements()
	{
		webDriver = DriversBrowser.Chrome();
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		
		fail("Not yet implemented");
		
	}
}
