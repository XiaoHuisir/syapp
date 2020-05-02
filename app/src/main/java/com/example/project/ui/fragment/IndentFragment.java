package com.example.project.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.R;
import com.example.project.adapter.IndentListAdapter;
import com.example.project.base.BaseFragment;
import com.example.project.bean.NewIndentBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.IndentContract;
import com.example.project.presenter.HomePresenter;
import com.example.project.presenter.IndentPresenter;
import com.example.project.ui.activity.IineItemActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

// http://192.168.124.13:8080/toOrderIndex?userId=15
public class IndentFragment extends BaseFragment implements IndentContract.View, IndentListAdapter.IndentItemClick {
    @BindView(R.id.re_indent_list)
    RecyclerView reIndentList;
    @BindView(R.id.indent_swipeRefeash)
    SwipeRefreshLayout indentSwipeRefeash;
    private ArrayList<NewIndentBean.OrderListsBean> list;
    private IndentListAdapter indentListAdapter;


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
                ((IndentPresenter) mPresenter).indents(15);

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

    @Override
    protected void initData() {
        ((IndentPresenter) mPresenter).indents(15);
    }

    @Override
    public void indentRean(NewIndentBean newIndentBean) {
        List<NewIndentBean.OrderListsBean> order_lists = newIndentBean.getOrder_lists();
        if (order_lists != null) {
            list.clear();
            list.addAll(order_lists);
            indentListAdapter.notifyDataSetChanged();
        }
    }

    //回调 跳转订单详情
    @Override
    public void indentclick(NewIndentBean.OrderListsBean orderListsBean) {
        if (orderListsBean != null) {
            int id = orderListsBean.getId();
            Intent intent = new Intent();
            intent.setClass(context, IineItemActivity.class);
            intent.putExtra("indent_id", id);
            startActivity(intent);

        }
    }
}
