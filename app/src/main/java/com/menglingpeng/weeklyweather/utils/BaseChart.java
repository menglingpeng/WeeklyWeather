package com.menglingpeng.weeklyweather.utils;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;

import org.w3c.dom.Entity;

import java.util.List;

/**
 * 图表基类
 * Created by mengdroid on 2018/5/18.
 */

public abstract class BaseChart<T extends Entity>{

    protected BarLineChartBase chart;
    protected List<T>[] entries;
    protected String[] labels;
    protected int []chartColors;
    protected float textSize;
    protected int valueColor;

    /*为true表示需要设置成虚线*/
    protected boolean[] hasDotted;

    protected BaseChart(BarLineChartBase chart, List<T> []entries, String[] labels,
                        int []chartColor, int valueColor, float textSize) {
        this.chart = chart;
        this.entries = entries;
        this.labels = labels;
        this.valueColor = valueColor;
        this.chartColors = chartColor;
//        this.mTextSize = textSize;
        this.textSize = 11f;
        initChart();
    }

    protected BaseChart(BarLineChartBase chart, List<T> []entries, String[] labels,
                              int []chartColor, int valueColor, float textSize,boolean[] hasDotted) {
        this.chart = chart;
        this.entries = entries;
        this.labels = labels;
        this.valueColor = valueColor;
        this.chartColors = chartColor;
        this.textSize = textSize;
//        this.mTextSize = 11f;
        this.hasDotted = hasDotted;
        initChart();
    }

    protected void initChart() {
        initProperties();

        setChartData();

        //initLegend(Legend.LegendForm.LINE, textSize, valueColor);

        initXAxis(valueColor, textSize);

        initLeftAxis(valueColor, textSize);
    }

    /**
     *初始化属性
     */
    private void initProperties() {
        chart.setNoDataText("");
        // no description text
        chart.getDescription().setEnabled(false);

        // enable touch gestures
        chart.setTouchEnabled(true);
        chart.setDragDecelerationFrictionCoef(0.9f);
        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleXEnabled(true);
        chart.setPinchZoom(false);
        chart.setVisibleXRangeMaximum(6);
        chart.setScaleYEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setHighlightPerDragEnabled(false);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);
    }

    private void initLeftAxis(int color, float textSize) {
        YAxis leftAxis = chart.getAxisLeft();

        leftAxis.setTextColor(color);
        leftAxis.setTextSize(textSize);
        float yMax = chart.getData().getYMax() == 0 ? 100f : chart.getData().getYMax();
        leftAxis.setAxisMaximum(yMax + yMax * 0.007f);
//        leftAxis.setAxisMinimum(0f);
        leftAxis.setDrawGridLines(false);
        leftAxis.setGranularityEnabled(false);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setLabelCount(6);
        leftAxis.setAxisLineWidth(1f);
        leftAxis.setAxisLineColor(valueColor);

        chart.getAxisRight().setEnabled(false);

    }

    private void initXAxis(int color, float textSize) {
        XAxis xAxis = chart.getXAxis();

        xAxis.setTextSize(textSize);
        xAxis.setAxisMinimum(0);
        xAxis.setTextColor(color);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawLabels(true);
        xAxis.setAxisLineWidth(1f);
        xAxis.setLabelCount(8);
        xAxis.setDrawLimitLinesBehindData(true);
        xAxis.setAxisLineColor(valueColor);
        xAxis.setCenterAxisLabels(false);
        xAxis.setAxisMinimum(chart.getData().getXMin());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

    }

    /**
     * 图表value显示开关
     */
    public void toggleChartValue () {
        List<BaseDataSet> sets = chart.getData().getDataSets();
        for (BaseDataSet iSet : sets) {
            iSet.setDrawValues(!iSet.isDrawValuesEnabled());
        }
        chart.invalidate();
    }

    public void setMarkView (MarkerView markView) {
        markView.setChartView(chart); // For bounds control
        chart.setMarker(markView); // Set the marker to the chart
        chart.invalidate();
    }

    /**
     * x/ylabel显示样式
     * @param xvalueFromatter x
     * @param leftValueFromatter y
     */
    public void setAxisFormatter(IAxisValueFormatter xvalueFromatter, IAxisValueFormatter leftValueFromatter) {
        chart.getXAxis().setValueFormatter(xvalueFromatter);
        chart.getAxisLeft().setValueFormatter(leftValueFromatter);
        chart.invalidate();

    }

    /**
     * value显示格式设置
     * @param valueFormatter IValueFormatter
     */
    public void setDataValueFormatter(IValueFormatter valueFormatter) {
        chart.getData().setValueFormatter(valueFormatter);
    }

    protected abstract void setChartData();

}
