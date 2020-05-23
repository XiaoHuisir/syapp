package com.example.shiyuankeji.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FmManager extends FragmentPagerAdapter {

    FragmentManager fm;
    List<Fragment> fragments;
    String[] titles;

    public FmManager(FragmentManager fm, List<Fragment> fragments, String[] titles){
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
        this.titles = titles;
    }

    public void setTitles(String[] titles){
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }
}
