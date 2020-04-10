package com.example.project.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.project.R;
import com.example.project.adapter.FragmentApader;
import com.example.project.base.BaseFragment;
import com.example.project.interfaces.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ClassifyFragment extends BaseFragment {
    @BindView(R.id.tab_classfy)
    TabLayout tabClassfy;
    @BindView(R.id.vp_classfy)
    ViewPager vpClassfy;


    List<Fragment> mFragmentList = new ArrayList<>();

    List<String> mList = new ArrayList<>();
    private String name;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.classify_fragment;
    }

    @Override
    protected void initView() {
        initbundle();
        mList.add("手机");
        mList.add("数码");
        mList.add("生活");
        mList.add("电器");
        mList.add("百货");
        mList.add("会员");
        mList.add("学习");
        mList.add("测试1");
        mList.add("测试2");
        mList.add("测试3");
        for (int i = 0; i < mList.size(); i++) {
            //返回一个对象
            Fragment fuYong = ShowClassfyFragment.getFuYong(mList.get(i));
            // fragment集合添加这个对象，fragment集合就添加了5个fragment
            mFragmentList.add(fuYong);
        }
        //然后是ViewPager适配器，搭配上TabLayout
        FragmentApader apader =
                new FragmentApader(getChildFragmentManager(), mFragmentList, mList);
        vpClassfy.setAdapter(apader);
        tabClassfy.setupWithViewPager(vpClassfy);

    }


    private void initbundle() {
        Bundle arguments = getArguments();

        if (arguments != null) {

            name = arguments.getString("string");

        }
    }

    @Override
    protected void initData() {

    }
}
