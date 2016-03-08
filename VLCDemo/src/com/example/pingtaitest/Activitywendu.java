package com.example.pingtaitest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
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
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activitywendu extends Activity implements View.OnClickListener {
	int constNum = 100;
	private Timer timer;
	private GraphicalView chart;
	private double addY = -1;
	private long addX;
	private TimeSeries series;
	private XYMultipleSeriesDataset dataset;
	private Random random = new Random();
	private TextView textview;
	private TextView zhanting;
	LinearLayout layout1;
	private TextView qilou;
	String a = null;
	Date[] xcache = new Date[constNum];
	int[] ycache = new int[constNum];


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.wendu);
		textview = (TextView) findViewById(R.id.textView1);
		zhanting = (TextView) findViewById(R.id.zhanting);
		
		qilou = (TextView) findViewById(R.id.qilou);
		layout1 = (LinearLayout) findViewById(R.id.linearlayout1);
		// 生成图表
		View b_jifang=findViewById(R.id.b_jifang);
		View b_zhanting=findViewById(R.id.b_zhanting);
		View b_qilou=findViewById(R.id.b_qilou);
		b_jifang.setOnClickListener(this);
		b_zhanting.setOnClickListener(this);
		b_qilou.setOnClickListener(this);

		timer = new Timer(true);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.b_jifang:new GenerateData(Activitywendu.this,layout1, 326, "温度","机房");break;
			case R.id.b_qilou:new GenerateData(Activitywendu.this,layout1 ,368, "温度","七楼");break;
			case R.id.b_zhanting:new GenerateData(Activitywendu.this,layout1, 382, "温度","展厅");break;
		}
	}
	
	TimerTask task = new TimerTask(){  
		   
	      public void run() {  
	    	  try {// 传入用户名和密码
					a = WebServiceUtil.getHd("sss", "njuptcloud");
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				try {
					final String b = WebServiceUtil.getMs(a, 326);
					if (b != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								textview.setText(b + "度");
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String c = WebServiceUtil.getMs(a, 382);
					if (c != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								zhanting.setText(c + "度");
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					final String d = WebServiceUtil.getMs(a, 368);
					if (d != null) {
						runOnUiThread(new Runnable() {
							public void run() {
								qilou.setText(d + "度");
								
							}
						});    
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	 
				
	   }
	      
	};
	private void updateChart() throws Exception {
		// 设定长度为20
		int length = series.getItemCount();
		if (length >= constNum)
			length = constNum;
		addY = Double.parseDouble(WebServiceUtil.getMs(a, 13));
		// addY=random.nextInt()%5+10;

		addX = new Date().getTime();
		// 将前面的点放入缓存
		for (int i = 0; i < length; i++) {
			xcache[i] = new Date((long) series.getX(i));
			ycache[i] = (int) series.getY(i);
		}

		series.clear();
		// 将新产生的点首先加入到点集中，然后在循环体中将坐标变换后的一系列点都重新加入到点集中
		series.add(new Date(addX), addY);
		for (int k = 0; k < length; k++) {
			series.add(xcache[k], ycache[k]);
		}
		// 在数据集中添加新的点集
		dataset.removeSeries(series);
		dataset.addSeries(series);
		// 曲线更新
		chart.invalidate();
	}

	private XYMultipleSeriesRenderer getDemoRenderer() {
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setChartTitle("机房温度显示");// 标题
		renderer.setChartTitleTextSize(20);
		renderer.setXTitle("时间"); // x轴说明
		// renderer.setYTitle("网络丢包率（‰）");
		renderer.setAxisTitleTextSize(16);
		renderer.setAxesColor(Color.BLACK);
		renderer.setLabelsTextSize(15); // 数轴刻度字体大小
		renderer.setLabelsColor(Color.BLACK);
		renderer.setLegendTextSize(25); // 曲线说明
		renderer.setAxesColor(Color.BLACK);
		renderer.setAxesColor(Color.BLACK);
		renderer.setXAxisMin(0);
		renderer.setXAxisMax(23);
		renderer.setXLabels(23);
		renderer.setAntialiasing(true);
		renderer.setShowLegend(false);
		renderer.setMargins(new int[] { 10, 30, 15, 2 });// 上左下右{ 20, 30, 100, 0
															// })
		XYSeriesRenderer r1 = new XYSeriesRenderer();
		r1.setColor(Color.RED);
		r1.setChartValuesTextSize(15);
		r1.setChartValuesSpacing(3);
		r1.setPointStyle(PointStyle.POINT);
		r1.setFillPoints(true);	
		renderer.addSeriesRenderer(r1);
		XYSeriesRenderer r2=new XYSeriesRenderer();
		r2.setColor(Color.BLUE);
		r2.setChartValuesTextSize(15);
		r2.setChartValuesSpacing(3);
		r2.setPointStyle(PointStyle.POINT);
		r2.setFillPoints(true);
		renderer.addSeriesRenderer(r2);
		XYSeriesRenderer r3 = new XYSeriesRenderer();
		r3.setColor(Color.YELLOW);
		r3.setChartValuesTextSize(15);
		r3.setChartValuesSpacing(3);
		r3.setPointStyle(PointStyle.POINT);
		r3.setFillPoints(true);	
		renderer.addSeriesRenderer(r3);
		renderer.setMarginsColor(Color.WHITE);
		renderer.setPanEnabled(false, false);
		renderer.setShowGrid(true);
		renderer.setYAxisMax(40);// 纵坐标最大值
		renderer.setYAxisMin(10);// 纵坐标最小值
		renderer.setYLabels(6);// 把Y轴坐标分为6等分
		renderer.setInScroll(true);
		return renderer;
	}

	private XYMultipleSeriesDataset getDateDemoDataset() {// 初始化的数据
		dataset = new XYMultipleSeriesDataset();
		final int nr = 24;
		long value = new Date().getTime();
		Random r = new Random();
		XYMultipleSeriesDataset barDataset=new XYMultipleSeriesDataset();
		CategorySeries barSeries1=new CategorySeries("展厅");
		CategorySeries barSeries2=new CategorySeries("机房");
		CategorySeries barSeries3=new CategorySeries("七楼");
		for (int k = 0; k < nr; k++) {
			barSeries1.add(20 + r.nextInt() % 10);
			barSeries2.add(20 + r.nextInt() % 10);
			barSeries3.add(20 + r.nextInt() % 10);
//			series.add(new Date(value + k * 1000), 20 + r.nextInt() % 10);// 初值Y轴以20为中心，X轴初值范围再次定义
		}
//		barDataset.addAllSeries(lxy);
		barDataset.addSeries(barSeries1.toXYSeries());
		barDataset.addSeries(barSeries2.toXYSeries());
		barDataset.addSeries(barSeries3.toXYSeries());
		return barDataset;
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//计时器，每隔20秒更新一次	
		timer.schedule(task,0, 20000);  
	}
   @Override
public void onBackPressed() {
	super.onBackPressed();
	//关闭计时器
	timer.cancel();
}


}