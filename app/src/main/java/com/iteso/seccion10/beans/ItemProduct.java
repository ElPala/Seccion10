package com.iteso.seccion10.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Palaf on 21/09/2017.
 */
public  class ItemProduct implements Parcelable {

    private int code;
    private int image;
    private String title;
    private String description;
    private Category category;
    private Store store;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public  Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeInt(this.image);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeParcelable(this.category, flags);
        dest.writeParcelable(this.store, flags);
    }

    public ItemProduct() {
    }

    protected ItemProduct(Parcel in) {
        this.code = in.readInt();
        this.image = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.category = in.readParcelable(Category.class.getClassLoader());
        this.store = in.readParcelable(Store.class.getClassLoader());
    }

    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };
}
