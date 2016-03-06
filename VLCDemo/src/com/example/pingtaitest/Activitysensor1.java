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
		manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);  //��ȡ�������������
	}
	@Override
	protected void onResume() {
		super.onResume();
		//Ϊ���򴫸���ע�������
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_ORIENTATION), manager.SENSOR_DELAY_GAME);
		//Ϊ�ų�������ע�������
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), manager.SENSOR_DELAY_GAME);
		//Ϊ�¶ȴ�����ע�������
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_TEMPERATURE), manager.SENSOR_DELAY_GAME);
		//Ϊ���մ�����ע�������
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_LIGHT), manager.SENSOR_DELAY_GAME);
		//Ϊѹ��������ע�������
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_PRESSURE), manager.SENSOR_DELAY_GAME);
		//Ϊ���봫����ע�������
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_PROXIMITY), manager.SENSOR_DELAY_GAME);
		//Ϊ�����Ǵ�����ע�������
		manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_GRAVITY), manager.SENSOR_DELAY_GAME);
	}

	@Override
	protected void onPause() {
		//������ͣʱȡ��ע��
		manager.unregisterListener(this);
		super.onPause();
	}

	@Override
	protected void onStop() {
		//����ֹͣʱȡ��ע��
		manager.unregisterListener(this);
		super.onStop();
	}
      //ʵ��SensorEventListener�ӿڱ���ʵ�ֵķ���
	@Override
	//��������ֵ�����ı�ʱ�ص��˷���
	public void onSensorChanged(SensorEvent event) {
		float[] values = event.values;
		int sensorType = event.sensor.getType();
		StringBuilder sb = null;
		switch(sensorType){
		//���򴫸���
		case Sensor.TYPE_ORIENTATION:
			sb = new StringBuilder();
			sb.append("��Z��ת���ĽǶȣ�");
			sb.append(values[0]);
			sb.append("\n��X��ת���ĽǶȣ�");
			sb.append(values[1]);
			sb.append("\n��Y��ת���ĽǶȣ�");
			sb.append(values[2]);
			orientation.setText(sb.toString());
			break;
		//�ų�������
		case Sensor.TYPE_MAGNETIC_FIELD:
			sb = new StringBuilder();
			sb.append("X�����ϵĽǶȣ�");
			sb.append(values[0]);
			sb.append("\nY�����ϵĽǶȣ�");
			sb.append(values[1]);
			sb.append("\nZ�����ϵĽǶȣ�");
			sb.append(values[2]);
			magnetic.setText(sb.toString());
			break;
		//�¶ȴ�����	
		case Sensor.TYPE_TEMPERATURE:
			sb = new StringBuilder();
			sb.append("��ǰ�¶�Ϊ��");
			sb.append(values[0]);
			temperature.setText(sb.toString());
			break;
		//�⴫����	
		case Sensor.TYPE_LIGHT:
			sb = new StringBuilder();
			sb.append("��ǰ���ǿ��(lux)Ϊ��");
			sb.append(values[0]);
			light.setText(sb.toString());
			break;
		//ѹ��������	
		case Sensor.TYPE_PRESSURE:
			sb = new StringBuilder();
			sb.append("��ǰѹ��(hPa)Ϊ��");
			sb.append(values[0]);
			pressure.setText(sb.toString());
			break;
		//���봫����
		case Sensor.TYPE_PROXIMITY:
			sb = new StringBuilder();
			sb.append("��ǰ����(cm)Ϊ��");
			sb.append(values[0]);
			proximity.setText(sb.toString());
			break;
		//����������
		case Sensor.TYPE_GRAVITY:
			sb = new StringBuilder();
			sb.append("X�����ϵ�����ֵ��");
			sb.append(values[0]);
			sb.append("\nY�����ϵ�����ֵ��");
			sb.append(values[1]);
			sb.append("\nZ�����ϵ�����ֵ��");
			sb.append(values[2]);
			gravity.setText(sb.toString());
			break;  
		}
		
	}
	@Override
	//���������ȷ����ı�ʱ�ص��˷���
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
		
	}

}