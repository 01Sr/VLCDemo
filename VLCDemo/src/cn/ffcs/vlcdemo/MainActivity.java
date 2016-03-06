package cn.ffcs.vlcdemo;

import java.util.List;
import java.util.jar.Pack200.Unpacker;

import org.json.JSONException;
import org.json.JSONObject;
import org.videolan.vlc.VLCApplication;
import org.videolan.vlc.gui.video.VideoPlayerActivity;

import com.example.pingtaitest.ActivityShowDevice;
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
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
	private String devID;
	private String devKey;
	private String rtsp;
	private int cameraid;//(要传给Video)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		Intent intent=getIntent();
		rtsp=intent.getStringExtra("rtsp");
		cameraid=intent.getIntExtra("devid", -1);
		//	rtsp="rtsp://112.25.191.156:51238/realplay?devid=90100003207&channelno=0&streamtype=2&hashtoken=91a74c59cd92bec65caa330db0ba2a91";
//		local_edt = (EditText) findViewById(R.id.local);
//		upnp_edt = (EditText) findViewById(R.id.upnp);
//		turn_edt = (EditText) findViewById(R.id.turn);
//		ip_edt = (EditText) findViewById(R.id.ip);
//		port_edt = (EditText) findViewById(R.id.port);
//		play_btn = (Button) findViewById(R.id.play);
//
//		local_edt.setText(rtsp);
//		upnp_edt.setText(rtsp);
//		turn_edt.setText(rtsp);
//		ip_edt.setText("117.27.144.28");
//		port_edt.setText("52124");
		playVideo();

	}
	public void playVideo(){
//		Constant.localPlayUrl = local_edt.getText().toString();
//		Constant.upnpPlayUrl = upnp_edt.getText().toString();
//		Constant.turnPlayUrl = turn_edt.getText().toString();
//		Constant.stunIP = ip_edt.getText().toString();
//		Constant.stunPort = port_edt.getText().toString();
		VideoPlayerActivity.start(VLCApplication.getAppContext(), rtsp, rtsp, 0, false, true,false);
		
	}

	public void getDeviceUrl() {
		final SyncHttpRequestService service = new SyncHttpRequestService();
		final String url = this.getResources().getString(R.string.getDevUrl);
		String date = TimeUtil.getTime();
		String appID = this.getResources().getString(R.string.appID);
		String account = this.getResources().getString(R.string.account);
		String key = this.getResources().getString(R.string.key);
		String md5 = MD5Util.Md5(appID + account +devID + date+ key);
		final String params = "appID=" + appID + "&account=" + account +"&devID="+devID+"&devKey="+devKey+ "&opTime=" + date + "&opkey=" + md5;
		// 开启线程，发送数据请求
	}
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				Toast.makeText(MainActivity.this, "注销成功", Toast.LENGTH_SHORT).show();
				playVideo();
				break;
			case 1:
				Toast.makeText(MainActivity.this, "应用ID非法", Toast.LENGTH_SHORT).show();
				break;

			case 2:
				Toast.makeText(MainActivity.this, "用户名不存在！", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(MainActivity.this, "验证码错误！", Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(MainActivity.this, "设备不存在！", Toast.LENGTH_SHORT).show();
				break;
			}
		};
	};
}
