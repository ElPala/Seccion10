package com.iteso.seccion10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.iteso.seccion10.beans.Category;
import com.iteso.seccion10.beans.ItemProduct;
import com.iteso.seccion10.beans.Store;
import com.iteso.seccion10.database.CategoryControl;
import com.iteso.seccion10.database.DataBaseHandler;
import com.iteso.seccion10.database.ItemProductControl;
import com.iteso.seccion10.database.StoreControl;

import java.util.ArrayList;

public class ActivityProduct extends AppCompatActivity {

    protected Spinner stores;
    protected Spinner categories;
    protected Spinner images;
    protected EditText id;
    protected EditText title;
    protected EditText description;
    protected ArrayAdapter<Store> storesAdapter;
    protected ArrayAdapter<Category> categoriesAdapter;
    protected ArrayAdapter<String> imagesAdapter;
    protected DataBaseHandler dh; //DataBase Instance
    protected Store storeSelected; //Store selected in spinner
    protected Category categorySelected; //Category selected in spinner
    protected int imageSelected; //Image selected in spinner
    protected Toolbar toolbar;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_product_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        //Cast GUI elements
        toolbar = (Toolbar)findViewById(R.id.activity_product_toolbar);
        setSupportActionBar(toolbar);
        stores = (Spinner)findViewById(R.id.activity_product_category) ;
        categories = (Spinner)findViewById(R.id.activity_product_store) ;
        images = (Spinner)findViewById(R.id.activity_product_image) ;
        id = (EditText) findViewById(R.id.activity_product_id);
        title = (EditText) findViewById(R.id.activity_product_title);
        description = (EditText) findViewById(R.id.activity_product_description);
        storeSelected = new Store();

        categorySelected = new Category();
        categorySelected.setName("lala");
        categorySelected.setIdCategory(2);
        imageSelected = -1;
//DataBase Objects
        dh = DataBaseHandler.getInstance(this);
        StoreControl storeControl = new StoreControl();
        CategoryControl categoryControl = new CategoryControl();
//Fill info from Database
        ArrayList<Store> storesList = storeControl.getStoresWhere( -103.4207757, 20.6489713, dh);
        ArrayList<Category> categoriesList = categoryControl.getAllCategories(dh);
//Create Adapter to show into Spinner, ListView or GridLayout
        storesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storesList);
        stores.setAdapter(storesAdapter);
        categoriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriesList);
        categories.setAdapter(categoriesAdapter);


        ArrayList<String> myimages = new ArrayList<>();
        myimages.add("Mac"); myimages.add("Alienware");
        imagesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myimages);
        images.setAdapter(imagesAdapter);
        stores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                storeSelected = storesAdapter.getItem(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        images.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageSelected = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save2) {
            if(isValidProduct()){
                ItemProduct itemProduct = new ItemProduct();
                itemProduct.setTitle(title.getText().toString().trim());
                itemProduct.setDescription(description.getText().toString().trim());
                itemProduct.setStore(storeSelected);
                itemProduct.setCategory(categorySelected);
                itemProduct.setCategory(categorySelected);
                itemProduct.setImage(imageSelected);
                ItemProductControl itemProductControl = new ItemProductControl();
                itemProductControl.addItemProduct(itemProduct, dh);
                Intent intent = new Intent();
                intent.putExtra("ITEM", itemProduct);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setCategorySelected(int categoryId){
        for (int position = 0; position < categoriesAdapter.getCount(); position++)
        {
            if(((Category)categoriesAdapter.getItem(position)).getIdCategory() == categoryId)
            {
                categories.setSelection(position);
                return;
            }
        }
    }
    public void setStoreSelected(int storeId){
        for (int position = 0; position < storesAdapter.getCount(); position++)
        {
            if(((Store)storesAdapter.getItem(position)).getId() == storeId)
            {
                stores.setSelection(position);
                return;
            }
        }
    }
    public void setImageSelected(int imageId){
        images.setSelection(imageId);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_product_search:
                int idProduct = 0;
                try {
                    idProduct = Integer.parseInt(id.getText().toString().trim());
                }catch(NumberFormatException e){ return; }
                ItemProductControl itemProductControl = new ItemProductControl();
                ItemProduct itemProduct = itemProductControl.getProductById(idProduct, dh);
                if(itemProduct != null) {
                    title.setText(itemProduct.getTitle());
                    description.setText(itemProduct.getDescription());
                    if(itemProduct.getCategory() != null) {
                        setCategorySelected(itemProduct.getCategory().getIdCategory());}
                    if(itemProduct.getStore()!= null) {
                        setStoreSelected(itemProduct.getStore().getId());}
                    setImageSelected(itemProduct.getImage());
                }
                break;
        }
    }
    public boolean isValidProduct(){
        return true;
    }

}