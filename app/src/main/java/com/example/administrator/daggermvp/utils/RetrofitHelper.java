package com.example.administrator.daggermvp.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RetrofitHelper {

    @Inject
    public RetrofitHelper(){}
    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param service
     * @param <T>
     * @return
     */

//    public synchronized <T> T obtainRetrofitService(Class<T> service) {
//
//        return retrofitService;
//    }
}
