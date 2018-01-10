package com.customviewdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yashwant on 03/12/17.
 */

public class MySquareView extends View {

    public MySquareView(Context context) {
        super(context);
    }

    public MySquareView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MySquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size=Math.min(getMeasuredHeight(),getMeasuredWidth());
        setMeasuredDimension(size,size);
    }
}
