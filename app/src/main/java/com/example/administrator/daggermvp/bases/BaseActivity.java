package com.example.administrator.daggermvp.bases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.daggermvp.bases.mvp.IPresenter;

import javax.inject.Inject;

public class BaseActivity<P extends IPresenter> extends AppCompatActivity  {
    // presenter 通过依赖注入实例，model ,view  已经注入。
    @Inject
    protected P  mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    public void setupActivityComponent(){

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.onDestroy();
        }
        mPresenter=null;
    }
}
