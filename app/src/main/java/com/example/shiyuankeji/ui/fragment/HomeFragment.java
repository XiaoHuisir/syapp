package com.example.shiyuankeji.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.HomeAdapter;
import com.example.shiyuankeji.adapter.Homeclassadapter;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseFragment;
import com.example.shiyuankeji.bean.HomeBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.HomeCotract;
import com.example.shiyuankeji.presenter.HomePresenter;
import com.example.shiyuankeji.ui.activity.ProductDetailsActivity;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//toIndex
public class HomeFragment extends BaseFragment implements HomeCotract.View, Homeclassadapter.HomeClassClick {
    @BindView(R.id.ban)
    Banner ban;
    @BindView(R.id.hot_recyler)
    RecyclerView hotRecyler;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefres;
    @BindView(R.id.scr_view)
    ScrollView scrView;
    @BindView(R.id.re_no_data)
    RelativeLayout reNoData;
    @BindView(R.id.re_gone)
    RelativeLayout reGone;
    @BindView(R.id.re_home_classtiy)
    RecyclerView reHomeClasstiy;


    private HomeAdapter homeAdapter;
    private ArrayList<String> list_path;
    private List<HomeBean.MainListBannerBean> mainList_banner;
    private List<HomeBean.MainListTitleBean> mainList_title;
    private ArrayList<HomeBean.MainListTitleBean> listTetle;
    //Banner 点击事件 1 详情  2 分类
    public static final int ONE_TYPE_ = 1;
    public static final int TWO_TYPE_ = 2;
    private SwipeRefreshLayout.OnRefreshListener listener;
    private ArrayList<HomeBean.CateListBean> cateListbean;
    private Homeclassadapter homeclassadapter;

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
        String token = SharedPreferencesUtil.getToken(MyApp.mApp);
        SharedPreferencesUtil.addUserToken(context, token);
        Constant.token = token;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        hotRecyler.setLayoutManager(layoutManager);
        listTetle = new ArrayList<>();
        homeAdapter = new HomeAdapter(listTetle, context);
        hotRecyler.setAdapter(homeAdapter);
        reHomeClasstiy.setLayoutManager(new GridLayoutManager(context,4));
        cateListbean = new ArrayList<>();
        homeclassadapter = new Homeclassadapter(cateListbean);
        homeclassadapter.homeclassClick=this;
        reHomeClasstiy.setAdapter(homeclassadapter);
        //刷新
//        refress();  //效果一 简单刷新
        newrefres(); //效果二  自动刷新
    }

    private void refress() {
        // 让页面返回顶部
        scrView.post(new Runnable() {
            @Override
            public void run() {
                scrView.post(new Runnable() {
                    public void run() {
                        // 滚动至顶部
                        scrView.fullScroll(ScrollView.FOCUS_UP);
                        // 滚动到底部
                        //sc.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });
            }
        });
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


    private void newrefres() {
        //设置刷新球颜色
        swipeRefres.setColorSchemeColors(Color.BLUE, Color.RED, Color.YELLOW);
        swipeRefres.setProgressBackgroundColorSchemeColor(Color.parseColor("#ffffff"));//#BBFFFF
        ViewTreeObserver obeser = swipeRefres.getViewTreeObserver();
        obeser.addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                swipeRefres.setRefreshing(true);
//                Toast.makeText(context, "刷新", Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "登录成功！");
//                toastUtil2.show();
                ((HomePresenter) mPresenter).home();
//                Log.i("11getMeasuredHeight",mSwipeRefreshLayout.getMeasuredHeight()+"");
                swipeRefres.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefres != null) {
                            swipeRefres.setRefreshing(false);
                            scrView.fullScroll(View.FOCUS_UP);
                        }
                    }
                }, 2000);
            }
        });
        swipeRefres.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((HomePresenter) mPresenter).home();

                swipeRefres.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefres != null) {
                            swipeRefres.setRefreshing(false);
                            scrView.fullScroll(View.FOCUS_UP);
                        }
                    }
                }, 2000);
            }
        });
    }


    @Override
    public void homeReturn(HomeBean result) {
        if (result==null){
            return;
        }
        if (result.getCateList().size()<=0&&result.getCateList()==null){
            return;
        }
//        分类展示
        List<HomeBean.CateListBean> cateList = result.getCateList();
        cateListbean.clear();
        cateListbean.addAll(cateList);
        homeclassadapter.notifyDataSetChanged();
        // 让页面返回顶部
        scrView.post(new Runnable() {
            @Override
            public void run() {
                scrView.post(new Runnable() {
                    public void run() {
                        // 滚动至顶部
                        scrView.fullScroll(ScrollView.FOCUS_UP);
                        // 滚动到底部
                        //sc.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });
            }
        });
        mainList_banner = result.getMainList_banner();
        if (mainList_banner.size() > 0 && mainList_banner != null) {
            initbann(mainList_banner); //banner
        }
        mainList_title = result.getMainList_title();
        if (mainList_title != null && mainList_title.size() > 0) {
            reGone.setVisibility(View.VISIBLE);
            reNoData.setVisibility(View.GONE);
            listTetle.clear();
            listTetle.addAll(mainList_title);
            homeAdapter.notifyDataSetChanged();
        }else {
            reGone.setVisibility(View.GONE);
            reNoData.setVisibility(View.VISIBLE);
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
        ban.setIndicatorGravity(BannerConfig.CENTER)
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
                if (type2 == TWO_TYPE_) {  // 分类
                    Constant.IDS_CLASSFY = ids2;
                    Constant.CLASS_BOOLEAN=true;
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("id", Constant.TWO_TYPE_2);
                    startActivityForResult(intent, Constant.TWO_TYPE_2);
                    startActivity(intent);
//                    Toast.makeText(context, "跳 分类", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    //分类展示回调
    @Override
    public void cliaasclick(HomeBean.CateListBean listBean) {
        if (listBean==null){
            return;
        }
        if (listBean.getCateid()<0){
            return;
        }
        int cateid = listBean.getCateid();
        Constant.IDS_CLASSFY = String.valueOf(cateid);
        Constant.CLASS_BOOLEAN=true;
        Intent intent = new Intent();
        intent.setClass(getActivity(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id", Constant.TWO_TYPE_2);
        startActivityForResult(intent, Constant.TWO_TYPE_2);
        startActivity(intent);

    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }


    @Override
    protected void initData() {

        ((HomePresenter) mPresenter).home();
    }


}
