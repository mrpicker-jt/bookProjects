package com.jt.androidartexplore.chapter2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.jt.androidartexplore.Book;
import com.jt.androidartexplore.BookController;
import com.jt.androidartexplore.OnBookArrivedListener;

import java.util.ArrayList;
import java.util.List;

public class AIDLBookService extends Service {
    private static final String TAG = "com.jt.aidl";

    private List<Book> bookList;
    private RemoteCallbackList<OnBookArrivedListener> onBookArrivedListeners;
    private final BookController.Stub stub = new BookController.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }

        @Override
        public void addBookInOut(Book book) throws RemoteException {
            Log.e(TAG, "Client addBookInOut Book Name: " + book.name);
            bookList.add(book);
        }

        @Override
        public void registerListener(OnBookArrivedListener listener) throws RemoteException {
                onBookArrivedListeners.register(listener);
        }

        @Override
        public void unRegisterListener(OnBookArrivedListener listener) throws RemoteException {
            onBookArrivedListeners.unregister(listener);
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
        onBookArrivedListeners = new RemoteCallbackList<>();
        new Thread(new AddBookWork()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    class AddBookWork implements Runnable {

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Book book = new Book("ServerBook" + bookList.size(), bookList.size());
                bookList.add(book);
                int N = onBookArrivedListeners.beginBroadcast();
                for (int i = 0; i < N; i++) {
                    OnBookArrivedListener broadcastItem = onBookArrivedListeners.getBroadcastItem(i);
                    try {
                        broadcastItem.onNewBookArrived(book);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                onBookArrivedListeners.finishBroadcast();
            }
        }
    }
}
