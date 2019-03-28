package com.example.administrator.daggermvp.mvp.model;



import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.bean.UserBean;
import com.example.administrator.daggermvp.net.HttpResponse;
import com.example.administrator.daggermvp.net.httpprovider.LoginProvider;
import com.example.administrator.daggermvp.net.retrofit.RetrofitApi;
import com.example.administrator.daggermvp.net.retrofit.RetrofitClients;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;


public class UserModel extends BaseModel <LoginProvider>implements UserConstract.Model{
    RetrofitClients retrofitHelper;
    @Inject
    public UserModel(){
        // 将具体的请求类实例注入到本类中   暂时无用------------------------------------------
       // DaggerProviderComponent.builder().build().inject(this);
        retrofitHelper= BaseApplication.getInstance().getRetrofitClient();
    }


    @Override
    public Observable<HttpResponse<UserBean>> requestLogin( String phone, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("Phone", phone);
        map.put("password", password);
        map.put("terminal","IPAD");
       return retrofitHelper.getRetrofitApi(RetrofitApi.class).login(map);
    }
}
