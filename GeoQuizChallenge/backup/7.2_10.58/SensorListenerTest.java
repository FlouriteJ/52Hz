package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;

import android.content.Context;
import android.widget.EditText;

public class SensorListenerTest extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor gyroscope; // 陀螺仪
    private Sensor accelerometer;  // 加速计
    private Sensor magnetometer; // 磁场传感器

    private float mLastX, mLastY, mLastZ;

    private Context mContext;
    private FileOutputStream out_stream;

    private EditText output_sample;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    private static  String data="";
    private int lasttimelength=0;

    public SensorListenerTest(Context context) {
        mContext = context;
        // 在构造函数里面注册Sensor服务
        //enableSensor();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //out_stream = new FileOutputStream("test.txt", true);
        output_sample = findViewById(R.id.output_sample);

        verifyStoragePermissions(this);
        // 在SD卡目录下创建文件
        createFile("test.txt");
        createFile("test2.txt");
    }

    // 注册传感器服务，在本java和Activity里面都要注册，但是取消注册的时候，只在activity里面取消注册即可。
    public void enableSensor() {
        // 在这里真正注册Service服务
        mSensorManager = (SensorManager) mContext
                .getSystemService(Context.SENSOR_SERVICE);

        gyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE); // 陀螺仪
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); // 加速计
        magnetometer =  mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD); // 磁场传感器

        if (mSensorManager == null) {
            Log.v("传感器 -- 陀螺仪", "没有发现该传感器 -- 陀螺仪 -- ");
        }

        mSensorManager.registerListener(this, gyroscope,
                SensorManager.SENSOR_DELAY_FASTEST); // 最快速度获取数据

        mSensorManager.registerListener(this, accelerometer,
                SensorManager.SENSOR_DELAY_FASTEST); // 最快速度获取数据
        mSensorManager.registerListener(this, magnetometer,
                SensorManager.SENSOR_DELAY_FASTEST); // 最快速度获取数据
    }

    // 取消注册传感器服务
    public void disableSensor() {
        if (mSensorManager != null) {
            mSensorManager.unregisterListener(this);
            mSensorManager = null;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // TODO Auto-generated method stub
        if (event.sensor == null) {
            return;
        }

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            
            mLastX = event.values[0];
            mLastY = event.values[1];
            mLastZ = event.values[2];

            String sX = String.valueOf(mLastX);
            String sY = String.valueOf(mLastY);
            String sZ = String.valueOf(mLastZ);

            String SensorTime = String.valueOf(System.currentTimeMillis());
            String SensorTime2 = String.valueOf(event.timestamp);

            Log.i("gyroscope==", sX + "||" + sY+ "||"+ sZ + "||" + SensorTime + "||" + SensorTime2);

            String sensordata="gyroscope||"+sX+"||" + sY+"||"+ sZ+"||"+SensorTime+"||"+SensorTime2+"\n";

            //写文件部分

            data+=sensordata; //要写入的数据
            
            //writeappend(mContext,"test2.txt",sensordata);
            if(data.length()>=(lasttimelength+1000))//数据更新频率
            {
                lasttimelength=data.length();//每增加1000个文件更新一次
                try {
                    writeExternal(mContext,"test.txt",data);
                } catch (IOException e) {
                    verifyStoragePermissions(this);
                    e.printStackTrace();
                }
            }
        }
        else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            mLastX = event.values[0];
            mLastY = event.values[1];
            mLastZ = event.values[2];

            String sX = String.valueOf(mLastX);
            String sY = String.valueOf(mLastY);
            String sZ = String.valueOf(mLastZ);

            String SensorTime = String.valueOf(System.currentTimeMillis());
            String SensorTime2 = String.valueOf(event.timestamp);

            Log.i("accelerometer==", sX + "||" + sY+ "||"+ sZ + "||" + SensorTime + "||" + SensorTime2);

            String sensordata="accelerometer||"+sX+"||" + sY+"||"+ sZ+"||"+SensorTime+"||"+SensorTime2+"\n";

            //写文件部分

            data+=sensordata; //要写入的数据


            //writeappend(mContext,"test2.txt",sensordata);
            if(data.length()>=(lasttimelength+1000))//数据更新频率
            {
                lasttimelength=data.length();//每增加1000个文件更新一次
                try {
                    writeExternal(mContext,"test.txt",data);
                } catch (IOException e) {
                    verifyStoragePermissions(this);
                    e.printStackTrace();
                }
            }
        }
        else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {

            mLastX = event.values[0];
            mLastY = event.values[1];
            mLastZ = event.values[2];

            String sX = String.valueOf(mLastX);
            String sY = String.valueOf(mLastY);
            String sZ = String.valueOf(mLastZ);

            String SensorTime = String.valueOf(System.currentTimeMillis());
            String SensorTime2 = String.valueOf(event.timestamp);

            Log.i("magnetometer==", sX + "||" + sY+ "||"+ sZ + "||" + SensorTime + "||" + SensorTime2);

            String sensordata="magnetometer||"+sX+"||" + sY+"||"+ sZ+"||"+SensorTime+"||"+SensorTime2+"\n";

            //写文件部分

            data+=sensordata; //要写入的数据


            //writeappend(mContext,"test2.txt",sensordata);
            if(data.length()>=(lasttimelength+1000))//数据更新频率
            {
                lasttimelength=data.length();//每增加1000个文件更新一次
                try {
                    writeExternal(mContext,"test.txt",data);
                } catch (IOException e) {
                    verifyStoragePermissions(this);
                    e.printStackTrace();
                }
            }
        }

    }


    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将内容写入sd卡中
     * @param filename 要写入的文件名
     * @param content  待写入的内容
     * @throws IOException
     */
    public static void writeExternal(Context context, String filename, String content) throws IOException {

        //获取外部存储卡的可用状态
        String storageState = Environment.getExternalStorageState();

        //判断是否存在可用的的SD Card
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {

            //路径： /storage/emulated/0/Android/data/com.yoryky.demo/cache/yoryky.txt
            filename = context.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath()  + File.separator + filename;

            FileOutputStream outputStream = new FileOutputStream(filename);
            outputStream.write(content.getBytes());
            outputStream.close();
        }
    }

    /**
     * 追加文件：使用FileWriter
     *
     * @param filename
     * @param content
     */
    public static void writeappend(Context context,String filename, String content)
    {
        FileWriter writer = null;
        //获取外部存储卡的可用状态
        String storageState = Environment.getExternalStorageState();

        //判断是否存在可用的的SD Card
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {

            //路径： /storage/emulated/0/Android/data/com.yoryky.demo/cache/yoryky.txt
            filename = context.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + filename;

            try {
                // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
                writer = new FileWriter(filename, true);
                writer.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void createFile(String filename)
    {
        File file = new File(mContext.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath()  , filename);
        Log.d("TAG=", "file.exists():" + file.exists() + " file.getAbsolutePath():"+ file.getAbsolutePath());
        if (!file.exists()) {
            //file.delete();
            try {
                file.createNewFile();
                Log.d("TAG=", "SD卡目录下创建文件成功...");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("TAG=", "SD卡目录下创建文件失败...");
            }

        }
        else
        {
            //
        }

    }

}