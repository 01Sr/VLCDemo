package com.example.pingtaitest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.videolan.vlc.VLCApplication;
import org.videolan.vlc.gui.video.VideoPlayerActivity;

import android.R.integer;
import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pingtaitest.WebServiceUtil;

import cn.ffcs.vlcdemo.R;

public class ActivityShiPin extends Activity {
	String a = null;
	public static int current_locID=-1;
	public static int current_camID=-1;
	private List<String> nameList;
	private ListView camList;
	Integer[] idList={50,28,20,34,27,24,40,31,30,36,32,26,22,44,45,29,33,25,41,13,35,43,38,51,12,37,42,7,17,15,18,9,11,8,23,21,14,16,10,46,39};;
	private int getLocID(int i){
		switch(i){
    	case 1:return 9;		
    	case 2:return 9;		
    	case 3:return 9;			
    	case 4:return 11; 		
    	case 5:return 13; 		
    	case 6:return -1; 		
    	case 7:return 54;		
    	case 8:return 61;		
    	case 9:return 59;		
    	case 10:return 67;		
    	case 11:return 60;		
    	case 12:return 52;		
    	case 13:return 50;		
    	case 14:return 65;		
    	case 15:return 57;		
    	case 16:return 66;		
    	case 17:return 56;		
    	case 18:return 58;		
    	case 19:return -1; 		
    	case 20:return 38;		
    	case 21:return 64;		
    	case 22:return 45;		
    	case 23:return 62;		
    	case 24:return 76;		
    	case 25:return 48;		
    	case 26:return 44; 		
    	case 27:return 39; 		
    	case 28:return 74; 		
    	case 29:return 46; 		
    	case 30:return 42; 		
    	case 31:return 41; 		
    	case 32:return 77; 		
    	case 33:return 46; 		
    	case 34:return 74; 		
    	case 35:return 50; 		
    	case 36:return 43; 		
    	case 37:return 53; 		
    	case 38:return 51; 		
    	case 39:return 69; 		
    	case 40:return 40; 		
    	case 41:return 49; 		
    	case 42:return 54; 		
    	case 43:return 51; 		
    	case 44:return 79; 		
    	case 45:return 25; 		
    	case 46:return 68; 		
    	case 47:return 7; 		
    	case 48:return 9; 		
    	case 49:return 9; 		
    	case 50:return 72; 		
    	case 51:return 27; 		
    	case 52:return 5; 		
		}
		return -1;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e(">>>>>>>>", "&&Create");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shipin);
//		new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                	Log.e(">>>>>>>>>>","进入run");
//                    a = WebServiceUtil.getHd("sss", "njupt");
//                    if(a!=null){
//                        final String b = WebServiceUtil.getPermission(a,"1");
//                        Log.e("--------------->",a);
//                        if(b!=null){
//                            runOnUiThread(new  Runnable() {
//                                public void run() {
//                                    Toast.makeText(ActivityShiPin.this, b, Toast.LENGTH_SHORT).show();
//                                    
//                                }
//                            });
//
//                        }
//                        else{
//                        	runOnUiThread(new  Runnable() {
//                                public void run() {
//                                    Toast.makeText(ActivityShiPin.this, "未获取权限", Toast.LENGTH_SHORT).show();
//                                    
//                                }
//                            });
//                        }
//                    }
//                    else {
//						Log.e(">>>>>>>>>>","错误");
//					}
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                	Log.e(">>>>>>>>>>","异常"+e.getMessage());
//                    e.printStackTrace();
//                }
//            }
//        }).start();
		String[] list={"一楼大厅内","一楼展厅","东1","东一展厅","西1","西1展厅","东2","西2","东3","西3","3s","东4","西4","西五工程中心","五楼","东5","东5走廊","东6","西6","东7","东七楼走廊","西7","西7楼走廊","七楼室内屏幕","东8","西8","东9","东9-2","东10","西10","东11","西11","东12","西12","东13","东14","西14","东15","西15","东16楼","西16"};
		
		nameList=Arrays.asList(list);
		camList=(ListView) findViewById(R.id.camList);
		ArrayAdapter adapter= new ArrayAdapter<String>(this, R.layout.camera_item, nameList);
		camList.setAdapter(adapter);
		camList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			//	Toast.makeText(ActivityShiPin.this, String.valueOf(arg2), Toast.LENGTH_SHORT).show();
				current_camID=idList[arg2];
				current_locID=getLocID(current_camID);
				if(current_locID!=-1){
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								a=WebServiceUtil.getHd("sss", "njuptcloud");
	                            if(a!=null){
	                                final String b = WebServiceUtil.getRtspUrl(a, String.valueOf(current_camID));
	                                if(b!=null){
	                                            VideoPlayerActivity.start(VLCApplication.getAppContext(), b, b, 0, false, true,false);

	                                }

	                            }

	                        } catch (Exception e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
						}
					}).start();
				}
			
			}
		});
	}

}





