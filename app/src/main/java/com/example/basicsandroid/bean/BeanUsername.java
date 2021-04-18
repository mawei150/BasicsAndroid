package com.example.basicsandroid.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

public class BeanUsername  implements Parcelable {

    public boolean  mIsDiaplay;
    private String name;
    private Context mContext;

    public BeanUsername(Context mContext) {
        this.mContext=mContext;
    }


    public BeanUsername() {

    }

    public boolean ismIsDiaplay() {
        return mIsDiaplay;
    }

    public void setmIsDiaplay(boolean mIsDiaplay) {
        this.mIsDiaplay = mIsDiaplay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void method(){
        Toast.makeText(mContext,mIsDiaplay+"",Toast.LENGTH_LONG).show();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
