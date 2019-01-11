package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.model.UserModel;
import com.example.administrator.daggermvp.net.httpprovider.LoginProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

//    @ActivityScope
//    @Provides
//    LoginProvider provideLoginProvider(UserModel model){
//        return new LoginProvider(model);
//    }
    @ActivityScope
    @Provides
    UserModel provideUserModel(){
        return new UserModel();
    }

}
