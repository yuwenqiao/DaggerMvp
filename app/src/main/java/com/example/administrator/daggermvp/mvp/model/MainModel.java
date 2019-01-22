package com.example.administrator.daggermvp.mvp.model;

import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.mvp.contract.MainConstract;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerProviderComponent;
import com.example.administrator.daggermvp.mvp.di.module.HttpAcHandleModule;
import com.example.administrator.daggermvp.net.HttpActionHandle;
import com.example.administrator.daggermvp.net.httpprovider.LoginProvider;


public class MainModel extends BaseModel <LoginProvider>implements MainConstract.Model{
    @Override
    protected void setupProviderComponent(HttpActionHandle httpActionHandle) {
        DaggerProviderComponent.builder().httpAcHandleModule(new HttpAcHandleModule(httpActionHandle)).build().inject(this);
    }
    @Override
    public void showStr() {
        mProvider.requestLogin("haha","hhh","122","123");
    }
}
