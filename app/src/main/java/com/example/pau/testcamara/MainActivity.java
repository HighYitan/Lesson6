package com.example.pau.testcamara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button bFoto;
    private ImageView mImageView;
    static final int REQUEST_IMAGE_CAPTURE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image) ;
        bFoto = (Button) findViewById(R.id.fotoButton);

        bFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            mImageView.setImageBitmap(imageBitmap);

    }



}
