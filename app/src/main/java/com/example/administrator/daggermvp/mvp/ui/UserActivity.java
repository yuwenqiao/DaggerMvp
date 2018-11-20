package com.example.administrator.daggermvp.mvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.administrator.daggermvp.MainActivity;
import com.example.administrator.daggermvp.R;
import com.example.administrator.daggermvp.bases.BaseActivity;
import com.example.administrator.daggermvp.bases.MyApplication;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerUserComponent;
import com.example.administrator.daggermvp.mvp.di.module.PresenterModule;
import com.example.administrator.daggermvp.mvp.presenter.UserPresenter;

public class UserActivity extends BaseActivity<UserPresenter> implements UserConstract.View{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void setupActivityComponent() {
        AppComponent appComponent= ((MyApplication) getApplicationContext()).getAppComponent();
        DaggerUserComponent.builder().presenterModule(new PresenterModule(this)).appComponent(appComponent).build().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.show();
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
