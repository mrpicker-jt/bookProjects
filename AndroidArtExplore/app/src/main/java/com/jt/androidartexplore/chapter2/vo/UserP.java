package com.jt.androidartexplore.chapter2.vo;

import android.os.Parcel;
import android.os.Parcelable;


public class UserP implements Parcelable {
    public static final Creator<UserP> CREATOR = new Creator<UserP>() {
        @Override
        public UserP createFromParcel(Parcel in) {
            return new UserP(in);
        }

        @Override
        public UserP[] newArray(int size) {
            return new UserP[size];
        }
    };
    public int userId;
    public String userName;
    public boolean isMale;

    public UserP(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    protected UserP(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
    }
}
