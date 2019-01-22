package com.example.administrator.daggermvp.mvp.contract;

import com.example.administrator.daggermvp.bases.mvp.IModel;
import com.example.administrator.daggermvp.bases.mvp.IView;
import com.example.administrator.daggermvp.net.HttpActionHandle;

/**
 * 契约类，主要是定义view ，presenter主要骨架函数
 */
public interface UserConstract {

    interface View extends IView{

    }

    interface Model extends IModel{
       void requestLogin(String httpFlag, String url, String phone, String password);
    }
}
