package com.menglingpeng.weeklyweather.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.menglingpeng.weeklyweather.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mengdroid on 2018/5/14.
 */

public class ChartUtils {

    public static int dayValue = 0;
    public static int weekValue = 1;
    public static int monthValue = 2;

    /**
     * 初始化图表
     *
     * @param chart 原始图表
     * @return 初始化后的图表
     */
    public static LineChart initChart(LineChart chart) {
        // 不显示数据描述
        chart.getDescription().setEnabled(false);
        // 没有数据的时候，显示“暂无数据”
        chart.setNoDataText("暂无数据");
        // 不显示表格颜色
        chart.setDrawGridBackground(false);
        // 不可以缩放
        chart.setScaleEnabled(false);
        // 不显示y轴右边的值
        chart.getAxisRight().setEnabled(false);
        // 不显示图例
        Legend legend = chart.getLegend();
        legend.setEnabled(false);
        // 向左偏移15dp，抵消y轴向右偏移的30dp
        chart.setExtraLeftOffset(-15);

        XAxis xAxis = chart.getXAxis();
        // 不显示x轴
        xAxis.setDrawAxisLine(false);
        // 设置x轴数据的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(12);
        xAxis.setGridColor(Color.parseColor("#30FFFFFF"));
        // 设置x轴数据偏移量
        xAxis.setYOffset(-12);

        YAxis yAxis = chart.getAxisLeft();
        // 不显示y轴
        yAxis.setDrawAxisLine(false);
        // 设置y轴数据的位置
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        // 不从y轴发出横向直线
        yAxis.setDrawGridLines(false);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setTextSize(12);
        // 设置y轴数据偏移量
        yAxis.setXOffset(30);
        yAxis.setYOffset(-3);
        yAxis.setAxisMinimum(0);

        //Matrix matrix = new Matrix();
        // x轴缩放1.5倍
        //matrix.postScale(1.5f, 1f);
        // 在图表动画显示之前进行缩放
        //chart.getViewPortHandler().refresh(matrix, chart, false);
        // x轴执行动画
        //chart.animateX(2000);
        chart.invalidate();
        return chart;
    }

    /**
     * 设置图表数据
     *
     * @param chart  图表
     * @param values 数据
     */
    public static void setChartData(LineChart chart, List<Entry> values) {
        LineDataSet lineDataSet;

        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            lineDataSet = new LineDataSet(values, "");
            // 设置曲线颜色
            lineDataSet.setColor(Color.parseColor("#FFFFFF"));
            // 设置平滑曲线
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            // 不显示坐标点的小圆点
            lineDataSet.setDrawCircles(false);
            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false);
            // 不显示定位线
            lineDataSet.setHighlightEnabled(false);

            LineData data = new LineData(lineDataSet);
            chart.setData(data);
            chart.invalidate();
        }
    }

    /**
     * 更新图表
     *
     * @param chart     图表
     * @param values    数据
     * @param valueType 数据类型
     */
    public static void notifyDataSetChanged(LineChart chart, List<Entry> values,
                                            final int valueType) {
        chart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValuesProcess(valueType)[(int) value];
            }
        });

        chart.invalidate();
        setChartData(chart, values);
    }

    /**
     * x轴数据处理
     *
     * @param valueType 数据类型
     * @return x轴数据
     */
    private static String[] xValuesProcess(int valueType) {
        String[] week = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

        if (valueType == dayValue) { // 今日
            String[] dayValues = new String[7];
            long currentTime = System.currentTimeMillis();
            for (int i = 6; i >= 0; i--) {
                dayValues[i] = TimeUtils.dateToString(currentTime, TimeUtils.dateFormat_day);
                currentTime -= (3 * 60 * 60 * 1000);
            }
            return dayValues;

        } else if (valueType == weekValue) { // 本周
            String[] weekValues = new String[7];
            Calendar calendar = Calendar.getInstance();
            int currentWeek = calendar.get(Calendar.DAY_OF_WEEK);

            for (int i = 6; i >= 0; i--) {
                weekValues[i] = week[currentWeek - 1];
                if (currentWeek == 1) {
                    currentWeek = 7;
                } else {
                    currentWeek -= 1;
                }
            }
            return weekValues;

        } else if (valueType == monthValue) { // 本月
            String[] monthValues = new String[7];
            long currentTime = System.currentTimeMillis();
            for (int i = 6; i >= 0; i--) {
                monthValues[i] = TimeUtils.dateToString(currentTime, TimeUtils.dateFormat_month);
                currentTime -= (4 * 24 * 60 * 60 * 1000);
            }
            return monthValues;
        }
        return new String[]{};
    }

    /**
     * 曲线赋值与设置
     *
     * @param context
     *            上下文
     * @param xDataList
     *            x轴数据
     * @param yDataList
     *            y轴数据
     * @return LineData
     */
    private static LineData setLineData(Context context, List<String> xDataList, List<Entry> yDataList,
                                        String curveLable) {
        // LineDataSet表示一条曲线数据对象
        ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yDataList, curveLable);
        // mLineDataSet.setFillAlpha(110);
        // mLineDataSet.setFillColor(Color.RED);
        // 用y轴的集合来设置参数
        // 不显示坐标点的数据
        lineDataSet.setDrawValues(false);
        // 显示坐标点的小圆点
        lineDataSet.setDrawCircles(true);
        // 定位线
        lineDataSet.setHighlightEnabled(true);
        // 线宽
        lineDataSet.setLineWidth(2.0f);
        // 显示的圆形大小
        lineDataSet.setCircleSize(4f);
        // 显示颜色
        lineDataSet.setColor(context.getApplicationContext().getResources().getColor(R.color.bg_blue));
        // 圆形的颜色
        lineDataSet.setCircleColor(context.getApplicationContext().getResources().getColor(R.color.bg_blue));
        // 高亮的线的颜色
        lineDataSet.setHighLightColor(context.getApplicationContext().getResources()
                .getColor(R.color.text_yellow));
        // 设置坐标点的颜色
        lineDataSet.setFillColor(context.getApplicationContext().getResources().getColor(R.color.bg_blue));
        // 设置坐标点为空心环状
        lineDataSet.setDrawCircleHole(false);
        // lineDataSet.setValueTextSize(9f);
        lineDataSet.setFillAlpha(65);
        // 设置显示曲线和X轴围成的区域阴影
        lineDataSet.setDrawFilled(true);
        // 坐标轴在左侧
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        // 设置每条曲线图例标签名
        // lineDataSet.setLabel("标签");
        lineDataSet.setValueTextSize(14f);
        // 曲线弧度（区间0.05f-1f，默认0.2f）
        lineDataSet.setCubicIntensity(0.2f);
        // 设置为曲线显示,false为折线
        lineDataSet.setDrawCubic(true);
        lineDataSets.add(lineDataSet);
        // y轴的数据
        LineData lineData = new LineData(xDataList, lineDataSets);
        return lineData;
    }

}

/**
 * 自定义图表的MarkerView(点击坐标点，弹出提示框)
 */
class CustomMarkerView extends MarkerView {

    private TextView tvContent;
    private String unitName;
    /**
     *
     * @param context
     *            上下文
     * @param layoutResource
     *            资源文件
     * @param unitName
     *            Y轴数值计量单位名称
     */
    public CustomMarkerView(Context context, int layoutResource, final String unitName) {
        super(context, layoutResource);
        // 显示布局中的文本框
        tvContent = (TextView) findViewById(R.id.txt_tips);
        this.unitName = unitName;
    }

    // 每次markerview回调重绘，可以用来更新内容
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        // 设置Y周数据源对象Entry的value值为显示的文本内容
        tvContent.setText("" + e.getVal()+unitName);
    }

    @Override
    public int getXOffset(float xpos) {
        // 水平居中
        return -(getWidth() / 2);
    }

    @Override
    public int getYOffset(float ypos) {
        // 提示框在坐标点上方显示
        return -getHeight();
    }

    public static BarChart initBarChart(LineChart chart, List<Entry> values){
        //创建条形数据对象
        BarChart barChart = new BarChart(this);
        setContentView(barChart);
       //设置条形数据
        barChart.setData(getBarData());
       //设置描述
        barChart.setDescription("");
      //设置绘制bar的阴影
        barChart.setDrawBarShadow(true);
        //设置绘制的动画时间
        barChart.animateXY(3000,3000);
        return barChart;

    }

    public BarData getBarData() {
        int maxX = 10;
        //创建集合，存放每个柱子的数据
        List<BarEntry> list = new ArrayList<>();
        List<BarEntry> list2 = new ArrayList<>();
        for (int i = 0; i < maxX; i++) {
            //一个BarEntry就是一个柱子的数据对象
            BarEntry barEntry = new BarEntry(i + 5, i);
            list.add(barEntry);
            BarEntry barEntry2 = new BarEntry(i + 3, i);
            list2.add(barEntry2);
        }
        //创建BarDateSet对象，其实就是一组柱形数据
        BarDataSet barSet = new BarDataSet(list, "Android");
        BarDataSet barSet2 = new BarDataSet(list2, "iOS");
        //设置柱形的颜色
        barSet.setColor(Color.BLUE);
        //设置是否显示柱子上面的数值
        barSet.setDrawValues(false);
        //设置柱子阴影颜色
        barSet.setBarShadowColor(Color.GRAY);
        //创建集合，存放所有组的柱形数据
        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barSet);
        dataSets.add(barSet2);
        BarData barData = new BarData(ChartData.generateXVals(0, maxX), dataSets);
        return barData;
    }

<<<<<<< HEAD
    /**

     *初始化环状统计表

     *@paramChart 环状统计图控件

     *@parampieData 填充统计图的数据对象

     */

    public static PieChart initPieChart(PieChart pieChart, PieData pieData){
        pieChart.setUsePercentValues(true);

        pieChart.setDescription("");  //设置描述信息

        pieChart.setExtraOffsets(5,10,5,5);  //设置间距

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setCenterTextTypeface(mTfLight);  //设置饼状图中间文字字体

        pieChart.setCenterText("");  //设置饼状图中间文字，我需求里面并没有用到这个。。

        pieChart.setDrawHoleEnabled(true);

        pieChart.setHoleColor(Color.WHITE);

        pieChart.setTransparentCircleColor(Color.WHITE);

        pieChart.setTransparentCircleAlpha(110);

        pieChart.setHoleRadius(58f);

        pieChart.setTransparentCircleRadius(61f);

        pieChart.setTouchEnabled(false);  //设置是否响应点击触摸

        pieChart.setDrawCenterText(true);  //设置是否绘制中心区域文字

        pieChart.setDrawEntryLabels(false);  //设置是否绘制标签

        pieChart.setRotationAngle(0); //设置旋转角度

        pieChart.setRotationEnabled(true); //设置是否旋转

        pieChart.setHighlightPerTapEnabled(false);  //设置是否高亮显示触摸的区域

        pieChart.setData(pieData);  //设置数据

        pieChart.setOnChartValueSelectedListener(this); //设置选中监听

        pieChart.setDrawMarkerViews(false);  //设置是否绘制标记

        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);  //设置动画效果
        return pieChart;
    }

}
