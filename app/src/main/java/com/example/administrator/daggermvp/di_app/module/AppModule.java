package com.example.administrator.daggermvp.di_app.module;

import com.example.administrator.daggermvp.bases.MyApplication;
import com.example.administrator.daggermvp.utils.ActivityManager;
import com.example.administrator.daggermvp.utils.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    MyApplication provideApplication(){
        return this.application;
    }

    /**
     * 网络请求处理类
     * @return
     */
    @Singleton
    @Provides
    RetrofitHelper provideRetrifitHelper(Retrofit mRetrifit){
        return  new RetrofitHelper(mRetrifit);
    }

    /**
     *  activity 管理者
     * @return
     */
    @Singleton
    @Provides
    ActivityManager provideAppManager(){
        return new ActivityManager();
    }

}
