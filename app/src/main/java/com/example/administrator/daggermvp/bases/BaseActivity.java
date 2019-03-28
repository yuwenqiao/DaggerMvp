package com.example.administrator.daggermvp.bases;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.daggermvp.bases.mvp.IPresenter;
import com.example.administrator.daggermvp.net.net_state.NetBroadcastReceiver;
import com.example.administrator.daggermvp.utils.ActivityManager;
import com.example.administrator.daggermvp.utils.rx.RxLifecycleUtils;
import com.uber.autodispose.AutoDisposeConverter;

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
        initLifecycleObserver(getLifecycle());
        activityManager.addActivity(this);
        NetBroadcastReceiver.setNetStateListener(this);

    }

    /**
     * 注册生命周期观察者
     * @param lifecycle
     */
    protected void initLifecycleObserver( Lifecycle lifecycle) {
       if(lifecycle!=null) {
           lifecycle.addObserver(mPresenter);
       }
    }

    /**
     * 实现Observable和组件生命周期的绑定（此方法只是想用于当前view绑定Observable,跟presenter中性质一样）
     * @return
     */
    protected  AutoDisposeConverter bindLifecycle() {
        return RxLifecycleUtils.bindLifecycle(this);
    }

    // Presenter注入器注入的地方
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
     * 广播网络状态回调
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
