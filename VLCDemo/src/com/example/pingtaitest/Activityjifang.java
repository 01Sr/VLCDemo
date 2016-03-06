package com.example.pingtaitest;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Activityjifang extends Activity {
	RelativeLayout wendu;
    RelativeLayout shidu;
    RelativeLayout dian;
    RelativeLayout shuijin;
    RelativeLayout PM;
    RelativeLayout dengkong;
    RelativeLayout menkong;
    Button button1;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.jifang);
		wendu = (RelativeLayout)findViewById(R.id.wendu);
		shidu = (RelativeLayout)findViewById(R.id.shidu);
		dian = (RelativeLayout)findViewById(R.id.dian);
		shuijin = (RelativeLayout)findViewById(R.id.shuijin);
		PM = (RelativeLayout)findViewById(R.id.PM);
		dengkong = (RelativeLayout)findViewById(R.id.dengkong);
		menkong = (RelativeLayout)findViewById(R.id.menkong);
		
		wendu.setOnClickListener(new OnClickListenerwen());
		shidu.setOnClickListener(new OnClickListenershi());
		dian.setOnClickListener(new OnClickListenerdian());
		shuijin.setOnClickListener(new OnClickListenershui());
		PM.setOnClickListener(new OnClickListeneryan());
		dengkong.setOnClickListener(new OnClickListenerdeng());
		menkong.setOnClickListener(new OnClickListenermen());
		
		button1 = (Button)findViewById(R.id.button1);
	//	button1.setOnClickListener(new OnClickListenerW());
		
		
	
	/*	wendu.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activityjifang.this,Activitywendu.class);
				startActivity(intent);
				finish();
			}
			
		});
		shidu.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activityjifang.this,Activityshidu.class);
				startActivity(intent);
				finish();
			}
			
		});
		dian.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activityjifang.this,Activitydian.class);
				startActivity(intent);
				finish();
			}
			
		});
		shuijin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activityjifang.this,Activityshuijin.class);
				startActivity(intent);
				finish();
			}
			
		});
		yanwu.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activityjifang.this,Activityyanwu.class);
				startActivity(intent);
				finish();
			}
			
		});
		dengkong.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Activityjifang.this,Activitydengkong.class);
				startActivity(intent);
				finish();
			}
			
		});  */
	}
	private class OnClickListenerwen implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activitywendu.class);
			startActivity(intent);
			//finish();
			
		}
	}
	private class OnClickListenershi implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activityshidu.class);
			startActivity(intent);
			//finish();
		}
		
	}
	private class OnClickListenerdian implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activitydian.class);
			startActivity(intent);
			//finish();
		}
		
	}
	private class OnClickListenershui implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activityshuijin.class);
			startActivity(intent);
			//finish();
		}
		
	}
	private class OnClickListeneryan implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activityyanwu.class);
			startActivity(intent);
			//finish();
		}
		
	}
	private class OnClickListenerdeng implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activitydengkong.class);
			startActivity(intent);
			//finish();
		}
		
	}
	private class OnClickListenermen implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activitymenkong.class);
			startActivity(intent);
			//finish();
		}
	}
/*	private class OnClickListenerW implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Activityjifang.this,Activityweixin.class);
			startActivity(intent);
			//finish();
		}
	}
	*/
}
