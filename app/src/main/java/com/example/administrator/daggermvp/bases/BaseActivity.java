package com.example.administrator.daggermvp.bases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.daggermvp.bases.mvp.IPresenter;
import com.example.administrator.daggermvp.net.net_state.NetBroadcastReceiver;
import com.example.administrator.daggermvp.utils.ActivityManager;

import javax.inject.Inject;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity  implements NetBroadcastReceiver.NetStateListener{
    // presenter 通过依赖注入实例，model ,view  已经注入。
    @Inject
    protected P  mPresenter;
    @Inject
    ActivityManager activityManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
        activityManager.addActivity(this);
        NetBroadcastReceiver.setNetStateListener(this);
    }
    // 注入器注入的地方
    public abstract void setupActivityComponent();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.onDestroy();
        }
        mPresenter=null;
        activityManager.removeActivity(this);
        NetBroadcastReceiver.removeNetStateListener(this);
    }

    public abstract void initView();
    public abstract void initListener();

    /**
     * 网络状态回调
     * 设置此回调的页面在网络出现变化时进行处理
     * 如果不是所有页面都要网络状态监听，就不需要在这里实现，放在需要监听的页面中实现。同样设置、移除监听也要放到页面中去处理
     * @param netState
     */
    public void onNetstateChange(int netState){
        if(netState==-1){
           //没有网络更改页面
        }else{
          //有网络
        }
    }

}
