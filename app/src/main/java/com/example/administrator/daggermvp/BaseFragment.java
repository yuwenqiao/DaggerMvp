package com.example.administrator.daggermvp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.administrator.daggermvp.bases.mvp.IPresenter;

import javax.inject.Inject;

import io.reactivex.annotations.Nullable;

public abstract class BaseFragment<P extends IPresenter> extends Fragment {

    @Inject
    @Nullable
    protected P mPresenter;//如果当前页面逻辑简单, Presenter 可以为 null



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initListener();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
    }



}