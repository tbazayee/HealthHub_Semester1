package com.example.cesar.healthhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class SendHeartBeat extends AppCompatActivity {

    private double x;
    private double y;
    private double z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_heart_beat);
    }

    public void onGenrateData(View v)
    {
        int start  = -1;
        int end = 3;
        //------ Genrate Vaues ---------
        double random = new Random().nextDouble();
        x = start + (random * (end - start));


        //--- Show in label -------
        TextView Xlable = (TextView)findViewById(R.id.XvalueLabel);
        Xlable.setText(x+"");



    }
}
