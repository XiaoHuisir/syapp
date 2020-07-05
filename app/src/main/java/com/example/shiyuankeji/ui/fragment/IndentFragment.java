package com.example.shiyuankeji.ui.fragment;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.IndentListAdapter;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseFragment;
import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.bean.NewIndentBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.IndentContract;
import com.example.shiyuankeji.presenter.IndentPresenter;
import com.example.shiyuankeji.presenter.MinePresenter;
import com.example.shiyuankeji.ui.activity.IineItemActivity;
import com.example.shiyuankeji.ui.activity.login.LoginActivity;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

// http://192.168.124.13:8080/toOrderIndex?userId=15
public class IndentFragment extends BaseFragment implements IndentContract.View, IndentListAdapter.IndentItemClick {
    @BindView(R.id.re_indent_list)
    RecyclerView reIndentList;
    @BindView(R.id.indent_swipeRefeash)
    SwipeRefreshLayout indentSwipeRefeash;
    private ArrayList<NewIndentBean.OrderListListBean> list;
    private IndentListAdapter indentListAdapter;
    private String msg;


    @Override
    protected IBasePresenter getPresenter() {
        return new IndentPresenter();
    }

    @Override
    protected int getLayoutId() {

        return R.layout.indent_fragment;
    }

    @Override
    protected void initView() {
        //countDown();//我的模块登录状态初始化处理（判断是否登录） 带秒数的
//        StateHandling();//我的模块登录状态初始化处理（判断是否登录） 不带秒数的
        reIndentList.setHasFixedSize(true);
        reIndentList.setNestedScrollingEnabled(false);
        list = new ArrayList<>();
        reIndentList.setLayoutManager(new LinearLayoutManager(context));
        indentListAdapter = new IndentListAdapter(context, list);
        indentListAdapter.itemClick = this;
        reIndentList.setAdapter(indentListAdapter);

        //刷新
        indentSwipeRefeash.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((IndentPresenter) mPresenter).indents();

                indentSwipeRefeash.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (indentSwipeRefeash != null) {
                            indentSwipeRefeash.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
    }

    //    /**
//     * 倒计时显示
//     */
//    private void countDown() {
//        CountDownTimer timer = new CountDownTimer(1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//            }
//
//            @Override
//            public void onFinish() {
////                Toast.makeText(context, "时间就是生命", Toast.LENGTH_SHORT).show();
//                StateHandling();   //TODO 用Token进行判断用户是否是登录状态
//            }
//        }.start();
//    }
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
        ((IndentPresenter) mPresenter).logintokens();  //校验是否登录状态
        ((IndentPresenter) mPresenter).indents();
    }

    @Override
    public void logintokenReaun(LoginTokenBean loginTokenBean) {
        String token = SharedPreferencesUtil.getToken(MyApp.mApp);
        msg = loginTokenBean.getMsg();
        Intent intent = new Intent();
        if (msg.equals("001")) {
//            StateHandling();
            SharedPreferencesUtil.deleteToken(MyApp.mApp);
            intent.setClass(context, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            getActivity().finish();
        }else {
            Constant.token = token;
        }
    }

    @Override
    public void indentRean(NewIndentBean newIndentBean) {
        List<NewIndentBean.OrderListListBean> order_lists = newIndentBean.getOrder_listList();
        if (order_lists != null) {
            list.clear();
            list.addAll(order_lists);
            indentListAdapter.notifyDataSetChanged();
        }
    }

    //回调 跳转订单详情
    @Override
    public void indentclick(NewIndentBean.OrderListListBean orderListsBean) {
        if (orderListsBean != null) {
            String id = orderListsBean.getOrder_num();
            Intent intent = new Intent();
            intent.setClass(context, IineItemActivity.class);
            intent.putExtra("indent_id", id);
            startActivity(intent);

        }
    }
}
