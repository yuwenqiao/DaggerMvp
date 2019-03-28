package com.example.administrator.daggermvp.di_app.module;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 提供Retrofit 实例依赖
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) ; //支持Rxjava
        return builder.build();
    }

    // 最好在弄一个有cache的 和无cache的 OKhttp 供后面使用   (Interceptor intercept, @Nullable List<Interceptor> interceptors)
    @Singleton
    @Provides
    OkHttpClient provideHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
               .addInterceptor(new RequestLoggerInterceptor());
            //   .addNetworkInterceptor(mTokenInterceptor); 让网络请求附加上拦截器，比如为请求添加token参数；
//        if(interceptors!=null){ //如果外部提供了interceptors的集合遍历添加
//            for(Interceptor interceptor:interceptors){
//                builder.addInterceptor(interceptor);
//            }
//        }
        return builder.build();
    }
    class RequestLoggerInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Log.i("dagger", "url     =  : " + request.url());
            Log.i("dagger", "method  =  : " + request.method());
            Log.i("dagger", "headers =  : " + request.headers().toString());
            Log.i("dagger", "body    =  : " + response.body().toString());
            Log.i("dagger", "body    =  : " + response.headers().toString());

            return response;
        }
    }
    @Singleton
    @Provides
    Gson provideGson(){
        return  new GsonBuilder().create();
    }

    @Singleton
    @Provides
    String provideStr(){
        return "http://192.168.40.234:8011/";
    }
}
