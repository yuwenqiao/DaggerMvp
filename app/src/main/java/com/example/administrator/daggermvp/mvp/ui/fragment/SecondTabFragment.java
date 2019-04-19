package com.example.administrator.daggermvp.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.daggermvp.R;
import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.bases.BaseFragment;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.mvp.contract.TabFirstConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerTabFirstComponent;
import com.example.administrator.daggermvp.mvp.di.module.TabFirstPresenterModule;
import com.example.administrator.daggermvp.mvp.presenter.TabFirstPresenter;

/**
 * 主页面导航第二页
 */
public class SecondTabFragment extends BaseFragment<TabFirstPresenter> implements TabFirstConstract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void initView() {

        View view = getView();
        //    banner = (ConvenientBanner) view.findViewById(R.id.banner);

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

    @Override
    public void setupActivityComponent() {
        AppComponent appComponent= ((BaseApplication) getActivity().getApplicationContext()).getAppComponent();
        DaggerTabFirstComponent.builder().tabFirstPresenterModule(new TabFirstPresenterModule(this)).appComponent(appComponent).build().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment","onresume-----------2222222--------------");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment","onstart-----------22222222--------------");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i("fragment","onpause-----------22222--------------");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment","onStop-----------22222--------------");
    }
}
