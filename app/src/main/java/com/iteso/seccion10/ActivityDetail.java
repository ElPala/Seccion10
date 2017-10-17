package com.iteso.seccion10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.seccion10.beans.ItemProduct;

public class ActivityDetail extends AppCompatActivity {

    protected EditText title,store,location;
    protected ImageView image;
    protected Button button;
    ItemProduct product = getIntent().getParcelableExtra("ITEM");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = (EditText)findViewById(R.id.title);
        store = (EditText)findViewById(R.id.store);
        location = (EditText)findViewById(R.id.location);
        image = (ImageView) findViewById(R.id.image);
        button = (Button)findViewById(R.id.save);



        store.setText(product.getStore().getName());
        location.setText(product.getStore().getCity().getName());
        switch (product.getImage()) {
            case 0:
                image.setImageResource(R.drawable.mac);
                break;
            case 1:
                image.setImageResource(R.drawable.alienware);
                break;
        }
        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setTitle(title.getText().toString());
                product.getStore().setName(store.getText().toString());
                product.getStore().getCity().setName(location.getText().toString());
            }
        });
    }
}
