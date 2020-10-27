package com.jt.androidartexplore.chapter2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.jt.androidartexplore.Book;
import com.jt.androidartexplore.chapter2.aidl.BookControllerStub;

import java.util.ArrayList;
import java.util.List;

public class AIDLBookService extends Service {
    private static final String TAG = "com.jt.aidl";

    private List<Book> bookList;
    private final BookControllerStub stub = new BookControllerStub() {
        @Override
        public void addBook(Book book) throws RemoteException {
            Log.e(TAG, "Client addBookInOut Book Name: " + book.name);
            bookList.add(book);
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "AIDLBookService Created");
        bookList = new ArrayList<>();
        bookList.add(new Book("活着", bookList.size()));
        bookList.add(new Book("小王子", bookList.size()));
        bookList.add(new Book("童年", bookList.size()));
        bookList.add(new Book("在人间", bookList.size()));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
