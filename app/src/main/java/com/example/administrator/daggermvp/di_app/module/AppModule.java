package com.example.administrator.daggermvp.di_app.module;

import com.example.administrator.daggermvp.bases.MyApplication;
import com.example.administrator.daggermvp.utils.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *  提供全局applicaContext 和 retrofit 的请求管理类
 */
@Module
public class AppModule {
    private MyApplication application;
    public AppModule(MyApplication application) {
        this.application=application;
    }

    @Singleton
    @Provides
    MyApplication provideApplicationContext(){
        return this.application;
    }


    @Singleton
    @Provides
    RetrofitHelper provideRetrifitHelper( ){

        return  new RetrofitHelper();
    }

}
