package com.example.tony.ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/**
 * Created by Tony on 2016/6/16.
 */
public class DrawView extends View {
    private final Context context;
    private int centerPointX = 300;
    private int centerPointY = 300;

    private Canvas canvas;
    private Paint p;
    public DrawView(Context context) {
        super(context);
        this.context = context;
    }
    public void setCenterPointX(int x) {
        this.centerPointX = x;
    }

    public int getCenterPointX() {
        return this.centerPointX;
    }

    public void setCenterPointY(int y) {
        this.centerPointY = y;
    }

    public int getCenterPointY() {
        return this.centerPointY;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        //创建画笔
        p = new Paint();
        p.setColor(Color.GREEN);

//        canvas.drawCircle(300, 600, 50, p);
//        p.setAntiAlias(false);// 设置画笔的锯齿效果。 true是去除，大家一看效果就明白了
        canvas.drawCircle(centerPointX, centerPointY, 60, p);

/*        canvas.drawText("画矩形：", 10, 80, p);
        p.setColor(Color.GRAY);// 设置灰色
        p.setStyle(Paint.Style.FILL);//设置填满
        canvas.drawRect(60, 60, 80, 80, p);// 正方形
        canvas.drawRect(60, 90, 160, 100, p);// 长方形
*/
/*
        // 设置渐变色
        Shader mShader = new LinearGradient(10, 50, 200, 50,
                new int[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
                        Color.LTGRAY }, null, Shader.TileMode.REPEAT);
        p.setShader(mShader);
        //一个长方形
        RectF oval2 = new RectF(60, 100, 200, 240);
        //将扇形画在长方形里面
        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线
        canvas.drawArc(oval2, 400, 260, true, p);
        //画椭圆
        oval2.set(410,100,500,260);
        canvas.drawOval(oval2, p);
*/
    }

  //  public void drawCircle(float x,float y,float radius){
   //     canvas.drawCircle(x, y, radius, p);
    //    //invalidate();
   // }
}
