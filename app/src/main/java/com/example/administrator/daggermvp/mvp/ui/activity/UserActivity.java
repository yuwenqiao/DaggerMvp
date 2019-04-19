package com.example.administrator.daggermvp.mvp.ui.activity;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.daggermvp.R;
import com.example.administrator.daggermvp.bases.BaseActivity;
import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerUserComponent;
import com.example.administrator.daggermvp.mvp.di.module.UserPresenterModule;
import com.example.administrator.daggermvp.mvp.presenter.UserPresenter;
import com.example.administrator.daggermvp.other_view.LoadingProgress;


public class UserActivity extends BaseActivity<UserPresenter> implements UserConstract.View{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.btn);
        btn.setText("user页面");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mPresenter.show();

            }});
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
        initLifecycleObserver(getLifecycle());
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void showLoading() {
        LoadingProgress.showProgressDialog(this);
    }

    @Override
    public void hideLoading() {
        LoadingProgress.dismissProgressDialog();
    }

    @Override
    public void showMessage(@NonNull String message) {

    }
}
