package com.example.android.bluetoothchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GraphActivity extends Activity {
    private static LineGraphSeries<DataPoint> batterySeries;
    private static GraphView batteryGraph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        // Create battery current graph
        batteryGraph = (GraphView) findViewById(R.id.batteryGraph);
        batterySeries = new LineGraphSeries<>(new DataPoint[] {
        });
        batteryGraph.addSeries(batterySeries);
        StaticLabelsFormatter staticLabelsFormatterBattery = new StaticLabelsFormatter(batteryGraph);
        staticLabelsFormatterBattery.setHorizontalLabels(new String[] {"", "Batteri",""});
        batteryGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatterBattery);


        // Create solarpanel current graph
        GraphView solarGraph = (GraphView) findViewById(R.id.solarGraph);
        LineGraphSeries<DataPoint> solarSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        solarGraph.addSeries(solarSeries);
        StaticLabelsFormatter staticLabelsFormatterSolar = new StaticLabelsFormatter(solarGraph);
        staticLabelsFormatterSolar.setHorizontalLabels(new String[] {"", "Solpanel",""});
        solarGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatterSolar);
    }
    public void returnToHomepage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public static void updateData(ArrayList<Integer> dataStream)
    {
        if(batterySeries != null)
        batterySeries.resetData(new DataPoint[]{new DataPoint(0,0)});


        Calendar initialCal = Calendar.getInstance();
        initialCal.set(dataStream.get(0)+2017,dataStream.get(1),dataStream.get(2),dataStream.get(3),0);
        Date initialDate = initialCal.getTime();

        Log.d("CREATION","Size of dataList:"+ Integer.toString(dataStream.size()));
        for(int i =0; i<dataStream.size()/10; i++)
        {
            Calendar cal = Calendar.getInstance();
            cal.set(dataStream.get(i*10)+2017,dataStream.get(i*10),dataStream.get(i*10+1),dataStream.get(i*10+2),0);
            Date date = cal.getTime();
            int datePoint =(int)((date.getTime()-initialDate.getTime())/(3600000));
            Log.d("CREATION",Long.toString(date.getTime()));
            Log.d("CREATION",Long.toString(initialDate.getTime()));
            Log.d("CREATION",Integer.toString(datePoint));
            int lightSensValue = dataStream.get(i*10+4);
            int potValue = dataStream.get(i*10+5);
            int solarAmp = dataStream.get(i*10+6);
            int solarVolt = dataStream.get(i*10+7);
            int batteryAmp = dataStream.get(i*10+8);
            int batteryVolt = dataStream.get(i*10+9);
            Log.d("CREATION", Integer.toString(dataStream.get(i*10)));
            Log.d("CREATION", Integer.toString(dataStream.get(i*10+1)));
            Log.d("CREATION", Integer.toString(dataStream.get(i*10+2)));
            Log.d("CREATION", Integer.toString(dataStream.get(i*10+3)));
            Log.d("CREATION", "New packet");
            //batterySeries.appendData(new DataPoint(datePoint,solarAmp), false,10000);
        }




    }

}
