package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * 为创建presenter实例提供构造中需要的 view 和model 实例
 */
@Module
public class UserPresenterModule {

    private UserConstract.View view;
    //只能通过在view注入的地方将view添加进来作为依赖
    public UserPresenterModule(UserConstract.View  view){
        this.view=view;
    }
    @ActivityScope
    @Provides
    UserConstract.View provideView(){
        return this.view;
    }
    @ActivityScope
    @Provides
    UserConstract.Model provideModel (){
        return  new UserModel();
    }


}
