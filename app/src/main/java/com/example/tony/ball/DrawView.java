package com.example.tony.ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;

/**
 * Created by Tony on 2016/6/20.
 */
public class DrawView extends View {
    private int xMin = 0;
    private int yMin = 0;
    private int xMax;
    private int yMax;
    private float ballRadius = 80;
    private float ballX = ballRadius +20;
    private float ballY = ballRadius +40;
    private float ballSpeedX = 10;
    private float ballSpeedY = 6;
    private RectF ballBounds;
    private Paint paint;

    public DrawView(Context context) {
        super(context);
        Log.e("draw", "DrawView:");
        ballBounds = new RectF();
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        ballBounds.set(ballX - ballRadius, ballY - ballRadius, ballX + ballRadius, ballY + ballRadius);
        paint.setColor(Color.GREEN);
        canvas.drawOval(ballBounds, paint);

        update();
        //这里相当于sleep 30ms之后就调用 invalidate
        try {
            Thread.sleep(30);
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
    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        // Set the movement bounds for the ball
        xMax = w-1;
        yMax = h-1;
    }

}
