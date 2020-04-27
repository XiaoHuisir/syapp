package com.example.project.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.project.R;
import com.example.project.adapter.ShowClassAdapter;
import com.example.project.base.BaseFragment;
import com.example.project.bean.ClassBean;
import com.example.project.bean.ClassListBean;
import com.example.project.bean.InfoBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.ClassListifyContract;
import com.example.project.interfaces.contract.ClassifyContract;
import com.example.project.presenter.ClassListifyPresenter;
import com.example.project.presenter.ClassifyPresenter;
import com.example.project.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class ShowClassfyFragment extends BaseFragment implements ClassListifyContract.View {

    @BindView(R.id.recycler_showclassfy)
    RecyclerView recyclerShowclassfy;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefr;


    private ArrayList<ClassListBean.ItemsListBean> list;
    private int type;
    private ShowClassAdapter showClassAdapter;

    public ShowClassfyFragment(int cateid) {
        super();
        this.type = cateid;
    }


    @Override
    protected IBasePresenter getPresenter() {
        return new ClassListifyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_showclass;
    }

    @Override
    protected void initView() {
//        initbun();

        initrecycler();
        //刷新
        swipeRefr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((ClassListifyPresenter) mPresenter).cifyList(type);

                swipeRefr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefr != null) {
                            swipeRefr.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
    }

    private void initrecycler() {
        recyclerShowclassfy.setHasFixedSize(true);
        recyclerShowclassfy.setNestedScrollingEnabled(false);
        recyclerShowclassfy.setLayoutManager(new GridLayoutManager(context, 2));
        list = new ArrayList<>();


        showClassAdapter = new ShowClassAdapter(context, list);
        recyclerShowclassfy.setAdapter(showClassAdapter);
    }


    @Override
    public void classListReturn(ClassListBean result) {
        if (result != null) {
            List<ClassListBean.ItemsListBean> itemsList = result.getItemsList();
            list.clear();
            list.addAll(itemsList);
            showClassAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(context, "分类列表请求失败", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void initData() {
        ((ClassListifyPresenter) mPresenter).cifyList(type);
    }
}
