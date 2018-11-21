package com.example.administrator.daggermvp.mvp.model;

import android.util.Log;

import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.http.api.UserService;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.utils.RetrofitHelper;


public class UserModel extends BaseModel implements UserConstract.Model{

    public UserModel(RetrofitHelper retrofitHelper) {
        super(retrofitHelper);
    }
    @Override
    public void showStr() {

    }
}
