package com.jt.androidartexplore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "com.jt.aidl";
    private final OnBookArrivedListener listener = new OnBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            runOnUiThread(() -> {
                Log.e(TAG, "onNewBookArrived newBook: " + newBook.name);
            });
        }
    };
    private BookController bookController;
    private boolean isConnected;
    private List<Book> bookList;
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bookController = BookController.Stub.asInterface(service);
            isConnected = true;
            try {
                service.linkToDeath(mDeathRecipient, 0);
                bookController.registerListener(listener);
                bookList = bookController.getBookList();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnected = false;
        }
    };
    private final IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            if (bookController == null) {
                return;
            }
            bookController.asBinder().unlinkToDeath(mDeathRecipient, 0);
            bookController = null;
            bindService();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
    }

    public void gotoMessengerActivity(View view) {
        startActivity(new Intent(this, MessengerActivity.class));
    }

    public void getBookList(View view) throws RemoteException {
        if (isConnected) {
            bookList = bookController.getBookList();
            log();
        }
    }

    public void getLastBook(View view) throws RemoteException {
        if (isConnected) {
            bookList = bookController.getBookList();
            Log.e(TAG, "LAST BOOK: " + bookList.get(bookList.size() - 1).toString());
        }
    }

    public void addBook(View view) throws RemoteException {
        if (isConnected) {
            Book book = new Book("Client New Book", bookList.size());
            bookController.addBookInOut(book);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bookController != null && bookController.asBinder().isBinderAlive()) {
            try {
                bookController.unRegisterListener(listener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (isConnected) {
            unbindService(serviceConnection);
        }
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.jt.androidartexplore");
        intent.setAction("com.jt.androidartexplore.action");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void log() {
        for (Book book :
                bookList) {
            Log.e(TAG, book.toString());
        }
    }
}