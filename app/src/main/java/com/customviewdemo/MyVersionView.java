package com.customviewdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yashwant on 03/12/17.
 */

@SuppressLint("AppCompatCustomView")
public class MyVersionView extends TextView {


    //Java
    public MyVersionView(Context context) {
        super(context);
        init();
    }

    private void init() {
        try {
            int version=getContext().getPackageManager().getPackageInfo(getContext().getPackageName(),0).versionCode;
            setText(""+version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Xml
    public MyVersionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    //xml with attribute
    public MyVersionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

}
