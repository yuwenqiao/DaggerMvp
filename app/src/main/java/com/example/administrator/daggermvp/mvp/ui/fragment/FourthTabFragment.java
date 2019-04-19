package com.example.administrator.daggermvp.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.daggermvp.R;
import com.example.administrator.daggermvp.bases.BaseFragment;
import com.example.administrator.daggermvp.mvp.contract.TabFirstConstract;
import com.example.administrator.daggermvp.mvp.presenter.TabFirstPresenter;

/**
 *  主页面导航第四页
 */
public class FourthTabFragment extends BaseFragment<TabFirstPresenter> implements TabFirstConstract.View {

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

    }
}
