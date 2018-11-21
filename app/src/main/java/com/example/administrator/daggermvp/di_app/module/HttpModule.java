package com.example.administrator.daggermvp.di_app.module;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 提供网络相关
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, String base_url, Gson gson){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(base_url) //域名
                .client(client) // okhttp
                .addConverterFactory(GsonConverterFactory.create(gson))   //数据解析
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) ; //支持Rxjava
        return builder.build();
    }

    // 最好在弄一个有cache的 和无cache的 OKhttp 供后面使用   (Interceptor intercept, @Nullable List<Interceptor> interceptors)
    @Singleton
    @Provides
    OkHttpClient provideHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS);
//                .addNetworkInterceptor(intercept);
//        if(interceptors!=null){ //如果外部提供了interceptors的集合遍历添加
//            for(Interceptor interceptor:interceptors){
//                builder.addInterceptor(interceptor);
//            }
//        }
        return builder.build();
    }

    @Singleton
    @Provides
    Gson provideGson(){
        return  new GsonBuilder().create();
    }

    @Singleton
    @Provides
    String provideStr(){
        return "http://www.baidu./";
    }
}
