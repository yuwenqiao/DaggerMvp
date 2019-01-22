package com.example.administrator.daggermvp.mvp.model;

import android.util.Log;

import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerProviderComponent;
import com.example.administrator.daggermvp.mvp.di.module.HttpAcHandleModule;
import com.example.administrator.daggermvp.net.HttpActionHandle;
import com.example.administrator.daggermvp.net.httpprovider.LoginProvider;


public class UserModel extends BaseModel <LoginProvider>implements UserConstract.Model{
    @Override
    protected void setupProviderComponent(HttpActionHandle httpActionHandle) {
        DaggerProviderComponent.builder().httpAcHandleModule(new HttpAcHandleModule(httpActionHandle)).build().inject(this);
    }

    @Override
    public void requestLogin(String httpFlag, String url, String phone, String password) {
        mProvider.requestLogin(httpFlag,url,phone,password);
    }
}
