package com.geekbrains.coolimage.model.retrofit;

import com.geekbrains.coolimage.model.entity.PixabayResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("?key=17902344-d6abfe0f0033b2d53a27c83f0&image_type=photo")
    Observable<PixabayResponse> getPictures();
}
