package com.example.administrator.daggermvp.mvp.model;

import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.mvp.contract.TabFirstConstract;
import com.example.administrator.daggermvp.mvp.model.bean.UserBean;
import com.example.administrator.daggermvp.net.HttpResponse;
import com.example.administrator.daggermvp.net.retrofit.RetrofitClients;


import io.reactivex.Observable;

/**
 * tab首页面数据处理类
 */
public class TabFirstModel extends BaseModel implements TabFirstConstract.Model {
    protected RetrofitClients retrofitHelper;
    public TabFirstModel(){
        retrofitHelper= BaseApplication.getInstance().getRetrofitClient();
    }
    @Override
    public Observable<HttpResponse<UserBean>> requestLogin(String phone, String password) {
        return null;
    }
}
