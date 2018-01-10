package com.customviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yashwant on 30/09/17.
 */

public class PhotoSpiral extends ViewGroup {
    public PhotoSpiral(Context context) {
        super(context);
    }

    public PhotoSpiral(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoSpiral(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        View first=getChildAt(0);
        int childWidth=first.getMeasuredWidth();
        int childHeight=first.getMeasuredHeight();

        for (int j = 0; j <getChildCount() ; j++) {

            View child=getChildAt(j);
            int x=0;
            int y=0;
            switch (j){
                case 1:
                    x=childWidth;
                    y=0;
                    break;
                case 2:
                    x=childHeight;
                    y=childWidth;
                    break;
                case 3:
                    x=0;
                    y=childHeight;
                    break;

            }
            child.layout(x,y,x+getMeasuredWidth(),y+getMeasuredHeight());

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        View first=getChildAt(0);
        int size=first.getMeasuredWidth()+first.getMeasuredHeight();
        int width=ViewGroup.resolveSize(size,widthMeasureSpec);
        int height=ViewGroup.resolveSize(size,heightMeasureSpec);
        setMeasuredDimension(width,height);
    }
}
