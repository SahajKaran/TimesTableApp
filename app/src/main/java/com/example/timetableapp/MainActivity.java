package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTable=(ListView) findViewById(R.id.list);

    public void generateTimesTable(int timeTablesNumber){

        ArrayList<String> timeTableContent=new ArrayList<String>();
        for (int j=0; j<=10; j++){
            timeTableContent.add(Integer.toString(j*timeTablesNumber));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timeTableContent);
        timesTable.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar=(SeekBar)findViewById(R.id.seek);
        timesTable=(ListView) findViewById(R.id.list);
        int max=20;
        int startingPosition=10;
        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timeTablesNumber;

                if(i<min){
                    timeTablesNumber=min;
                    seekBar.setProgress(min);
                }else{
                    timeTablesNumber= i;
                }
                Log.i("Seekbar value",Integer.toString(timeTablesNumber));

                generateTimesTable(timeTablesNumber);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}