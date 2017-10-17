package com.iteso.seccion10;

import android.os.Parcel;
import android.os.Parcelable;

import com.iteso.seccion10.beans.Category;
import com.iteso.seccion10.beans.Store;

/**
 * Created by Palaf on 21/09/2017.
 */
public  class ItemProduct implements Parcelable {

    private int image;
    private int code;
    private  String title;
    private  Store store;
    private String location;
    private String phone;
    private Category category;
    private String description;


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

    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel in) {
            return new ItemProduct(in);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

    @Override
    public String toString() {
        return "ItemProduct{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public ItemProduct(Parcel in) {
        image = in.readInt();
        title = in.readString();
        location = in.readString();
        phone = in.readString();
        description = in.readString();
        store = in.readParcelable(Store.class.getClassLoader());
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public ItemProduct(){
        image = 0;
        title = "";
        location = "";
        phone = "";
        description = "";
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public  String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeString(location);
        parcel.writeString(phone);
        parcel.writeString(description);
        parcel.writeParcelable(store, flags);
        parcel.writeParcelable(category, flags);
    }


}
