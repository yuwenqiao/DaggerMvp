package com.example.administrator.daggermvp.utils.net_error;

import android.util.Log;

import com.example.administrator.daggermvp.net.RequestException;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.text.ParseException;

import retrofit2.HttpException;

/**
 * 统一处理请求返回失败帮助类
 */
public class HttpErrorHelper {

    public static RequestException handleHttpError(Throwable e){
        RequestException ex;
        if(e instanceof HttpException){  //均视为网络错误
            ex=new RequestException(HttpErrorCode.BAD_NETWORK,HttpErrorCode.BAD_NETWORK_MSG);
            Log.i("fragment","网络错误");
        }else if(e instanceof JsonParseException  // 解析错误
                || e instanceof JSONException
                || e instanceof ParseException){
            ex=new RequestException(HttpErrorCode.PARSE_ERROR,HttpErrorCode.PARSE_ERROR_MSG);
            Log.i("fragment","解析");
        }else if( e instanceof ConnectException){
            ex=new RequestException(HttpErrorCode.CONNECT_ERROR,HttpErrorCode.CONNECT_ERROR_MSG);
            Log.i("fragment","连接错误");
        }else if(e instanceof RequestException){
            ex= (RequestException) e;
            Log.i("fragment","运行时错误");
        }else{
            ex=new RequestException(HttpErrorCode.OTHER,HttpErrorCode.OTHER_MSG);
            Log.i("fragment","其它错误");
        }

        return ex;
    }
}
