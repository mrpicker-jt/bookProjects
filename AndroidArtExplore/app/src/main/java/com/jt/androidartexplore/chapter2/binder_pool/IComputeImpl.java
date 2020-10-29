package com.jt.androidartexplore.chapter2.binder_pool;

import android.os.RemoteException;

import com.jt.androidartexplore.ICompute;

public class IComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
