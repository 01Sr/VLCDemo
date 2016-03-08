package com.example.pingtaitest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.xmlpull.v1.XmlPullParserException;

import android.R.integer;
import android.util.Log;

public class WebServiceUtil {
	static final String namespace = "http://cloud.nupt.com/";//鎸囧畾Web Services鐨勫懡鍚嶇┖闂�
	static final String serviceUrl = "http://202.119.234.4:8090/platformService?wsdl";//鎸囧畾Web Services鐨剈rl鍦板潃
	
  public static  String getHd(String arg0,String arg1) throws Exception{
	  	
	    String methodName = "getPermission";//鎸囧畾璋冪敤鐨勬柟娉曞悕
	 	SoapObject request = new SoapObject(namespace, methodName);//瀹炰緥鍖朣oapObject瀵硅薄
	 	request.addProperty("arg0",arg0); //璁剧疆璋冪敤鏂规硶鍙傛暟锛堟湁2涓弬鏁伴渶瑕佷紶鍏ワ級
	 	request.addProperty("arg1",arg1);
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);//浣跨敤SOAP1.1鍒涘缓Envelop瀵硅薄
	 	envelope.bodyOut = request;//灏哠oapObject瀵硅薄璁剧疆涓篠oapSerializationEnvelope瀵硅薄鐨勪紶鍑篠OAP娑堟伅浣�
	    //envelope.dotNet=true; 	//鏄惁璋冪敤doNet寮�彂鐨剋eb service
	 	(new MarshalBase64()).register(envelope);  //娉ㄥ唽Envelope
	    envelope.encodingStyle="UTF-8";//缂栫▼鏂瑰紡涓篣TF-8
	    AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	//android浼犺緭瀵硅薄
	 	ht.debug=true;
	    try {
			ht.call(namespace+methodName, envelope);//璋冪敤WebService(鍛藉悕绌洪棿+鏂规硶鍚嶇О锛孍nvelope瀵硅薄)锛�
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} 
	    SoapObject  result = (SoapObject) envelope.bodyIn;   //鑾峰緱杩斿洖鏁版嵁 
	   String m=result.getProperty(0).toString();//鎶婅繑鍥炴暟鎹被鍨嬪彉涓篠tring绫诲瀷
	   	return m;
	  
  }	
	
   public static String getMs(String arg0,int arg1)throws Exception{
	    String methodName = "getCurrentValue";
	 	SoapObject request = new SoapObject(namespace, methodName);
	 	request.addProperty("arg0",arg0); 
	 	request.addProperty("arg1",arg1);
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 	envelope.bodyOut = request;
	    //envelope.dotNet=true; 	
	 	(new MarshalBase64()).register(envelope);  
	    envelope.encodingStyle="UTF-8";
	 	AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	
	 	ht.debug=true;
	    try {
			ht.call(namespace+methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} 
	    SoapObject  result = (SoapObject) envelope.bodyIn;    
	    
	   String s=result.getProperty(0).toString();
	 	return s; 
   }
	public static  List<String> getMs(String arg0,int arg1,int arg2)throws Exception{
		if(arg1==arg2) {
			List<String> list=new ArrayList<String>();
			list.add(getMs(arg0,arg1));
			return list;
		}
		String methodName = "getLocationValues";
		SoapObject request = new SoapObject(namespace, methodName);
		request.addProperty("arg0",arg0);
		request.addProperty("arg1",arg1);
		request.addProperty("arg2",arg2);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut = request;
		//envelope.dotNet=true;
		(new MarshalBase64()).register(envelope);
		envelope.encodingStyle="UTF-8";
		AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);
		ht.debug=true;
		try {
			ht.call(namespace+methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
		SoapObject  result = (SoapObject) envelope.bodyIn;

//	   String s=result.getProperty(0).toString();
//	 //   String k=s.substring(43, 47);
//	 	return s;
		List<String> clist=new ArrayList<String>();
		List<String> list=new ArrayList<String>();
		String resultString=result.getProperty(0).toString();
		clist=Arrays.asList(resultString.split(";"));
		for(int i=0;i<clist.size();i++){
			list.add(clist.get(i).split(":")[1]);
		}
		return list;
	}

	public static String getLog(String arg0)throws Exception{
	    String methodName = "logout";
	 	SoapObject request = new SoapObject(namespace, methodName);
	 	request.addProperty("arg0",arg0); 
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 	envelope.bodyOut = request;
	    //envelope.dotNet=true; 	
	 	(new MarshalBase64()).register(envelope);  
	    envelope.encodingStyle="UTF-8";
	 	AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	
	 	ht.debug=true;
	    try {
			ht.call(namespace+methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} 
	    SoapObject  result = (SoapObject) envelope.bodyIn;    
	    
	   String k=result.getProperty(0).toString();
	 	return k; 
  }	
   public static String sendType(String arg0,String arg1,String arg2)throws Exception{
	    String methodName = "SwitchControl";
	 	SoapObject request = new SoapObject(namespace, methodName);
	 	request.addProperty("arg0",arg0); 
	 	request.addProperty("arg1",arg1);
	 	request.addProperty("arg2",arg2);
	 	
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 	envelope.bodyOut = request;
	    //envelope.dotNet=true; 	
	 	(new MarshalBase64()).register(envelope);  
	    envelope.encodingStyle="UTF-8";
	 	AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	
	 	ht.debug=true;
	    try {
			ht.call(namespace+methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} 
	    SoapObject  result = (SoapObject) envelope.bodyIn;    
	    String n2=result.getProperty(0).toString();//鎶婅繑鍥炴暟鎹被鍨嬪彉涓篠tring绫诲瀷
	   	return n2;
}	
   public static String getRtspUrl(String arg0,String arg1)throws Exception{
	    String methodName = "getRtspUrl";
		 	SoapObject request = new SoapObject(namespace, methodName);
		 	request.addProperty("arg0",arg0); 
		 	request.addProperty("arg1",arg1);
		 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		 	envelope.bodyOut = request;
		    //envelope.dotNet=true; 	
		 	(new MarshalBase64()).register(envelope);  
		    envelope.encodingStyle="UTF-8";
		    AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	
		 	ht.debug=true;
		    try {
				ht.call(namespace+methodName, envelope);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} 
		    SoapObject  result = (SoapObject) envelope.bodyIn;   
		   String rtsp=result.getProperty(0).toString();
		   	return rtsp;
	    
	   
	   
}	
 public static String getPermission(String arg0,String arg1){
	 String methodName = "SwitchControl";
	 	SoapObject request = new SoapObject(namespace, methodName);
	 	request.addProperty("arg0",arg0); 
	 	request.addProperty("arg1",arg1);	 	
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 	envelope.bodyOut = request;
	    //envelope.dotNet=true; 	
	 	(new MarshalBase64()).register(envelope);  
	    envelope.encodingStyle="UTF-8";
	 	AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	
	 	ht.debug=true;
	    try {
			ht.call(namespace+methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} 
	    SoapObject  result = (SoapObject) envelope.bodyIn;    
	    String n2=result.getProperty(0).toString();//鎶婅繑鍥炴暟鎹被鍨嬪彉涓篠tring绫诲瀷
	   	return n2;
 }
  
 /*  public static String sendMsg(String arg0,String arg1)throws Exception{
	    String methodName = "SwitchControl";
	 	SoapObject request = new SoapObject(namespace, methodName);
	 	request.addProperty("arg0",arg0); 
	 	request.addProperty("arg1",arg1);
	 	
	 	
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 	envelope.bodyOut = request;
	    //envelope.dotNet=true; 	
	 	(new MarshalBase64()).register(envelope);  
	    envelope.encodingStyle="UTF-8";
	 	AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	
	 	ht.debug=true;
	    try {
			ht.call(namespace+methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} 
	    SoapObject  result = (SoapObject) envelope.bodyIn;    
	    String n=result.getProperty(0).toString();//鎶婅繑鍥炴暟鎹被鍨嬪彉涓篠tring绫诲瀷
	   	return n;
 }	  */
   
   public static String sendData(String arg0,String arg1)throws Exception{
	    String methodName = "DataTransfer";
	 	SoapObject request = new SoapObject(namespace, methodName);
	 	request.addProperty("arg0",arg0); 
	 	request.addProperty("arg1",arg1);
	 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 	envelope.bodyOut = request;
	    //envelope.dotNet=true; 	
	 	(new MarshalBase64()).register(envelope);  
	    envelope.encodingStyle="UTF-8";
	 	AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	 	
	 	ht.debug=true;
	    try {
			ht.call(namespace+methodName, envelope);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} 
	    SoapObject  result = (SoapObject) envelope.bodyIn;    
	    String n1=result.getProperty(0).toString();//鎶婅繑鍥炴暟鎹被鍨嬪彉涓篠tring绫诲瀷
	   	return n1;
}	
   public static double[] getSensorOnedayRecord(String arg0,int arg1,String arg2){
	    String methodName = "getSensorOnedayRecord";
		 	SoapObject request = new SoapObject(namespace, methodName);
		 	request.addProperty("arg0",arg0); 
		 	request.addProperty("arg1",arg1);
		 	request.addProperty("arg2",arg2);
		 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		 	envelope.bodyOut = request;
		    //envelope.dotNet=true; 	
		 	(new MarshalBase64()).register(envelope);  
		    envelope.encodingStyle="UTF-8";
		    AndroidHttpTransport ht = new AndroidHttpTransport(serviceUrl);	
		 	ht.debug=true;
		    try {
				ht.call(namespace+methodName, envelope);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} 
		    SoapObject  result = (SoapObject) envelope.bodyIn;   
		   String data=result.getProperty(0).toString();
		   OneDayInfoHandler oneDayInfoHandler=new OneDayInfoHandler(data);
		   double[] dataSet=oneDayInfoHandler.getOneDayInfo();
//		   Log.e("*********", result.toString().substring(result.toString().length()-40, result.toString().length()-1));
		   	return dataSet;
   }
}
