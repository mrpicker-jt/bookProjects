// OnBookArrivedListener.aidl
package com.jt.androidartexplore;

import com.jt.androidartexplore.Book;
// Declare any non-default types here with import statements

interface OnBookArrivedListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onNewBookArrived(in Book newBook);
}