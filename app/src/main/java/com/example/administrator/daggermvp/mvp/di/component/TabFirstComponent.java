package com.example.administrator.daggermvp.mvp.di.component;

import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.di_app.scope.FragmentScope;
import com.example.administrator.daggermvp.mvp.di.module.TabFirstPresenterModule;
import com.example.administrator.daggermvp.mvp.ui.fragment.FirstTabFragment;
import com.example.administrator.daggermvp.mvp.ui.fragment.SecondTabFragment;

import dagger.Component;

/**
 * tab 首页面依赖注入器
 */
@FragmentScope
@Component(modules = {TabFirstPresenterModule.class},dependencies = AppComponent.class)
public interface TabFirstComponent {

    void inject(FirstTabFragment fragment);
    void inject(SecondTabFragment fragment);
}
