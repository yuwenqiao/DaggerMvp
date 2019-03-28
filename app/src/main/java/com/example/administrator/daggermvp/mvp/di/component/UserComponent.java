package com.example.administrator.daggermvp.mvp.di.component;

import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.di.module.UserPresenterModule;
import com.example.administrator.daggermvp.mvp.ui.UserActivity;

import dagger.Component;

/**
 *   主要是View中注入 xxxPresenter的实例 ，UserModule  主要是给提供 model实例,provier 实例;   其中参数主要是继承 appComponent 中的retrofitHelper 实例）
 */
@ActivityScope
@Component (modules = {UserPresenterModule.class},dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity userActivity);
}
