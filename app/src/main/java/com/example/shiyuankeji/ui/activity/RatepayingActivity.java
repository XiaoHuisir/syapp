package com.example.shiyuankeji.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.RatepAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.RatepayingBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.RatepayContract;
import com.example.shiyuankeji.presenter.MinePresenter;
import com.example.shiyuankeji.presenter.RatepayPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RatepayingActivity extends BaseActivity implements RatepayContract.View {
    @BindView(R.id.im_wbeak)
    ImageView imWbeak;
    @BindView(R.id.recyc_rate)
    RecyclerView recycRate;
    @BindView(R.id.scro_view)
    ScrollView scroView;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.tv_tilet)
    TextView tvTilet;
    @BindView(R.id.re_no)
    RelativeLayout reNo;
    @BindView(R.id.re_ok)
    RelativeLayout reOk;

    private ArrayList<RatepayingBean.DataBean> list;
    private RatepAdapter ratepAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new RatepayPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ratepaying;
    }

    @Override
    protected void initView() {
        newrefres(); //自动刷新
        recycRate.setNestedScrollingEnabled(false);
        String deducts_s = getIntent().getStringExtra("deducts_s");
        tvTilet.setText("纳税总额：" + deducts_s);
        if (deducts_s.equals("0.0")) {
            reNo.setVisibility(View.VISIBLE);
            reOk.setVisibility(View.GONE);
        } else {
            reOk.setVisibility(View.VISIBLE);
            reNo.setVisibility(View.GONE);
        }
        recycRate.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        ratepAdapter = new RatepAdapter(list);
        recycRate.setAdapter(ratepAdapter);
    }

    private void newrefres() {
        //设置刷新球颜色
        swipe.setColorSchemeColors(Color.BLUE, Color.RED, Color.YELLOW);
        swipe.setProgressBackgroundColorSchemeColor(Color.parseColor("#ffffff"));//#BBFFFF
        ViewTreeObserver obeser = swipe.getViewTreeObserver();
        obeser.addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                swipe.setRefreshing(true);
//                Toast.makeText(context, "刷新", Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "登录成功！");
//                toastUtil2.show();
                ((RatepayPresenter) mPresenter).retepays();
//                Log.i("11getMeasuredHeight",mSwipeRefreshLayout.getMeasuredHeight()+"");
                swipe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipe != null) {
                            swipe.setRefreshing(false);
//                            scrView.fullScroll(View.FOCUS_UP);
                        }
                    }
                }, 2000);
            }
        });
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((RatepayPresenter) mPresenter).retepays();

                swipe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipe != null) {
                            swipe.setRefreshing(false);
//                            scrView.fullScroll(View.FOCUS_UP);
                        }
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void ratepayRean(RatepayingBean ratepayingBean) {
        if (ratepayingBean == null || ratepayingBean.getStatus() != 200) {
            return;
        }
        List<RatepayingBean.DataBean> data = ratepayingBean.getData();
        list.clear();
        list.addAll(data);
        ratepAdapter.notifyDataSetChanged();

    }


    @Override
    protected void initData() {
        ((RatepayPresenter) mPresenter).retepays();
    }


    @OnClick({R.id.im_wbeak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_wbeak:
                finish();
                break;
        }
    }
}
