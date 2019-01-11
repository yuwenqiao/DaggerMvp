package com.example.administrator.daggermvp.mvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.administrator.daggermvp.R;
import com.example.administrator.daggermvp.bases.BaseActivity;
import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerUserComponent;
import com.example.administrator.daggermvp.mvp.di.module.UserPresenterModule;
import com.example.administrator.daggermvp.mvp.presenter.UserPresenter;

public class UserActivity extends BaseActivity<UserPresenter> implements UserConstract.View{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.show();
            }
        });
    }

    @Override
    public void setupActivityComponent() {
        AppComponent appComponent= ((BaseApplication) getApplicationContext()).getAppComponent();
        DaggerUserComponent.builder().userPresenterModule(new UserPresenterModule(this)).appComponent(appComponent).build().inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }
}
