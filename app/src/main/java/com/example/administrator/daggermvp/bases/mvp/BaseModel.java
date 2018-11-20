package com.example.administrator.daggermvp.bases.mvp;

import android.util.Log;

import com.example.administrator.daggermvp.utils.RetrofitHelper;

public class BaseModel implements IModel {
    private RetrofitHelper retrofitHelper;
    public BaseModel(RetrofitHelper retrofitHelper){
        this.retrofitHelper=retrofitHelper;
        Log.i("dagger2","retrofitHelper------"+retrofitHelper);
    }

    @Override
    public void onDestroy() {
        Log.i("dagger2","ondestroy11------"+retrofitHelper);
        retrofitHelper=null;
        Log.i("dagger2","ondestroy22------"+retrofitHelper);
    }
}
