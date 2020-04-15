package com.example.project.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.R;
import com.example.project.adapter.IndentListAdapter;
import com.example.project.base.BaseFragment;
import com.example.project.bean.IndentBean;
import com.example.project.bean.InfoBean;
import com.example.project.interfaces.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class IndentFragment extends BaseFragment {
    @BindView(R.id.re_indent_list)
    RecyclerView reIndentList;
    private ArrayList<IndentBean> list;


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {

        return R.layout.indent_fragment;
    }

    @Override
    protected void initView() {
        reIndentList.setHasFixedSize(true);
        reIndentList.setNestedScrollingEnabled(false);
        reIndentList.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        for (int i = 0; i < 4
                ; i++) {
            IndentBean indentBean = new IndentBean();
            indentBean.setColor("黑色");
            indentBean.setName("识缘手机");
            indentBean.setPrice(3333);
            indentBean.setOrdernumber(919191);
            indentBean.setTotal(66666);
            indentBean.setQuantity(1);
            list.add(indentBean);
        }

        IndentListAdapter indentListAdapter = new IndentListAdapter(context, list);
        reIndentList.setAdapter(indentListAdapter);
    }

    @Override
    protected void initData() {

    }
}
