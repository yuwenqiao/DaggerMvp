package com.example.administrator.daggermvp.net.net_state;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetStateUtils {
    public static final int NETWORK_NONE=-1;
    public static final int NETWORK_MOBILE=0;
    public static final int NETWORD_WIFI=1;

    public static int getNetWorkState(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWorkInfo=connectivityManager.getActiveNetworkInfo();
        if(activeNetWorkInfo!=null&&activeNetWorkInfo.isConnected()){
            if(activeNetWorkInfo.getType()==(ConnectivityManager.TYPE_MOBILE)){
                return NETWORK_MOBILE;
            }else if(activeNetWorkInfo.getType()==(ConnectivityManager.TYPE_WIFI)){
                return NETWORD_WIFI;
            }
        }else{
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }
}
