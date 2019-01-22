package com.example.administrator.daggermvp.mvp.di.component;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.di.module.HttpAcHandleModule;
import com.example.administrator.daggermvp.mvp.model.MainModel;
import com.example.administrator.daggermvp.mvp.model.UserModel;

import dagger.Component;
/**
 * 为创建  XXXRequstProvider 实例提供的注入器，在每个xxxModel实例的构造中添加注入：
 * 可以写入多个注入类   void inject(UserModel userModel);
 */
@ActivityScope
@Component(modules = {HttpAcHandleModule.class})
public interface ProviderComponent {

    void inject(UserModel userModel);
    void inject(MainModel userModel);
   // void inject(UserModel userModel);
   // void inject(UserModel userModel);

}
