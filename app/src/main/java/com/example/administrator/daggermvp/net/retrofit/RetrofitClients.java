package com.example.administrator.daggermvp.net.retrofit;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
@Singleton
public class RetrofitClients {
    protected  Retrofit mRetrofit;
    @Inject
    public RetrofitClients(Retrofit retrofit){
        this.mRetrofit=retrofit;
    }
    public RetrofitService getRetrofitApi(){
        return mRetrofit.create(RetrofitService.class);
    }
}
