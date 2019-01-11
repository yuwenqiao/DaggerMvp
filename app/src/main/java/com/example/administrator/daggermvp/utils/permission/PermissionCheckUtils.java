package com.example.administrator.daggermvp.utils.permission;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;

/**
 * 6.0权限检测工具类
 * 在需要调用权限的地方使用，无需关注是6.0以上或者以下，内部已做处理
 */
public class PermissionCheckUtils {
    private PermissionHelper permissionUtil;
    private Activity mActivity;

    public PermissionCheckUtils(Activity activity) {
        mActivity = activity;
        permissionUtil = new PermissionHelper();
    }

    /**
     * 请求电话权限
     * <p>
     * 请求回调监听
     */
    public void requestPhonePermission(OnResultPermissListener permissionListener) {

        if (permissionUtil.requestPermission(new String[]{PERMISSION_CALL_PHONE}, REQUEST_CALL_PHONE, mActivity)) {
            permissionListener.onPermissionSuccess();
        } else {

            //当勾选并拒绝权限时候再次申请回调
            if (!ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.CALL_PHONE)) {
                showTipsDialog();
            }
        }


    }

    /**
     * 请求SD卡权限
     */
    public void requestSDCardPermission(OnResultPermissListener permissionListener) {

        if (permissionUtil.requestPermission(new String[]{PERMISSION_WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORAGE, mActivity)) {
            permissionListener.onPermissionSuccess();
        } else {
            //当勾选并拒绝权限时候再次申请回调
            if (!ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.CALL_PHONE)) {
                showTipsDialog();
            }

        }
    }

    /**
     * 请求相机权限
     */
    public void requestCameraPermission(OnResultPermissListener permissionListener) {
        if (permissionUtil.requestPermission(new String[]{PERMISSION_CAMERA}, REQUEST_CAMERA, mActivity)) {
            permissionListener.onPermissionSuccess();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //当勾选并拒绝权限时候再次申请回调
                if (!ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.CALL_PHONE)) {
                    showTipsDialog();
                }
            }
        }
    }

    /**
     * 请求打电话，相机,SD卡组合权限(用于splash页面权限的请求)
     */
    public void requestAllPermission(OnResultPermissListener permissionListener) {
        if (permissionUtil.requestPermission(new String[]{PERMISSION_WRITE_EXTERNAL_STORAGE, PERMISSION_CAMERA, PERMISSION_CALL_PHONE}, REQUEST_ALL, mActivity)) {
            permissionListener.onPermissionSuccess();
        } else {
            // showTipsDialog();
        }
    }

    /**
     * 请求联系人权限
     */
    public void requestContactsPermission(OnResultPermissListener permissionListener) {

        if (permissionUtil.requestPermission(new String[]{PERMISSION_CONTACTS}, REQUEST_CONTACTS, mActivity)) {
            permissionListener.onPermissionSuccess();
        }
    }

    /**
     * 请求日历权限
     */
    public void requestCalendarPermission(OnResultPermissListener permissionListener) {
        if (permissionUtil.requestPermission(new String[]{PERMISSION_CALENDAR}, REQUEST_CALENDAR, mActivity)) {
            permissionListener.onPermissionSuccess();
        }
    }

    /**
     * 请求地理(GPS)权限
     */
    public void requestLocationPermission(OnResultPermissListener permissionListener) {
        if (permissionUtil.requestPermission(new String[]{PERMISSION_LOCATION}, REQUEST_LOCATION, mActivity)) {
            permissionListener.onPermissionSuccess();
        }
    }

    /**
     * 请求麦克风权限
     */
    public void requestMicrophonePermission(OnResultPermissListener permissionListener) {
        if (permissionUtil.requestPermission(new String[]{PERMISSION_MICROPHONE}, REQUEST_MICROPHONE, mActivity)) {
            permissionListener.onPermissionSuccess();
        }
    }

    /**
     * 请求传感器权限
     */
    public void requestSensorsPermission(OnResultPermissListener permissionListener) {
        if (permissionUtil.requestPermission(new String[]{PERMISSION_SENSORS}, REQUEST_SENSORS, mActivity)) {
            permissionListener.onPermissionSuccess();
        }
    }

    /**
     * 请求短信权限
     */
    public void requestSmsPermission(OnResultPermissListener permissionListener) {
        if (permissionUtil.requestPermission(new String[]{PERMISSION_SMS}, REQUEST_SMS, mActivity)) {
            permissionListener.onPermissionSuccess();
        }
    }


    /**
     * 显示提示对话框
     */
    public void showTipsDialog() {
        new AlertDialog.Builder(mActivity)
                .setTitle("提示信息")
                .setMessage("当前应用缺少必要权限，该功能暂时无法使用。如若需要，请前往设置中心进行权限授权。")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAppSettings();
                    }
                }).show();
    }

    /**
     * 启动当前应用设置页面
     */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + mActivity.getPackageName()));
        mActivity.startActivity(intent);
    }

    public interface OnResultPermissListener {
        void onPermissionSuccess();

    }

    //请求电话方面的权限
    private static final String PERMISSION_CALL_PHONE = Manifest.permission.CALL_PHONE;
    private static final int REQUEST_CALL_PHONE = 0x0001;

    //SD卡读取写入权限
    private static final String PERMISSION_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 0x0002;

    //相机
    private static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    private static final int REQUEST_CAMERA = 0x0003;

    //读取联系人
    private static final String PERMISSION_CONTACTS = Manifest.permission.READ_CONTACTS;
    private static final int REQUEST_CONTACTS = 0x0004;

    //日历
    private static final String PERMISSION_CALENDAR = Manifest.permission.READ_CALENDAR;
    private static final int REQUEST_CALENDAR = 0x0005;

    //GPS
    private static final String PERMISSION_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int REQUEST_LOCATION = 0x0006;

    //麦克风
    private static final String PERMISSION_MICROPHONE = Manifest.permission.RECORD_AUDIO;
    private static final int REQUEST_MICROPHONE = 0x0007;

    //传感器
    private static final String PERMISSION_SENSORS = Manifest.permission.BODY_SENSORS;
    private static final int REQUEST_SENSORS = 0x0008;

    //短信
    private static final String PERMISSION_SMS = Manifest.permission.READ_SMS;
    private static final int REQUEST_SMS = 0x0009;

    //组合权限
    private static final int REQUEST_ALL = 0x0010;
}
