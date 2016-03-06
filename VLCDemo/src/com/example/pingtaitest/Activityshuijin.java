package com.example.pingtaitest;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Activityshuijin extends Activity {
	String a = null;
    String b = null;
    String c =null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shuijin);
		try {//�����û��������
			 a = WebServiceUtil.getHd("sss","njuptcloud");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {//�����û��������
			 b = WebServiceUtil.getMs(a,11);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TextView textview = (TextView)findViewById(R.id.textView1);
		if(b== "ee"){
			textview.setText("机房有水入侵");
		}else if(b=="dd"){
			textview.setText("机房已恢复正常");
		}else{
			textview.setText("机房环境正常，"
					        + "无水入侵");  
		
		}
		try {//传入用户名和密码
			 c = WebServiceUtil.getMs(a,10);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TextView textview2 = (TextView)findViewById(R.id.textView2);
		if(c== "FF"){
			textview.setText("机房有烟雾");
		}else if(c=="aa"){
			textview.setText("机房已恢复正常");
		}else{
			textview.setText("机房环境正常，"
				           	+ "无烟雾");
		}
	}

/*	String getMs(String deviceID) throws Exception
	{
 	String serviceUrl = "http://10.10.22.220:10222/AndroidService";
		String methodName = "getCurrentValue";
	 	SoapObject request = new SoapObject("http://nupt.cloud.android.com/", methodName);
	 	request.addProperty("deviceID", deviceID); 
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 	envelope.bodyOut = request;
	    envelope.dotNet=true; 	   
 	    envelope.encodingStyle="UTF-8";
	 	AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	
	    ht.call(null, envelope); 
	    Object  result = (Object) envelope.bodyIn;    	   
	    String s=result.toString();
	    String k=s.substring(43, 48);
	 	return k; 
	}     */
}