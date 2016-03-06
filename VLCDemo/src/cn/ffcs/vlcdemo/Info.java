package cn.ffcs.vlcdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.pingtaitest.*;
import com.example.pingtaitest.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Info extends Activity {
	TableLayout tl;
	HashMap<Integer,ArrayList<Integer>> loc_devMap;
	HashMap<Integer, String> dev_nameMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		tl= (TableLayout) findViewById(R.id.table);
		LayoutInflater inflater=getLayoutInflater();
		loc_devMap= MainActivity.loc_devMap;
		dev_nameMap=MainActivity.dev_nameMap;
		List<Integer> devList=loc_devMap.get(74);
		for(Integer devID:devList){
			View view=inflater.inflate(R.layout.device_table,null);
			TextView dev_id= (TextView) view.findViewById(R.id.dev_id);
			TextView name= (TextView) view.findViewById(R.id.name);
			TextView loc= (TextView) view.findViewById(R.id.loc);
			dev_id.setText(String.valueOf(devID));
			name.setText(dev_nameMap.get(devID));
			loc.setText("һ¥չ��");
			tl.addView(view);
		}
		devList=loc_devMap.get(7);
		for(Integer devID:devList){
			View view=inflater.inflate(R.layout.device_table,null);
			TextView dev_id= (TextView) view.findViewById(R.id.dev_id);
			TextView name= (TextView) view.findViewById(R.id.name);
			TextView loc= (TextView) view.findViewById(R.id.loc);
			dev_id.setText(String.valueOf(devID));
			name.setText(dev_nameMap.get(devID));
			loc.setText("��ƺ");
			tl.addView(view);
		}
		devList=loc_devMap.get(14);
		for(Integer devID:devList){
			View view=inflater.inflate(R.layout.device_table,null);
			TextView dev_id= (TextView) view.findViewById(R.id.dev_id);
			TextView name= (TextView) view.findViewById(R.id.name);
			TextView loc= (TextView) view.findViewById(R.id.loc);
			dev_id.setText(String.valueOf(devID));
			name.setText(dev_nameMap.get(devID));
			loc.setText("�Ͼ�����");
			tl.addView(view);
		}
		devList=loc_devMap.get(40);
		for(Integer devID:devList){
			View view=inflater.inflate(R.layout.device_table,null);
			TextView dev_id= (TextView) view.findViewById(R.id.dev_id);
			TextView name= (TextView) view.findViewById(R.id.name);
			TextView loc= (TextView) view.findViewById(R.id.loc);
			dev_id.setText(String.valueOf(devID));
			name.setText(dev_nameMap.get(devID));
			loc.setText("�������Ƽ�԰2¥");
			tl.addView(view);
		}
		devList=loc_devMap.get(46);
		for(Integer devID:devList){
			View view=inflater.inflate(R.layout.device_table,null);
			TextView dev_id= (TextView) view.findViewById(R.id.dev_id);
			TextView name= (TextView) view.findViewById(R.id.name);
			TextView loc= (TextView) view.findViewById(R.id.loc);
			dev_id.setText(String.valueOf(devID));
			name.setText(dev_nameMap.get(devID));
			loc.setText("�������Ƽ�԰5¥");
			tl.addView(view);
		}
		devList=loc_devMap.get(79);
		for(Integer devID:devList){
			View view=inflater.inflate(R.layout.device_table,null);
			TextView dev_id= (TextView) view.findViewById(R.id.dev_id);
			TextView name= (TextView) view.findViewById(R.id.name);
			TextView loc= (TextView) view.findViewById(R.id.loc);
			dev_id.setText(String.valueOf(devID));
			name.setText(dev_nameMap.get(devID));
			loc.setText("5¥����������");
			tl.addView(view);
		}
		devList=loc_devMap.get(75);
		for(Integer devID:devList){
			View view=inflater.inflate(R.layout.device_table,null);
			TextView dev_id= (TextView) view.findViewById(R.id.dev_id);
			TextView name= (TextView) view.findViewById(R.id.name);
			TextView loc= (TextView) view.findViewById(R.id.loc);
			dev_id.setText(String.valueOf(devID));
			name.setText(dev_nameMap.get(devID));
			loc.setText("1¥���߹���");
			tl.addView(view);
		}
	}
}
