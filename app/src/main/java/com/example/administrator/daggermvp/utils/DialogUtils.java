package com.example.administrator.daggermvp.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.daggermvp.R;

/**
 * 传统标准dialog，底部两个或者一个按钮
 */
public class DialogUtils extends Dialog {

    private Context mContext;
    private int height ,width;
    private boolean cancelTouchout=false; //是否可以点击外部取消.默认不允许
    private View mView,verticalLine;
    //标题，左右按钮文字，中间描述文字,如果只有一个底部按钮以左侧描述文字为主
    private String titleStr,leftDes,rightDes,contentStr;
    private TextView title,msg,confirm,cancel;
    private LinearLayout bottomLl; //确认取消按钮整体布局
    private RelativeLayout topRl; //标题整体布局
    public DialogUtils(Builder builder) {
        super(builder.mContext, R.style.Dialog_Style);
        mContext=builder.mContext;
        titleStr=builder.title;
        leftDes=builder.leftDes;
        rightDes=builder.rightDes;
        contentStr=builder.desStr;
        cancelTouchout=builder.cancelTouchout;
        mView=builder.mView;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mView);
        setCanceledOnTouchOutside(cancelTouchout);
        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width =   DisplayUtils.getWindowWidth(mContext) * 4 / 5; // 设置dialog宽度为屏幕的4/5;
        win.setAttributes(lp);


        this.title = (TextView) mView.findViewById(R.id.common_dialog_title_tv);

        this.msg = (TextView) mView.findViewById(R.id.common_dialog_message_tv);
        // Set Scrollable
        this.msg.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.confirm = (TextView) mView.findViewById(R.id.common_dialog_confirm_tv);
        this.cancel = (TextView) mView.findViewById(R.id.common_dialog_cancel_tv);
        this.bottomLl = (LinearLayout) mView.findViewById(R.id.common_dialog_bottom_ll);
        this.topRl = (RelativeLayout) mView.findViewById(R.id.common_dialog_top_rl);
        this.verticalLine = mView.findViewById(R.id.common_dialog_vertical_line);







        // 如果没有标题，仍然使用标题模块作为描述使用
        if(!TextUtils.isEmpty(titleStr)){
            this.title.setText(titleStr);
            if(!TextUtils.isEmpty(contentStr)) {
                this.msg.setText(contentStr);
            }else{
                this.msg.setVisibility(View.GONE);
            }
        }else{
            this.msg.setVisibility(View.GONE);
        }
        //底部按钮模块,如果底部一个按钮，使用左侧按钮
        if(TextUtils.isEmpty(leftDes)&&TextUtils.isEmpty(rightDes)){
            this.bottomLl.setVisibility(View.GONE);
        }else{
            if(!TextUtils.isEmpty(leftDes)) {

                this.cancel.setText(leftDes);
            }
            if(!TextUtils.isEmpty(rightDes)) {
               this.confirm.setText(rightDes);
            }else{
                this.verticalLine.setVisibility(View.GONE);
                this.confirm.setVisibility(View.GONE);
            }
        }


    }



    public static class Builder{
        private Context mContext;
        private int height ,width;   //宽高
        private View mView;
        //标题，左右按钮文字，中间描述文字
        private String title,leftDes,rightDes,desStr;
        private boolean cancelTouchout;
        private int[] listenedItems; //需要设置点击的id
        public Builder(Context context){
            this.mContext=context;
        }

        public Builder view(int resId){
            this.mView= LayoutInflater.from(mContext).inflate(resId,null);
            return this;
        }
        public Builder height(int height){
            this.height=height;
            return this;
        }
        public Builder width(int width){
            this.width=width;
            return this;
        }
        public Builder leftDes(String leftDes){
            this.leftDes=leftDes;
            return this;
        }
        public Builder rightDes(String rightDes){
            this.rightDes=rightDes;
            return this;
        }
        public Builder desStr(String desStr){
            this.desStr=desStr;
            return this;
        }
        public Builder title(String title){
            this.title=title;
            return this;
        }
        public Builder cancelTouchout(boolean cancelTouchout){
            this.cancelTouchout=cancelTouchout;
            return this;
        }

        /**
         *  给需要点击事件view添加点击监听
         * @param listenedItems
         * @param click
         * @return
         */
        public Builder addViewOnclike(int[] listenedItems, View.OnClickListener click){
            if(listenedItems!=null&&listenedItems.length!=0){

                for(int i=0;i<listenedItems.length;i++){
                    this.mView.findViewById(listenedItems[i]).setOnClickListener(click);
                }
            }
            return this;
        }
        public DialogUtils build(){
                return new DialogUtils(this);
        }
    }
/**----------------------------------------使用情况如下-------------------------------------------------------------------------**/
//    findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            // mPresenter.show();
//            View.OnClickListener listener = new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    switch (view.getId()) {
//                        case R.id.common_dialog_cancel_tv:
//                            Log.i("dialog","取消");
//                            break;
//                        case R.id.common_dialog_confirm_tv:
//                            Log.i("dialog","确认");
//                            break;
//                    }
//                }
//            };
//            int [] arr={R.id.common_dialog_cancel_tv,R.id.common_dialog_confirm_tv};
//            DialogUtils.Builder builder = new DialogUtils.Builder(UserActivity.this);
//            DialogUtils dialog = builder
//                    .title("哈哈")
//                    .desStr("这里是描述界面")
//                    .leftDes("取消")
//                    .rightDes("确认")
//                    .view(R.layout.common_dialog)
//                    .addViewOnclike(arr,listener)
//                    .cancelTouchout(false)
//                    .build();
//            dialog.show();


}
