package com.example.administrator.daggermvp.bases.mvp;


import com.example.administrator.daggermvp.net.HttpActionHandle;
import com.example.administrator.daggermvp.net.httpprovider.BaseRequestProvider;

import javax.inject.Inject;

public class BaseModel <P extends BaseRequestProvider>implements IModel,HttpActionHandle {
    @Inject
    protected P mProvider;
    public BaseModel(){

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void handleActionError(String httpFlag, String errorMsg, Exception e, Object result) {

    }

    @Override
    public void handleActionSuccess(String httpFlag, Object object) {

    }
}
