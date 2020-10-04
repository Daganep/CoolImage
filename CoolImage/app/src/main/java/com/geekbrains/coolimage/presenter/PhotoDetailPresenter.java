package com.geekbrains.coolimage.presenter;

import android.util.Log;
import android.widget.ImageView;

import com.geekbrains.coolimage.di.App;
import com.geekbrains.coolimage.model.Model;
import com.geekbrains.coolimage.model.picasso.ImageSetter;
import com.geekbrains.coolimage.view.photodetail.PhotoDetailView;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class PhotoDetailPresenter extends MvpPresenter<PhotoDetailView> {

    private final String TAG = "Request";
    private ImageSetter imageSetter;

    @Inject
    Model model;

    public PhotoDetailPresenter(){
        App.getAppComponent().inject(this);
        imageSetter = new ImageSetter();
        Log.d(TAG, "" + model.getPhotoPosition());
    }

    public void setImage(ImageView imageView){
        imageSetter.setImage(model.getCurrentReference(), imageView);
    }


}
