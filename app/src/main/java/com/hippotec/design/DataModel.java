package com.hippotec.design;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by anupamchugh on 11/02/17.
 */

public class DataModel implements Serializable ,Parcelable {


    public String text;
    public int drawable;
    public int drawable2;
    public String color;


    public DataModel(String t, int d, String c )
    {
        text=t;
        drawable=d;
        color=c;
    }

    public DataModel (Parcel parcel) {
        this.color = parcel.readString();
        this.text = parcel.readString();
        this.drawable = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Required method to write to Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(color);
        dest.writeString(text);
        dest.writeInt(drawable);
    }

    // Method to recreate a Question from a Parcel
    public static Creator<DataModel> CREATOR = new Creator<DataModel>() {

        @Override
        public DataModel createFromParcel(Parcel source) {
            return new DataModel(source);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }

    };
}
