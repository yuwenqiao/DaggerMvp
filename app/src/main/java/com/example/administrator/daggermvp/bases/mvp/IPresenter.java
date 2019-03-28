package com.example.administrator.daggermvp.bases.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 *  框架要求每个Model都要实现此类。满足规范,
 *  继承LifecycleObserver达到观察视图生命周期状态的监听
 */
public interface IPresenter extends LifecycleObserver{
    /**
     *  做一些初始化操作,比如进入页面权限请求
     */
    void onStar();

    /**
     *  在 activity  的 onDestroy()是会调用
     */
    void onDestroy();


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate( LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart( LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume( LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy( LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onLifecycleChanged(LifecycleOwner owner,
                             Lifecycle.Event event);

}
