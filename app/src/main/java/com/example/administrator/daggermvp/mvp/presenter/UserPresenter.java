package com.example.administrator.daggermvp.mvp.presenter;


import android.util.Log;

import com.example.administrator.daggermvp.bases.mvp.BasePresenter;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;


import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class UserPresenter extends BasePresenter<UserConstract.View,UserConstract.Model> {
    private static final String REQUST_LOGIN="REQUST_LOGIN";
    @Inject
    public UserPresenter(UserConstract.View view,UserConstract.Model model) {
        super(view, model);
    }

    public void show(){
        mModel.requestLogin(REQUST_LOGIN,"URL","1323636333","password");
    }

    @Override
    public void handleActionSuccess(String httpFlag, Object object) {
        super.handleActionSuccess(httpFlag, object);
        Log.i("dagger","success");
        Observable call= (Observable) object;
       // call.
    }
}
