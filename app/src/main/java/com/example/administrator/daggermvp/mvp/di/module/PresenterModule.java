package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * 提供view 和model 实例
 */
@Module
public class PresenterModule {

    private UserConstract.View view;
    public PresenterModule (UserConstract.View  view){
        this.view=view;
    }
    @ActivityScope
    @Provides
    UserConstract.View provideView(){
        return this.view;
    }
    @ActivityScope
    @Provides
    UserConstract.Model provideModel (UserModel model){
        return  model;
    }


}
