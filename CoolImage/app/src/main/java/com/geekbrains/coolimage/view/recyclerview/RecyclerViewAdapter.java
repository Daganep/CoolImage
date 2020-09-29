package com.geekbrains.coolimage.view.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geekbrains.coolimage.R;
import com.geekbrains.coolimage.model.entity.Hit;
import com.geekbrains.coolimage.model.picasso.ImageSetter;
import com.geekbrains.coolimage.presenter.MainPresenter;
import com.geekbrains.coolimage.view.photodetail.PhotoDetailActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder> {

    private final String TAG = "Request";

    private List<Hit> photos;
    private ImageSetter imageSetter;
    private MainPresenter presenter;

    public RecyclerViewAdapter(List<Hit> photos, MainPresenter presenter){
        this.photos = photos;
        this.presenter = presenter;
        imageSetter = new ImageSetter();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.image_view_holder;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        int position;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.view_holder_imageView);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(imageView.getContext(), PhotoDetailActivity.class);
                    intent.putExtra("URL", photos.get(position).getWebFormatUrl());
                    imageView.getContext().startActivity(intent);
                }
            });
        }

        void bind(int position){
            this.position = position;
            imageSetter.setImage(photos.get(position).getWebFormatUrl(), imageView);
        }
    }
}

