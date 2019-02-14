package com.example.camara;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>  {

    private List<String> photos;

    public PhotoAdapter(){
        this.photos = new ArrayList<>();
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<String> getPhotos() {
        return photos;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView photoImage;
        ImageButton removeButton;

        public ViewHolder(View itemView) {
            super(itemView);
            photoImage = itemView.findViewById(R.id.photo_image);
            removeButton = itemView.findViewById(R.id.remove_button);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String photo = this.photos.get(position);

        holder.photoImage.setImageBitmap(BitmapFactory.decodeFile(photo));

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(holder.itemView.getContext())
                        .setMessage("¿Desea eliminar el archivo?")
                        .setNegativeButton(android.R.string.cancel, null)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // Remove photo file
                                new File(photo).delete();

                                // Refresh RecyclerView Adapter
                                photos.remove(position);
                                notifyDataSetChanged();

                            }
                        }).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.photos.size();
    }

}