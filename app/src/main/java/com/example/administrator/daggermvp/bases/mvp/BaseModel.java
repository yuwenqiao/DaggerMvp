package com.example.administrator.daggermvp.bases.mvp;

import android.util.Log;

import com.example.administrator.daggermvp.utils.RetrofitHelper;

public class BaseModel implements IModel {
    protected RetrofitHelper retrofitHelper;
    public BaseModel(RetrofitHelper retrofitHelper){
        this.retrofitHelper=retrofitHelper;
    }

    @Override
    public void onDestroy() {
        retrofitHelper=null;
    }
}
