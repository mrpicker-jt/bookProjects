package com.jt.androidartexplore.aidl.binder_pool;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.jt.androidartexplore.IBinderPool;

import java.util.concurrent.CountDownLatch;

public class BinderPoolUtils {
    public static final int BINDER_SUM = 1;
    public static final int BINDER_MAX = 2;

    private static BinderPoolUtils poolUtils;
    private Context context;
    private CountDownLatch countDownLatch;
    private IBinderPool mBinderPool;


    private BinderPoolUtils(Context context) {
        this.context = context;
        bindServicePool();
    }

    public static BinderPoolUtils getInstance(Context context) {
        if (poolUtils == null) {
            synchronized (BinderPoolUtils.class) {
                if (poolUtils == null) {
                    poolUtils = new BinderPoolUtils(context);
                }
            }
        }
        return poolUtils;
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinderPool = IBinderPool.Stub.asInterface(service);
            try {
                mBinderPool.asBinder().linkToDeath(deathRecipient, 0);//监听Binder的存货状态
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {}
    };
    private IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {//Binder死掉之后重新绑定
            mBinderPool.asBinder().unlinkToDeath(deathRecipient, 0);//重置死亡状态
            mBinderPool = null;
            bindServicePool();//重新连接
        }
    };

    private void bindServicePool() {
        countDownLatch = new CountDownLatch(1);//同步

        Intent intent = new Intent();
        intent.setPackage("com.jt.androidartexplore");
        intent.setAction("com.jt.androidartexplore.binderpool");
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public IBinder getBinder(int binderCode) {
        IBinder binder = null;
        try {
            binder = mBinderPool.queryBinder(binderCode);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return binder;
    }
}