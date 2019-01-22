package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.MainConstract;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.MainModel;
import com.example.administrator.daggermvp.mvp.model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * 为创建presenter实例提供构造中需要的 view 和model 实例
 */
@Module
public class MainPresenterModule {

    private MainConstract.View view;
    //只能通过在view注入的地方将view添加进来作为依赖
    public MainPresenterModule(MainConstract.View  view){
        this.view=view;
    }
    @ActivityScope
    @Provides
    MainConstract.View provideView(){
        return this.view;
    }
    @ActivityScope
    @Provides
    MainConstract.Model provideModel (){
        return  new MainModel();
    }


}
