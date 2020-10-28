package com.jt.androidartexplore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MessengerActivity extends AppCompatActivity {

    private static final int FROM_CLIENT = 1;
    private static final int FROM_SERVER = 2;
    private static final String TAG = "MessengerClient";
    Messenger messenger;
    Messenger receiveMessenger;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            Message message = Message.obtain(null, FROM_CLIENT);
            Bundle bundle = new Bundle();
            bundle.putString("msg", "Hello,this is a client");
            message.replyTo = receiveMessenger;
            message.setData(bundle);
            Log.e(TAG, "onServiceConnected Client send msg: " + bundle.getString("msg"));
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Handler target;
        receiveMessenger = new Messenger(new ReceiveHandler());
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.jt.androidartexplore");
        intent.setAction("com.jt.androidartexplore.messageaction");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    private static class ReceiveHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case FROM_SERVER:
                    Log.e(TAG, "ReceiveHandler FROM_SERVER msg: " + msg.getData().getString("msg"));
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}