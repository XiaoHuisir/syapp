package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.YieldAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.QueryEarningsBean;
import com.example.shiyuankeji.bean.YieDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.QueryEarningsContract;
import com.example.shiyuankeji.presenter.HomePresenter;
import com.example.shiyuankeji.presenter.QueryEarningsPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YieldActivity extends BaseActivity implements QueryEarningsContract.View, YieldAdapter.YieContextItem {
    @BindView(R.id.lli_back)
    LinearLayout lliBack;
    @BindView(R.id.rell)
    RelativeLayout rells;
    @BindView(R.id.ree_yield)
    RecyclerView reeYield;
    @BindView(R.id.tv_now)
    TextView tvNow;
    @BindView(R.id.tv_zong)
    TextView tvZong;
    @BindView(R.id.re_no_data)
    RelativeLayout reNoData;
    @BindView(R.id.re_have)
    RelativeLayout reHave;
    @BindView(R.id.smartRef)
    SwipeRefreshLayout smartRefs;
    @BindView(R.id.scroll_view)
    ScrollView  scrollView;
    private boolean indxler =false;
    private ArrayList<QueryEarningsBean.ShareInfoVoBean> listyieid;
    private YieldAdapter yieldAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new QueryEarningsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yield;
    }

    @Override
    protected void initData() {
        ((QueryEarningsPresenter) mPresenter).earnings();
    }

    @Override
    protected void initView() {
       newrefres(indxler); //自动刷新
        reeYield.setHasFixedSize(true);
        reeYield.setNestedScrollingEnabled(false);
        listyieid = new ArrayList<>();
        reeYield.setLayoutManager(new LinearLayoutManager(context));//管理器
        //适配器
        yieldAdapter = new YieldAdapter(listyieid);
        yieldAdapter.yieContextItem = this;
        reeYield.setAdapter(yieldAdapter);
    }

    @OnClick({R.id.rell})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rell:
                finish();
                break;
        }
    }

    @Override
    public void earningsRean(QueryEarningsBean queryEarningsBean) {
        if (queryEarningsBean != null) {
            List<QueryEarningsBean.ShareInfoVoBean> shareInfoVo = queryEarningsBean.getShareInfoVo();
            if (shareInfoVo.size()>0&&shareInfoVo!=null){
                reNoData.setVisibility(View.GONE);
                reHave.setVisibility(View.VISIBLE);
                listyieid.clear();
                listyieid.addAll(shareInfoVo);
                yieldAdapter.notifyDataSetChanged();
                tvNow.setText(String.valueOf(queryEarningsBean.getTotalprice()));
                tvZong.setText(String.valueOf(queryEarningsBean.getProfit()));
                indxler=true;
                newrefres(indxler); //自动刷新
            }else {
                reNoData.setVisibility(View.VISIBLE);
                reHave.setVisibility(View.GONE);
                indxler=false;
                newrefres(indxler);
            }

        }
    }

    private void newrefres(boolean indx) {
        if (indx==true){
            //设置刷新球颜色
            smartRefs.setColorSchemeColors(Color.BLUE, Color.RED, Color.YELLOW);
            smartRefs.setProgressBackgroundColorSchemeColor(Color.parseColor("#ffffff"));//#BBFFFF
            ViewTreeObserver obeser = smartRefs.getViewTreeObserver();
            obeser.addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
                @Override
                public void onWindowFocusChanged(boolean hasFocus) {
                    smartRefs.setRefreshing(true);
//                Toast.makeText(context, "刷新", Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "登录成功！");
//                toastUtil2.show();
                    ((QueryEarningsPresenter) mPresenter).earnings();
//                Log.i("11getMeasuredHeight",mSwipeRefreshLayout.getMeasuredHeight()+"");
                    smartRefs.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (smartRefs != null) {
                                smartRefs.setRefreshing(false);
                                scrollView.fullScroll(View.FOCUS_UP);
                            }
                        }
                    }, 2000);
                }
            });
            smartRefs.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    ((QueryEarningsPresenter) mPresenter).earnings();

                    smartRefs.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (smartRefs != null) {
                                smartRefs.setRefreshing(false);
                                scrollView.fullScroll(View.FOCUS_UP);
                            }
                        }
                    }, 2000);
                }
            });
        }else {
            return;
        }
    }

    @Override
    public void yiedetailsRean(YieDetailsBean yieDetailsBean) {

    }

    //回调
    @Override
    public void yiecontextitem(QueryEarningsBean.ShareInfoVoBean list) {
        if (list != null) {
            String order_num = list.getOrder_num();
            Intent intent = new Intent();
            intent.setClass(context,YiedetailsActivity.class);
            intent.putExtra("order",order_num);
            startActivity(intent);
        }
    }
}
