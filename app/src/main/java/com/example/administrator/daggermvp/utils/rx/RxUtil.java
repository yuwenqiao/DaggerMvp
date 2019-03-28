package com.example.administrator.daggermvp.utils.rx;

import com.example.administrator.daggermvp.net.RequestException;
import com.example.administrator.daggermvp.net.HttpResponse;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtil {
    /**
     * 统一处理请求线程切换
     * @param <T>
     * @return
     */
    public static<T> ObservableTransformer<T,T> applySchedulers(){
        return new ObservableTransformer<T,T>(){
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 返回结果处理,主要是根据状态码处理相关情况
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<HttpResponse<T>,T> handelResult(){
        return new ObservableTransformer<HttpResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<HttpResponse<T>> upstream) {
                return upstream.flatMap(new Function<HttpResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(HttpResponse<T> tHttpResponse) throws Exception {
                       if(tHttpResponse.getResCode().equals("000000")){
                           return createObservable(tHttpResponse.getData());
                       }else{
                           // 处理请求结果不用返回data的情况
                           return Observable.error(new RequestException(tHttpResponse.getMessage()));
                       }
                    }
                });
            }
        };
    }
    /**
     * 生成Observable将数据返回
     * @param <T>
     * @return
     */
    public static <T> Observable<T> createObservable(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(new RequestException("网络异常，请检测网络"));
                }
            }
        });
    }

}


















