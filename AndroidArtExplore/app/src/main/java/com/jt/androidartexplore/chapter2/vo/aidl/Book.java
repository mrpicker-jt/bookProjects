package com.jt.androidartexplore.chapter2.vo.aidl;

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

    protected Book(Parcel in) {
        name = in.readString();
        bookId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(bookId);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
