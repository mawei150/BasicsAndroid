package com.example.basicsandroid.activity.chart;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.SeekBar;


import com.example.basicsandroid.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class PiePolylineChartActivity extends DemoBase implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {


    private PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pie_polyline_chart);

        setTitle("PiePolylineChartActivity");


        chart = findViewById(R.id.chart1);
        chart.setUsePercentValues(true);//设置是否使用百分比
        chart.getDescription().setEnabled(false);//设置描述
        chart.setExtraOffsets(5, 10, 5, 5);//设置饼状图的大小

        chart.setDragDecelerationFrictionCoef(0.95f);//拖动降速速率

        //设置文体大小
        chart.setEntryLabelColor(getResources().getColor(R.color.colorPrimary));
        chart.setEntryLabelTextSize(11f);

        chart.setExtraOffsets(20.f, 0.f, 20.f, 0.f);//更改饼图大小
        chart.setDrawHoleEnabled(true);//设置是否启用空洞，默认为true
        chart.setHoleColor(Color.WHITE);
        chart.setHoleRadius(58f);
        chart.setTransparentCircleColor(Color.WHITE);//半透明圆
        chart.setTransparentCircleAlpha(110);
        chart.setTransparentCircleRadius(61f);

        chart.setDrawCenterText(true);//设置是否绘制中间文本，默认为true
        chart.setCenterText(generateCenterSpannableText());//设置中间文本


        // enable rotation of the chart by touch
        chart.setRotationEnabled(true);//是否可以旋转
        chart.setRotationAngle(0);//设置旋转角度
        chart.setHighlightPerTapEnabled(true);

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        chart.setOnChartValueSelectedListener(this);//饼图的点击事件


        chart.animateY(1400, Easing.EaseInOutQuad);//设置动画
        // chart.spin(2000, 0, 360);

        Legend l = chart.getLegend();//图例设置
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l.setTextColor(Color.RED);
        l.setDrawInside(false);

        l.setEnabled(true);

        setData(3, 20);//设置数据  重点
    }


    //设置饼图数据源
    private void setData(int count, float range) {

        ArrayList<PieEntry> entries = new ArrayList<>();
        String HDFCount = "78";
        String HDCount = "118";
        String OthersCount = "6";


        String HDF = "HDF\n" + HDFCount + "位患者";
        String HD = "HD\n" + HDCount + "位患者";
        String Others = "其他\n" + OthersCount + "位患者";

        SpannableString s = new SpannableString(HDF);
        s.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, 3, 0);

        SpannableString s1 = new SpannableString(HD);
        s1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, 1, 0);

        SpannableString s2 = new SpannableString(Others);
        s2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, 4, 0);

        entries.add(new PieEntry(78, "HDF" + "\n" + HDFCount + "位患者", "wwwwwwwwwww"));
        entries.add(new PieEntry(118, "其他\n" + OthersCount + "位患者", "22222222"));
        entries.add(new PieEntry(6, "其他\n" + OthersCount + "位患者", "2222222"));


        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#FC78B2"));
        colors.add(Color.parseColor("#0AC693"));
        colors.add(Color.parseColor("#FF17E5E5"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(3f);//设置饼块之间的间隔
        dataSet.setSelectionShift(5f);//设置饼块选中时偏离饼图中心的距离

        dataSet.setColors(colors);


        dataSet.setValueLinePart1OffsetPercentage(70.f);//数据连接线距图形片内部边界的距离，为百分数
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);

//        dataSet.setValueLineColor(Color.BLUE);//设置连接线的颜色
        dataSet.setUsingSliceColorAsValueLineColor(true);//设置Y轴描述线和填充区域的颜色一致

        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);


        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(chart));

        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);

//        data.setValueTypeface(tf);data
        chart.setData(data);

        // undo all highlights
        chart.highlightValues(null);

//        chart.setDrawValues(false);   5

        chart.setDrawSliceText(false);
        chart.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.pie, menu);
        return true;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//        tvX.setText(String.valueOf(seekBarX.getProgress()));
//        tvY.setText(String.valueOf(seekBarY.getProgress()));

//        setData(seekBarX.getProgress(), seekBarY.getProgress());
    }

    @Override
    protected void saveToGallery() {
        saveToGallery(chart, "PiePolylineChartActivity");
    }

    private SpannableString generateCenterSpannableText() {
        String count = "235";

        SpannableString s = new SpannableString("当前在透\n" + count);
        s.setSpan(new RelativeSizeSpan(0.85f), 0, 4, 0);//设置文字相对大小
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, 4, 0);//设置字体风格
        s.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, 4, 0);


        s.setSpan(new RelativeSizeSpan(1.65f), 4, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.BOLD), 4, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 4, s.length(), 0);


        return s;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getY() + ", xIndex: " + e.getX()
                        + ", DataSet index: " + h.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
