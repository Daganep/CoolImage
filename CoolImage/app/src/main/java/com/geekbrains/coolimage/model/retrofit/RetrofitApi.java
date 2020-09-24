package com.geekbrains.coolimage.model.retrofit;

import com.geekbrains.coolimage.model.entity.PixabayResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    public Observable<PixabayResponse> requestServer(){
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RetrofitService api = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);

        return api.getPictures().subscribeOn(Schedulers.io());
    }
}
