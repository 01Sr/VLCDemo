package com.example.pingtaitest.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.ffcs.vlcdemo.R;

public class MyDeviceListViewAdapter extends BaseAdapter{

	private List<Device> mList = new ArrayList<Device>();
	private Context context;
	public MyDeviceListViewAdapter(Context context) {
		super();
		this.context = context;
	}
	public void setLists(List<Device> lists) {
		this.mList = lists;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder;
		if(convertView == null)
		{
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item_devicelist, null);
			viewHolder.online = (TextView) convertView.findViewById(R.id.tv_item_devicelist_online);
			viewHolder.ptzflag = (TextView) convertView.findViewById(R.id.tv_item_devicelist_ptzFlag);
			viewHolder.reverseFlag = (TextView) convertView.findViewById(R.id.tv_item_devicelist_reverseFlag);
			viewHolder.devid = (TextView) convertView.findViewById(R.id.tv_item_devicelist_devid);
			viewHolder.devkey = (TextView) convertView.findViewById(R.id.tv_item_devicelist_devkey);
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		mList.get(position).getOnline();
		if("1".equals(mList.get(position).getOnline()+"")){
			viewHolder.online.setText("在线状态:"+("在线"));
		}
		else{
			viewHolder.online.setText("在线状态:"+("不在线"));
		}
		if("1".equals(mList.get(position).getPtzFlag()+"")){
			viewHolder.ptzflag.setText("PTZ控制能力:"+"有");
		}
		else{
			viewHolder.ptzflag.setText("PTZ控制能力:"+"无");
		}
		
		if("1".equals(mList.get(position).getReverseFlag()+"")){
			viewHolder.reverseFlag.setText("反转倒置能力:"+"有");
		}
		else{
			viewHolder.reverseFlag.setText("反转倒置能力:"+"无");
		}
		viewHolder.devid.setText("devid:"+mList.get(position).getDevid()+"");
		viewHolder.devkey.setText("devkey:"+mList.get(position).getDevKey()+"");
		return convertView;
	}

	class ViewHolder
	{
		public TextView online;
		public TextView ptzflag;
		public TextView reverseFlag;
		public TextView devid;
		public TextView devkey;
	}
	
}
