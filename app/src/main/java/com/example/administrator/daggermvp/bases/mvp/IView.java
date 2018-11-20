package com.example.administrator.daggermvp.bases.mvp;

import android.support.annotation.NonNull;
/**
 *  框架要求每个Model都要实现此类。满足规范
 */
public interface IView {
    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示信息
     *
     * @param message 消息内容, 不能为 {@code null}
     */
    void showMessage(@NonNull String message);
}
