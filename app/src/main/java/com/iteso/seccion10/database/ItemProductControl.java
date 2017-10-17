package com.iteso.seccion10.database;

import com.iteso.seccion10.ItemProduct;

import java.util.ArrayList;

/**
 * Created by Palaf on 16/10/2017.
 */

public class ItemProductControl {
    public long addItemProduct(ItemProduct product, DataBaseHandler dh){
    return 1;
    }
    public int updateProduct(ItemProduct product, DataBaseHandler dh){
    return 1;
    }
    public void deleteProduct(int idProduct, DataBaseHandler dh){

    }
    public ItemProduct getProductById(int idProduct, DataBaseHandler dh){
    return new ItemProduct();
    }
    public ArrayList<ItemProduct> getProductsWhere(
            String strWhere, String strOrderBy, DataBaseHandler dh){
    return new ArrayList<ItemProduct>();
    }

}
