package com.example.administrator.daggermvp.mvp.model;

import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerUserProviderComponent;
import com.example.administrator.daggermvp.mvp.di.module.HttpAcHandleModule;
import com.example.administrator.daggermvp.net.httpprovider.LoginProvider;


public class UserModel extends BaseModel <LoginProvider>implements UserConstract.Model{
    public UserModel() {
       //为其父类中的Provider注入器
       DaggerUserProviderComponent.builder().httpAcHandleModule(new HttpAcHandleModule(this)).build().inject(this);
    }

    @Override
    public void showStr() {
        mProvider.requestLogin("haha","hhh","122","123");
    }
}
