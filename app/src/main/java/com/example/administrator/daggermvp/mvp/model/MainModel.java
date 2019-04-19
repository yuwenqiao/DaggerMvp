package com.example.administrator.daggermvp.mvp.model;

import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.mvp.contract.MainConstract;
import com.example.administrator.daggermvp.net.httpprovider.LoginProvider;

import javax.inject.Inject;


public class MainModel extends BaseModel implements MainConstract.Model{
    @Inject
    public MainModel(){
    }

    @Override
    public void showStr() {
    }
}
