package com.example.pingtaitest;

import cn.ffcs.vlcdemo.R;

import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activityweixin extends Activity {
	Button send;
	EditText et;
	String text = null;

	private static final String APP_ID = "wx6612bf9e0bb2601e";
	private IWXAPI api;

	/*
	 * private void regToWX(){ api = WXAPIFactory.createWXAPI(this, APP_ID,
	 * true); api.registerApp(APP_ID); }
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weixin);
		et = (EditText) findViewById(R.id.et);
		send = (Button) findViewById(R.id.send);

		api = WXAPIFactory.createWXAPI(this, APP_ID, false);

		send.setOnClickListener(new OnClickListenerW());
	}

	public class OnClickListenerW implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			text = et.getText().toString();

			api.registerApp(APP_ID);
			// 初始化一个WXTextObject对象
			WXTextObject textObj = new WXTextObject();
			textObj.text = text;
			// 用WXTextObject对象初始化一个WXMediaMessage对象
			WXMediaMessage msg = new WXMediaMessage();
			msg.mediaObject = textObj;
			// 发送文本类型的消息时，title字段不起作用
			msg.title = "Will be ignored";
			msg.description = "sdddd";
			// 构造一个Req
			SendMessageToWX.Req req = new SendMessageToWX.Req();
			req.transaction = String.valueOf(System.currentTimeMillis()); // transaction字段用于唯一标识一个请求
			req.message = msg;
			// req.scene = SendMessageToWX.Req.WXSceneTimeline ;
			// 调用api接口发送数据到微信
			api.sendReq(req);
			finish();

		}

	}
}
