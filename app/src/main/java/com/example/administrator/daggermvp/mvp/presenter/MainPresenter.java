package com.example.administrator.daggermvp.mvp.presenter;

import com.example.administrator.daggermvp.bases.mvp.BasePresenter;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.MainConstract;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;

import javax.inject.Inject;

@ActivityScope
public class MainPresenter extends BasePresenter<MainConstract.View,MainConstract.Model> {
    @Inject
    public MainPresenter(MainConstract.View view, MainConstract.Model model) {

        super(view, model);
    }

    public void show(){
        mModel.showStr();
    }
}
