package com.example.shiyuankeji.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.shiyuankeji.R;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;
import com.example.shiyuankeji.utils.SystemUtils;

import com.jaeger.library.StatusBarUtil;
import com.umeng.analytics.MobclickAgent;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<V extends IBaseView, P extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    protected P mPresenter;
    Unbinder unbinder;
    protected AppCompatActivity activity;
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setStatusBar();

        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        activity = this;
        context = this;

        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.attchView(this);
        }
        if (!SystemUtils.checkNetWork()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.not_net, null);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            addContentView(inflate, params);
        } else {

            initFragments();
            initView();
            initData();
            initListener();
        }


    }

    protected void setStatusBar(){
        StatusBarUtil.setColor(this, ContextCompat.getColor(this,R.color.tou_ming),50);
        //StatusBarUtil.setDarkMode(this);
    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected void initFragments() {

    }


    protected abstract P getPresenter();

    protected abstract int getLayoutId();


    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void showError() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.attchView(this);
        }
        MobclickAgent.onResume(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }

    public void addFragment(FragmentManager manager, Class<? extends BaseFragment> zClass, int layoutID, Bundle args) {

        String tag = zClass.getName();

        Fragment fragment = manager.findFragmentByTag(tag);
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment == null) {
            try {
                fragment = zClass.newInstance();

                BaseFragment baseFragment = (BaseFragment) fragment;
                fragment.setArguments(args);
                transaction.add(layoutID, fragment,tag);
                hideOtherFragment(manager, transaction, fragment);
                if (baseFragment.isNeedToBackStack()) {
                    transaction.addToBackStack(tag);
                }
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (fragment.isAdded()) {
                if (fragment.isHidden()) {
                    fragment.setArguments(args);
                    transaction.show(fragment);
                    hideOtherFragment(manager, transaction, fragment);
                    transaction.commit();
                }
            } else {

                fragment.setArguments(args);
                transaction.add(layoutID, fragment,tag);
                hideOtherFragment(manager, transaction, fragment);
                transaction.commit();
            }

        }
    }

    private void hideOtherFragment(FragmentManager manager, FragmentTransaction transaction, Fragment willShowFragment) {
        List<Fragment> fragments = manager.getFragments();

        for (Fragment fragment : fragments) {
            if (fragment != willShowFragment && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
    }
}
