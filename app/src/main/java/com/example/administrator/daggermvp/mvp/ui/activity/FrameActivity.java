package com.example.administrator.daggermvp.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.daggermvp.R;
import com.example.administrator.daggermvp.bases.BaseActivity;
import com.example.administrator.daggermvp.bases.BaseApplication;
import com.example.administrator.daggermvp.bases.BaseFragment;
import com.example.administrator.daggermvp.bases.Constance;
import com.example.administrator.daggermvp.di_app.component.AppComponent;
import com.example.administrator.daggermvp.mvp.contract.FrameConstract;
import com.example.administrator.daggermvp.mvp.di.component.DaggerFrameComponent;
import com.example.administrator.daggermvp.mvp.di.component.DaggerUserComponent;
import com.example.administrator.daggermvp.mvp.di.module.FramePresenterModule;
import com.example.administrator.daggermvp.mvp.di.module.UserPresenterModule;
import com.example.administrator.daggermvp.mvp.presenter.FramePresenter;
import com.example.administrator.daggermvp.mvp.ui.fragment.FirstTabFragment;
import com.example.administrator.daggermvp.mvp.ui.fragment.FourthTabFragment;
import com.example.administrator.daggermvp.mvp.ui.fragment.SecondTabFragment;
import com.example.administrator.daggermvp.mvp.ui.fragment.ThirdTabFragment;

//@Route(path= Constance.ACTIVITY_URL_MAIN)
public class FrameActivity extends BaseActivity<FramePresenter> implements FrameConstract.View{

    public final static int TAB_FLAG_HOME = 0;
    private final static int TAB_FLAG_WH = 1;
    private final static int TAB_FLAG_MY = 2;
    private final static int TAB_FLAG_MORE = 3;
    private int currentTabFlagIndex = TAB_FLAG_HOME;
    private FrameLayout mContentView;
    private RadioGroup tabRadio;
    private RadioButton  firstTab ,secondTab, thirdTab, fourthTab;


    private FragmentManager fm;
    private FragmentTransaction transaction;

    @Override
    public void setupActivityComponent() {
        AppComponent appComponent= ((BaseApplication) getApplicationContext()).getAppComponent();
        DaggerFrameComponent.builder().framePresenterModule(new FramePresenterModule(this)).appComponent(appComponent).build().inject(this);
    }


    @Override
    public void initView() {
        setContentView(R.layout.activity_frame);
        fm=getSupportFragmentManager();
        mContentView=findViewById(R.id.content);
        tabRadio=findViewById(R.id.main_radioGroup);
        firstTab=findViewById(R.id.tab_first);
        secondTab=findViewById(R.id.tab_second);
        thirdTab=findViewById(R.id.tab_third);
        fourthTab=findViewById(R.id.tab_four);
    }

    @Override
    public void initListener() {

        tabRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.tab_first:
                        selectTab(TAB_FLAG_HOME);
                        break;
                    case R.id.tab_second:
                        selectTab(TAB_FLAG_WH);
                        break;
                    case R.id.tab_third:
                        selectTab(TAB_FLAG_MY);
                        break;
                    case R.id.tab_four:
                        selectTab(TAB_FLAG_MORE);
                        break;
                }
            }
        });
        // 默认选中首选项卡
        firstTab.setChecked(true);
    }

    /**
     * 切换选项卡
     * @param tabFlag
     */
    public void selectTab(int tabFlag){
        transaction=fm.beginTransaction();
        String newTag="tag"+tabFlag;
        String currentTag="tag"+currentTabFlagIndex;
        Fragment currentFragment=fm.findFragmentByTag(currentTag);
        if(currentFragment!=null){  //隐藏当前页面
            currentFragment.onPause();     // 切换tab按钮时候，fragment不会走生命周期（附着到activity时第一次会执行，切换并不会走生命周期）
            transaction.hide(currentFragment);
        }
        Fragment newFragment=fm.findFragmentByTag(newTag);
        if(newFragment==null){
            newFragment=createNewFragment(tabFlag);
            transaction.add(R.id.content,newFragment,newTag);
        }else{
            newFragment.onResume();        // 切换tab按钮时候，fragment不会走生命周期（附着到activity时第一次会执行，切换并不会走生命周期）
            transaction.show(newFragment);
        }
        transaction.commitAllowingStateLoss();
        currentTabFlagIndex=tabFlag;
    }
    protected BaseFragment createNewFragment(int tab){
        BaseFragment newFragment=null;
        switch (tab){
            case TAB_FLAG_HOME:// 首页
                newFragment = new FirstTabFragment();
                break;

            case TAB_FLAG_WH:// 列表
                newFragment = new SecondTabFragment();
                break;
            case TAB_FLAG_MY:// 账户
                newFragment = new ThirdTabFragment();
                break;
            case TAB_FLAG_MORE:// 更多
                newFragment = new FourthTabFragment();
                break;
        }
        return newFragment;

    }

    /**
     * Description: 设置底部导航选中状态
     *
     * @Author: lgs
     * Create Date: 2016/10/28 下午4:24
     */
    public void setNavRadioButtonChecked(int currentTabFlagIndex) {
        switch (currentTabFlagIndex) {
            case TAB_FLAG_HOME:
                firstTab.setChecked(true);
                break;
            case TAB_FLAG_WH:
                secondTab.setChecked(true);
                break;
            case TAB_FLAG_MY:
                thirdTab.setChecked(true);
                break;
            case TAB_FLAG_MORE:
                fourthTab.setChecked(true);
                break;
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }
}
