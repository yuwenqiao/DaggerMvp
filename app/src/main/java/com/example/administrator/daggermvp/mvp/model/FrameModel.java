package com.example.administrator.daggermvp.mvp.model;

import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.bases.mvp.BaseModel;
import com.example.administrator.daggermvp.mvp.contract.FrameConstract;
import com.example.administrator.daggermvp.net.retrofit.RetrofitClients;


public class FrameModel extends BaseModel implements FrameConstract.Model{
    protected RetrofitClients retrofitHelper;
    public FrameModel(){
        retrofitHelper= BaseApplication.getInstance().getRetrofitClient();
    }




    @Override
    public void showStr() {

    }
}
