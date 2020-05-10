package com.example.project.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.app.MyApp;
import com.example.project.base.BaseFragment;
import com.example.project.bean.MineBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.MineContract;
import com.example.project.presenter.HomePresenter;
import com.example.project.presenter.MinePresenter;
import com.example.project.ui.activity.DetailsActivity;
import com.example.project.ui.activity.PersonalCenterActivity;
import com.example.project.ui.activity.SelectAddressActivity;
import com.example.project.ui.activity.login.LoginActivity;
import com.example.project.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment implements MineContract.View {
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
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv_score4)
    TextView tvScore4;
    @BindView(R.id.tv_score2)
    TextView tvScore2;
    @BindView(R.id.tv_score3_1)
    TextView tvScore3_1;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefres;
    private String phone_number;
    private String name;
    private String user_name;
    private String identity_num;

    private String score = "";
    private String score4 = "";
    private String score2 = "";
    private String score3_1 = "";

    @Override
    protected IBasePresenter getPresenter() {
        return new MinePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }


    @Override
    protected void initView() {
//        countDown();//我的模块登录状态初始化处理（判断是否登录）
        refress();

    }
    private void refress() {
        swipeRefres.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((MinePresenter) mPresenter).mines();

                swipeRefres.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefres != null) {
                            swipeRefres.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
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
//                StateHandling();   //TODO 用Token进行判断用户是否是登录状态
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
        ((MinePresenter) mPresenter).mines();
    }


    @OnClick({R.id.lin_shop, R.id.lin_donate, R.id.lin_stock, R.id.lin_fh, R.id.re_personage, R.id.re_ID, R.id.re_site, R.id.re_exit})
    public void onViewClicked(View view) {
        Intent intent03 = new Intent();
        switch (view.getId()) {
            case R.id.lin_shop: //购物积分（详情）
                intent03.setClass(context, DetailsActivity.class);
                intent03.putExtra("jifen", "购物积分");
                intent03.putExtra("score_", score);
                startActivity(intent03);
                break;
            case R.id.lin_donate: //赠送积分（详情）
                intent03.setClass(context, DetailsActivity.class);
                intent03.putExtra("jifen", "赠送积分");
                intent03.putExtra("score4_", score4);
                startActivity(intent03);
                break;
            case R.id.lin_stock: //识缘股（详情）
                intent03.setClass(context, DetailsActivity.class);
                intent03.putExtra("jifen", "识缘股");
                intent03.putExtra("score2_", score2);
                startActivity(intent03);
                break;
            case R.id.lin_fh:  //周分红(股)（详情）
                intent03.setClass(context, DetailsActivity.class);
                intent03.putExtra("jifen", "周分红");
                intent03.putExtra("score3_1_", score3_1);
                startActivity(intent03);
                break;
            case R.id.re_personage: //个人信息（详情）
                Intent intent = new Intent();
                intent.setClass(context, PersonalCenterActivity.class);
//                intent.putExtra("user_name_", user_name);
//                intent.putExtra("name_", name);
//                intent.putExtra("phone_number_", phone_number);
//                intent.putExtra("identity_num_", identity_num);
                startActivity(intent);
                break;
            case R.id.re_ID:  //订单管理（详情）
                Intent intents = new Intent();
                intents.setClass(context, MainActivity.class);
                intents.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intents.putExtra("id", Constant.TWO_TYPE_3);
                startActivityForResult(intents, Constant.TWO_TYPE_3);
                getActivity().finish();
                break;
            case R.id.re_site:  //收货地址（详情）
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(), SelectAddressActivity.class);
                intent1.putExtra("mine_","个人中心");
                Constant.IS_MINE = true;
                Constant.IS_MINE_IS = "2";
                startActivity(intent1);
                break;
            case R.id.re_exit:  //退出
                SharedPreferencesUtil.deleteToken(MyApp.mApp);
                Intent intent2 = new Intent();
                intent2.setClass(context, LoginActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                getActivity().finish();
                break;
        }
    }

    @Override
    public void mineReand(MineBean mineBean) {
        if (mineBean != null) {
            user_name = mineBean.getUser_name();
            name = mineBean.getName();
            phone_number = mineBean.getPhone_number();
            //身份证号
            identity_num = mineBean.getIdentity_num();
            tvUserName.setText(user_name);
            tvScore.setText(String.valueOf(mineBean.getScore()));
            tvScore4.setText(String.valueOf(mineBean.getScore4()));
            tvScore2.setText(String.valueOf(mineBean.getScore2()));
            tvScore3_1.setText(String.valueOf(mineBean.getScore3_1()));
            score = String.valueOf(mineBean.getScore());
            score2 = String.valueOf(mineBean.getScore2());
            score4 = String.valueOf(mineBean.getScore4());
            score3_1 = String.valueOf(mineBean.getScore3());
        }
    }


}
