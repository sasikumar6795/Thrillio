package com.sasi.dateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeDemo {

	
	public static void testLegacyDateApi()
	{
		System.out.println("\nDate class .......");
		
		Date currentDate = new Date();
		
		System.out.println("currentDate: " + currentDate);
		
		System.out.println("CurrentDate in ms: " + currentDate.getTime());
		
		System.out.println("\nCalendar class ......");
		
		Calendar expiryDate = new GregorianCalendar(2020, 05, 30);
		System.out.println("expiryDate: " + expiryDate);
		System.out.println("expirtyDate in ms: " + expiryDate.getTime());
		expiryDate.add(Calendar.MONTH, 9);
		
		System.out.println("newExpiryDate: " + expiryDate.getTime());
		
		expiryDate.roll(Calendar.MONTH, 11);
		
		System.out.println("newExpiryDate(roll): " + expiryDate.getTime());
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		testLegacyDateApi();

	}

}
