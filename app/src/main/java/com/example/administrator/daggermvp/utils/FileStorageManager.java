package com.example.administrator.daggermvp.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

public class FileStorageManager {
    private Context mContext;
    private volatile static FileStorageManager instance;
    private FileStorageManager(){

    }
    public static FileStorageManager getInstance(){
        if(instance==null){
            synchronized (FileStorageManager.class){
                if(instance==null){
                    instance=new FileStorageManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context){
        mContext=context;
    }

    /**
     * 根据传入路径获取文件
     * @param url
     * @return
     */
    public File getFileByUrl(String url){
        File fileParent;
        if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED){
            fileParent=mContext.getExternalCacheDir();
        }else{
            fileParent=mContext.getCacheDir();
        }
        String fileName=MD5Utils.generateCode(url);
        File file=new File(fileParent,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 根据传入文件名称获取/创建文件
     * @param url
     * @return
     */
    public File getFileByName(String url){
        File fileParent;
        if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED){
            fileParent=mContext.getExternalCacheDir();
        }else{
            fileParent=mContext.getCacheDir();
        }
        String fileName=MD5Utils.generateCode(url);
        File file=new File(fileParent,fileName);
        try {
        if(!file.exists()){

                file.createNewFile();

        }else{
            file.createNewFile();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
