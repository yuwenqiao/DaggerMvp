package com.example.administrator.daggermvp.di_app.module;

import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.net.retrofit.RetrofitClients;
import com.example.administrator.daggermvp.utils.ActivityManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 *  提供全局applicaContext 和 retrofit 的请求管理类
 */
@Module
public class AppModule {
    private BaseApplication application;
    public AppModule(BaseApplication application) {
        this.application=application;
    }

    @Singleton
    @Provides
    BaseApplication provideApplication(){
        return this.application;
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

    /**
     *  activity 管理者
     * @return
     */
    @Singleton
    @Provides
    RetrofitClients provideARetrofitClient(Retrofit retrofit){
        return new RetrofitClients(retrofit);
    }

}
