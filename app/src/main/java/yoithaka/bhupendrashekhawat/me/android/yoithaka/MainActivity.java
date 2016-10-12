package yoithaka.bhupendrashekhawat.me.android.yoithaka;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
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


    private BubbleChart chart;
    private BubbleData data;
    private  BubbleDataSet dataset;

    private ArrayList<Trend> thailandTrends = null;
    private ArrayList<BubbleEntry> entries = null;
    private ArrayList<String> labels = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Here we are creating a list of Trend objects and storing them in arrayList , we can fetch any no. of objects from server
        , then put them in this arraylist and tthe rest of the code will work fine
         */
        thailandTrends = new ArrayList<>();

        thailandTrends.add(new Trend(1200,"Scuba"));
        thailandTrends.add(new Trend(1400,"Thai massage"));
        thailandTrends.add(new Trend(900,"Hotel booking"));
        thailandTrends.add(new Trend(300,"Bungee jumping"));

        //Get the chart view
        chart = (BubbleChart) findViewById(R.id.thai_trends_chart);

        entries = new ArrayList<>();

        //Define the labels
        labels = new ArrayList<>();
        
        for(int i=0; i<thailandTrends.size(); i++){
            Trend currentTrend = thailandTrends.get(i);
            entries.add(new BubbleEntry(i,currentTrend.getCount(),currentTrend.getCount()));
            labels.add(currentTrend.getType());
        }

        // Define the limits of the chart in the Y axis
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMaxValue(Utils.getMaxCount(thailandTrends));
        leftAxis.setAxisMinValue(Utils.getMinCount(thailandTrends));

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setAxisMaxValue(Utils.getMaxCount(thailandTrends));
        rightAxis.setAxisMinValue(Utils.getMinCount(thailandTrends));

        rightAxis.setDrawLabels(false);


        //Create the dataSet
        dataset = new BubbleDataSet(entries,"Trends");

        // Fill chart with data
        data = new BubbleData(labels, dataset);
        chart.setData(data);

        //Add description to the chart
        chart.setDescription(getResources().getString(R.string.trend_bubble_desc));

        chart.setBackgroundColor(ContextCompat.getColor(this,R.color.trendBubbleBackground));

        //Add a set of colors to chart
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setValueTextColor(Color.WHITE);
        dataset.setValueTextSize(8);
        dataset.setLabel("Trend count");

        //Animate the chart
        chart.animateX(1000);
        chart.animateY(1000);

    }
}
