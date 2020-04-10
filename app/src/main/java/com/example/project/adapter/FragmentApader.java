package com.example.project.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentApader extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private List<String> mList;

    public FragmentApader(FragmentManager fm, List<Fragment> mFragmentList, List<String> mList) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.mList = mList;
    }


    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
