package com.example.tony.ball;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;
import android.graphics.Color;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawView ball = new DrawView(this);
        setContentView(R.layout.activity_main);
        //需要将新建的view添加到布局中才能够显示
        LinearLayout ll = (LinearLayout) findViewById(R.id.root);
        ll.addView(ball);
        Log.e("log", "oncreate------");
        ball.setBackgroundColor(Color.BLACK);
    }

}
