package com.iteso.seccion10;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Palaf on 26/09/2017.
 */

public class Store implements Parcelable {
    private  String name;
    private ArrayList<ItemProduct> products;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeTypedList(this.products);
    }

    public Store() {
    }

    protected Store(Parcel in) {
        this.name = in.readString();
        this.products = in.createTypedArrayList(ItemProduct.CREATOR);
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel source) {
            return new Store(source);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };
}
