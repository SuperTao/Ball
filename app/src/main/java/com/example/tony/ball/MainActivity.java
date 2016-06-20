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
//    private final int DELAY = 10;
//    int screenWidth;
//    int screenHeight;
//    int ballX;
//    int ballY;
//    //每次像素移动的距离
//    int offsetX = 10;
//    int offsetY = 10;

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

//        DisplayMetrics metric = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metric);
//        screenWidth = metric.widthPixels;  // 屏幕宽度（像素）
//        screenHeight = metric.heightPixels;  // 屏幕高度（像素）
//        Log.e("width", "width" + screenWidth);
//        Log.e("height", "height" + screenHeight);
//        init();
//        /* 在子线程中不能够直接设置ui,需要通过主线程中的handler来处理
//           无论是通过thread.sleep还是timer，都需要通过handler的msg来设置ui
//           这里使用postDelayed（）函数来实现定时器
//         */
//        handler.postDelayed(runable, DELAY);
//    }
//    DrawView view;
//    LinearLayout layout;
//
//    private void init() {
//        layout = (LinearLayout) findViewById(R.id.root);
//        view = new DrawView(this);
////        view.setMinimumHeight(10);
////        view.setMinimumWidth(10);
//        //通知view重绘组件
//        //view.invalidate();
//
//        layout.addView(view);
//    }
//
//    Handler handler = new Handler();
//    Runnable runable = new Runnable() {
//        @Override
//        public void run() {
//            try {
//                handler.postDelayed(this, DELAY);
//                //自己实现的view到底有多大？
//                //使用view.getX(), view.getY()获得的值都是0
////                ballX = (int)view.getX();
////                ballY = (int)view.getY();
//                //调用自己实现的方法来获取值
//                ballX = (int)view.getCenterPointX();
//                ballY = (int)view.getCenterPointY();
//                Log.w("ballX", "ballX = " + ballX);
//                Log.w("ballY", "ballY = " + ballY);
////        view.setMinimumHeight(10);
////        view.setMinimumWidth(10);
//                //通知view重绘组件
//                ballX += offsetX;
//                ballY += offsetY;
///*
//                if (ballX < 60 || (ballX > screenWidth - 60))
//                        offsetX = -offsetX;
//                if (ballY < 60 || (ballY > screenHeight - 60))
//                    offsetY = -offsetY;
//                    */
//
//                if (ballX < 60)
//                    offsetX = 10;
//                else if (ballX > screenWidth - 60)
//                    offsetX = -10;
//                if (ballY < 60)
//                    offsetY = 10;
//                else if (ballY > screenHeight - 60)
//                    offsetY = -10;
//
//                view.setCenterPointX(ballX);
//                view.setCenterPointY(ballY);
//
//                Log.w("ballX", "ballX = " + ballX);
//                Log.w("ballY", "ballY = " + ballY);
//
////                view.drawCircle(ballX, ballY, 60);
//                //对view进行重新绘制, 否者图不会更新
//                view.invalidate();
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Exception ...");
//            }
//        }
//    };
}
