package com.bignerdranch.android.geoquiz;

import android.os.Debug;
import android.provider.ContactsContract;
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

import java.io.FileOutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

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

    // 用于持续执行获取传感器信息的任务 貌似没啥用了
    private final Timer timer = new Timer();
    public FileOutputStream out_stream;

    SensorListenerTest sensorListenerTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        sensorListenerTest = new SensorListenerTest(this);
        //out_stream = new FileOutputStream("test.txt", true);

        displayText = (TextView)findViewById(R.id.text_output);
        // displayText.setText("onCreat");

        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // One Button!
                displayText.setText("你摁下了1");
            }
        });

        one.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了了1");
                return true;
            }
        });

        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了2");
            }
        });

        two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了2");
                return true;
            }
        });

        // 3
        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了3");
            }
        });

        three.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了3");
                return true;
            }
        });

        // 4
        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了4");
            }
        });

        four.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了4");
                return true;
            }
        });

        // 5
        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了5");
            }
        });

        five.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了5");
                return true;
            }
        });

        // 6
        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了6");
            }
        });

        six.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了6");
                return true;
            }
        });

        // 7
        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了7");
            }
        });

        seven.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了7");
                return true;
            }
        });

        // 8
        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了8");
            }
        });

        eight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了8");
                return true;
            }
        });

        // 9
        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayText.setText("你摁下了9");
            }
        });

//        nine.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event){
//                //displayText.setText("你抬起了9");
//                return true;
//            }
//        });

        // 0
        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //displayText.setText("你摁下了0");
            }
        });

        zero.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
                displayText.setText("你抬起了0");
                return true;
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //Log.i("===  时间  ===", "" + System.currentTimeMillis());
                // 循环获得数据
            }
        };

//        timer.schedule(timerTask,
//                5 * 1000,//延迟5秒执行
//                1);//周期为1秒

    }

    @Override
    protected void onResume() {
        // 监听服务，在activity和Listener里面都要注册，这是一个难点。不要只在一个地方注册。
        // TODO Auto-generated method stub
        super.onResume();
        sensorListenerTest.enableSensor();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        sensorListenerTest.disableSensor();
    }
}
