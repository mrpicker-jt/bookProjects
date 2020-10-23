package com.jt.androidartexplore;

import android.os.Environment;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class BaseActivity extends AppCompatActivity {
    protected final String TAG = "AAE" + this.getClass().getSimpleName();

    protected void showText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    protected String getFilePath(String fileName) {
        File file = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator + fileName;
    }
}
