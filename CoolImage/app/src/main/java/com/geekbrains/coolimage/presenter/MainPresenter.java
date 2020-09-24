package com.geekbrains.coolimage.presenter;

import android.util.Log;

import com.geekbrains.coolimage.di.App;
import com.geekbrains.coolimage.model.entity.PixabayResponse;
import com.geekbrains.coolimage.model.retrofit.RetrofitApi;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainPresenter {
    @Inject
    RetrofitApi retrofitApi;

    @Inject
    PixabayResponse pixabayResponse;

    public MainPresenter(){
        App.getAppComponent().inject(this);
        requestFromServer();
    }

    public void requestFromServer(){
        Observable<PixabayResponse> single = retrofitApi.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(emitter -> {
            pixabayResponse = emitter;
        }, throwable -> {
            Log.e("Error", "onError" + throwable);
        });
    }
}
