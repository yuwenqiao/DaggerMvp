package com.example.administrator.daggermvp.utils.net_error;

public interface HttpErrorCode {

    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1001;
    public static final String PARSE_ERROR_MSG = "解析数据失败";

    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1002;
    public static final String BAD_NETWORK_MSG = "网络问题";
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1003;
    public static final String CONNECT_ERROR_MSG = "连接错误";
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1004;
    public static final String CONNECT_TIMEOUT_MSG = "连接超时";
    /**
     * 未知错误
     */
    public static final int OTHER = 1005;
    public static final String OTHER_MSG = "未知错误";
}
