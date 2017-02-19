package com.example.android.bluetoothchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        // Create battery current graph
        GraphView batteryGraph = (GraphView) findViewById(R.id.batteryGraph);
        LineGraphSeries<DataPoint> batterySeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        batteryGraph.addSeries(batterySeries);

        // Create solarpanel current graph
        GraphView solarGraph = (GraphView) findViewById(R.id.solarGraph);
        LineGraphSeries<DataPoint> solarSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        solarGraph.addSeries(solarSeries);

    }
    public void returnToHomepage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
