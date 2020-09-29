package com.geekbrains.coolimage.view.photodetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.geekbrains.coolimage.databinding.ActivityPhotoDetailBinding;

import android.os.Bundle;

import com.geekbrains.coolimage.R;

public class PhotoDetailActivity extends AppCompatActivity {

    private ActivityPhotoDetailBinding photoDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoDetailBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_photo_detail);
    }
}