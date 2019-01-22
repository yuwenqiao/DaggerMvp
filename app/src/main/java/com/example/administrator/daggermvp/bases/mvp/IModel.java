package com.example.administrator.daggermvp.bases.mvp;

import com.example.administrator.daggermvp.net.HttpActionHandle;

/**
 *  框架要求每个Model都要实现此类。满足规范
 */
public interface IModel {

    /**
     *  presenter层注册的接口回调
     * @param httpActionHandle
     */
    void setHttpActionHandle(HttpActionHandle httpActionHandle);

    /**
     * 在框架中 BasePresenter 的onDestroy 时会默认调用
     */
    void onDestroy();
}
