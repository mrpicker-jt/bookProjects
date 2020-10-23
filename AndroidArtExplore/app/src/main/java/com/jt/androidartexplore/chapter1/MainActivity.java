package com.jt.androidartexplore.chapter1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.jt.androidartexplore.BaseActivity;
import com.jt.androidartexplore.R;
import com.jt.androidartexplore.chapter2.NewProcessActivity;
import com.jt.androidartexplore.chapter2.vo.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(null);
        AnimatorSet animatorSet=new AnimatorSet();
        Object target;
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(null, "alpha", 0);
    }

    public void jumpSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void jumpNewProcess(View view) throws IOException {
        Intent intent=new Intent();
        storeUserBySerial();
        startActivity(new Intent(this, NewProcessActivity.class));
    }

    private void storeUserBySerial() throws IOException {
        //序列化User
        User user = new User(1, "jt", true);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(getFilePath("cache.txt")));
        outputStream.writeObject(user);
        outputStream.close();
    }

    public void jumpThird(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d(TAG, "onWindowFocusChanged: " + hasFocus);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}