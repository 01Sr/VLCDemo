package com.example.pingtaitest;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activitymenkong extends Activity {
	String a = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menkong);

		ImageButton kai = (ImageButton) findViewById(R.id.kai);
		ImageButton guan = (ImageButton) findViewById(R.id.guan);
		final TextView tv1 = (TextView) findViewById(R.id.tv1);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					a = WebServiceUtil.getHd("sss", "njuptcloud");
					if(a!=null){
						final String b = WebServiceUtil.sendType(a, "door", "close")+WebServiceUtil.sendType(a, "curtain", "open");
						if(b!=null){
							runOnUiThread(new  Runnable() {
								public void run() {
									tv1.setText(b);
								}
							});
							
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		
		
		kai.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a, "door", "open")+
								WebServiceUtil.sendType(a, "curtain", "close");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("门打开和窗帘关闭");
											}
										});
										
								
								}
								
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		guan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a, "door", "close")+
								WebServiceUtil.sendType(a, "curtain", "open");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("门关闭窗帘打开");
											}
										});
										
								
								}
								
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
			}
			

		});
	}

}