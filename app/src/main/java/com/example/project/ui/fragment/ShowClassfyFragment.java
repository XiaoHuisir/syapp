package com.example.project.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.project.R;
import com.example.project.adapter.ShowClassAdapter;
import com.example.project.base.BaseFragment;
import com.example.project.bean.InfoBean;
import com.example.project.interfaces.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class ShowClassfyFragment extends BaseFragment {

    @BindView(R.id.recycler_showclassfy)
    RecyclerView recyclerShowclassfy;

    private String name;
    private ArrayList<InfoBean> list;

    //复用
    public static Fragment getFuYong(String string) {
        ShowClassfyFragment myFragmentFuYong = new ShowClassfyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("string", string);
        myFragmentFuYong.setArguments(bundle);
        return myFragmentFuYong;
    }

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_showclass;
    }

    @Override
    protected void initView() {
        initbun();
        initrecycler();

    }

    private void initrecycler() {
        recyclerShowclassfy.setHasFixedSize(true);
        recyclerShowclassfy.setNestedScrollingEnabled(false);
        recyclerShowclassfy.setLayoutManager(new GridLayoutManager(context, 2));

        list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {

            InfoBean infoBean = new InfoBean("机器人" + i, 1000, R.drawable.exhibition_bg);
            list.add(infoBean);

        }
        ShowClassAdapter showClassAdapter = new ShowClassAdapter(context,list);
        recyclerShowclassfy.setAdapter(showClassAdapter);
    }

    private void initbun() {
        Bundle arguments = getArguments();

        if (arguments != null) {
            name = arguments.getString("string");
        }
    }


}
