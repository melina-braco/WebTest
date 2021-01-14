package com.DemoQAPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {
	
	private static LocalDateTime date;
	
	public static String getDate()
	{		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		
		date = LocalDateTime.now();
		
		return formato.format(date);
		
	}
}
