package com.jt.androidartexplore.chapter2.aidl;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import com.jt.androidartexplore.Book;

import java.util.List;

public class BookControllerProxy implements IBookController {

    private final IBinder mRemote;

    public BookControllerProxy(IBinder remote) {
        this.mRemote = remote;
    }

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            if ((book != null)) {
                _data.writeInt(1);
                book.writeToParcel(_data, 0);
            } else {
                _data.writeInt(0);
            }
            boolean _status = mRemote.transact(TRANSACTION_addBookInOut, _data, _reply, 0);
            if (!_status) {
                return;
            }
            _reply.readException();
            if ((0 != _reply.readInt())) {
                book.readFromParcel(_reply);
            }
        } finally {
            _reply.recycle();
            _data.recycle();
        }
    }

    @Override
    public List<Book> getBookList() throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        List<Book> _result;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            boolean _status = mRemote.transact(TRANSACTION_getBookList, _data, _reply, 0);
            if (!_status) {
                return null;
            }
            _reply.readException();
            _result = _reply.createTypedArrayList(Book.CREATOR);
        } finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }
}
