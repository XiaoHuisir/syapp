package com.example.project.ui.activity.login;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.VideoView;


import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.app.MyApp;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.utils.SharedPreferencesUtil;

//implements VersionConstract.View
public class SplashActivity extends BaseActivity {

    VideoView videoView;

    /**
     * 处理初始化操作
     */
    @Override
    public void initView() {

    }

    //new VersionPersenter();
    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        String token = SharedPreferencesUtil.getToken(MyApp.mApp);
        Intent intent = new Intent();
        if (TextUtils.isEmpty(token)) {
            intent.setClass(this, LoginActivity.class);
        } else {
            Constant.token = token;
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
