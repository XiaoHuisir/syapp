package com.example.shiyuankeji.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.EperienceAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.ExperienceBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.ExperienceContract;
import com.example.shiyuankeji.presenter.ExperiencePresenter;
import com.example.shiyuankeji.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExperienceActivity extends BaseActivity implements ExperienceContract.View {
    @BindView(R.id.im_wbeak)
    ImageView imWbeak;
    @BindView(R.id.tv_tilte_name)
    TextView tvTilteName;
    @BindView(R.id.recycler_experience)
    RecyclerView recyclerExperience;
    @BindView(R.id.scrView)
    ScrollView scrView;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    private EperienceAdapter adapter;
    ArrayList<ExperienceBean.UserAddLogListBean> list = new ArrayList<>();

    @Override
    protected IBasePresenter getPresenter() {
        return new ExperiencePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_eperience;
    }

    @Override
    protected void initView() {
        recyclerExperience.setHasFixedSize(true);
        recyclerExperience.setNestedScrollingEnabled(false);
        String experience = getIntent().getStringExtra("experience");
        tvTilteName.setText("体验积分："+experience);
        recyclerExperience.setLayoutManager(new LinearLayoutManager(context));
        adapter = new EperienceAdapter(list);
        recyclerExperience.setAdapter(adapter);
        newrefres();
    }
    private void newrefres() {
        //设置刷新球颜色
        swipeRefresh.setColorSchemeColors(Color.BLUE, Color.RED, Color.YELLOW);
        swipeRefresh.setProgressBackgroundColorSchemeColor(Color.parseColor("#ffffff"));//#BBFFFF
        ViewTreeObserver obeser = swipeRefresh.getViewTreeObserver();
        obeser.addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                swipeRefresh.setRefreshing(true);
//                Toast.makeText(context, "刷新", Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "登录成功！");
//                toastUtil2.show();
                ((ExperiencePresenter) mPresenter).expers();
//                Log.i("11getMeasuredHeight",mSwipeRefreshLayout.getMeasuredHeight()+"");
                swipeRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefresh != null) {
                            swipeRefresh.setRefreshing(false);
                            scrView.fullScroll(View.FOCUS_UP);
                        }
                    }
                }, 2000);
            }
        });
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((ExperiencePresenter) mPresenter).expers();

                swipeRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefresh != null) {
                            swipeRefresh.setRefreshing(false);
                            scrView.fullScroll(View.FOCUS_UP);
                        }
                    }
                }, 2000);
            }
        });
    }
    @Override
    public void experRean(ExperienceBean experienceBean) {
        if (experienceBean.getUser_add_logList().size()>0&&experienceBean.getUser_add_logList()!=null){
            List<ExperienceBean.UserAddLogListBean> user_add_logList = experienceBean.getUser_add_logList();
            list.clear();
            list.addAll(user_add_logList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void initData() {
        ((ExperiencePresenter) mPresenter).expers();
    }



    @OnClick(R.id.im_wbeak)
    public void onViewClicked() {
        finish();
    }
}
