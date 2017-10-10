package com.iteso.seccion10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ActivityDetail extends AppCompatActivity {

    protected EditText title,store,location;
    protected ImageView image;
    protected Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = (EditText)findViewById(R.id.title);
        store = (EditText)findViewById(R.id.store);
        location = (EditText)findViewById(R.id.location);
        image = (ImageView) findViewById(R.id.image);
        button = (Button)findViewById(R.id.guardar);


        ItemProduct product = getIntent().getParcelableExtra("ITEM");
        store.setText(product.getStore());
        title.setText(product.getTitle());
        location.setText(product.getLocation());
        switch (product.getImage()) {
            case 0:
                image.setImageResource(R.drawable.mac);
                break;
            case 1:
                image.setImageResource(R.drawable.alienware);
                break;
        }
    }
}
