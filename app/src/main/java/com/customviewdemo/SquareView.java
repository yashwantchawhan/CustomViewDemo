package com.customviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yashwant on 03/12/17.
 */

public class SquareView extends View{

    public SquareView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public SquareView(Context context) {
        super(context);
        init();
    }

    private void init() {
    setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size=Math.min(getMeasuredHeight(),getMeasuredWidth());
        setMeasuredDimension(size,size);
    }
}
