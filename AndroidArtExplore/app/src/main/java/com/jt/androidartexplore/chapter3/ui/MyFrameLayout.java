package com.jt.androidartexplore.chapter3.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Field;

public class MyFrameLayout extends FrameLayout {
    final String TAG = "View-Test-" + getClass().getSimpleName();

    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Class<? extends MyFrameLayout> aClass = this.getClass();
        Field[] declaredFields = aClass.getSuperclass()
                .getSuperclass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field f = declaredFields[i];
            f.setAccessible(true);
            if (f.getName().equals("mFirstTouchTarget")) {
                try {
                    Log.d(TAG, "dispatchTouchEvent: ev action: " +
                            ev.getAction() +
                            " mFirstTouchTarget: " + (f.get(this) == null ? "null" : f.get(this)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        boolean b = super.dispatchTouchEvent(ev);
        Log.d(TAG, "dispatchTouchEvent: ev action: " + ev.getAction() + " return: " + b);
        return b;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean b = super.onInterceptTouchEvent(ev);
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            b = true;
        }
        Log.d(TAG, "onInterceptTouchEvent: ev action: " + ev.getAction() + " return: " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean b = super.onTouchEvent(ev);
        Log.d(TAG, "onTouchEvent: ev action: " + ev.getAction() + " return: " + b);
        return b;
    }


}
