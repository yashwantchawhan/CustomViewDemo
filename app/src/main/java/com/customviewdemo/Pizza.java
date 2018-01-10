package com.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yashwant on 01/10/17.
 */

public class Pizza extends View {
    private Paint paint;
    private int numWedges=5;
    public Pizza(Context context) {
        super(context);
        init(context,null);
    }

    private void init(Context context,AttributeSet attributeSet) {
        int strokeWidth=4;
        int color=Color.YELLOW;
        if(attributeSet!=null){
            TypedArray typeArray=context.obtainStyledAttributes(attributeSet,R.styleable.Pizza);
            strokeWidth=typeArray.getDimensionPixelSize(R.styleable.Pizza_stroke_width,strokeWidth);
            color=typeArray.getColor(R.styleable.Pizza_color,color);
            numWedges=typeArray.getInt(R.styleable.Pizza_num_wedges,numWedges);
        }
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
    }

    public Pizza(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public Pizza(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        final int width=getWidth()-getPaddingLeft()-getPaddingRight();
        final int height=getHeight()-getPaddingTop()-getPaddingBottom();
        final int cx=width/2+getPaddingLeft();
        final int cy=height/2+getPaddingTop();
        final float diameter=Math.min(width,height)-paint.getStrokeWidth();
        final float radius=diameter/2;
       // canvas.drawColor(Color.BLUE);
        canvas.drawCircle(cx,cy,radius,paint);
        drawPizzaCuts(canvas,cx,cy,radius);
    }

    private void drawPizzaCuts(Canvas canvas, int cx, int cy, float radius) {
        final float degree=360/numWedges;
        canvas.save();
        for (int i = 0; i <numWedges ; i++) {
            canvas.rotate(degree,cx,cy);
            canvas.drawLine(cx,cy,cx,cy-radius,paint);
        }
        canvas.restore();

    }

}
