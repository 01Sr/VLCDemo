package com.example.pingtaitest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class SyncHttpRequestService {

	public String httpGet(String url, String params) {
		String result = null;
		//添加请求参数
		if(params!=null){
			url+=params;
		}
		System.out.println(url);
		try {
			URL path = new URL(url);
			//3.获取连接对象,此时还没有初始化
			HttpURLConnection conn = (HttpURLConnection) path.openConnection();
			//4.初始化conn
			//设置请求方式
			conn.setRequestMethod("GET");
			//设置超时时间
			conn.setConnectTimeout(4000);
			//设置读取超时
			conn.setReadTimeout(4000);
			//发送请求，建立连接
			conn.connect();
			//响应码为200代表请求成功
			if(conn.getResponseCode()==200){
				//获取请求数据流
				InputStream is = conn.getInputStream();
				System.out.println(is.toString());
					//转换数据流
					result = StrUtils.getFromStream(is);
					System.out.println(result+"111111");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
