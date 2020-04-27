package com.example.project.ui.fragment;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.app.MyApp;
import com.example.project.base.BaseFragment;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.ui.activity.DetailsActivity;
import com.example.project.ui.activity.login.LoginActivity;
import com.example.project.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment {
    @BindView(R.id.lin_shop)
    LinearLayout linShop;
    @BindView(R.id.lin_donate)
    LinearLayout linDonate;
    @BindView(R.id.lin_stock)
    LinearLayout linStock;
    @BindView(R.id.lin_fh)
    LinearLayout linFh;
    @BindView(R.id.re_personage)
    RelativeLayout rePersonage;
    @BindView(R.id.re_ID)
    RelativeLayout reID;
    @BindView(R.id.re_site)
    RelativeLayout reSite;
    @BindView(R.id.re_exit)
    RelativeLayout reExit;


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }


    @Override
    protected void initView() {
        countDown();//我的模块登录状态初始化处理（判断是否登录）


    }

    /**
     * 倒计时显示
     */
    private void countDown() {
        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
//                Toast.makeText(context, "时间就是生命", Toast.LENGTH_SHORT).show();
                StateHandling();  //用Token进行判断用户是否是登录状态
            }
        }.start();


    }

    private void StateHandling() {
        String token = SharedPreferencesUtil.getToken(MyApp.mApp);
        Intent intent = new Intent();
        if (TextUtils.isEmpty(token)) {
            SharedPreferencesUtil.deleteToken(MyApp.mApp);
            intent.setClass(context, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            getActivity().finish();
        } else {
            Constant.token = token;
//            intent.setClass(context, MainActivity.class);
        }
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.lin_shop, R.id.lin_donate, R.id.lin_stock, R.id.lin_fh, R.id.re_personage, R.id.re_ID, R.id.re_site, R.id.re_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_shop: //购物积分（详情）
                startActivity(new Intent(context, DetailsActivity.class));
                break;
            case R.id.lin_donate: //赠送积分（详情）
                startActivity(new Intent(context, DetailsActivity.class));
                break;
            case R.id.lin_stock: //识缘股（详情）
                startActivity(new Intent(context, DetailsActivity.class));
                break;
            case R.id.lin_fh:  //周分红(股)（详情）
                startActivity(new Intent(context, DetailsActivity.class));
                break;
            case R.id.re_personage: //个人信息（详情）
                break;
            case R.id.re_ID:  //账号设置（详情）
                break;
            case R.id.re_site:  //收货地址（详情）
                break;
            case R.id.re_exit:  //退出
                break;
        }
    }
}
