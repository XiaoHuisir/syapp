package com.example.project.ui.fragment;

import android.content.Context;
import android.icu.text.IDNA;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.adapter.HomeAdapter;
import com.example.project.base.BaseFragment;
import com.example.project.bean.InfoBean;
import com.example.project.interfaces.IBasePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.ban)
    Banner ban;
    @BindView(R.id.hot_recyler)
    RecyclerView hotRecyler;
    @BindView(R.id.sale_recyler)
    RecyclerView saleRecyler;

    private HomeAdapter homeAdapter;
    private ArrayList<InfoBean> rl;
    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {
        initbann();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hotRecyler.setLayoutManager(layoutManager);


        GridLayoutManager layoutManager1 = new GridLayoutManager(context,2);
//        layoutManager1.setOrientation(LinearLayoutManager.v);
        saleRecyler.setLayoutManager(layoutManager1);
        rl = new ArrayList<>();
        for (int i = 0; i <4
                ; i++) {
            InfoBean infoBean = new InfoBean("这是商品"+i,6000,R.drawable.exhibition_bg);
            rl.add(infoBean);
        }

        homeAdapter = new HomeAdapter(rl,context);
        saleRecyler.setAdapter(homeAdapter);
        hotRecyler.setAdapter(homeAdapter);
    }

    private void initbann() {
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        list_path.add(R.mipmap.home);
        list_path.add(R.mipmap.home1);
        list_path.add(R.mipmap.home);
        list_path.add(R.mipmap.home1);
        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        ban.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        ban.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        ban.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        ban.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        ban.setBannerTitles(list_title);
        //设置轮播间隔时间
        ban.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        ban.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        ban.setIndicatorGravity(BannerConfig.RIGHT)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                //必须最后调用的方法，启动轮播图。
                .start();


    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load( path).into(imageView);
        }
    }



    @Override
    protected void initData() { //用于返回数据
        super.initData();
    }


}
