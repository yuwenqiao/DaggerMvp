package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.model.UserModel;
import com.example.administrator.daggermvp.utils.RetrofitHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @ActivityScope
    @Provides
    UserModel provideUserModel(RetrofitHelper retrofitHelper){
        return new UserModel(retrofitHelper);
    }
}
