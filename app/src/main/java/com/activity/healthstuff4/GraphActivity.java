package com.activity.healthstuff4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

   // LineChart lineChart;
    LineGraphSeries<DataPoint> series;
    private float x;
    DailyLogUpdates dlu;
    Float fCals, fMeals,fDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        double y,x;
        x = 5.0;
        GraphView graph = (GraphView) findViewById(R.id.LineGraph);
        series = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < 10; i++)
        {
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y),true,10);
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                /*     new DataPoint(2, 3),*/
                /*         new DataPoint(3, 2),*/
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

    }

}