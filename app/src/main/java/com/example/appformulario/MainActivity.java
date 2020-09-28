package com.example.appformulario;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int CAMERA_PIC_REQUEST = 1;
    private String PATH_IMAGE = "";
    EditText name_edit_text;
    EditText address_edit_text;
    EditText city_edit_text;
    EditText state_edit_text;
    EditText zip_edit_text;
    ImageView image_camera;
    Button save_button;

    public static final String I_NAME = "I_NAME";
    public static final String I_ADDRESS = "I_ADDRESS";
    public static final String I_CITY = "I_CITY";
    public static final String I_STATE = "I_STATE";
    public static final String I_ZIP = "I_ZIP";
    public static final String I_IMAGE = "I_IMAGE";

    public static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_edit_text = findViewById(R.id.name_edit_text);
        address_edit_text = findViewById(R.id.address_edit_text);
        city_edit_text = findViewById(R.id.city_edit_text);
        state_edit_text = findViewById(R.id.state_edit_text);
        zip_edit_text = findViewById(R.id.zip_edit_text);
        image_camera = findViewById(R.id.image_camera);
        save_button = findViewById(R.id.save_button);

        image_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = name_edit_text.getText().toString();
                String address = address_edit_text.getText().toString();
                String city = city_edit_text.getText().toString();
                String state = state_edit_text.getText().toString();
                String zip = zip_edit_text.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.error_string), Toast.LENGTH_SHORT).show();
                }
                else if (address.isEmpty()) {
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.error_string), Toast.LENGTH_SHORT).show();
                }
                else if (city.isEmpty()) {
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.error_string), Toast.LENGTH_SHORT).show();
                }
                else if (state.isEmpty()) {
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.error_string), Toast.LENGTH_SHORT).show();
                }
                else if (zip.isEmpty()) {
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.error_string), Toast.LENGTH_SHORT).show();
                }
                else {
                    SendData(name, address, city, state, zip);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_PIC_REQUEST){
            if(resultCode == RESULT_OK){
                bitmap = (Bitmap) data.getExtras().get("data");
                PATH_IMAGE = bitmap.toString();
                image_camera = findViewById(R.id.image_camera);
                image_camera.setImageBitmap(bitmap);
            }
        }
    }

    private void SendData(String name, String address, String city, String state, String zip){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(I_NAME, name);
        intent.putExtra(I_ADDRESS, address);
        intent.putExtra(I_CITY, city);
        intent.putExtra(I_STATE, state);
        intent.putExtra(I_ZIP, zip);
        startActivity(intent);
    }
}