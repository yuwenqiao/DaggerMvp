package com.example.administrator.daggermvp.net.httpprovider;

/**
 * 请求接口泛型，这里可以更改自己选择的网络请求框架
 * 暂时无用----------------------------------------------------------------
 */
public class BaseRequestProvider {

//    RetrofitClients retrofitHelper;
//    public BaseRequestProvider( ){
//        retrofitHelper= BaseApplication.getInstance().getRetrofitClient();
//    }
//
//    /**
//     * 普通get请求
//     * @param map
//     * @param requestUrl
//     */
////    public  Observable get(Map<String, Object> map,  String requestUrl){
////       return retrofitHelper.getRetrofitApi().get(requestUrl,map);
////        call.compose(RxUtil.<HttpResponse<T>>applySchedulers())
////               // .compose(RxUtil.<T>handelResult())
////                .subscribe(new Observer() {
////                    @Override
////                    public void onSubscribe(Disposable d) {
////
////                    }
////
////                    @Override
////                    public void onNext(Object o) {
////                        actionHandle.handleActionSuccess(httpFlag,o);
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////                        String errorMessage = "";
////                        if (e instanceof SocketException) {//请求异常
////                            errorMessage = "网络异常，请检查网络重试";
////                        } else if (e instanceof UnknownHostException) {//网络异常
////                            errorMessage = "请求失败，请稍后重试...";
////                        } else if (e instanceof SocketTimeoutException) {//请求超时
////                            errorMessage = "请求超时";
////                        } else if(e instanceof RequestException){
////                            errorMessage=e.getMessage();
////                        }else  {//服务器返回异常
////                            errorMessage = "网络异常，请检测网络";
////                        }
////
////
////                        actionHandle.handleActionError(httpFlag,new RequestException(errorMessage));
////                    }
////
////                    @Override
////                    public void onComplete() {
////                        actionHandle.handleActionCompolet(httpFlag);
////                    }
////                });
// //   }
//
//    /**
//     * 普通post请求
//     * @param map
//     * @param requestUrl
//     */
//    public  <T> Observable<T> post(Map<String, Object> map, String requestUrl){
//        return retrofitHelper.getRetrofitApi().post(requestUrl,map);
//    }
//
//    /**
//     * 文件下载
//     * @param map
//     * @param httpFlag
//     * @param requestUrl
//     * @param actionHandle
//     */
//    public void downLoadFile(Map<String, Object> map, final String httpFlag, String requestUrl, HttpActionHandle actionHandle){
//        Observable call=retrofitHelper.getRetrofitApi().downLoad(requestUrl,map);
//        actionHandle.handleActionSuccess(httpFlag,call);
//    }
//
//    /**
//     * 文件上传
//     * @param map
//     * @param httpFlag
//     * @param requestUrl
//     * @param actionHandle
//     */
//    public void upLoadFile(Map<String, Object> map, final String httpFlag, String requestUrl, File file, HttpActionHandle actionHandle){
//    //   Observable call=retrofitHelper.getRetrofitApi().upLoad(requestUrl,file);
//     //   actionHandle.handleActionSuccess(httpFlag,call);
//    }
//
//    protected CompositeDisposable mCompositeDisposable;
//    /**--------------请求管理相关方法---------------------**/
//    protected void unSubscribe() {
//        if (mCompositeDisposable != null) {
//            mCompositeDisposable.clear();
//        }
//    }
//
//    protected void addSubscribe(Disposable subscription) {
//        if (mCompositeDisposable == null) {
//            mCompositeDisposable = new CompositeDisposable();
//        }
//        mCompositeDisposable.add(subscription);
//    }
//
////    protected <U> void addRxBusSubscribe(Class<U> eventType, Consumer<U> act) {
////        if (mCompositeDisposable == null) {
////            mCompositeDisposable = new CompositeDisposable();
////        }
////        mCompositeDisposable.add(RxBus.getDefault().toDefaultFlowable(eventType, act));
////    }
//
//    public void cancelRequest(){
//        if (mCompositeDisposable != null) {
//            mCompositeDisposable.clear();
//        }
//    }
//
//
////    bus = PublishProcessor.create().toSerialized();
////    // 封装默认订阅
////    public <T> Disposable toDefaultFlowable(Class<T> eventType, Consumer<T> act) {
////        return bus.ofType(eventType).compose(RxUtil.<T>rxSchedulerHelper()).subscribe(act);
////    }
}
