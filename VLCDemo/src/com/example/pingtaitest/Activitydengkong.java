package com.example.pingtaitest;


import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activitydengkong extends Activity {
	String a = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dengkong);
		Button quanl = (Button) findViewById(R.id.quanl);
		Button quanm = (Button) findViewById(R.id.quanm);
		Button qianl = (Button) findViewById(R.id.qianl);
		Button houl = (Button) findViewById(R.id.houl);
		Button zuol = (Button) findViewById(R.id.zuol);
		Button youl = (Button) findViewById(R.id.youl);
		final TextView tv1 = (TextView) findViewById(R.id.tv1);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						a = WebServiceUtil.getHd("sss", "njuptcloud");
						if(a!=null){
							final String b = WebServiceUtil.sendType(a, "light", "offall");
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
			
		
		quanl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a, "light","onall");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("灯全部亮");
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

		});//
		quanm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a,"light", "offall");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("灯全部灭");
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
		});//
		qianl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a, "light","onfront");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("前半部分灯亮");
											}
										});
										
								
								}
								else{
									runOnUiThread(new  Runnable() {
										public void run() {
											Toast.makeText(Activitydengkong.this, "网络访问出错", 0).show();
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
		});//
		houl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a, "light","onbehind");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("后半部分灯亮");
											}
										});
										
								
								}
								else{
									runOnUiThread(new  Runnable() {
										public void run() {
											Toast.makeText(Activitydengkong.this, "网络访问出错", 0).show();
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

		});//
		zuol.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a, "light","onoutside");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("外侧部分灯亮");
											}
										});
										
								
								}
								else{
									runOnUiThread(new  Runnable() {
										public void run() {
											Toast.makeText(Activitydengkong.this, "网络访问出错", 0).show();
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

		});//
		youl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							if(a!=null){
								String b = WebServiceUtil.sendType(a,"light", "oninside");
								if(b!=null){
									
										runOnUiThread(new  Runnable() {
											public void run() {
												tv1.setText("内侧部分灯亮");
											}
										});
										
								
								}
								else{
									runOnUiThread(new  Runnable() {
										public void run() {
											Toast.makeText(Activitydengkong.this, "网络访问出错", 0).show();
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
