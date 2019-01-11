package com.example.administrator.daggermvp.net;

/**
 * Description: 请求回调函数
 */
public interface HttpActionHandle {

    /**
     * Description: 请求错误回调
     */
    public void handleActionError(String httpFlag, String errorMsg, Exception e, Object result);

    /**
     * Description: 请求成功回调
     *
     */
    public void handleActionSuccess(String httpFlag, Object object);
}
