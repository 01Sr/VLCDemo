package com.example.pingtaitest;

import java.util.Timer;
import java.util.TimerTask;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IndexActivity extends Activity {
	private int index = 0;
	private Timer timer;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
//			if(index>0){
				//txfenxiang();
				timer.cancel();
//			}
			Intent intent = new Intent(IndexActivity.this,
					MainActivity.class);
			startActivity(intent);
			finish();
			super.handleMessage(msg);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				index = index+1;
				handler.sendEmptyMessage(0);
			}
		},1500,1000);
	}
	
}
