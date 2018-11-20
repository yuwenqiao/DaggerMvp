package com.example.administrator.daggermvp.bases.mvp;
/**
 *  框架要求每个Model都要实现此类。满足规范
 */
public interface IPresenter {
    /**
     *  做一些初始化操作
     */
    void onStar();

    /**
     *  在 activity  的 onDestroy()是会调用
     */
    void onDestroy();
}
