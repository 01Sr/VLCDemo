package com.example.pingtaitest;

import com.polites.android.GestureImageView;
import com.polites.android.GestureImageViewListener;

import android.R.bool;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.videolan.vlc.VLCApplication;
import org.videolan.vlc.gui.video.VideoPlayerActivity;

import cn.ffcs.vlcdemo.R;

public class ActivityDevice extends Activity {
	public static int current_locID=-1;
	public static int current_camID=-1;
	String a=null;
    FrameLayout root;
    GestureImageView gestureImageView;
	int statusBarHeight;
	int screenWidth;
	int screenHeight;
	int imgWidth;
	int imgHeight;
	int imgX;
	int imgY;
	boolean isClicked=false;
	FrameLayout.LayoutParams params;
	List<DevImg> devList;
	private class DevImg{
		public DevImg(int id,int type, ImageView img, double xP, double yP){
			this.id=id;
			this.img=img;
			this.xP=xP;
			this.yP=yP;
			this.type=type;
		}
		public int id;
		public  int type;
		public ImageView img;
		public double xP;
		public double yP;
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
		for(DevImg devImg:devList){
			devImg.img=null;
			devImg=null;
		}
		devList.clear();
		devList=null;
		Log.e("^^^^^^^^^^^^","Desttory");
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		isClicked=false;
		Log.e("#resume", "width:"+imgWidth+" height:"+imgHeight+" x:"+imgX+" y:"+imgY);
	}


	@Override
    protected void onCreate(Bundle savedInstanceState) {
		Log.e("##########", "Create");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
		devList=new ArrayList<DevImg>();
		devList.add(new DevImg(1,0,new ImageView(ActivityDevice.this),0.52,0.506));
		devList.add(new DevImg(2,0, new ImageView(ActivityDevice.this), 0.558, 0.43));
		devList.add(new DevImg(3,0, new ImageView(ActivityDevice.this), 0.38, 0.57));
		devList.add(new DevImg(4,0, new ImageView(ActivityDevice.this), 0.6336, 0.4115));
		devList.add(new DevImg(5,0, new ImageView(ActivityDevice.this), 0.8107, 0.3294));
		devList.add(new DevImg(48,0, new ImageView(ActivityDevice.this), 0.275, 0.75));
		devList.add(new DevImg(47,0, new ImageView(ActivityDevice.this), 0.39, 0.69));
		
		devList.add(new DevImg(7,1, new ImageView(ActivityDevice.this), 0.41, 0.707));
		devList.add(new DevImg(46,1, new ImageView(ActivityDevice.this), 0.3758, 0.71145));
		devList.add(new DevImg(14,1,new ImageView(ActivityDevice.this),0.56,0.506));
		devList.add(new DevImg(14,1, new ImageView(ActivityDevice.this), 0.598, 0.43));
		devList.add(new DevImg(14,1, new ImageView(ActivityDevice.this), 0.42, 0.57));
		devList.add(new DevImg(14,1, new ImageView(ActivityDevice.this), 0.6736, 0.4115));
		devList.add(new DevImg(14,1, new ImageView(ActivityDevice.this), 0.8507, 0.3294));
		devList.add(new DevImg(14,1, new ImageView(ActivityDevice.this), 0.315, 0.75));
		setContentView(R.layout.device_map);
		DisplayMetrics m=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(m);
		screenWidth=m.widthPixels;
		screenHeight=m.heightPixels;
		Rect rect=new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		statusBarHeight=rect.top;
        gestureImageView= (GestureImageView) findViewById(R.id.img_njupt);
		try {
			Drawable d=Drawable.createFromStream(getAssets().open("njupt_sanpailou.jpg"),"njupt") ;
			gestureImageView.setImageDrawable(d);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					a=WebServiceUtil.getHd("sss", "njuptcloud");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();
		gestureImageView.setMaxScale(10.0f);
		imgWidth=gestureImageView.getScaledWidth();
		imgHeight=gestureImageView.getScaledHeight();
		imgX=Math.round(gestureImageView.getImageX() - imgWidth / 2);
		imgY=Math.round(gestureImageView.getImageY() - imgHeight / 2);
		root= (FrameLayout) findViewById(R.id.root);
		params=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		for(final DevImg devImg:devList){
			ImageView img=devImg.img;
			if(devImg.type==0){
				img.setImageResource(R.drawable.video);
				img.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						//	devList=null;
						current_camID = devImg.id;
						// TODO Auto-generated method stub
						new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									a=WebServiceUtil.getHd("sss", "njuptcloud");
									   if(a!=null){
									final String b = WebServiceUtil.getRtspUrl(a, String.valueOf(devImg.id));
									if (b != null) {
										VideoPlayerActivity.start(VLCApplication.getAppContext(), b, b, 0, false, true, false);
									}
									}else{
										Log.e("++++","δ���Ȩ��");
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}).start();
					}
				});
			}else {
				img.setImageResource(R.drawable.device);
				img.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(ActivityDevice.this, SenssorsInfo.class);
						intent.putExtra("LocationID", devImg.id);
						startActivity(intent);
					}
				});
			}
			
			params=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			params.setMargins((int) (imgWidth * devImg.xP), (int) (imgHeight * devImg.yP + (screenHeight - statusBarHeight - imgHeight) / 2-30), 0, 0);
			Log.e("#create", "width:"+imgWidth+" height:"+imgHeight+" x:"+imgX+" y:"+imgY);
		//	params.setMargins((int) (imgWidth * devImg.xP + imgX - 17.5), (int) (imgHeight * devImg.yP + imgY - 17.5), 0, 0);
			img.setLayoutParams(params);
			root.addView(img);

			img=null;
		}
		//gestureImageView.redraw();
		gestureImageView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				imgWidth = gestureImageView.getScaledWidth();
				imgHeight = gestureImageView.getScaledHeight();
				imgX = Math.round(gestureImageView.getImageX() - imgWidth / 2);
				imgY = Math.round(gestureImageView.getImageY() - imgHeight / 2);
				double cX=(event.getX()-imgX)/imgWidth;
				double cY=(event.getY()-imgY)/imgHeight;
				if(cX>=0.32824&&cX<=0.36785&&cY>=0.58564&&cY<=0.71494&&!isClicked){
					isClicked=true;
					Intent intent=new Intent(ActivityDevice.this,ActivityShiPin.class);
					startActivity(intent);
				}
				Log.e("#click", "x:"+((event.getX()-imgX)/imgWidth)+" y:"+((event.getY()-imgY)/imgHeight));
//				Log.e("#click", "x:"+event.getX()+" y:"+event.getY());
//				Log.e("#click", "x:"+gestureImageView.getImageX()+" y:"+event.getY());
				return true;
			}
		});
        gestureImageView.setGestureImageViewListener(new GestureImageViewListener() {
			
			@Override
			public void onTouch(float x, float y) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void onScale(float scale) {
				// TODO Auto-generated method stub
				for(DevImg devImg:devList)
					resetImgPosition(devImg);
			}
			
			@Override
			public void onPosition(float x, float y) {
				// TODO Auto-generated method stub
				for(DevImg devImg:devList)
				resetImgPosition(devImg);
			}
		});
    }
	
	private void resetImgPosition(DevImg devImg){
		final ImageView img=devImg.img;
		final double xP=devImg.xP;
		final double yP=devImg.yP;
		try{
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
					imgWidth = gestureImageView.getScaledWidth();
					imgHeight = gestureImageView.getScaledHeight();
					imgX = Math.round(gestureImageView.getImageX() - imgWidth / 2);
					imgY = Math.round(gestureImageView.getImageY() - imgHeight / 2);
					 params.setMargins((int) (imgWidth * xP + imgX-img.getMeasuredWidth()/2), (int) (imgHeight * yP + imgY-img.getMeasuredHeight()*6/7), 0, 0);
					img.setLayoutParams(params);
				//	Log.e("#click", "width:"+imgWidth+" height:"+imgHeight+" x:"+imgX+" y:"+imgY);
				}
			});

		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
