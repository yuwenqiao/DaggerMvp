package com.example.administrator.daggermvp.net.retrofit;

import com.example.administrator.daggermvp.mvp.model.bean.UserBean;
import com.example.administrator.daggermvp.net.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 请求泛型
 */
public interface RetrofitApi {
    @GET
   <T> Observable<HttpResponse<T>> get(@Url String url, @QueryMap Map<String,Object> params);

    @FormUrlEncoded
    @POST("api/login")
    Observable<HttpResponse<UserBean>> login(@FieldMap Map<String,Object> params);

    @POST
    Observable<Object> postRaw(@Url String url, @Body RequestBody body);

    @Multipart
    @POST
    Observable<Object> upLoad(@Url String url ,@Part MultipartBody.Part file);

    @Streaming
    @GET
    Observable<Object> downLoad(@Url String url,@QueryMap Map<String,Object> params);

}
