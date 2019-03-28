package com.example.administrator.daggermvp.utils.net_error;

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
        }else if(e instanceof JsonParseException  // 解析错误
                || e instanceof JSONException
                || e instanceof ParseException){
            ex=new RequestException(HttpErrorCode.PARSE_ERROR,HttpErrorCode.PARSE_ERROR_MSG);
        }else if( e instanceof ConnectException){
            ex=new RequestException(HttpErrorCode.CONNECT_ERROR,HttpErrorCode.CONNECT_ERROR_MSG);
        }else if(e instanceof RequestException){
            ex= (RequestException) e;
        }else{
            ex=new RequestException(HttpErrorCode.OTHER,HttpErrorCode.OTHER_MSG);
        }

        return ex;
    }
}
