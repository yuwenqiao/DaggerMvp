package com.example.administrator.daggermvp.mvp.presenter;

import com.example.administrator.daggermvp.bases.mvp.BasePresenter;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.FrameConstract;

import javax.inject.Inject;

@ActivityScope
public class FramePresenter extends BasePresenter<FrameConstract.View,FrameConstract.Model> {
    @Inject
    public FramePresenter(FrameConstract.View view, FrameConstract.Model model) {
        super(view, model);
    }
}
