package com.example.pingtaitest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.videolan.vlc.MediaDatabase.mediaColumn;

import android.R.integer;
import android.text.format.Time;
import android.util.Log;

public class OneDayInfoHandler {
	String info;
	double[] dataSet;
	public OneDayInfoHandler(String info) {
		super();
		this.info = info;
	}
	public double[] getOneDayInfo(){
		String info1=info.replaceAll("\\d*-\\d*-\\d* ", "");
		Log.e("+++++++++info1", info1);
				//\d*-\d*-\d* 
				//01:01:44 20.2;
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);	
		hour=hour==0?24:hour;
		dataSet=new double[hour];
		Log.e("__________", String.valueOf(hour));
		for(int i=0;i<hour;i++){
			String arg=i<10?"0"+i:""+i;
			Pattern p=Pattern.compile(arg+":\\d*:\\d* \\S*;");
			Matcher m=p.matcher(info1);
			while(m.find()){
				Log.e("+++++++++m.group(0)", m.group(0));
				String s=m.group(0).replaceAll("\\d*:\\d*:\\d* ", "");
				s=s.replace(";", "");
				Log.e("+++++++s", s);
				dataSet[i]=Double.parseDouble(s);
				break;
			}
		}
		
		return dataSet;
	}

}
