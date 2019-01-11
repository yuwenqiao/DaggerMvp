package com.example.administrator.daggermvp.bases;

import android.app.ActivityManager;
import android.app.Application;

import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.di_app.component.DaggerAppComponent;
import com.example.administrator.daggermvp.di_app.module.AppModule;
import com.example.administrator.daggermvp.net.retrofit.RetrofitClients;

import javax.inject.Inject;

public class BaseApplication extends Application {
    private AppComponent appComponent;
    private static BaseApplication mInstance;
    @Inject
    protected RetrofitClients mRetrofitClient;
    @Inject
    protected ActivityManager mActivityManager;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        appComponent= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }
    public static BaseApplication getInstance() {
        return mInstance;
    }
    /**
     *  提供AppComponent  供其它component依赖使用，主要是使用全局中的实力类如：ActivityManager
     * @return
     */
    public AppComponent getAppComponent() {
        return appComponent;
    }

    public  RetrofitClients getRetrofitClient(){
        return mRetrofitClient;
    }
}
