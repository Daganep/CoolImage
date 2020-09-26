package com.geekbrains.coolimage.di;

import android.app.Application;

import com.geekbrains.coolimage.model.entity.Hit;
import com.geekbrains.coolimage.model.entity.PixabayResponse;
import com.geekbrains.coolimage.model.picasso.ImageSetter;
import com.geekbrains.coolimage.model.retrofit.RetrofitApi;
import com.geekbrains.coolimage.presenter.MainPresenter;
import com.geekbrains.coolimage.view.recyclerview.RecyclerViewAdapter;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    RetrofitApi provideRetrofitApi(){return new RetrofitApi();}

    @Singleton
    @Provides
    PixabayResponse providePixabayResponse(){return new PixabayResponse();}

    @Singleton
    @Provides
    MainPresenter provideMainPresenter(){return new MainPresenter();}

    /*@Singleton
    @Provides
    ImageSetter provideImageSetter(){return new ImageSetter();}*/
}
