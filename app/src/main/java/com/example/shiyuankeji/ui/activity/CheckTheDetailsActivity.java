package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.DetailsOkAdpter;
import com.example.shiyuankeji.adapter.NotMonthAdapter;
import com.example.shiyuankeji.adapter.NotSeasonAdapter;
import com.example.shiyuankeji.adapter.NotWeekAdapter;
import com.example.shiyuankeji.adapter.NotYearAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.CheckDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.CheckDetailsContract;
import com.example.shiyuankeji.presenter.CheckDetailsPresenter;
import com.example.shiyuankeji.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckTheDetailsActivity extends BaseActivity implements CheckDetailsContract.View, NotWeekAdapter.ClickNotWeekItem, NotMonthAdapter.ClickNotMonthItem, NotSeasonAdapter.ClickNotSeasonItem, NotYearAdapter.ClickNotYearItem, DetailsOkAdpter.ClickDetailsOkItem {
    @BindView(R.id.lli_back)
    LinearLayout lliBack;
    @BindView(R.id.recycler_earningsok)
    RecyclerView recyclerEarningsok;
    @BindView(R.id.tv_geng_add)
    TextView tvGengAdd;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.smartRef)
    SwipeRefreshLayout smartRef;
    @BindView(R.id.recycler_notweek)
    RecyclerView recyclerNotweek;
    @BindView(R.id.recycler_notmonth)
    RecyclerView recyclerNotmonth;
    @BindView(R.id.recycler_notseason)
    RecyclerView recyclerNotseason;
    @BindView(R.id.recycler_notyear)
    RecyclerView recyclerNotyear;
    ArrayList<CheckDetailsBean.AlreadyShareInfoVoBean> detailslistok = new ArrayList<>();//已到账收益
    ArrayList<CheckDetailsBean.NotShareInfoVoBean> notWeeklist = new ArrayList<>();//周（未）
    ArrayList<CheckDetailsBean.NotMonthShareInfosBean> notMonthlist = new ArrayList<>();//月（未）
    ArrayList<CheckDetailsBean.NotSeasonShareInfosBean> notSeasonlist = new ArrayList<>();//季（未）
    ArrayList<CheckDetailsBean.NotYearShareInfosBean> notYearlist = new ArrayList<>();//年（未）
    private DetailsOkAdpter detailsOkAdpter;
    private NotWeekAdapter notWeekAdapter;
    private NotMonthAdapter notMonthAdapter;
    private NotSeasonAdapter notSeasonAdapter;
    private NotYearAdapter notYearAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new CheckDetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_checkdetails;
    }

    @Override
    protected void initView() {
        recyclerEarningsok.setHasFixedSize(true);
        recyclerEarningsok.setNestedScrollingEnabled(false);
        recyclerNotweek.setHasFixedSize(true);
        recyclerNotweek.setNestedScrollingEnabled(false);
        recyclerNotmonth.setHasFixedSize(true);
        recyclerNotmonth.setNestedScrollingEnabled(false);
        recyclerNotseason.setHasFixedSize(true);
        recyclerNotseason.setNestedScrollingEnabled(false);
        recyclerNotyear.setHasFixedSize(true);
        recyclerNotyear.setNestedScrollingEnabled(false);
        recyclerEarningsok.setLayoutManager(new LinearLayoutManager(context)); //到账收益
        recyclerNotweek.setLayoutManager(new LinearLayoutManager(context));
        recyclerNotmonth.setLayoutManager(new LinearLayoutManager(context));
        recyclerNotseason.setLayoutManager(new LinearLayoutManager(context));
        recyclerNotyear.setLayoutManager(new LinearLayoutManager(context));
        detailsOkAdpter = new DetailsOkAdpter(context,detailslistok);
        detailsOkAdpter.clickDetailsOkItem = this;
        recyclerEarningsok.setAdapter(detailsOkAdpter);
        notWeekAdapter = new NotWeekAdapter(notWeeklist);
        notWeekAdapter.clickWeekItems = this;
        recyclerNotweek.setAdapter(notWeekAdapter);
        notMonthAdapter = new NotMonthAdapter(notMonthlist);
        notMonthAdapter.clickNotMonthItem = this;
        recyclerNotmonth.setAdapter(notMonthAdapter);
        notSeasonAdapter = new NotSeasonAdapter(notSeasonlist);
        notSeasonAdapter.clickNotSeasonItem = this;
        recyclerNotseason.setAdapter(notSeasonAdapter);
        notYearAdapter = new NotYearAdapter(notYearlist);
        notYearAdapter.clickNotYearItem = this;
        recyclerNotyear.setAdapter(notYearAdapter);
        refress();

    }

    private void refress() {
        // 让页面返回顶部
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.post(new Runnable() {
                    public void run() {
                        // 滚动至顶部
                        scrollView.fullScroll(ScrollView.FOCUS_UP);
                        // 滚动到底部
                        //sc.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });
            }
        });
        smartRef.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((CheckDetailsPresenter) mPresenter).checks();

                smartRef.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (smartRef != null) {
                            smartRef.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
    }

    @OnClick({R.id.lli_back, R.id.tv_geng_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lli_back:
                finish();
                break;
            case R.id.tv_geng_add: //查看更多
                Intent intent = new Intent();
                intent.setClass(context, SeeMoreActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void initData() {
        ((CheckDetailsPresenter) mPresenter).checks();
    }

    @Override
    public void checkRean(CheckDetailsBean checkDetailsBean) {
        if (checkDetailsBean != null) {
            if (checkDetailsBean.getAlreadyShareInfoVo() == null) {
                return;
            }
            List<CheckDetailsBean.AlreadyShareInfoVoBean> alreadyShareInfoVo = checkDetailsBean.getAlreadyShareInfoVo();//已到账收益
            detailslistok.clear();
            detailslistok.addAll(alreadyShareInfoVo);
            detailsOkAdpter.notifyDataSetChanged();
            if (checkDetailsBean.getNotShareInfoVo() != null || checkDetailsBean.getNotShareInfoVo().size() == 0) { //周（未）
                List<CheckDetailsBean.NotShareInfoVoBean> notShareInfoVo = checkDetailsBean.getNotShareInfoVo();
                notWeeklist.clear();
                notWeeklist.addAll(notShareInfoVo);
                notWeekAdapter.notifyDataSetChanged();
            } else {
                recyclerNotweek.setVisibility(View.INVISIBLE);
                return;
            }
            if (checkDetailsBean.getNotMonthShareInfos() != null || checkDetailsBean.getNotMonthShareInfos().size() == 0) { //月（未）
                List<CheckDetailsBean.NotMonthShareInfosBean> notMonthShareInfos = checkDetailsBean.getNotMonthShareInfos();
                notMonthlist.clear();
                notMonthlist.addAll(notMonthShareInfos);
                notMonthAdapter.notifyDataSetChanged();
            } else {
                recyclerNotmonth.setVisibility(View.INVISIBLE);
                return;
            }
            if (checkDetailsBean.getNotSeasonShareInfos() != null || checkDetailsBean.getNotSeasonShareInfos().size() == 0) { //季（未）
                List<CheckDetailsBean.NotSeasonShareInfosBean> notSeasonShareInfos = checkDetailsBean.getNotSeasonShareInfos();
                notSeasonlist.clear();
                notSeasonlist.addAll(notSeasonShareInfos);
                notSeasonAdapter.notifyDataSetChanged();
            } else {
                recyclerNotseason.setVisibility(View.INVISIBLE);
                return;
            }
            if (checkDetailsBean.getNotYearShareInfos() != null || checkDetailsBean.getNotYearShareInfos().size() == 0) { //年（未）
                List<CheckDetailsBean.NotYearShareInfosBean> notYearShareInfos = checkDetailsBean.getNotYearShareInfos();
                notYearlist.clear();
                notYearlist.addAll(notYearShareInfos);
                notYearAdapter.notifyDataSetChanged();
            } else {
                recyclerNotyear.setVisibility(View.INVISIBLE);
                return;
            }
        } else {
            return;
        }
    }

    //回调（周）
    @Override
    public void clickweekitem(String createtime) {
        if (createtime != null) {
            Intent intent = new Intent();
            intent.setClass(context, GrantDetailsActivity.class);
            intent.putExtra("createtimes", createtime);
            startActivity(intent);
        }
    }

    //回调（月）
    @Override
    public void clicknotmonthitem(String createtime) {
        if (createtime != null) {
            Intent intent = new Intent();
            intent.setClass(context, GrantDetailsActivity.class);
            intent.putExtra("createtimes", createtime);
            startActivity(intent);
        }
    }

    //回调（季）
    @Override
    public void clicknotseasonitem(String createtime) {
        Intent intent = new Intent();
        intent.setClass(context, GrantDetailsActivity.class);
        intent.putExtra("createtimes", createtime);
        startActivity(intent);
    }

    //回调（年）
    @Override
    public void clicknotyearitem(String createtime) {
        Intent intent = new Intent();
        intent.setClass(context, GrantDetailsActivity.class);
        intent.putExtra("createtimes", createtime);
        startActivity(intent);
    }

    //回调（已发放）
    @Override
    public void clickdetailsokitem(String createtime) {
        Intent intent = new Intent();
        intent.setClass(context, GrantDetailsActivity.class);
        intent.putExtra("createtimes", createtime);
        startActivity(intent);
    }
}
