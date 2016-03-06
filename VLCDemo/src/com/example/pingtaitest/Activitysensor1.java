package com.example.pingtaitest;

import java.io.OutputStream;
import java.net.Socket;

import cn.ffcs.vlcdemo.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Activitysensor1 extends Activity implements SensorEventListener{
    private TextView orientation;
    private TextView magnetic;
    private TextView temperature;
    private TextView light;
    private TextView pressure;
    private TextView proximity;
    private TextView gravity;
    private SensorManager manager;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensor1);
		orientation = (TextView)findViewById(R.id.orientation);
		magnetic = (TextView)findViewById(R.id.magnetic);
		temperature = (TextView)findViewById(R.id.temperature);
		light = (TextView)findViewById(R.id.light);
		pressure = (TextView)findViewById(R.id.pressure);
		proximity = (TextView)findViewById(R.id.proximity);
		gravity = (TextView)findViewById(R.id.gravity);
		manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);  //获取传感器管理服务
	}
	@Override
	protected void onResume() {
		super.onResume();
		//为方向传感器注册监听器
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_ORIENTATION), manager.SENSOR_DELAY_GAME);
		//为磁场传感器注册监听器
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), manager.SENSOR_DELAY_GAME);
		//为温度传感器注册监听器
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_TEMPERATURE), manager.SENSOR_DELAY_GAME);
		//为光照传感器注册监听器
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_LIGHT), manager.SENSOR_DELAY_GAME);
		//为压力传感器注册监听器
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_PRESSURE), manager.SENSOR_DELAY_GAME);
		//为距离传感器注册监听器
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_PROXIMITY), manager.SENSOR_DELAY_GAME);
		//为陀螺仪传感器注册监听器
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_GRAVITY), manager.SENSOR_DELAY_GAME);
	}

	@Override
	protected void onPause() {
		//程序暂停时取消注册
		manager.unregisterListener(this);
		super.onPause();
	}

	@Override
	protected void onStop() {
		//程序停止时取消注册
		manager.unregisterListener(this);
		super.onStop();
	}
      //实现SensorEventListener接口必须实现的方法
	@Override
	//传感器的值发生改变时回调此方法
	public void onSensorChanged(SensorEvent event) {
		float[] values = event.values;
		int sensorType = event.sensor.getType();
		StringBuilder sb = null;
		switch(sensorType){
		//方向传感器
		case Sensor.TYPE_ORIENTATION:
			sb = new StringBuilder();
			sb.append("绕Z轴转过的角度：");
			sb.append(values[0]);
			sb.append("\n绕X轴转过的角度：");
			sb.append(values[1]);
			sb.append("\n绕Y轴转过的角度：");
			sb.append(values[2]);
			orientation.setText(sb.toString());
			break;
		//磁场传感器
		case Sensor.TYPE_MAGNETIC_FIELD:
			sb = new StringBuilder();
			sb.append("X方向上的角度：");
			sb.append(values[0]);
			sb.append("\nY方向上的角度：");
			sb.append(values[1]);
			sb.append("\nZ方向上的角度：");
			sb.append(values[2]);
			magnetic.setText(sb.toString());
			break;
		//温度传感器	
		case Sensor.TYPE_TEMPERATURE:
			sb = new StringBuilder();
			sb.append("当前温度为：");
			sb.append(values[0]);
			temperature.setText(sb.toString());
			break;
		//光传感器	
		case Sensor.TYPE_LIGHT:
			sb = new StringBuilder();
			sb.append("当前光的强度(lux)为：");
			sb.append(values[0]);
			light.setText(sb.toString());
			break;
		//压力传感器	
		case Sensor.TYPE_PRESSURE:
			sb = new StringBuilder();
			sb.append("当前压力(hPa)为：");
			sb.append(values[0]);
			pressure.setText(sb.toString());
			break;
		//距离传感器
		case Sensor.TYPE_PROXIMITY:
			sb = new StringBuilder();
			sb.append("当前距离(cm)为：");
			sb.append(values[0]);
			proximity.setText(sb.toString());
			break;
		//重力传感器
		case Sensor.TYPE_GRAVITY:
			sb = new StringBuilder();
			sb.append("X方向上的重力值：");
			sb.append(values[0]);
			sb.append("\nY方向上的重力值：");
			sb.append(values[1]);
			sb.append("\nZ方向上的重力值：");
			sb.append(values[2]);
			gravity.setText(sb.toString());
			break;  
		}
		
	}
	@Override
	//传感器精度发生改变时回调此方法
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
		
	}

}