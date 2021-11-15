package com.cristian.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	
	public static String getDateAndTime() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();  
		 return dtf.format(now);   
	}

}
