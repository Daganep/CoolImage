package com.geekbrains.coolimage.presenter;

import android.util.Log;

import com.geekbrains.coolimage.di.App;
import com.geekbrains.coolimage.model.entity.Hit;
import com.geekbrains.coolimage.model.entity.PixabayResponse;
import com.geekbrains.coolimage.model.retrofit.RetrofitApi;
import com.geekbrains.coolimage.view.main.MainView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private final String TAG = "Request";

    @Inject
    RetrofitApi retrofitApi;

    @Inject
    PixabayResponse pixabayResponse;

    public MainPresenter(){
        App.getAppComponent().inject(this);
    }

    public void requestFromServer(){
        Observable<PixabayResponse> single = retrofitApi.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(emitter -> {
            pixabayResponse = emitter;
            getViewState().updateRecyclerView();
            }, throwable -> {
            Log.e("Error", "onError" + throwable);
        });
    }

    public List<Hit> getPhotos(){
        return pixabayResponse.getHits();
    }

    public int getTotal(){
        return pixabayResponse.getTotal();
    }

    public int getTotalHits(){
        return pixabayResponse.getTotalHits();
    }

    public int getHitId(){
        return pixabayResponse.getHits().get(0).id;
    }

}
