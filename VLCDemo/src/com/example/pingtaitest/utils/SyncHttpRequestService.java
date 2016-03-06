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
		//����������
		if(params!=null){
			url+=params;
		}
		System.out.println(url);
		try {
			URL path = new URL(url);
			//3.��ȡ���Ӷ���,��ʱ��û�г�ʼ��
			HttpURLConnection conn = (HttpURLConnection) path.openConnection();
			//4.��ʼ��conn
			//��������ʽ
			conn.setRequestMethod("GET");
			//���ó�ʱʱ��
			conn.setConnectTimeout(4000);
			//���ö�ȡ��ʱ
			conn.setReadTimeout(4000);
			//�������󣬽�������
			conn.connect();
			//��Ӧ��Ϊ200��������ɹ�
			if(conn.getResponseCode()==200){
				//��ȡ����������
				InputStream is = conn.getInputStream();
				System.out.println(is.toString());
					//ת��������
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
