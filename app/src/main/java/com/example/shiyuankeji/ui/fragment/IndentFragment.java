package com.example.shiyuankeji.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.IndentListAdapter;
import com.example.shiyuankeji.base.BaseFragment;
import com.example.shiyuankeji.bean.NewIndentBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.IndentContract;
import com.example.shiyuankeji.presenter.IndentPresenter;
import com.example.shiyuankeji.ui.activity.IineItemActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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

    @Override
    protected void initData() {
        ((IndentPresenter) mPresenter).indents();
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
