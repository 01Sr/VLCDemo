package com.example.pingtaitest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String getTime(){
		String result = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		result = sdf.format(date);
		System.out.println(result);
		return result;
	}
}
