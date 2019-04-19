package com.example.administrator.daggermvp.mvp.presenter;


import com.example.administrator.daggermvp.bases.mvp.BasePresenter;
import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.bean.UserBean;
import com.example.administrator.daggermvp.net.RequestException;
import com.example.administrator.daggermvp.utils.rx.BaseObserver;
import com.example.administrator.daggermvp.utils.rx.RxUtil;


import javax.inject.Inject;

import io.reactivex.disposables.Disposable;


@ActivityScope
public class UserPresenter extends BasePresenter<UserConstract.View,UserConstract.Model> {
    @Inject
    public UserPresenter(UserConstract.View view,UserConstract.Model model) {
        super(view, model);
    }

    public void show(){
       mModel.requestLogin("13333333333","a123456")
                .compose(RxUtil.applySchedulers())
                .compose(RxUtil.<UserBean>handelResult())
                    .as(super.<UserBean>bindLifecycle())
                   .subscribe(new BaseObserver<UserBean>() {
                       @Override
                       public void onSuccess(UserBean userBean) {
                           mView.hideLoading();
                            //  明天叫请求时间调长，模拟请求，页面onpause时看请求是否终止----------------------------------------------------------------------------
                       }

                       @Override
                       public void onFail(RequestException e) {
                            mView.hideLoading();
                       }

                       @Override
                       public void onSubscrebe(Disposable d) {
                           mView.showLoading();
                       }
                   });

    }


}
