package com.example.shiyuankeji.ui.activity.login;

import android.content.Intent;
import android.util.Log;
import android.widget.VideoView;


import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.LoginTokenContract;
import com.example.shiyuankeji.presenter.login.LoginTokenPresenter;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;

//implements VersionConstract.View
public class SplashActivity extends BaseActivity implements LoginTokenContract.View {

    private static final String TAG = "测试token";
    VideoView videoView;
    private String msg;
    private String logintoken;

    /**
     * 处理初始化操作
     */
    @Override
    public void initView() {

    }

    //new VersionPersenter();
    @Override
    protected IBasePresenter getPresenter() {
        return new LoginTokenPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        Log.d(TAG, "initData: " + Constant.token);
        logintoken = SharedPreferencesUtil.getToken(MyApp.mApp);
        Constant.token = logintoken;
        ((LoginTokenPresenter) mPresenter).logintokens();


    }

    @Override
    public void logintokenReaun(LoginTokenBean loginTokenBean) {
        msg = loginTokenBean.getMsg();
        Intent intent = new Intent();
        if (msg.equals("001")) {
            intent.setClass(this, LoginActivity.class);
        } else {
            Constant.token = logintoken;
            intent.setClass(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

//    @Override
//    public void getVersionReturn(VerBean result) {
//
//    }
}
