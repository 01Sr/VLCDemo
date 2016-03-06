package com.example.pingtaitest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import cn.ffcs.vlcdemo.About;
import cn.ffcs.vlcdemo.Info;
import cn.ffcs.vlcdemo.R;

import com.example.pingtaitest.Activityhome;
import com.example.pingtaitest.Activityhuanbao;
import com.example.pingtaitest.Activityjifang;
import com.example.pingtaitest.Activitysensor;
import com.example.pingtaitest.MainActivity;
import com.example.pingtaitest.MainActivity.ItemClickListener;

import android.R.integer;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class MainActivity extends Activity {

	private String texts[] = null;
    private int images[] = null;
    Button sensor;
    Button info;
    Button about;
    private static boolean isFirst=true;
    public static ArrayList<Integer> locIDList;
    public static HashMap<Integer,ArrayList<Integer>> loc_devMap;
    public static HashMap<Integer,Integer> dev_typeMap;
    public static HashMap<Integer, String> dev_nameMap;
    private static int Dian=1;
    public static String generateResult(int TypeID,String arg){
        switch (TypeID) {
            case 1:
                return arg+"℃" ;
            case 2:
                return arg+"RH";
            case 3:
                return arg+"μg/m3(微克每立方米)";
            case 4:
            	if(arg== "ee")
        			return "机房有水入侵";
        		else if(arg=="dd")
        			 return "机房已恢复正常";
        		else
        			 return "机房环境正常，"+ "无水入侵";
            case 5:
                return "门磁";
            case 6:
                 if(Dian==1||Dian==2||Dian==3){
                	 Dian++;
                	 return arg+"V"; 
                 }
                 if(Dian==4||Dian==5){
                	 Dian++;
                	 return arg+"A";
                 }
                 if(Dian==6){
                	 Dian=1;
                	 return arg+"A";
                 }
            case 7:
                return arg+"Kpa";
            case 8: return arg+"ppm";
            case 9:
            	int angle=Math.round(Integer.parseInt(arg));
            	if(angle>=337.5&&angle<360||angle>=0&&angle<22.5)
            		return "南风";
            	if(angle>=22.5&&angle<67.5)
            		return "西南风";
            	if(angle>=67.5&&angle<112.5)
            		return "西风";
            	if(angle>=112.5&&angle<157.5)
            		return "西北风";
            	if(angle>=157.5&&angle<202.5)
            		return "北风";
            	if(angle>=202.5&&angle<247.5)
            		return "东北风";
            	if(angle>=247.5&&angle<292.5)
            		return "东风";
            	if(angle>=292.5&&angle<337.5)
            		return "东南风";
            case 10:
                return arg+"km/h";
            case 11:
                return 	arg+"Kpa";
            case 12:
                return 	arg+"mm";
            case 13:return 	arg+"μg/m3(微克每立方米)";
            case 14:return 	arg+"km";
            case 15:return 	arg+"lx";
            case 16:return 	"红外：";
            case 17:if(Integer.parseInt(arg)==0)
            	return "窗帘关闭";
            else 
				return "窗帘打开";
            case 18:return 	"火焰：";
            case 19	:return arg+"cm";
            case 20	:return arg+""	;
            case 21:return 	"采矿：";
            case 22:
            	int a=Integer.parseInt(arg);
            	if(a>=0&&a<=50)
            		return "优";
            	if(a>50&&a<=100)
            		return "良";
            	if(a>100&&a<=150)
            		return "轻度污染";
            	if(a>150&&a<=200)
            		return "中度污染";
           		if(a>200&&a<=300)
           			return "重度污染";
   				if(a>300)
   					return "严重污染";
            		
            case 23	:return arg+"μg/m3(微克每立方米)";
            case 24:return 	arg+"ppm";
            case 25	:return arg+"ppm";
            case 26	:return arg+"ppm";
            case 27:return 	arg+"ppm";
            case 28	:return "灯";
            case 29	:return arg+"bpm";
            case 30	:return arg+"℃";
            case 31:return 	"插座："	;
            case 32:return 	"蓝牙基站："	;
            case 33	:return "加热棒："	;
            case 34:return 	"空调：";
            case 35	:if(Integer.parseInt(arg)==0)
            	return "无车";
            else
            	return "有车";
            case 36:return 	"摄像头："	;
            default:
                return null;
        }
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        if(isFirst){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream is= null;
                    try {
                        is = getAssets().open("LocationID.txt");
                        BufferedReader br=new BufferedReader(new InputStreamReader(is));
                        String line=null;
                        locIDList=new ArrayList<Integer>();
                        while((line=br.readLine())!=null){
                            locIDList.add(Integer.parseInt(line));
                        }
                        br.close();
                        is.close();
                        loc_devMap=new HashMap<Integer, ArrayList<Integer>>();
                        dev_typeMap=new HashMap<Integer, Integer>();
                        dev_nameMap=new HashMap<Integer, String>();
                        for(int i=0;i<locIDList.size();i++){
                            loc_devMap.put(locIDList.get(i),new ArrayList<Integer>());
                        }
                        is=getAssets().open("IDMap.txt");
                        br=new BufferedReader(new InputStreamReader(is));
                        String list[];
                        while((line=br.readLine())!=null){
                            list=line.split("\\t");
                            loc_devMap.get(Integer.parseInt(list[3])).add(Integer.parseInt(list[0]));
                            dev_typeMap.put(Integer.parseInt(list[0]),Integer.parseInt(list[2]));
                            dev_nameMap.put(Integer.parseInt(list[0]), list[1]);
                        }
                        br.close();
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            isFirst=false;
        }
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		sensor = (Button)findViewById(R.id.sensor);
		about=(Button) findViewById(R.id.about);
		about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,About.class));
			}
		});
		info=(Button) findViewById(R.id.info);
		info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,Info.class));
			}
		});
		sensor.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,Activitysensor.class);
				startActivity(intent);
			}
		});
		images=new int[]{R.drawable.pn_agriculture, R.drawable.pn_control,
                R.drawable.pn_health, R.drawable.pn_home, 
                R.drawable.pn_huanbao,R.drawable.pn_jifang};
		 texts = new String[]{ "智慧农业", "视频传输",
	                "医疗健康", "智能家居", 
	                "环保信息", "机房监控"};

        GridView gridview = (GridView)findViewById(R.id.my_grid);
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 6; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", images[i]);
            map.put("itemText", texts[i]);
            lstImageItem.add(map);
        }
        SimpleAdapter saImageItems = new SimpleAdapter(this, 
                lstImageItem,// 鏁版嵁婧�
                R.layout.gridview_item,// 鏄剧ず甯冨眬
                new String[] { "itemImage", "itemText" }, 
                new int[] { R.id.itemImage, R.id.itemText }); 
        gridview.setAdapter(saImageItems);
        gridview.setOnItemClickListener(new ItemClickListener());
	}
	class ItemClickListener implements OnItemClickListener {
		/**
         * 点击项时触发事件
         * file:/G:/Users/hhp/workspace/VLCDemo/res/layout/huanbaowendu.xml
         * @param parent  发生点击动作的AdapterView
         * @param view 在AdapterView中被点击的视图(它是由adapter提供的一个视图)。
         * @param position 视图在adapter中的位置。
         * @param rowid 被点击元素的行id。
         */
        public void onItemClick(AdapterView<?> parent, View view, int position, long rowid) {
            HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
            //鑾峰彇鏁版嵁婧愮殑灞炴�у��
            String itemText=(String)item.get("itemText");
            Object object=item.get("itemImage");
            Toast.makeText(MainActivity.this, itemText, Toast.LENGTH_LONG).show();
            
            //鏍规嵁鍥剧墖杩涜鐩稿簲鐨勮烦杞�
            switch (images[position]) {
            case R.drawable.pn_jifang:
                startActivity(new Intent(MainActivity.this, Activityjifang.class));//锟斤拷锟斤拷锟斤拷一锟斤拷Activity
                break;
            case R.drawable.pn_huanbao:
                startActivity(new Intent(MainActivity.this, Activityhuanbao.class));                
                break;
            case R.drawable.pn_home:
                startActivity(new Intent(MainActivity.this, Activityhome.class));
                break;
                
            case R.drawable.pn_control:
                startActivity(new Intent(MainActivity.this,ActivityDevice.class));
                break;
            }
        }
    }

}
