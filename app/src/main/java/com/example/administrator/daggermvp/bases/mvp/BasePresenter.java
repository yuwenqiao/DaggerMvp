package com.example.administrator.daggermvp.bases.mvp;

public class BasePresenter <V extends IView,M extends IModel> implements IPresenter {
    protected V mView;
    protected M mModel;

    /**
     *  如果当前页面同时需要model 和view 层，使用此构造函数 （默认）
     * @param view
     * @param model
     */
    public BasePresenter(V view, M model){
        this.mView=view;
        this.mModel=model;
        onStar();
    }

    /**
     *   当前页面不需要数据操作的时候，只需要使用此构造即可
     * @param view
     */
    public BasePresenter(V view){
        this.mView=view;
        onStar();
    }

    @Override
    public void onStar() {

    }

    @Override
    public void onDestroy() {
        if(mModel!=null){
            mModel.onDestroy();
        }
        mModel=null;
        mView=null;
    }
}
