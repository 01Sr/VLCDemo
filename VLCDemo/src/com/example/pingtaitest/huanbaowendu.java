package com.example.pingtaitest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class huanbaowendu extends Activity {
	int constNum = 100;
	private Timer timer;
	private GraphicalView chart;
	private double addY = -1;
	private long addX;
	private TimeSeries series;
	private XYMultipleSeriesDataset dataset;
	private Random random = new Random();
	private TextView qiwen;
	private TextView shidu;
	
	private TextView aqi;
	String a = null;
	Date[] xcache = new Date[constNum];
	int[] ycache = new int[constNum];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.huanbaowendu);
		qiwen = (TextView) findViewById(R.id.qiwen);
		shidu = (TextView) findViewById(R.id.shidu);
		
		aqi = (TextView) findViewById(R.id.aqi);
		LinearLayout layout1 = (LinearLayout) findViewById(R.id.linearlayout1);
		// ����ͼ��
		chart = ChartFactory.getTimeChartView(this, getDateDemoDataset(), getDemoRenderer(), "HH:mm:ss");
		layout1.addView(chart);
		timer = new Timer(true);
	}

	TimerTask task = new TimerTask(){  
		   
	      public void run() {  
	    	  try {// �����û���������
					a = WebServiceUtil.getHd("sss", "njuptcloud");
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				try {
					final String b = WebServiceUtil.getMs(a, 243);
					if (b != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								qiwen.setText(b + "��");
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String c = WebServiceUtil.getMs(a, 244);
					if (c != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								shidu.setText(c + "��");
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String d = WebServiceUtil.getMs(a, 245);
					if (d != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								aqi.setText(d + "��");
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	 
				
	   }
	      
	};

	private void updateChart() throws Exception {
		// �趨����Ϊ20
		int length = series.getItemCount();
		if (length >= constNum)
			length = constNum;
		addY = Double.parseDouble(WebServiceUtil.getMs(a, 13));
		// addY=random.nextInt()%5+10;

		addX = new Date().getTime();
		// ��ǰ��ĵ���뻺��
		for (int i = 0; i < length; i++) {
			xcache[i] = new Date((long) series.getX(i));
			ycache[i] = (int) series.getY(i);
		}

		series.clear();
		// ���²����ĵ����ȼ��뵽�㼯�У�Ȼ����ѭ�����н�����任���һϵ�е㶼���¼��뵽�㼯��
		series.add(new Date(addX), addY);
		for (int k = 0; k < length; k++) {
			series.add(xcache[k], ycache[k]);
		}
		// �����ݼ�������µĵ㼯
		dataset.removeSeries(series);
		dataset.addSeries(series);
		// ���߸���
		chart.invalidate();
	}

	private XYMultipleSeriesRenderer getDemoRenderer() {
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setChartTitle("�����¶���ʾ");// ����
		renderer.setChartTitleTextSize(20);
		renderer.setXTitle("ʱ��"); // x��˵��
		// renderer.setYTitle("���綪���ʣ��룩");
		renderer.setAxisTitleTextSize(16);
		renderer.setAxesColor(Color.BLACK);
		renderer.setLabelsTextSize(15); // ����̶������С
		renderer.setLabelsColor(Color.BLACK);
		renderer.setLegendTextSize(25); // ����˵��
		renderer.setAxesColor(Color.BLACK);
		renderer.setAxesColor(Color.BLACK);
		renderer.setShowLegend(false);
		renderer.setMargins(new int[] { 10, 30, 15, 2 });// ��������{ 20, 30, 100, 0
															// })
		XYSeriesRenderer r = new XYSeriesRenderer();
		r.setColor(Color.RED);
		r.setChartValuesTextSize(15);
		r.setChartValuesSpacing(3);
		r.setPointStyle(PointStyle.POINT);
		r.setFillBelowLine(true);
		r.setFillBelowLineColor(Color.WHITE);
		r.setFillPoints(true);
		renderer.addSeriesRenderer(r);
		renderer.setMarginsColor(Color.WHITE);
		renderer.setPanEnabled(false, false);
		renderer.setShowGrid(true);
		renderer.setYAxisMax(40);// ���������ֵ
		renderer.setYAxisMin(10);// ��������Сֵ
		renderer.setYLabels(6);// ��Y�������Ϊ6�ȷ�
		renderer.setInScroll(true);
		return renderer;
	}

	private XYMultipleSeriesDataset getDateDemoDataset() {// ��ʼ��������
		dataset = new XYMultipleSeriesDataset();
		final int nr = 10;
		long value = new Date().getTime();
		Random r = new Random();
		series = new TimeSeries("Demo series " + 1);
		for (int k = 0; k < nr; k++) {
			series.add(new Date(value + k * 1000), 20 + r.nextInt() % 10);// ��ֵY����20Ϊ���ģ�X���ֵ��Χ�ٴζ���
		}
		dataset.addSeries(series);
		return dataset;
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//��ʱ����ÿ��20�����һ��	
		timer.schedule(task,0, 20000);  
	}
   @Override
public void onBackPressed() {
	super.onBackPressed();
	//�رռ�ʱ��
	timer.cancel();
}
}