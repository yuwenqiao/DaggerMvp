package com.example.administrator.daggermvp.utils;

import android.content.Context;

public class DownloadManager {
    private Context context;
    private int loadingProgress=0;
    public DownloadManager (Context context){
        this.context=context;
    }
}
