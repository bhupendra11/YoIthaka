package yoithaka.bhupendrashekhawat.me.android.yoithaka;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, Integer> thailandTrends= new HashMap<String, Integer>();

        thailandTrends.put("Scuba", 1200);
        thailandTrends.put("Thai massage ", 1400);
        thailandTrends.put("Hotel booking", 900);


        BubbleChart chart;
        BubbleData data;

        chart = (BubbleChart) findViewById(R.id.thai_trends_chart);

        ArrayList<BubbleEntry> entries = new ArrayList<>();

        //Define the labels
        ArrayList<String> labels = new ArrayList<>();


        entries.add(new BubbleEntry(0,1200,1200 ,"Scuba"));
        entries.add(new BubbleEntry(1,1400,1400, "Thai massage"));
        entries.add(new BubbleEntry(2,900,900, "Hotel booking"));


        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMaxValue(1600);
        leftAxis.setAxisMinValue(500);
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setAxisMaxValue(1600);
        rightAxis.setAxisMinValue(500);



        labels.add("Scuba");
        labels.add("Thai massage");
        labels.add("Hotel booking");


        //Create the dataSet
        BubbleDataSet dataset = new BubbleDataSet(entries,"Trends");



        //Create the chart



        // Fill chart with data
        data = new BubbleData(labels, dataset);
        chart.setData(data);

        //Add description to the chart
        chart.setDescription("Major trends in Thailand");

        chart.setBackgroundColor(Color.parseColor("#ffffff"));

        //Add a set of colors to chart
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        //Animate the chart
        chart.animateX(1000);
        chart.animateY(1000);










    }
}
