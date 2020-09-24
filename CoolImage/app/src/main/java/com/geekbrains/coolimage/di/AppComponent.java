package com.geekbrains.coolimage.di;

import com.geekbrains.coolimage.model.entity.PixabayResponse;
import com.geekbrains.coolimage.model.retrofit.RetrofitApi;
import com.geekbrains.coolimage.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(RetrofitApi retrofitApi);

    void inject(PixabayResponse pixabayResponse);

    void inject(MainPresenter mainPresenter);

}
