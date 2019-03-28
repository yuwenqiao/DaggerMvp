package com.example.administrator.daggermvp.net;

import java.io.Serializable;

public class HttpResponse<T> implements Serializable{
    private String resCode;
    private String message;
    private T data;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
