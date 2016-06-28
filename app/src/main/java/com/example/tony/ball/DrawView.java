package com.example.tony.ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Tony on 2016/6/20.
 */
public class DrawView extends View {
    private int xMin = 0;
    private int yMin = 0;
    private float ballRadius = 60;
    private float ballX = ballRadius + 50;      //圆心坐标
    private float ballY = ballRadius + 50;      //圆心坐标
    private float ballSpeedX = 20;
    private float ballSpeedY = 10;
    private int ballAlpha;                  //透明度
    private int xMax;               //屏幕尺寸
    private int yMax;               //屏幕尺寸
    private Paint paint;
    moveBall ball;
    ArrayList<moveBall> ballShadow;
    private final int alphaLevel = 10;  //透明度递减
    private final int radiusLevel = 3;  //半径递减
    private final int shadowMaxAlpha = 180;  //影子的最大透明度,为了突出最大的圆（透明度255）

    public DrawView(int xMax, int yMax, Context context) {
        super(context);
        this.xMax = xMax;   //屏幕尺寸
        this.yMax = yMax;
        paint = new Paint();
        paint.setColor(Color.GREEN);
        ballShadow = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //数组里面的ball透明度减少一个等级
        ListIterator<moveBall> moveBallListIterator = ballShadow.listIterator();
        while (moveBallListIterator.hasNext()) {
            moveBall ball = moveBallListIterator.next();
            //突出最头上的圆，其他圆最大透明度180；
            if (ball.alpha > shadowMaxAlpha)
                ball.alpha = shadowMaxAlpha;

            ball.alpha -= alphaLevel;
            ball.radius -= radiusLevel;
            ball.color = Color.DKGRAY;
            //透明度为0的圆删除
            if (ball.alpha <= 0)
                moveBallListIterator.remove();
            if (ball.radius <= 0)
                moveBallListIterator.remove();
        }
    //for循环也能有同样的效果
/*
        for (int i = 0; i < ballShadow.size(); i++) {
            ballShadow.get(i).alpha -= 30;
            if (ballShadow.get(i).alpha < 0) {
                ballShadow.remove(i);
//                Log.e("53", "X ref:" + x.ballX + " ,Y ref:" + x.ballY + " ,alpha: " + x.alpha);
            }
        }
*/

        //最头上的圆不透明
        ballAlpha = 255;
        ball = new moveBall(ballX, ballY, ballRadius, ballAlpha, Color.BLACK);
        //将圆添加到数组中
        ballShadow.add(ball);
        for (moveBall x : ballShadow) {
            x.drawBall(canvas, paint);
        }
        //更新最头上圆的坐标
        update();
        //这里相当于sleep 30ms之后就调用 invalidate
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) { }
        //强制从新绘制,运行一次就会从新调用一次onDraw()函数
        invalidate();
    }

    private void update() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;
        if (ballX + ballRadius > xMax) {
            ballSpeedX = -ballSpeedX;
            ballX = xMax-ballRadius;
        } else if (ballX - ballRadius < xMin) {
            ballSpeedX = -ballSpeedX;
            ballX = xMin+ballRadius;
        }
        if (ballY + ballRadius > yMax) {
            ballSpeedY = -ballSpeedY;
            ballY = yMax - ballRadius;
        } else if (ballY - ballRadius < yMin) {
            ballSpeedY = -ballSpeedY;
            ballY = yMin + ballRadius;
        }
    }
    /*
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        // Set the movement bounds for the ball
        xMax = w-1;
        yMax = h-1;
        Log.e("xMax", "max;" + xMax);
        Log.e("xMax", "max;" + yMax);
    }
    */
}

class moveBall {
    float ballX;
    float ballY;
    float radius;

    int alpha;
    int color;

    moveBall(float ballX, float ballY, float radius, int alpha, int color) {
        this.ballX = ballX;
        this.ballY = ballY;
        this.radius = radius;
        this.alpha = alpha;
        this.color = color;
    }

    public void drawBall (Canvas canvas, Paint paint) {
        //要先设置颜色，再设置透明度，才会有透明的效果
        //否者其他的圆只有一种透明度
        paint.setColor(color);
        paint.setAlpha(alpha);
        canvas.drawCircle(ballX, ballY, radius, paint);
    }
}
