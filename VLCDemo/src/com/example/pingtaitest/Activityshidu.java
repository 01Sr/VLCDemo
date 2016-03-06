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

public class Activityshidu extends Activity {
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
	private TextView qilou;

	String a = null;
	Date[] xcache = new Date[constNum];
	int[] ycache = new int[constNum];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shidu);
		textview = (TextView) findViewById(R.id.textView1);
		zhanting = (TextView) findViewById(R.id.zhanting);
		qilou = (TextView) findViewById(R.id.qilou);

		LinearLayout layout1 = (LinearLayout) findViewById(R.id.linearlayout1);
		// 生成图表
		chart = ChartFactory.getTimeChartView(this, getDateDemoDataset(), getDemoRenderer(), "HH:mm:ss");
		layout1.addView(chart);
		new Thread(new Runnable() {
			public void run() {
				try {// 传入用户名和密码
					a = WebServiceUtil.getHd("sss", "njuptcloud");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}finally{
					Message message = handler.obtainMessage();
					message.what=0;
					handler.sendMessage(message);
				}
			}
		}).start();
		Toast.makeText(this, a, 0).show();
	}

	TimerTask task = new TimerTask() {

		public void run() {
			try {// 传入用户名和密码
				GetMs getMs1 = new GetMs(327, 1);
				GetMs getMs2 = new GetMs(383, 2);
				GetMs getMs3 = new GetMs(348, 3);
				getMs1.start();
				getMs2.start();
				getMs3.start();
			} catch (Exception e1) {
				e1.printStackTrace();
				Message m=new Message();
				m.what=-1;
				handler.sendMessage(m);
			}	
		}
	};
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case -1:
				Toast.makeText(Activityshidu.this, "网络或服务器异常", Toast.LENGTH_SHORT);
			case 0:
				timer = new Timer(true);
				timer.schedule(task, 0, 30000);
				break;
			case 1:
				textview.setText(msg.obj + "度");
				break;
			case 2:
				zhanting.setText(msg.obj + "度");
				break;
			case 3:
				qilou.setText(msg.obj + "度");
				break;
			default:
				break;
			}
		};
	};

	public void getMs(int b, int c) {
		
				try {
					final String d = WebServiceUtil.getMs(a, b);
					if (d != null) {
						Message message = handler.obtainMessage();
						message.what=c;
						message.obj=d;
						handler.sendMessage(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

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
		renderer.setShowLegend(false);
		renderer.setMargins(new int[] { 10, 30, 15, 2 });// 上左下右{ 20, 30, 100, 0
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
		renderer.setYAxisMax(40);// 纵坐标最大值
		renderer.setYAxisMin(10);// 纵坐标最小值
		renderer.setYLabels(6);// 把Y轴坐标分为6等分
		renderer.setInScroll(true);
		return renderer;
	}

	private XYMultipleSeriesDataset getDateDemoDataset() {// 初始化的数据
		dataset = new XYMultipleSeriesDataset();
		final int nr = 10;
		long value = new Date().getTime();
		Random r = new Random();
		series = new TimeSeries("Demo series " + 1);
		for (int k = 0; k < nr; k++) {
			series.add(new Date(value + k * 1000), 20 + r.nextInt() % 10);// 初值Y轴以20为中心，X轴初值范围再次定义
		}
		dataset.addSeries(series);
		return dataset;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// 计时器，每隔20秒更新一次
		if(timer!=null){
			timer.schedule(task, 0, 30000);
		}	
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		// 关闭计时器
		timer.cancel();
	}
	class GetMs extends Thread{
		private int key;
		private int id;
		public GetMs(int key,int id){
			this.key=key;
			this.id=id;
		}
		@Override
		public void run() {
			getMs(key,id);
		}
	}
}
