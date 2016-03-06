package com.example.pingtaitest.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectUtil {
    
	public static List<Device> getDeviceList(JSONObject jsonObject){
		List<Device> list = null;
		Device device = null;
		try {
			JSONArray array = jsonObject.getJSONArray("info");
			list = new ArrayList<Device>();
			for(int  i = 0;i<array.length();i++){
				device = new Device();
				JSONObject newsObject = (JSONObject) array.opt(i);
				device.setDevKey(newsObject.getString("devKey"));
				device.setDevid(newsObject.getString("devid"));
				device.setOnline(newsObject.getInt("online"));
				device.setPtzFlag(newsObject.getInt("ptzFlag"));
				device.setReverseFlag(newsObject.getInt("reverseFlag"));
				device.setVideo(newsObject.getString("video"));
				list.add(device);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
