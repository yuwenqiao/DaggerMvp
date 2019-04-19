package com.example.administrator.daggermvp.bases.mvp;


import com.example.administrator.daggermvp.net.httpprovider.BaseRequestProvider;

import javax.inject.Inject;

/**
 * 数据请求公共方法封装，暂时无用，根据需求创建
 */
public abstract class BaseModel implements IModel{
    /**
     * 取消时候根据需求做处理
     */
    @Override
    public void onDestroy() {
       //正常是做数据请求取消处理，此项目使用RxLife,自动根据生命周期结束掉请求

    }

}
