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
import android.widget.Toast;
import cn.ffcs.vlcdemo.R;

public class ActivityControlDevice extends Activity {

	private String devID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control_device);
		Intent intent = getIntent();
		devID = intent.getStringExtra("devID");
	}
	public void stop(View v){
	controlDevice(0);
	}
	public void top(View v){
		controlDevice(1);
	}
	public void bottpm(View v){
		controlDevice(2);
	}
	public void left(View v){
		controlDevice(3);
	}
	public void right(View v){
		controlDevice(4);
	}
	public void controlDevice(int pdz) {
		int channelNo = 0;
		final SyncHttpRequestService service = new SyncHttpRequestService();
		final String url = this.getResources().getString(R.string.ptzAction);
		String date = TimeUtil.getTime();
		String appID = this.getResources().getString(R.string.appID);
		String account = this.getResources().getString(R.string.account);
		String key = this.getResources().getString(R.string.key);
		String md5 = MD5Util.Md5(appID + account +devID+pdz+date+ key);
		final String params = "appID=" + appID + "&account=" + account +"&devID="+devID+"&channelNo="+channelNo+"&ptzDirection="+pdz+"&opTime=" + date + "&opkey=" + md5;
		// 开启线程，发送数据请求
		new Thread() {
			@Override
			public void run() {
				// 获取响应数据
				String result = service.httpGet(url, params);
				System.out.println(result.length());
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
					else if ("1".equals(responseCode)) {
						msg.what = 1;
					}
					else if ("2".equals(responseCode)) {
						msg.what = 1;
					}
					else if ("3".equals(responseCode)) {
						msg.what = 1;
					}
					else if ("4".equals(responseCode)) {
						msg.what = 1;
					}
					else if ("5".equals(responseCode)) {
						msg.what = 5;
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
			
				Toast.makeText(ActivityControlDevice.this, "操作成功！="+msg.obj.toString(), Toast.LENGTH_LONG).show();
				break;
			case 1:
				Toast.makeText(ActivityControlDevice.this, "应用ID非法", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(ActivityControlDevice.this, "用户名不存在", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(ActivityControlDevice.this, "验证码错误", Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(ActivityControlDevice.this, "设备不存在", Toast.LENGTH_SHORT).show();
				break;
			case 5:
				Toast.makeText(ActivityControlDevice.this, "设备不在线", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
}
