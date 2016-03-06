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

public class Activityyanwu extends Activity {
	int constNum = 100;
	private Timer timer;
	private GraphicalView chart;
	private double addY = -1;
	private long addX;
	private TimeSeries series;
	private XYMultipleSeriesDataset dataset;
	private Random random = new Random();
	private TextView pm;
	private TextView yiloupm;
	private TextView hongone;
	private TextView hongtwo;
	private TextView hongthree;
	
	String a = null;
	Date[] xcache = new Date[constNum];
	int[] ycache = new int[constNum];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yanwu);
		pm = (TextView) findViewById(R.id.pm);
		yiloupm = (TextView) findViewById(R.id.yiloupm);
		hongone = (TextView) findViewById(R.id.hongone);
		hongtwo= (TextView) findViewById(R.id.hongtwo);
		hongthree = (TextView) findViewById(R.id.hongthree);
		
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
					final String b = WebServiceUtil.getMs(a, 44);
					if (b != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								pm.setText(b+"μg/m3(微克每立方米)" );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String c = WebServiceUtil.getMs(a, 239);
					if (c != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								yiloupm.setText(c+"μg/m3(微克每立方米)" );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String c = WebServiceUtil.getMs(a, 239);
					if (c != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								yiloupm.setText(c+"μg/m3(微克每立方米)" );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String e = WebServiceUtil.getMs(a, 331);
					if (e != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								hongone.setText(e);
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String f = WebServiceUtil.getMs(a, 338);
					if (f != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								hongtwo.setText(f );
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String g = WebServiceUtil.getMs(a,345);
					if (g != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								hongthree.setText(g );
								
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
		timer.schedule(task,1000, 20000);  
	}
   @Override
public void onBackPressed() {
	super.onBackPressed();
	//关闭计时器
	timer.cancel();
}
}