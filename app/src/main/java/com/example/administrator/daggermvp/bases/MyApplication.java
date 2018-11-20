package com.example.administrator.daggermvp.bases;

import android.app.Application;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.di_app.component.DaggerAppComponent;
import com.example.administrator.daggermvp.di_app.module.AppModule;

public class MyApplication extends Application {
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
       // appComponent.inject(this);
    }

    /**
     *  提供AppComponent  供依赖使用
     * @return
     */
    public AppComponent getAppComponent() {
        return appComponent;
    }
}
