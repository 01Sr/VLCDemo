package com.example.pingtaitest;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class Activitysensor extends Activity {
    private ImageButton kind,phone,place;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sensor);
		
		place = (ImageButton)findViewById(R.id.id_place);
		place.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activitysensor.this,Activitysensor1.class);
				startActivity(intent);
				//finish();
			}
			
		});
		
		phone = (ImageButton)findViewById(R.id.id_phone);
		phone.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent1 = new Intent(Activitysensor.this,Activitysensor2.class);
				startActivity(intent1);
				//finish();
			}
			
		});
	}
    
}
