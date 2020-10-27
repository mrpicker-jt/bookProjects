package com.jt.androidartexplore;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    public String name;
    public int bookId;
    public Book(String name, int bookId) {
        this.name = name;
        this.bookId = bookId;
    }

    public Book(Parcel in) {
        name = in.readString();
        bookId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(bookId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", bookId=" + bookId +
                '}';
    }

    public void readFromParcel(Parcel dest) {
        name = dest.readString();
        bookId = dest.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
