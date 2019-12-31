package com.example.paintart.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.paintart.R;

import java.security.PrivateKey;
import java.util.Random;

public class ShapesView extends View {
    private static final int SQUARE_SIZE_DEF=300;
    private static final int DISTANCE=50;



    public Paint mPaint;
    public static Canvas mCanvas;
    private int mPivotX = 0;
    private int mPivotY = 0;
    private int radius = 60;

    private int mSqureColor;
    private int mSquareSize;

    private Rect mRectSquare;
    private Paint mPaintSqaure;
    private Paint mPaintCircle;
    private Paint mPaintRect;
    private Paint mPaintArc;
    private Paint mPaintTriangle;
    private Paint mPaintLine;

    public ShapesView(Context context) {
        super(context);

        init(null);
    }

    public ShapesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ShapesView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ShapesView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);;
    }

    private void init(@Nullable AttributeSet set){
//       Initialization of Square
        mRectSquare = new Rect();
        mPaintSqaure = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSqaure.setColor(Color.parseColor("#fafafa"));

//       Initialization of Circle
        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setColor(Color.parseColor("#fafafa"));

//       Initialization of Rectangle
        mPaintRect = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintRect.setColor(Color.parseColor("#fafafa"));

//       Initialization of Arc
        mPaintArc = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintArc.setColor(Color.parseColor("#fafafa"));

//      Initialization of Triangle
        mPaintTriangle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintTriangle.setColor(Color.parseColor("#fafafa"));

//      Initialization of Line
        mPaintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLine.setColor(Color.parseColor("#fafafa"));

    }

    public void DrawRectangle(){
        mPaintSqaure.setColor(Color.parseColor("#fafafa"));
        mPaintCircle.setColor(Color.parseColor("#fafafa"));
        mPaintArc.setColor(Color.parseColor("#fafafa"));
        mPaintLine.setColor(Color.parseColor("#fafafa"));
        mPaintTriangle.setColor(Color.parseColor("#fafafa"));
        mPaintRect.setColor(Color.BLACK);
        postInvalidate();
    }

    public void DrawTriangle(){
        mPaintSqaure.setColor(Color.parseColor("#fafafa"));
        mPaintCircle.setColor(Color.parseColor("#fafafa"));
        mPaintArc.setColor(Color.parseColor("#fafafa"));
        mPaintLine.setColor(Color.parseColor("#fafafa"));
        mPaintTriangle.setColor(Color.BLACK);
        mPaintRect.setColor(Color.parseColor("#fafafa"));
        postInvalidate();
    }

    public void DrawLine(){
        mPaintSqaure.setColor(Color.parseColor("#fafafa"));
        mPaintCircle.setColor(Color.parseColor("#fafafa"));
        mPaintArc.setColor(Color.parseColor("#fafafa"));
        mPaintLine.setColor(Color.BLACK);
        mPaintTriangle.setColor(Color.parseColor("#fafafa"));
        mPaintRect.setColor(Color.parseColor("#fafafa"));
        postInvalidate();
    }

    public void DrawArc(){
        mPaintSqaure.setColor(Color.parseColor("#fafafa"));
        mPaintCircle.setColor(Color.parseColor("#fafafa"));
        mPaintArc.setColor(Color.BLACK);
        mPaintLine.setColor(Color.parseColor("#fafafa"));
        mPaintTriangle.setColor(Color.parseColor("#fafafa"));
        mPaintRect.setColor(Color.parseColor("#fafafa"));
        postInvalidate();
    }

    public void DrawCircle(){
        mPaintSqaure.setColor(Color.parseColor("#fafafa"));
        mPaintCircle.setColor(Color.BLACK);
        mPaintArc.setColor(Color.parseColor("#fafafa"));
        mPaintLine.setColor(Color.parseColor("#fafafa"));
        mPaintTriangle.setColor(Color.parseColor("#fafafa"));
        mPaintRect.setColor(Color.parseColor("#fafafa"));
        postInvalidate();
    }

    public void DrawSqaure(){
        mPaintSqaure.setColor(Color.BLACK);
        mPaintCircle.setColor(Color.parseColor("#fafafa"));
        mPaintArc.setColor(Color.parseColor("#fafafa"));
        mPaintLine.setColor(Color.parseColor("#fafafa"));
        mPaintTriangle.setColor(Color.parseColor("#fafafa"));
        mPaintRect.setColor(Color.parseColor("#fafafa"));
        postInvalidate();
    }



    //  A function when called draws a circle
    public void drawCircle() {
        mPaintLine.setStrokeWidth(10);
        mCanvas.drawLine(200, 500, 200, 200, mPaintLine);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas mCanvas) {
        super.onDraw(mCanvas);

//      code to draw square on canvas
        int rectSide = 100;
//        mCanvas.drawRect(150,150, 200, 200,mPaintSqaure);
        int width = mCanvas.getWidth();
        int height = mCanvas.getHeight();
        mCanvas.drawRect(width/2f - rectSide/2f,
                height/2f - rectSide/2f,
                width/2f + rectSide/2f,
                height/2f + rectSide/2f, mPaintSqaure);

//      code to draw circle on canvas
        float cx, cy;
        float radius = 150f;
        cx = getWidth()-radius - 100f;
        cy = mRectSquare.top+(mRectSquare.height()/2);
        mCanvas.drawCircle(800,200,radius,mPaintCircle);

//      code to draw rectangle on canvas
        mCanvas.drawRect(400, 200, 600, 300, mPaintRect);

//      code to draw triangle on canvas
        mPaintTriangle.setStrokeWidth(4);
        mPaintTriangle.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintTriangle.setAntiAlias(true);
        Point a = new Point(0, 0);
        Point b = new Point(0, 100);
        Point c = new Point(87, 50);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();
        mCanvas.drawPath(path, mPaintTriangle);

//      code to draw arc on canvas
        final RectF oval = new RectF();
        oval.set(10, 10, 150, 150);
        mCanvas.drawArc(oval, 30, 45, true, mPaintArc);

//      Code to draw line
        mPaintLine.setStrokeWidth(10);
        mCanvas.drawLine(200, 500, 200, 200, mPaintLine);

    }

//    public void drawCircle() {
//        int minX = radius * 2;
//        int maxX = getWidth() - (radius *2 );
//
//        int minY = radius * 2;
//        int maxY = getHeight() - (radius *2 );
//
//        //Generate random numbers for x and y locations of the circle on screen
//        Random random = new Random();
//        mPivotX = random.nextInt(maxX - minX + 1) + minX;
//        mPivotY = random.nextInt(maxY - minY + 1) + minY;
//
//        //important. Refreshes the view by calling onDraw function
//        invalidate();
//}
//    //what I want to draw is here
//    protected void onDraw(Canvas mCanvas) {
//
//        super.onDraw(mCanvas);
//        mCanvas.drawColor(Color.WHITE);
//        mPaintCircle.setColor(Color.BLUE);
//        mPaintCircle.setStrokeWidth(10);
//        mPaintCircle.setStyle(Paint.Style.STROKE);
//        mPaintCircle.setAntiAlias(true);
//        mCanvas.drawCircle(mPivotX, mPivotY, radius,mPaintCircle );
//
//        mPaintLine.setStrokeWidth(10);
//        mCanvas.drawLine(200, 500, 200, 200, mPaintLine);
//    }
//
//    public void drawLine() {
////      Code to draw line
//        mPaintLine.setStrokeWidth(10);
//        mCanvas.drawLine(200, 500, 200, 200, mPaintLine);
//        invalidate();
//    }

}
