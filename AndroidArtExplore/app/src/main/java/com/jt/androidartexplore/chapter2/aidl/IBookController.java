package com.jt.androidartexplore.chapter2.aidl;

import android.os.IInterface;
import android.os.RemoteException;

import com.jt.androidartexplore.Book;

import java.util.List;

public interface IBookController extends IInterface {
    String DESCRIPTOR = "com.jt.androidartexplore.BookController";
    int TRANSACTION_getBookList = android.os.IBinder.FIRST_CALL_TRANSACTION;
    int TRANSACTION_addBookInOut = android.os.IBinder.FIRST_CALL_TRANSACTION + 1;

    void addBook(Book book) throws RemoteException;

    List<Book> getBookList() throws RemoteException;
}
