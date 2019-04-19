package com.example.administrator.daggermvp.mvp.di.component;

import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.di.module.FramePresenterModule;
import com.example.administrator.daggermvp.mvp.ui.activity.FrameActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {FramePresenterModule.class},dependencies = AppComponent.class)
public interface FrameComponent {
    void inject(FrameActivity frameActivity);
}
