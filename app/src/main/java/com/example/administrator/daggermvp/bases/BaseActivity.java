package com.example.administrator.daggermvp.bases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.daggermvp.bases.mvp.IPresenter;
import com.example.administrator.daggermvp.utils.ActivityManager;

import javax.inject.Inject;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity  {
    // presenter 通过依赖注入实例，model ,view  已经注入。
    @Inject
    protected P  mPresenter;
    @Inject
    ActivityManager activityManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
        activityManager.addActivity(this);
    }
    // 注入器注入的地方
    public abstract void setupActivityComponent();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.onDestroy();
        }
        mPresenter=null;
        activityManager.removeActivity(this);
    }

    public abstract void initView();
    public abstract void initListener();
}
