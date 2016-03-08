package com.example.pingtaitest;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.TextureView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class GenerateData {
	Context context;
	int id;
	String name;
	LinearLayout layout;
	String title;
	public GenerateData(Context context,LinearLayout layout, int id, String name,String title) {
		super();
		this.context = context;
		this.layout=layout;
		this.id = id;
		this.name = name;
		this.title=title;
		final MyHandle myHandle=new MyHandle();
		if(layout.getChildCount()!=0){
			layout.removeAllViews();
		}
		TextView textView=new TextView(context);
		LayoutParams layoutParams= new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		textView.setLayoutParams(layoutParams);
		textView.setText("正在加载...");
		Log.e(">>>>>>", "正在加载");
		layout.addView(textView);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Message message=new Message();
				try {
					Date date=new Date();
					Log.e("ssssssss",new SimpleDateFormat("yyyy-MM-dd").format(date));
					double[] dataSet= WebServiceUtil.getSensorOnedayRecord(WebServiceUtil.getHd("sss", "njuptcloud"),GenerateData.this.id, new SimpleDateFormat("yyyy-MM-dd").format(date));
					message.what=1;
					message.obj=dataSet;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					message.what=0;
				}
				finally{
					myHandle.sendMessage(message);
					Log.e("___________","sendMe");	
				}
			}
		}).start();
	}

	class MyHandle extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			if(msg.what==1){
				double[] dataSet=(double[]) msg.obj;
				Chart chart=new Chart(context, layout, (int)getMax(dataSet)+3, (int)getMin(dataSet)-3, 6,title ,name, dataSet);
				chart.generateChart();
				Log.e("::::::::", "已进入what");
			}
			super.handleMessage(msg);
		}
		
	}
	
	double getMax(double[] dataSet){
		double max=dataSet[0];
		for(int i=1;i<dataSet.length;i++){
			if(max<dataSet[i])max=dataSet[i];
		}
		return max;
	}
	double getMin(double[] dataSet){
		double min=dataSet[0];
		for(int i=1;i<dataSet.length;i++){
			if(min<dataSet[i])min=dataSet[i];
		}
		return min;
	}
}
