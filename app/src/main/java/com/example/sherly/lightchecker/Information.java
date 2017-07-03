package com.example.sherly.lightchecker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Information extends AppCompatActivity implements SensorEventListener{

    TextView tvStatus, tvCurrentLight, tvRequiredLight, tvInfo;
    ImageView image;
    RelativeLayout rl1;
    private SensorManager sensorManager;
    ArrayList<LightLevelModel> lightLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvStatus = (TextView) findViewById(R.id.statuscahaya);
        tvCurrentLight = (TextView) findViewById(R.id.currentlight);
        tvRequiredLight = (TextView) findViewById(R.id.requiredlight);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        image = (ImageView) findViewById(R.id.imageinformation);
        rl1 = (RelativeLayout) findViewById(R.id.rl1);

        Bundle bundle = getIntent().getExtras();
        String room = bundle.getString("roomname");
        setTitle(room);

        DatabaseHandler db = new DatabaseHandler(this);
        lightLevel = db.readMinMaxLight(room);

        tvRequiredLight.setText("Required Light : "+String.valueOf(lightLevel.get(0).getLight_min())+" - "+String.valueOf(lightLevel.get(0).getLight_max())+" lx");
        //Toast.makeText(Information.this, String.valueOf(lightLevel.get(0).getLight_max()), Toast.LENGTH_SHORT).show();

        //create instance of sensor manager and get system service to interact with Sensor
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null){
            Toast.makeText(Information.this,"No Light Sensor Found! ",Toast.LENGTH_LONG).show();
        }
        else {
            //float max =  lightSensor.getMaximumRange();
            //Get Maximum Value From Light sensor
            //tvMaxValue.setText("Max Range : " + String.valueOf(max));
            sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the lightSensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT) {
            float currentLight = sensorEvent.values[0];
            if (currentLight == 0) {
                image.setImageDrawable(getResources().getDrawable(R.drawable.nolight));
                tvStatus.setText("NO LIGHT");
                tvInfo.setText("There is no light in this room.");
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));
                tvStatus.setTextColor(getResources().getColor(R.color.white));
                tvInfo.setTextColor(getResources().getColor(R.color.white));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.white));
                tvRequiredLight.setTextColor(getResources().getColor(R.color.white));
                rl1.setBackgroundColor(getResources().getColor(R.color.black));
            } else if (currentLight < lightLevel.get(0).getLight_min()) {
                image.setImageDrawable(getResources().getDrawable(R.drawable.dim));
                tvStatus.setText("DIM");
                tvInfo.setText("The light is too dim for this room.");
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));
                tvStatus.setTextColor(getResources().getColor(R.color.white));
                tvInfo.setTextColor(getResources().getColor(R.color.white));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.white));
                tvRequiredLight.setTextColor(getResources().getColor(R.color.white));
                rl1.setBackgroundColor(getResources().getColor(R.color.color4));
            } else if (currentLight > lightLevel.get(0).getLight_max()) {
                image.setImageDrawable(getResources().getDrawable(R.drawable.bright));
                tvStatus.setText("BRIGHT");
                tvInfo.setText("The light is too bright for this room.");
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));
                tvStatus.setTextColor(getResources().getColor(R.color.black));
                tvInfo.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.black));
                tvRequiredLight.setTextColor(getResources().getColor(R.color.black));
                rl1.setBackgroundColor(getResources().getColor(R.color.color5));
            } else {
                image.setImageDrawable(getResources().getDrawable(R.drawable.normal));
                tvStatus.setText("NORMAL");
                tvInfo.setText("The light is perfect for this room.");
                tvCurrentLight.setText("Current light : " + String.valueOf(currentLight));
                tvStatus.setTextColor(getResources().getColor(R.color.black));
                tvInfo.setTextColor(getResources().getColor(R.color.black));
                tvCurrentLight.setTextColor(getResources().getColor(R.color.black));
                tvRequiredLight.setTextColor(getResources().getColor(R.color.black));
                rl1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
