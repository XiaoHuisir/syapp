package com.example.project.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.adapter.HomeAdapter;
import com.example.project.base.BaseFragment;
import com.example.project.bean.HomeBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.HomeCotract;
import com.example.project.presenter.HomePresenter;
import com.example.project.ui.activity.ProductDetailsActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//toIndex
public class HomeFragment extends BaseFragment implements HomeCotract.View {
    @BindView(R.id.ban)
    Banner ban;
    @BindView(R.id.hot_recyler)
    RecyclerView hotRecyler;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefres;


    private HomeAdapter homeAdapter;
    private ArrayList<String> list_path;
    private List<HomeBean.MainListBannerBean> mainList_banner;
    private List<HomeBean.MainListTitleBean> mainList_title;
    private ArrayList<HomeBean.MainListTitleBean> listTetle;
    //Banner 点击事件 1 详情  2 分类
    public static final int ONE_TYPE_ = 1;
    public static final int TWO_TYPE_ = 2;

    @Override
    protected IBasePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView() {


        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        hotRecyler.setLayoutManager(layoutManager);

        listTetle = new ArrayList<>();
        homeAdapter = new HomeAdapter(listTetle, context);
        hotRecyler.setAdapter(homeAdapter);
        //刷新
        swipeRefres.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((HomePresenter) mPresenter).home();

                swipeRefres.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefres != null) {
                            swipeRefres.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
    }


    @Override
    public void homeReturn(HomeBean result) {
        mainList_banner = result.getMainList_banner();
        if (mainList_banner.size() > 0 && mainList_banner != null) {
            initbann(mainList_banner); //banner
        }
        mainList_title = result.getMainList_title();
        if (mainList_title != null && mainList_title.size() > 0) {
            listTetle.clear();
            listTetle.addAll(mainList_title);
            homeAdapter.notifyDataSetChanged();
        }

    }

    private void initbann(final List<HomeBean.MainListBannerBean> mainList_banner) {
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合

        for (int i = 0; i < mainList_banner.size(); i++) {
            String image = mainList_banner.get(i).getImage();
            list_path.add(image);
        }

        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        ban.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);//CIRCLE_INDICATOR_TITLE
        //设置图片加载器，图片加载器在下方
        ban.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        ban.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        ban.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
//      ban.setBannerTitles(list_title); //???
        //设置轮播间隔时间
        ban.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        ban.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        ban.setIndicatorGravity(BannerConfig.RIGHT)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                //必须最后调用的方法，启动轮播图。
                .start();
//      轮播点击事件
        ban.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                HomeBean.MainListBannerBean bean = mainList_banner.get(position);
                int type2 = bean.getType2();
                String ids2 = bean.getIds2();
                if (type2 == ONE_TYPE_) { // 详情
                    Intent intent = new Intent(context, ProductDetailsActivity.class);
                    intent.putExtra("idsa", ids2);
                    startActivity(intent);
                }
                if (type2 == TWO_TYPE_) {  // TODO 分类 ??

                    Toast.makeText(context, "跳 分类", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }


    @Override
    protected void initData() { //用于返回数据
        ((HomePresenter) mPresenter).home();
    }


}
