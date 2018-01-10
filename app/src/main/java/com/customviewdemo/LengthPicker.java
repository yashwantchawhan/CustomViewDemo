package com.customviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yashwant on 29/09/17.
 */

public class LengthPicker extends LinearLayout implements View.OnClickListener {

    private static final String KEY_SUPER_STATE = "superState";
    private static final String KEY_NUMBER_INCHES = "numInches";

    Button plusButton, minusButton;
    TextView txtValue;

    private int numInches = 0;

    //java
    public LengthPicker(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater layoutInflator = LayoutInflater.from(getContext());
        layoutInflator.inflate(R.layout.length_picker, this);

        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        txtValue = (TextView) findViewById(R.id.text);

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);

    }
    // xml

    public LengthPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //xml with attribute
    public LengthPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void updateControls() {
        int feet = numInches / 12;
        int inches = numInches % 12;

        String text = String.format("%d' %d\"", feet, inches);
        if (feet == 0) {
            text = String.format("%d\"", inches);
        } else {
            if (inches == 0) {
                text = String.format("%d\"", feet);
            }

        }
        txtValue.setText(text);
        minusButton.setEnabled(numInches > 0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plus_button:
                numInches++;
                updateControls();
                break;
            case R.id.minus_button:
                if (numInches > 0) {
                    numInches--;
                    updateControls();
                }

                break;
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle=new Bundle();
        bundle.putParcelable(KEY_SUPER_STATE,super.onSaveInstanceState());
        bundle.putInt(KEY_NUMBER_INCHES,numInches);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if(state instanceof Bundle){
            Bundle bundle=(Bundle)state;
            numInches=bundle.getInt(KEY_NUMBER_INCHES);
            super.onRestoreInstanceState(bundle.getParcelable(KEY_SUPER_STATE));

        }else {
            super.onRestoreInstanceState(state);
        }
        updateControls();
    }
}
