package com.jt.androidartexplore.chapter3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jt.androidartexplore.R;

public class ViewTestActivity extends AppCompatActivity {

    MovableTextView movableTextView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);
        movableTextView = findViewById(R.id.avt_mTV);
        editText = findViewById(R.id.avt_editTextPhone);
    }

    public void scrollMTVTo(View view) {
        String s = editText.getText().toString();
        try {
            Integer integer = Integer.valueOf(s);
            movableTextView.smoothScrollTo(integer, 0, 1000);
        } catch (Exception e) {

        }
    }
}