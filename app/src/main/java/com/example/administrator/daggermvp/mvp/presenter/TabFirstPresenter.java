package com.example.administrator.daggermvp.mvp.presenter;

import com.example.administrator.daggermvp.bases.mvp.BasePresenter;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.di_app.scope.FragmentScope;
import com.example.administrator.daggermvp.mvp.contract.TabFirstConstract;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;

import javax.inject.Inject;

/**
 * tab首页面逻辑处理类
 */
@FragmentScope
public class TabFirstPresenter extends BasePresenter<TabFirstConstract.View,TabFirstConstract.Model> {

    @Inject
    public TabFirstPresenter(TabFirstConstract.View view, TabFirstConstract.Model model) {
        super(view, model);
    }
}
