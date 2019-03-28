package com.example.administrator.daggermvp.net;

public class RequestException extends RuntimeException {


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

    public RequestException(String msg){
        super(msg);
    }
    public RequestException(int code, String msg){
        super(msg);
        this.code=code;
    }
}
