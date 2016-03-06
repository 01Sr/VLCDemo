package com.example.pingtaitest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




import org.videolan.vlc.gui.video.VideoPlayerActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.ffcs.vlcdemo.R;

public class SenssorsInfo extends Activity {
	LinearLayout msgContainer;
	private ArrayList<Integer> devList;
	HashMap<Integer,Integer> dev_typeMap;
	private class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(msg.obj!=null){
			List<String> msgList= (List<String>) msg.obj;
			for(int i=0;i<msgList.size();i++){
				TextView msgText= (TextView) msgContainer.getChildAt(i).findViewById(R.id.msg);
				msgText.setText(MainActivity.generateResult(dev_typeMap.get(devList.get(i)), msgList.get(i)));
				
				//msgText.setText("已获取数据");
			}
			}
		}
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senssors_info);
		final MyHandler myHandler=new MyHandler();
		final LayoutInflater inflater= LayoutInflater.from(this);
		msgContainer = (LinearLayout) findViewById(R.id.msg_container1);
		int current_locID=getIntent().getIntExtra("LocationID", -1);
		ArrayList<Integer> locIDList=MainActivity.locIDList;
		HashMap<Integer,ArrayList<Integer>> loc_devMap=MainActivity.loc_devMap;
		dev_typeMap=MainActivity.dev_typeMap;
		HashMap<Integer, String> dev_nameMap=MainActivity.dev_nameMap;
		Log.e("*****localID", String.valueOf(current_locID));
		if(current_locID!=-1){
			if(loc_devMap.containsKey(current_locID)){
				devList=loc_devMap.get(current_locID);
				if(devList.size()!=0){
					int sub=devList.get(0)-0;
					final ArrayList<Integer> brokenList=new ArrayList<Integer>();
					brokenList.add(0);int i;
					for(i=0;i<devList.size();i++){
						int devID=devList.get(i);
						if(sub!=devID-i){
							brokenList.add(i);
							Log.e("@@@@@@@@",String.valueOf(devID));
							sub=devID-i;
						}
						//int typeID=dev_typeMap.get(devID);
						final View view = inflater.inflate(R.layout.senssor_msg, null);
						TextView type= (TextView) view.findViewById(R.id.type);
						TextView msg= (TextView) view.findViewById(R.id.msg);
						type.setText(dev_nameMap.get(devID)+":");
						msgContainer.addView(view);
					}
					brokenList.add(i);
					new Thread(new Runnable() {
						@Override
						public void run() {
							Log.e(">>>>>>>>>","获取数据");
							String a=null;
							try {
								
								a=WebServiceUtil.getHd("sss", "njuptcloud");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								
								Log.e(">>>>>>>>>","获取a异常 ："+e1.getMessage());
								e1.printStackTrace();
								
							}
							if(a!=null){
								int i=0;
								List<String> msgList=new ArrayList<String>();
								while(i<(brokenList.size()-1)){
									try {
										//Toast.makeText(VideoPlayerActivity.this,"获取数据... " , Toast.LENGTH_SHORT).show();
										msgList.addAll(WebServiceUtil.getMs(a, devList.get(brokenList.get(i)), devList.get(brokenList.get(i + 1) - 1)));
									} catch (Exception e) {
										//Toast.makeText(VideoPlayerActivity.this,"获取数据异常 " , Toast.LENGTH_SHORT).show();
										e.printStackTrace();
									}
									i++;
								}
//								List<String> resultList=new ArrayList<String>();
//								resultList.add(object)
								Message msg=new Message();
								//Toast.makeText(VideoPlayerActivity.this,msgList.get(0) , Toast.LENGTH_SHORT).show();
								msg.obj=msgList;
								myHandler.sendMessage(msg);
							}
							else{
								Log.e(">>>>>>>","未获取数据");
								Message msg=new Message();
								//Toast.makeText(VideoPlayerActivity.this,msgList.get(0) , Toast.LENGTH_SHORT).show();
								msg.obj=null;
								myHandler.sendMessage(msg);
							}
								
						}
					}).start();
//					new Thread(new Runnable() {
//						@Override
//						public void run() {
//							int i=0;
//							List<String> msgList=new ArrayList<String>();
//							while(i<(brokenList.size()-1)){
//								try {
//									msgList.addAll(WebServiceUtil.getMs(WebServiceUtil.getHd("sss", "njuptcloud"), devList.get(brokenList.get(i)), devList.get(brokenList.get(i + 1) - 1)));
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//								i++;
//							}
////							List<String> resultList=new ArrayList<String>();
////							resultList.add(object)
//							Message msg=new Message();
//							
//							msg.obj=msgList;
//							myHandler.sendMessage(msg);
//						}
//					}).start();
				}
			}
		}
    }
}
