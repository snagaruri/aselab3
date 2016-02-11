package com.example.venkyganesh.signup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;

import java.io.File;
import java.io.IOException;

/**
 * Created by venky@ganesh on 10-02-2016.
 */
public class PhotoActivity extends Activity {
    int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;
    Bitmap photo;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar().setTitle("Capture image");
        setContentView(R.layout.photoactivity);
        Button capture = (Button) findViewById(R.id.Tclick);
        userImage = (ImageView) findViewById(R.id.view_photo);
        //Button click eventlistener. Initializes the camera.
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });
    }
    //If the photo is captured then set the image view to the photo captured.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
             photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            Log.d("CameraDemo", "Pic saved");
        }
    }

    public void onClickHome(View s){

        if(s.getId()==R.id.Bhome){

            Intent h=new Intent(PhotoActivity.this,MapsActivity.class);
          // h.putExtra("ImageView", (Parcelable) userImage);
           // h.putExtra("bmp", (Parcelable) userImage);
             h.putExtra("Bitmap",photo);
            startActivity(h);
        }
    }



}
