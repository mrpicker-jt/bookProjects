package com.jt.androidartexplore.chapter3.ui;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    final String TAG = "View-Test-" + getClass().getSimpleName();

    public MyButton(@NonNull Context context) {
        super(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean b = super.dispatchTouchEvent(event);
        Log.d(TAG, "dispatchTouchEvent: ev action: " + event.getAction() + " return: " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean b = super.onTouchEvent(ev);
        if (ev.getAction() != MotionEvent.ACTION_DOWN) {
            b = false;
        }
        Log.d(TAG, "onTouchEvent: ev action: " + ev.getAction() + " return: " + b);
        return b;
    }

}
