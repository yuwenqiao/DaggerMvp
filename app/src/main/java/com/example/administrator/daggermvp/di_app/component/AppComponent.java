package com.example.administrator.daggermvp.di_app.component;

import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.di_app.module.AppModule;
import com.example.administrator.daggermvp.di_app.module.HttpModule;
import com.example.administrator.daggermvp.utils.ActivityManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 提供全局使用相关类
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    //用于管理所有的activity
    ActivityManager activityManager();

    //图片管理器，用于加载图片的管理类，默认使用Glide
    //ImageLoader imageLoader();

    BaseApplication getAppContext();  //提供APP 的Context

    // PreferenceHelper  preferenceHelpere();
    void inject(BaseApplication application);
}
