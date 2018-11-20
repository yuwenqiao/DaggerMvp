package com.example.administrator.daggermvp.mvp.presenter;

import android.util.Log;

import com.example.administrator.daggermvp.bases.mvp.BasePresenter;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;

import javax.inject.Inject;

@ActivityScope
public class UserPresenter extends BasePresenter<UserConstract.View,UserConstract.Model> {
    @Inject
    public UserPresenter(UserConstract.View view,UserConstract.Model model) {
        super(view, model);
    }

    public void show(){
        mModel.showStr();
    }
}
