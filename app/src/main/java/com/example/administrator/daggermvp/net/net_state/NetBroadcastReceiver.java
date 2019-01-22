package com.example.administrator.daggermvp.net.net_state;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

public class NetBroadcastReceiver extends BroadcastReceiver {
    private static ArrayList<NetStateListener> mList = new ArrayList<NetStateListener>();
    private static NetBroadcastReceiver mNetBroadcastReceiver;
    private static BroadcastReceiver getReceiver() {
        if (null == mNetBroadcastReceiver) {
            synchronized (NetBroadcastReceiver.class) {
                if (null == mNetBroadcastReceiver) {
                    mNetBroadcastReceiver = new NetBroadcastReceiver();
                }
            }
        }
        return mNetBroadcastReceiver;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("dagger","onreceive");
        if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            int netState=NetStateUtils.getNetWorkState(context);
            notifyListenner(netState);
        }
    }

    private void notifyListenner(int netState) {
        for (NetStateListener listener:mList) {
                listener.onNetstateChange(netState);
        }
    }

    /**
     * 注册网络监听
     */
    public static void registerReceiver(@NonNull Context context) {
        Log.i("dagger","register-----");
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(getReceiver(), intentFilter);
    }

    /**
     * 取消网络监听
     */
    public static void unregisterReceiver(@NonNull Context context) {
        context.unregisterReceiver(getReceiver());
    }


    public interface NetStateListener {
        void onNetstateChange(int netState);
    }

    /**
     * 为需要监听网络的页面设置状态回调
     * @param netStateListener
     */
    public static void setNetStateListener(NetStateListener netStateListener){
        if(mList==null){
            mList=new ArrayList<NetStateListener>();
        }
        mList.add(netStateListener);
    }

    /**
     * 移除的监听,
     * @param netStateListener
     */
    public static void removeNetStateListener(NetStateListener netStateListener){
        if(mList!=null){
           if(mList.contains(netStateListener));
           mList.remove(netStateListener);
        }

    }
}
