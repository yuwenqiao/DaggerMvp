package com.example.administrator.daggermvp.bases;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.administrator.daggermvp.bases.mvp.IPresenter;
import com.example.administrator.daggermvp.net.net_state.NetBroadcastReceiver;
import com.example.administrator.daggermvp.utils.rx.RxLifecycleUtils;
import com.uber.autodispose.AutoDisposeConverter;

import javax.inject.Inject;

public abstract class BaseFragment <P extends IPresenter>extends Fragment implements NetBroadcastReceiver.NetStateListener {
    @Inject
    protected P mPresenter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupActivityComponent();
        initLifecycleObserver(getLifecycle());
        NetBroadcastReceiver.setNetStateListener(this);
    //    ARouter.getInstance().inject(this); //注入 ARouter
        initListener();
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

    // Presenter注入器注入的地方
    public abstract void setupActivityComponent();


    /**
     * 实现Observable和组件生命周期的绑定（此方法只是想用于当前view绑定Observable,跟presenter中性质一样）
     * @return
     */
    protected AutoDisposeConverter bindLifecycle() {
        return RxLifecycleUtils.bindLifecycle(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            // mPresenter.onDestroy();
        }
        mPresenter=null;
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
