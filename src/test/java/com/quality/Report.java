package com.quality;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Report {

	public static Test suite() {
        TestSuite suite = new TestSuite("Conjunto de pruebas de ejemplo");

       // suite.addTest(BasicCalculatorPage.class);
        
        return suite;
    }
	
}
