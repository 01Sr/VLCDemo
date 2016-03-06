package com.example.pingtaitest;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.pingtaitest.utils.Device;
import com.example.pingtaitest.utils.JsonObjectUtil;
import com.example.pingtaitest.utils.MD5Util;
import com.example.pingtaitest.utils.SyncHttpRequestService;
import com.example.pingtaitest.utils.TimeUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import cn.ffcs.vlcdemo.R;

public class ActivityReverseDevice extends Activity {
	private String devID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reverse_device);
		Intent intent = getIntent();
		devID = intent.getStringExtra("devID");
	}
	
	public void openReverse(View v){
		getDeviceList(1);
	}
	
	public void closeReverse(View v){
		getDeviceList(0);
	}
	
	public void getDeviceList(int reverseFlag ) {
		final SyncHttpRequestService service = new SyncHttpRequestService();
		final String url = this.getResources().getString(R.string.reverseDev);
		String date = TimeUtil.getTime();
		String appID = this.getResources().getString(R.string.appID);
		String account = this.getResources().getString(R.string.account);
		String key = this.getResources().getString(R.string.key);
		String md5 = MD5Util.Md5(appID + account +devID + reverseFlag+date+ key);
		final String params = "appID=" + appID + "&account=" + account +"&devID="+devID+"&reverseFlag="+reverseFlag+ "&opTime=" + date + "&opkey=" + md5;
		// 开启线程，发送数据请求
		new Thread() {
			@Override
			public void run() {
				// 获取响应数据
				String result = service.httpGet(url, params);
				try {
					// 解析响应码
					JSONObject jsonObject = new JSONObject(result);
					String responseCode = jsonObject.getString("result");
					String resultTxt = jsonObject.getString("resultText");
					Message msg = handler.obtainMessage();
					if ("0".equals(responseCode)) {
						msg.what = 0;
						msg.obj = resultTxt;
					}
					else{
						msg.what = 1;
					}
					handler.sendMessage(msg);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
			
				Toast.makeText(ActivityReverseDevice.this, "操作成功！="+msg.obj.toString(), Toast.LENGTH_LONG).show();
				break;
			case 1:
				Toast.makeText(ActivityReverseDevice.this, "应用ID非法", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
}
