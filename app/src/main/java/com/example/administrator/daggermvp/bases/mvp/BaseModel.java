package com.example.administrator.daggermvp.bases.mvp;


import com.example.administrator.daggermvp.mvp.di.component.DaggerProviderComponent;
import com.example.administrator.daggermvp.mvp.di.component.ProviderComponent;
import com.example.administrator.daggermvp.mvp.di.module.HttpAcHandleModule;
import  com.example.administrator.daggermvp.net.HttpActionHandle;
import com.example.administrator.daggermvp.net.httpprovider.BaseRequestProvider;

import javax.inject.Inject;

/**
 * 具体的请求业务处理放在这里，包括参数的校验
 * @param <P>
 */
public abstract class BaseModel <P extends BaseRequestProvider>implements IModel{

    protected HttpActionHandle httpActionHandle;
    @Inject
    protected P mProvider;
    public BaseModel(){

    }

    /**
     * 实现RequestProvider实例注入具体方法
     */
    protected abstract void setupProviderComponent(HttpActionHandle httpActionHandle);

    /**
     *  presenter层注册的接口回调
     * @param httpActionHandle
     */
    public void setHttpActionHandle(HttpActionHandle httpActionHandle){
        this.httpActionHandle=httpActionHandle;
        setupProviderComponent(httpActionHandle);
    }
    @Override
    public void onDestroy() {
        if(mProvider!=null){
            mProvider=null;
        }

    }

}
