package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private Button start;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private TextView displayText;
    private TextView state_program;

    public boolean startListen = false;

    // 用于持续执行获取传感器信息的任务 貌似没啥用了
    private final Timer timer = new Timer();
    private Handler handler = new Handler();
    public FileOutputStream out_stream;

    SensorListenerTest sensorListenerTest;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    private static  String data="";
    private  static String btndatafile="btndata.txt";
    private int lasttimelength=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        sensorListenerTest = new SensorListenerTest(this);

        displayText = (TextView)findViewById(R.id.text_output);

        state_program = (TextView)findViewById(R.id.STATE);

        start = (Button) findViewById(R.id.start);
        start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    sensorListenerTest.enableSensor();
                    displayText.setText("开始监听");
                    state_program.setText("The program is running");
                    startListen = true;
                }
                return false;
            }
        });

        one = (Button) findViewById(R.id.one);

        one.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了1");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||1||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了1");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||1||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        two = (Button) findViewById(R.id.two);

        two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了2");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||2||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了2");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||2||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 3
        three = (Button) findViewById(R.id.three);

        three.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了3");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||3||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了3");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||3||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 4
        four = (Button) findViewById(R.id.four);

        four.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了4");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||4||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了4");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||4||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 5
        five = (Button) findViewById(R.id.five);

        five.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了5");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||5||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了5");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||5||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 6
        six = (Button) findViewById(R.id.six);

        six.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了6");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||6||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了6");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||6||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 7
        seven = (Button) findViewById(R.id.seven);

        seven.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了7");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||7||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了7");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||7||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 8
        eight = (Button) findViewById(R.id.eight);

        eight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了8");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||8||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了8");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||8||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 9
        nine = (Button) findViewById(R.id.nine);

        nine.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了9");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||9||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了9");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||9||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        // 0
        zero = (Button) findViewById(R.id.zero);

        zero.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    displayText.setText("你抬起了了0");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||0||ACTION_UP||" + EventTime + "||" + EventTme2 + "\n");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    displayText.setText("你摁下了0");
                    String EventTime = String.valueOf(System.currentTimeMillis());
                    String EventTme2 = String.valueOf(event.getEventTime());
                    writedata("ButttonData||0||ACTION_DOWN||" + EventTime + "||" + EventTme2 + "\n");
                }
                return false;
            }
        });

        verifyStoragePermissions(this);
        // 在SD卡目录下创建文件
        //createFile("test.txt");
        //createFile("test2.txt");
        createFile(btndatafile);
    }

    @Override
    protected void onStart(){
        super.onStart();

        Runnable task =new Runnable() {
            public void run() {

                //handler.postDelayed(this,5*1000);//设置延迟时间，此处是5秒
                if(startListen){
                    state_program.setText("The program is running");
                }
                else{
                    state_program.setText("The program is waiting");
                }
            }
        };
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                //Log.i("===  时间  ===", "" + System.currentTimeMillis());
//                // 循环获得数据
//            }
//        };

//        timer.schedule(timerTask,
//                5 * 1000,//延迟5秒执行
//                1);//周期为1秒

        handler.post(task);//立即调用

    }

    @Override
    protected void onResume() {
        // 监听服务，在activity和Listener里面都要注册，这是一个难点。不要只在一个地方注册。
        // TODO Auto-generated method stub
        super.onResume();
        //sensorListenerTest.enableSensor();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        sensorListenerTest.disableSensor();
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
        File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath()  , filename);
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
    public void writedata(String data)
    {
        ///String sensordata="SensorData||"+sX+"||" + sY+"||"+ sZ+"||"+SensorTime+"||"+SensorTime2+"\n";

        //写文件部分

        //data+=sensordata; //要写入的数据


        writeappend(this,btndatafile,data);
        /*
        try {
            writeExternal(this,filename,data);
        } catch (IOException e) {
            verifyStoragePermissions(this);
            e.printStackTrace();
        }
        */

    }

}
