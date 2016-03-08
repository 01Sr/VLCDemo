package com.example.pingtaitest;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.R.integer;
import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.widget.LinearLayout;

public class Chart {
	Context context;
	LinearLayout parentLayout;
	int yMax;
	int yMin;
	int yDivider;
	String yName;
	double[] dataSet;
	String title;
	String seriesName="曲线";
	public Chart(Context context, LinearLayout parentLayout, int yMax, int yMin, int yDivider,String title,
			String yName, double[] dataSet) {
		this.context=context;
		this.parentLayout = parentLayout;
		this.yMax = yMax;
		this.yMin = yMin;
		this.yDivider = yDivider;
		this.title=title;
		this.yName = yName;
		this.dataSet = dataSet;
	}
	public void generateChart(){
		GraphicalView chart= ChartFactory.getLineChartView(context, getDataset(), getRenderer());
		if(parentLayout.getChildCount()!=0){
			parentLayout.removeAllViews();
		}
		parentLayout.addView(chart);
	}
	private XYMultipleSeriesRenderer getRenderer() {
		// TODO Auto-generated method stub
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setChartTitle(title);// 标题
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
//		renderer.setZoomEnabled(false);
//		renderer.Z
//		renderer.setAntialiasing(true);
		renderer.setShowLegend(false);
		renderer.setMargins(new int[] { 10, 30, 15, 2 });// 上左下右{ 20, 30, 100, 0
															// })
		XYSeriesRenderer r = new XYSeriesRenderer();
		r.setColor(Color.RED);
		r.setChartValuesTextSize(15);
		r.setChartValuesSpacing(3);
		r.setPointStyle(PointStyle.POINT);
		r.setFillPoints(true);
		
		renderer.addSeriesRenderer(r);
		renderer.setMarginsColor(Color.WHITE);
		renderer.setPanEnabled(false, false);
		renderer.setShowGrid(true);
		renderer.setYAxisMax(yMax);
		renderer.setYAxisMin(yMin);
		renderer.setYLabels(yDivider);
		renderer.setYTitle(yName);
		renderer.setInScroll(true);
		return renderer;
	}
	private XYMultipleSeriesDataset getDataset() {
		// TODO Auto-generated method stub
		XYMultipleSeriesDataset dataset=new XYMultipleSeriesDataset();
		CategorySeries categorySeries=new CategorySeries(seriesName);
		for(int i=0;i<dataSet.length;i++){
			categorySeries.add(dataSet[i]);
		}
//		for (int k = 0; k < 24; k++) {
//			categorySeries.add(10);
//
//		}
		dataset.addSeries(categorySeries.toXYSeries());
		return dataset;
	}
	
}
