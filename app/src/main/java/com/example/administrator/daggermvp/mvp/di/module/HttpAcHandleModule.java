package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.UserModel;
import com.example.administrator.daggermvp.net.HttpActionHandle;

import dagger.Module;
import dagger.Provides;

/**
 * 为XXXRequstProvider 创建实例时提供构造中的 HttpActionHandle依赖实例
 */
@Module
public class HttpAcHandleModule {

    HttpActionHandle httpActionHandle;
    public HttpAcHandleModule(HttpActionHandle httpActionHandle){
        this.httpActionHandle=httpActionHandle;
    }
    @ActivityScope
    @Provides
    HttpActionHandle provideUserModel(){
        return this.httpActionHandle;
    }

}
