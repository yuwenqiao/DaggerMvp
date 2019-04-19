package com.example.administrator.daggermvp.other_view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.daggermvp.R;

public class LoadingProgress {
    private static Dialog progressDialog;

    /**
     * 显示等待弹框
     * @param context
     */
    public static synchronized void showProgressDialog(Context context) {
        showProgressDialog(context,null,true);
    }

    /**
     * 显示等待弹框
     * @param context
     * @param message
     */
    public static synchronized void showProgressDialog(Context context, String message) {
        showProgressDialog(context,message,true);
    }

    /**
     * 显示等待弹框
     * @param context
     * @param message
     * @param cancelable
     */
    public static synchronized void showProgressDialog(Context context, String message, boolean cancelable) {
        if(progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = new Dialog(context, R.style.progress_dialog);
        progressDialog.setContentView(R.layout.dialog_loading_progress);
        progressDialog.setCancelable(cancelable);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        progressDialog.setCanceledOnTouchOutside(false);
        TextView tvText = (TextView) progressDialog.findViewById(R.id.tv_loadingmsg);
        if(!TextUtils.isEmpty(message)) {
            tvText.setVisibility(View.VISIBLE);
            tvText.setText(message);
        }else {
            tvText.setVisibility(View.GONE);
        }
        progressDialog.show();
    }

    /**
     * 隐藏等待弹框
     */
    public static synchronized void  dismissProgressDialog(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
