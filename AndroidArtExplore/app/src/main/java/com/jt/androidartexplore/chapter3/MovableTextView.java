package com.jt.androidartexplore.chapter3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Scroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MovableTextView extends AppCompatTextView {

    private static final String TAG = "MovableTextView";
    float clickRawX;
    float clickRawY;
    float originTransX;
    float originTransY;

    Scroller scroller;


    public MovableTextView(@NonNull Context context) {
        this(context, null);
    }

    public MovableTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovableTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context);
    }

    public void smoothScrollTo(int destX, int destY, int mills) {
        scroller.startScroll(getScrollX(), getScrollY(),
                destX - getScrollX(), destY - getScrollY(), mills);
        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "event Action: " + event.getAction() + " " + event.getRawX() + ":" + event.getRawY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                clickRawX = event.getRawX();
                clickRawY = event.getRawY();
                originTransX = getTranslationX();
                originTransY = getTranslationY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float dX = event.getRawX() - clickRawX;
                float dy = event.getRawY() - clickRawY;
                setTransX(originTransX + dX);
                setTransY(originTransY + dy);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }

    /**
     * 检查边界
     *
     * @param transX
     */
    private void setTransX(float transX) {
        float minTransX = -getLeft();
        float maxTransX = ((ViewGroup) getParent()).getWidth() - getRight();
        setTranslationX(Math.max(Math.min(transX, maxTransX), minTransX));
    }

    private void setTransY(float transY) {
        float minTransY = -getTop();
        float maxTransY = ((ViewGroup) getParent()).getHeight() - getBottom();
        setTranslationY(Math.max(Math.min(transY, maxTransY), minTransY));
    }
}
