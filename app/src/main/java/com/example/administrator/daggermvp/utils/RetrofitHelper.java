package com.example.administrator.daggermvp.utils;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import retrofit2.Retrofit;

@Singleton
public class RetrofitHelper {


   protected Retrofit mRetrofit;

    @Inject
    public RetrofitHelper(Retrofit mRetrifit){
        this.mRetrofit=mRetrifit;
    }
    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param service
     * @param <T>
     * @return
     */

    public synchronized <T> T obtainRetrofitService(Class<T> service) {
       T retrofitService = mRetrofit.create(service);
        return retrofitService;
    }
}
