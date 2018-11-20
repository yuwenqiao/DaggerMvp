package com.example.administrator.daggermvp.mvp.contract;

import com.example.administrator.daggermvp.bases.mvp.IModel;
import com.example.administrator.daggermvp.bases.mvp.IView;

public interface UserConstract {

    interface View extends IView{

    }

    interface Model extends IModel{
       void showStr();
    }
}
