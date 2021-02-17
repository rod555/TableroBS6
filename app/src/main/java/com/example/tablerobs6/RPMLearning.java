package com.example.tablerobs6;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.os.ParcelFileDescriptor.MODE_WORLD_READABLE;

public class RPMLearning {

    private SensorManager mySensorManager;
    private Sensor mySensorAcel;
    private SensorEvent myAcelReader;

    public RPMLearning(Context context) {

        mySensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mySensorAcel = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //mySensorAcel
        //mySensorAcel
        //myAcelReader=  new SensorEvent();
          //      sBody = my
    }




    public void saveAcelData(Context mcoContext, String sBody){

        //File dir = mcoContext.getExternalFilesDir(String);

        //and Context.getExternalCacheDir();

        File dir = new File(mcoContext.getFilesDir(), "mydir");

        if(!dir.exists()){
            dir.mkdir();
        }
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        try {
            File gpxfile = new File(dir, "acceldata"+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"-"+ (Calendar.getInstance().get(Calendar.MONTH)+1) +"-"+Calendar.getInstance().get(Calendar.MONTH) +"_"+Calendar.getInstance().get(Calendar.HOUR_OF_DAY) +
                    Calendar.getInstance().get(Calendar.MINUTE));
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}


