package com.example.administrator.daggermvp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.daggermvp.bases.BaseActivity;
import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.mvp.contract.MainConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerMainComponent;
import com.example.administrator.daggermvp.mvp.di.module.MainPresenterModule;
import com.example.administrator.daggermvp.mvp.presenter.MainPresenter;
import com.example.administrator.daggermvp.mvp.ui.UserActivity;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import io.reactivex.Observable;

public class MainActivity extends BaseActivity<MainPresenter> implements MainConstract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setupActivityComponent() {
        AppComponent appComponent= ((BaseApplication) getApplicationContext()).getAppComponent();
        //DaggerUserComponent.builder().userPresenterModule(new UserPresenterModule(this)).appComponent(appComponent).build().inject(this);
        DaggerMainComponent.builder().mainPresenterModule(new MainPresenterModule(this)).appComponent(appComponent).build().inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

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
