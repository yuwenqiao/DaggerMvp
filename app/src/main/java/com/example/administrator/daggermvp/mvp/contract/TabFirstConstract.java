package com.example.administrator.daggermvp.mvp.contract;

import com.example.administrator.daggermvp.bases.mvp.IModel;
import com.example.administrator.daggermvp.bases.mvp.IView;
import com.example.administrator.daggermvp.mvp.model.bean.UserBean;
import com.example.administrator.daggermvp.net.HttpResponse;

import io.reactivex.Observable;

public interface TabFirstConstract {

    interface View extends IView {

    }

    interface Model extends IModel {
        Observable<HttpResponse<UserBean>> requestLogin(String phone, String password);
    }
}
