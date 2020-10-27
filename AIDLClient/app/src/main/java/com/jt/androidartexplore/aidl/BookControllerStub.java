package com.jt.androidartexplore.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BookControllerStub extends Binder implements IBookController {
    public BookControllerStub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IBookController asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface instanceof IBookController) {
            return (IBookController) iInterface;
        }
        return new BookControllerProxy(iBinder);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }


    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        java.lang.String descriptor = DESCRIPTOR;
        switch (code)
        {
            case INTERFACE_TRANSACTION:
            {
                reply.writeString(descriptor);
                return true;
            }
            case TRANSACTION_getBookList:
            {
                data.enforceInterface(descriptor);
                java.util.List<com.jt.androidartexplore.Book> _result = this.getBookList();
                reply.writeNoException();
                reply.writeTypedList(_result);
                return true;
            }
            case TRANSACTION_addBookInOut:
            {
                data.enforceInterface(descriptor);
                com.jt.androidartexplore.Book _arg0;
                if ((0!=data.readInt())) {
                    _arg0 = com.jt.androidartexplore.Book.CREATOR.createFromParcel(data);
                }
                else {
                    _arg0 = null;
                }
                this.addBook(_arg0);
                reply.writeNoException();
                if ((_arg0!=null)) {
                    reply.writeInt(1);
                    _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                }
                else {
                    reply.writeInt(0);
                }
                return true;
            }
            default:
            {
                return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
