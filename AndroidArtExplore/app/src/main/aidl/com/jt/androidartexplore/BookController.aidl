// BookController.aidl
package com.jt.androidartexplore;

import com.jt.androidartexplore.Book;
// Declare any non-default types here with import statements

interface BookController {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<Book> getBookList();

    void addBook(in Book book);
}