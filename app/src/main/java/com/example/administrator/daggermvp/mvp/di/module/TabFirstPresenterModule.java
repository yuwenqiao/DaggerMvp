package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.di_app.scope.FragmentScope;
import com.example.administrator.daggermvp.mvp.contract.TabFirstConstract;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.TabFirstModel;
import com.example.administrator.daggermvp.mvp.model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * TabFirstFragment 页面 presenter 提供依赖
 */
@Module
public class TabFirstPresenterModule {
    private TabFirstConstract.View view;
    //只能通过在view注入的地方将view添加进来作为依赖
    public TabFirstPresenterModule(TabFirstConstract.View  view){
        this.view=view;
    }
    @FragmentScope
    @Provides
    TabFirstConstract.View provideView(){
        return this.view;
    }
    @FragmentScope
    @Provides
    TabFirstConstract.Model provideModel (){
        return  new TabFirstModel();
    }
}
