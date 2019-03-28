package com.example.administrator.daggermvp.utils.rx;

import android.content.Context;

import com.example.administrator.daggermvp.net.RequestException;
import com.example.administrator.daggermvp.utils.net_error.HttpErrorHelper;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    private Context mContext;

//    private BaseObserver() {
//    }
//
//    protected BaseObserver(Context context) {
//        mContext = context;
//    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        RequestException apiException = HttpErrorHelper.handleHttpError(e);
        onFail(apiException);
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);

    }
    public abstract void onSuccess(T t);
    public abstract void onFail(RequestException e);
}
