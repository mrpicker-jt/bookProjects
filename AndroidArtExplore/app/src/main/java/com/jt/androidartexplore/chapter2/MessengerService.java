package com.jt.androidartexplore.chapter2;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

public class MessengerService extends Service {

    private static final int FROM_CLIENT = 1;
    private static final int FROM_SERVER = 2;
    private static final String TAG = "MessengerService";
    private final Messenger messenger = new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case FROM_CLIENT:
                    Log.e(TAG, "MessengerHandler FROM_CLIENT msg: " + msg.getData().getString("msg"));
                    if (msg.replyTo!=null){
                        Messenger client = msg.replyTo;
                        Message message=Message.obtain(null,FROM_SERVER);
                        Bundle bundle=new Bundle();
                        bundle.putString("msg","This is server,i receiver your message");
                        message.setData(bundle);
                        try {
                            client.send(message);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}
