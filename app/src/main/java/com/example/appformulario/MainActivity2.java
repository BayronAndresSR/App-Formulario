package com.example.appformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //variables
    TextView label_name, label_address, label_city, label_state, label_zip;
    ImageView image_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //instanciar componentes
        label_name = findViewById(R.id.label_name);
        label_address = findViewById(R.id.label_address);
        label_city = findViewById(R.id.label_city);
        label_state = findViewById(R.id.label_state);
        label_zip = findViewById(R.id.label_zip);
        image_photo = findViewById(R.id.image_photo);

        //get intent
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.I_NAME);
        String address = intent.getStringExtra(MainActivity.I_ADDRESS);
        String city = intent.getStringExtra(MainActivity.I_CITY);
        String state = intent.getStringExtra(MainActivity.I_STATE);
        String zip = intent.getStringExtra(MainActivity.I_ZIP);


        //set data
        label_name.setText(name);
        label_address.setText(address);
        label_city.setText(city);
        label_state.setText(state);
        label_zip.setText(zip);
        image_photo.setImageBitmap(MainActivity.bitmap);

    }
}