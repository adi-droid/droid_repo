package com.app.weatherapp.utility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utility {

	//Converting milliseconds to date
	public static String getDateFromMillis(long milliSeconds) {

		SimpleDateFormat  formatter = new SimpleDateFormat("dd MMM yyyy",Locale.getDefault());
	
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		
		return formatter.format(new Date(milliSeconds*1000));
	}

	
}
