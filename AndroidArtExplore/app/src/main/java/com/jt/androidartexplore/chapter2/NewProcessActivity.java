package com.jt.androidartexplore.chapter2;

import android.os.Bundle;

import com.jt.androidartexplore.BaseActivity;
import com.jt.androidartexplore.R;
import com.jt.androidartexplore.chapter2.vo.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class NewProcessActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_process);
        try {
            recoverUserBySerial();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void recoverUserBySerial() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getFilePath("cache.txt")));
        User user = (User) objectInputStream.readObject();
        objectInputStream.close();
        showText(user.userName);
    }
}