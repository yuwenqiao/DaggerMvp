package com.example.administrator.daggermvp.mvp.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.daggermvp.R;
import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.bases.BaseFragment;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.mvp.contract.TabFirstConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerTabFirstComponent;
import com.example.administrator.daggermvp.mvp.di.module.TabFirstPresenterModule;
import com.example.administrator.daggermvp.mvp.presenter.TabFirstPresenter;
import com.example.administrator.daggermvp.mvp.ui.activity.UserActivity;

/**
 *  主页面导航第一页
 */
public class FirstTabFragment extends BaseFragment<TabFirstPresenter>implements TabFirstConstract.View,View.OnClickListener{

    private Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void initView() {
        View view = getView();
        btn = (Button) view.findViewById(R.id.btn);
    }

    @Override
    public void initListener() {
        btn.setOnClickListener(this);
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

    @Override
    public void setupActivityComponent() {
        AppComponent appComponent= ((BaseApplication) getActivity().getApplicationContext()).getAppComponent();
        DaggerTabFirstComponent.builder().tabFirstPresenterModule(new TabFirstPresenterModule(this)).appComponent(appComponent).build().inject(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                Intent intent=new Intent(getContext(), UserActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment","onresume-----------1111111--------------");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment","onstart-----------11111111--------------");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("fragment","onpause-----------1111111--------------");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment","onStop-----------11111--------------");
    }
}
