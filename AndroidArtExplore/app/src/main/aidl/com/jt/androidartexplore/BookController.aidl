// BookController.aidl
package com.jt.androidartexplore;

import com.jt.androidartexplore.Book;

import com.jt.androidartexplore.OnBookArrivedListener;
// Declare any non-default types here with import statements

interface BookController {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<Book> getBookList();

    void addBookInOut(inout Book book);

    void registerListener(OnBookArrivedListener listener);
    void unRegisterListener(OnBookArrivedListener listener);
}