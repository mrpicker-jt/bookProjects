package com.jt.androidartexplore.chapter2.binder_pool;

import android.os.RemoteException;

import com.jt.androidartexplore.ISecurityCenter;

public class ISecurityCenterImpl extends ISecurityCenter.Stub {
    private static final char SECRET_KEY = '^';

    @Override
    public String encrypt(String content) throws RemoteException {
        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= SECRET_KEY;
        }
        return new String(chars);
    }

    @Override
    public String decrypt(String password) throws RemoteException {
        return encrypt(password);
    }
}
