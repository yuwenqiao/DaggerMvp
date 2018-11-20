package com.example.administrator.daggermvp.di_app.component;

import com.example.administrator.daggermvp.bases.MyApplication;
import com.example.administrator.daggermvp.di_app.module.AppModule;
import com.example.administrator.daggermvp.di_app.module.HttpModule;
import com.example.administrator.daggermvp.utils.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 提供全局使用相关类
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    //用于管理所有的activity
    // ActivitysManager activitysManager();

    //图片管理器，用于加载图片的管理类，默认使用Glide
    //ImageLoader imageLoader();

    MyApplication getAppContext();  //提供APP 的Context

     RetrofitHelper retrofitHelper();

    // PreferenceHelper  preferenceHelpere();
    void inject(MyApplication application);
}
