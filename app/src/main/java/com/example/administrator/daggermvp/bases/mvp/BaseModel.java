package com.example.administrator.daggermvp.bases.mvp;


import com.example.administrator.daggermvp.net.httpprovider.BaseRequestProvider;

import javax.inject.Inject;

/**
 * 数据请求
 * @param <P>
 */
public abstract class BaseModel <P extends BaseRequestProvider>implements IModel{

    @Inject
    protected P mProvider;

    @Override
    public void onDestroy() {
        if(mProvider!=null){
            mProvider=null;
        }

    }

}
