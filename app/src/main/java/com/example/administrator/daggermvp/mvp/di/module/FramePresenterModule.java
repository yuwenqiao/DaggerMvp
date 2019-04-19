package com.example.administrator.daggermvp.mvp.di.module;

import com.example.administrator.daggermvp.di_app.scope.ActivityScope;
import com.example.administrator.daggermvp.mvp.contract.FrameConstract;
import com.example.administrator.daggermvp.mvp.contract.UserConstract;
import com.example.administrator.daggermvp.mvp.model.FrameModel;
import com.example.administrator.daggermvp.mvp.model.UserModel;

import dagger.Module;
import dagger.Provides;

@Module
public class FramePresenterModule {
    private FrameConstract.View view;
    //只能通过在view注入的地方将view添加进来作为依赖
    public FramePresenterModule(FrameConstract.View  view){
        this.view=view;
    }

    @ActivityScope
    @Provides
    FrameConstract.View provideView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    FrameConstract.Model provideModel (){
        return  new FrameModel();
    }
}
