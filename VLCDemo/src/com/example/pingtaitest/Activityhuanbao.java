package com.example.pingtaitest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activityhuanbao extends Activity {
	
	private Timer timer;
	
	private TextView qiwen;
	private TextView shidu;
	private TextView eryanghuatan;
	private TextView pm25;
	private TextView aqi;
	String a = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.huanbaowendu);
		qiwen = (TextView) findViewById(R.id.qiwen);
		shidu = (TextView) findViewById(R.id.shidu);
		eryanghuatan = (TextView) findViewById(R.id.eryanghuatan);
		aqi = (TextView) findViewById(R.id.aqi);
		pm25 = (TextView) findViewById(R.id.pm25);
		LinearLayout layout1 = (LinearLayout) findViewById(R.id.linearlayout1);
		// 生成图表
		
	
		timer = new Timer(true);
	}

	TimerTask task = new TimerTask(){  
		   
	      public void run() {  
	    	  try {// 传入用户名和密码
					a = WebServiceUtil.getHd("sss", "njuptcloud");
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				try {
					final String b = WebServiceUtil.getMs(a, 243);
					if (b != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								qiwen.setText(b + "度");
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String c = WebServiceUtil.getMs(a, 244);
					if (c != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								shidu.setText(c );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String d = WebServiceUtil.getMs(a, 245);
					if (d != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								aqi.setText(d );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	 
				try {
					final String d = WebServiceUtil.getMs(a, 249);
					if (d != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								eryanghuatan.setText(d );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	 
				try {
					final String d = WebServiceUtil.getMs(a, 246);
					if (d != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								pm25.setText(d );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	 
				
	   }
	      
	};




	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//计时器，每隔20秒更新一次	
		timer.schedule(task,0, 20000);  
	}
   @Override
public void onBackPressed() {
	super.onBackPressed();
	//关闭计时器
	timer.cancel();
}
}