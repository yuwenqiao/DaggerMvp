package com.example.administrator.daggermvp.bases.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;

import com.example.administrator.daggermvp.utils.rx.RxLifecycleUtils;
import com.uber.autodispose.AutoDisposeConverter;

import io.reactivex.disposables.CompositeDisposable;

/**
 *
 * @param <V>
 * @param <M>
 */
public class BasePresenter <V extends IView,M extends IModel> implements IPresenter {
    protected V mView;
    protected M mModel;
    protected CompositeDisposable mCompositeDisposable;

    protected LifecycleOwner mLifecycleOwner;
    /**
     *  如果当前页面同时需要model 和view 层，使用此构造函数 （默认）
     * @param view
     * @param model
     */
    public BasePresenter(V view, M model){
        this.mView=view;
        this.mModel=model;
        //将presenter层接口回调设置给M层，设置此回调时方便以后换网络框架不影响业务层改动

        onStar();
    }

    /**
     *   当前页面不需要数据操作的时候，只需要使用此构造即可
     * @param view
     */
    public BasePresenter(V view){
        this.mView=view;
        onStar();
    }

    @Override
    public void onStar() {

    }

    @Override
    public void onDestroy() {
        if(mModel!=null){
            mModel.onDestroy();
        }
        mModel=null;
        mView=null;
    }

    /**
     * 与Observable绑定（只要是持有LifecycleOwner对象，就可以通过此方法实现绑定）
     * @return
     */
    protected <T> AutoDisposeConverter<T> bindLifecycle(){
        if(null==mLifecycleOwner)
            throw new NullPointerException("lifecycleOwner==null");
        return RxLifecycleUtils.bindLifecycle(mLifecycleOwner);
    }

    /**
     * 获取 LifecycleOwner对象
     * @param owner
     */
    @Override
    public void onCreate(LifecycleOwner owner) {
        this.mLifecycleOwner=owner;
    }

    @Override
    public void onStart(LifecycleOwner owner) {

    }

    @Override
    public void onResume(LifecycleOwner owner) {

    }

    @Override
    public void onPause(LifecycleOwner owner) {

    }

    @Override
    public void onStop(LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(LifecycleOwner owner) {

    }

    @Override
    public void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event) {

    }


}
