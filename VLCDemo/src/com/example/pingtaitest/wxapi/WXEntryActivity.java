package com.example.pingtaitest.wxapi;

import cn.ffcs.vlcdemo.R;

import com.example.pingtaitest.MainActivity;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.widget.TextView;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
	
	private IWXAPI mWxApi;  //分享到微信接口
	private TextView txtresult;  //分享结果信息
	private static final String APP_ID = "wx6612bf9e0bb2601e";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wxentry);
		
		mWxApi = WXAPIFactory.createWXAPI(this, APP_ID, false);
		mWxApi.registerApp(APP_ID);
		mWxApi.handleIntent(getIntent(), this);
	}
	
	//防止这个Activity处于栈顶的时候微信回调我们
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		mWxApi.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq arg0) {
	/*	try {
			Intent intent = new Intent(Application.getInstance(), MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Application.getInstance().startActivity(intent);
		} catch (Exception e) {
		}
	}  
		GetMessageFromWX.Req req = new GetMessageFromWX.Req(); 
		switch (req.getType()) {
		case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
		
		break;
		case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
		
		break;
		default:
		break;
		}
		 */
	}

	@Override
	public void onResp(BaseResp arg0) {
		txtresult = (TextView)findViewById(R.id.txtresult);
		GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp();
		int result = 0;
		switch (resp.errCode) {
		case BaseResp.ErrCode.ERR_OK:
		result = R.string.errcode_success;
		break;
		case BaseResp.ErrCode.ERR_USER_CANCEL:
		result = R.string.errcode_cancel;
		break;
		case BaseResp.ErrCode.ERR_AUTH_DENIED:
		result = R.string.errcode_deny;
		break;
		default:
		result = R.string.errcode_unknown;
		break;
		}
		txtresult.setText(result);
	}

}
