package com.example.camara;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 100;

    private static final int GALLERY_REQUEST = 200;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new PhotoAdapter());

        loadPhotos();
    }

    // takePhoto with Camera intent: https://developer.android.com/training/permissions/usage-notes
    public void takePhoto(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    // Pick Photo with Gallery
    public void pickPhoto(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");  // Filtro de tipo de contenido
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST || requestCode == GALLERY_REQUEST) {
            if (resultCode == RESULT_OK) {

                try {
                    Bitmap bitmap;
                    if(requestCode == CAMERA_REQUEST)
                        bitmap = (Bitmap) data.getExtras().get("data");  // Get photo data as bitmap
                    else
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(data.getData())); // Read file as bitmap

                    // Save bitmap to internal storage
                    File directory = new ContextWrapper(this).getDir("photos", Context.MODE_PRIVATE);   // Directorio interno "app_photos"
                    File photofile = new File(directory, "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".jpg");

                    Log.d("TAG", "Save photo file to " + photofile.getAbsolutePath());
                    FileOutputStream fos = new FileOutputStream(photofile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.close();

                    // Refresh RecyclerView Adapter
                    PhotoAdapter photoAdapter = (PhotoAdapter) this.recyclerView.getAdapter();
                    photoAdapter.getPhotos().add(photofile.getAbsolutePath());
                    photoAdapter.notifyDataSetChanged();

                    this.recyclerView.scrollToPosition(photoAdapter.getItemCount()-1);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

    // List photo files from internal storage
    private void loadPhotos(){
        PhotoAdapter photoAdapter = (PhotoAdapter) this.recyclerView.getAdapter();

        File directory = new ContextWrapper(this).getDir("photos", Context.MODE_PRIVATE);
        String[] filenames = directory.list();
        for (int i=0; i<filenames.length; i++){
            File photofile = new File(directory, filenames[i]);
            Log.d("TAG", "Get photo from " + photofile.getAbsolutePath());
            photoAdapter.getPhotos().add(photofile.getAbsolutePath());
        }

        photoAdapter.notifyDataSetChanged();
    }

}