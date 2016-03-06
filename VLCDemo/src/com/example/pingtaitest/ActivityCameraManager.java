package com.example.pingtaitest;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.pingtaitest.utils.MD5Util;
import com.example.pingtaitest.utils.SyncHttpRequestService;
import com.example.pingtaitest.utils.TimeUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import cn.ffcs.vlcdemo.MainActivity;
import cn.ffcs.vlcdemo.R;

public class ActivityCameraManager extends Activity implements OnClickListener {

	Button btn_getdevlist;
	Button btn_to_videoplay;
	Button btn_to_reversedevice;
	Button btn_to_restartdevice;
	Button btn_to_controldevice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera_manager_activity);
		initView();
	}

	public void initView() {
		btn_getdevlist = (Button) findViewById(R.id.btn_get_device_list);
		btn_getdevlist.setOnClickListener(this);

		btn_to_videoplay = (Button) findViewById(R.id.btn_to_video_play);
		btn_to_videoplay.setOnClickListener(this);

		btn_to_reversedevice = (Button) findViewById(R.id.btn_to_reverse_device);
		btn_to_reversedevice.setOnClickListener(this);

		btn_to_restartdevice = (Button) findViewById(R.id.btn_to_restart_device);
		btn_to_restartdevice.setOnClickListener(this);

		btn_to_controldevice = (Button) findViewById(R.id.btn_to_control_device);
		btn_to_controldevice.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add_device:
			Intent intent = new Intent(ActivityCameraManager.this, ActivityAddDevice.class);
			startActivity(intent);
			break;

		case R.id.btn_get_device_list:
			Intent intent2 = new Intent(ActivityCameraManager.this, ActivityShowDevice.class);
			startActivity(intent2);
			break;
		case R.id.btn_to_video_play:
			Intent intent3 = new Intent(ActivityCameraManager.this, MainActivity.class);
			startActivity(intent3);
			break;

		case R.id.btn_to_reverse_device:
			Intent intent4 = new Intent(ActivityCameraManager.this, ActivityReverseDevice.class);
			startActivity(intent4);
			break;

		case R.id.btn_to_restart_device:

			break;

		case R.id.btn_to_control_device:
			Intent intent5 = new Intent(ActivityCameraManager.this, ActivityControlDevice.class);
			startActivity(intent5);
			break;
       
		default:
			break;
		}
	}

}
