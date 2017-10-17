package com.iteso.seccion10.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Palaf on 16/10/2017.
 */

public class Category implements Parcelable
{
    private int idCategory;
    private String name;




    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idCategory);
        dest.writeString(this.name);
    }

    public Category() {

    }

    protected Category(Parcel in) {
        this.idCategory = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
