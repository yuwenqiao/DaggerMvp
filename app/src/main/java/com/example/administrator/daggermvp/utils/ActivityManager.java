package com.example.administrator.daggermvp.utils;

import android.app.Activity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *  activity  管理器
 */
@Singleton
public class ActivityManager {
    private List<Activity>  mActivityList;
    @Inject
    public ActivityManager (){

    }

    /**
     * 返回所有的存活的activity集合
     */
    public List<Activity> getActivityList(){
        if(mActivityList==null){
            mActivityList=new LinkedList<>();
        }
        return mActivityList;
    }

    /**
     *  添加activity到集合
     */

    public void addActivity (Activity activity){
        List<Activity> activities=getActivityList();
        if(!activities.contains(activity)){
            activities.add(activity);
        }
    }
    /**
     * 移除指定activity
     *
     */
    public void removeActivity(Activity activity){
        List<Activity> activities=getActivityList();
        if (activities.contains(activity)) {
            activities.remove(activity);
        }
    }

    /**
     * 返回目前处于栈顶的activity
     *
     */

    public Activity getTopActivity (){
        if(mActivityList==null||mActivityList.size()==0){
            return null;
        }
        return mActivityList.get(mActivityList.size()-1);
    }

    /**
     * 关闭除了指定activity以外的所有activity
     */

    public void finishAll(Activity activity) {
        Iterator<Activity> iterator = getActivityList().iterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            if (next.getClass().getName().equals(activity.getClass().getName()))
                continue;

            iterator.remove();
            next.finish();
        }
    }
    /**
     * 关闭除了指定activity以外的所有activity
     */

    public void finishAll(Class<?> cls) {
        Iterator<Activity> iterator = getActivityList().iterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            if (next.getClass().equals(cls))
                continue;

            iterator.remove();
            next.finish();
        }
    }

    /**
     * 结束所有的activity
     */

    public void finishAll() {
        Iterator<Activity> iterator = getActivityList().iterator();
        while (iterator.hasNext()) {
            Activity nextAcy = iterator.next();
            iterator.remove();
            nextAcy.finish();
        }
    }

    /**
     * 退出应用程序
     */
    public void appExit() {
        try {
            finishAll();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
