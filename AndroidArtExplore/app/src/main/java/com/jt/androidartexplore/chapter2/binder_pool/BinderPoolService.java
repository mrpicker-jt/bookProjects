package com.jt.androidartexplore.chapter2.binder_pool;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.jt.androidartexplore.IBinderPool;

public class BinderPoolService extends Service {
    public static final int BINDER_COMPUTE = 1;
    public static final int BINDER_SECURITY = 2;

    @Override
    public IBinder onBind(Intent intent) {
        return new BinderPoolImpl();
    }

    private static class BinderPoolImpl extends IBinderPool.Stub {

        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            switch (binderCode) {
                case BINDER_COMPUTE:
                    return new IComputeImpl();
                case BINDER_SECURITY:
                    return new ISecurityCenterImpl();
            }
            return null;
        }
    }
}