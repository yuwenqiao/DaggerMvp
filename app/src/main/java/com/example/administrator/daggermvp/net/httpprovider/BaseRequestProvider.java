package com.example.administrator.daggermvp.net.httpprovider;

import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.net.HttpActionHandle;
import com.example.administrator.daggermvp.net.retrofit.RetrofitClients;

import java.io.File;
import java.util.Map;

import io.reactivex.Observable;

/**
 * 请求接口泛型，这里可以更改自己选择的网络请求框架
 * 使用的Retrofit作为请求框架，HttpActionHandle这里的回调只是用作call的返回，不是真正意义的网络请求成功回调
 */
public class BaseRequestProvider {

    RetrofitClients retrofitHelper;
    private HttpActionHandle actionHandle;
    public BaseRequestProvider( HttpActionHandle actionHandle){
        this.actionHandle=actionHandle;
        retrofitHelper= BaseApplication.getInstance().getRetrofitClient();
    }

    /**
     * 普通get请求
     * @param map
     * @param httpFlag
     * @param requestUrl
     * @param actionHandle
     */
    public void get(Map<String, Object> map, final String httpFlag, String requestUrl, HttpActionHandle actionHandle){
        Observable call=retrofitHelper.getRetrofitApi().get(requestUrl,map);
        actionHandle.handleActionSuccess(httpFlag,call);
    }

    /**
     * 普通post请求
     * @param map
     * @param httpFlag
     * @param requestUrl
     * @param actionHandle
     */
    public void post(Map<String, Object> map, final String httpFlag, String requestUrl, HttpActionHandle actionHandle){
        Observable call =retrofitHelper.getRetrofitApi().post(requestUrl,map);
        actionHandle.handleActionSuccess(httpFlag,call);
    }

    /**
     * 文件下载
     * @param map
     * @param httpFlag
     * @param requestUrl
     * @param actionHandle
     */
    public void downLoadFile(Map<String, Object> map, final String httpFlag, String requestUrl, HttpActionHandle actionHandle){
        Observable call=retrofitHelper.getRetrofitApi().downLoad(requestUrl,map);
        actionHandle.handleActionSuccess(httpFlag,call);
    }

    /**
     * 文件上传
     * @param map
     * @param httpFlag
     * @param requestUrl
     * @param actionHandle
     */
    public void upLoadFile(Map<String, Object> map, final String httpFlag, String requestUrl, File file, HttpActionHandle actionHandle){
    //   Observable call=retrofitHelper.getRetrofitApi().upLoad(requestUrl,file);
     //   actionHandle.handleActionSuccess(httpFlag,call);
    }
}
