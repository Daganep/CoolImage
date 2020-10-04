package com.geekbrains.coolimage.view.photodetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.geekbrains.coolimage.databinding.ActivityPhotoDetailBinding;

import android.os.Bundle;

import com.geekbrains.coolimage.R;
import com.geekbrains.coolimage.presenter.PhotoDetailPresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class PhotoDetailActivity extends MvpAppCompatActivity implements PhotoDetailView {

    private ActivityPhotoDetailBinding photoDetailBinding;

    @InjectPresenter
    PhotoDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoDetailBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_photo_detail);

        presenter.setImage(photoDetailBinding.imageView);
    }
}