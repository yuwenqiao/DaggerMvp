package com.example.administrator.daggermvp.net.httpprovider;

import android.content.Context;
import android.util.Log;

import com.example.administrator.daggermvp.net.HttpActionHandle;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * desp  登录模块请求相关接口方法
 */
public class LoginProvider extends BaseRequestProvider {
    protected HttpActionHandle httpActionHandle;
    @Inject
    public LoginProvider( HttpActionHandle actionHandle) {
        super(actionHandle);
        this.httpActionHandle=actionHandle;
    }

    /**
     * Description: 登录接口
     *
     * @param httpFlag 请求标识
     * @param phone    登录号
     * @param pwd      登录密码
     *                 Create Date:
     */
    public void requestLogin(String httpFlag, String requestUrl, String phone, String pwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("mobilePhone", phone);
        map.put("loginPassword", pwd);
        post(map, httpFlag, requestUrl, httpActionHandle);
    }
}
