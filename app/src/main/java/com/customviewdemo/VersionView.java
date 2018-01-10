package com.customviewdemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yashwant on 22/09/17.
 */

public class VersionView extends android.support.v7.widget.AppCompatTextView {

    //java
    public VersionView(Context context) {
        super(context);
        setVersion();
    }

    //xml
    public VersionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setVersion();
    }

    //xml with style
    public VersionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVersion();
    }

    private void setVersion(){
        try {
            PackageInfo packageInfo=getContext().getPackageManager().getPackageInfo(getContext().getPackageName(),0);
            setText(packageInfo.versionName);
            setTextColor(Color.CYAN);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }


}
