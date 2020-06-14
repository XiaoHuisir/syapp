package com.example.shiyuankeji;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.ui.fragment.ClassifyFragment;
import com.example.shiyuankeji.ui.fragment.HomeFragment;
import com.example.shiyuankeji.ui.fragment.IndentFragment;
import com.example.shiyuankeji.ui.fragment.MineFragment;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.fl)
    FrameLayout mFl;

    int curType;
    private int numNot;
    boolean indxler = false;

    private int currentBottomPosition;
    private int targetBottomPosition;
    private List<Fragment> fragmentList = new ArrayList<>();
    private PopupWindow popupWindow;

    private String apk_url;
    private int status;

    private int version_code;
    private boolean booleandelet = false;
    private FragmentManager manager;
    private HomeFragment homeFragment;
    private ClassifyFragment classifyFragment;
    private MineFragment mineFragment;
    private IndentFragment indentFragment;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        manager = getSupportFragmentManager();
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//        初始化 bugly 检测版本是否为最新 （是 更新 ，否 不更新）
        buglys();
//                    Bundle arguments = getArguments();
//                    int typeID = arguments.getInt("typeID");
        initFragment();

        manager.beginTransaction().add(R.id.fl, fragmentList.get(0)).commit();
        mTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                int position = tab.getPosition();
                curType = position;
                showFragment(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void buglys() {
// 腾讯bugly版本升级,第二个参数就是你的appid
        Bugly.init(MainActivity.this, "99f695bf69", true);
        Beta.canShowUpgradeActs.add(MainActivity.class); //添加可显示弹窗的Activity
        Beta.enableNotification = true; //设置是否显示消息通知
//        设置是否显示弹窗中的apk信息
        Beta.canShowApkInfo = true;
        Beta.enableHotfix = true; //关闭热更新能力
    }

    private Bundle getArguments() {
        return getArguments();
    }


    @Override
    protected void initData() {
        //TODO 这里做的跳转处理 （initData 方法里的都是跳转处理）
        int id = getIntent().getIntExtra("id", 0);
        FragmentTransaction ftran = manager.beginTransaction();
        if (id == 1) {
            targetBottomPosition = 0;
            if (currentBottomPosition == 0) {
                return;
            }
            ftran.hide(fragmentList.get(currentBottomPosition));
            if (!fragmentList.get(targetBottomPosition).isAdded()) {
                ftran.add(R.id.fl, fragmentList.get(targetBottomPosition));
            }
            ftran.show(fragmentList.get(targetBottomPosition)).commit();
            currentBottomPosition = 0;

        }
        if (id == 2) {

            targetBottomPosition = 1;
            if (currentBottomPosition == 1) {
                return;
            }
            ftran.hide(fragmentList.get(currentBottomPosition));
            if (!fragmentList.get(targetBottomPosition).isAdded()) {
                ftran.add(R.id.fl, fragmentList.get(targetBottomPosition));
            }
            ftran.show(fragmentList.get(targetBottomPosition)).commit();
            currentBottomPosition = 1;
            mTl.setSelected(true);
//            mTl.setClipChildren(true);
            mTl.getTabAt(1).select();


        }
        if (id == 3) {
            targetBottomPosition = 2;
            if (currentBottomPosition == 2) {
                return;
            }
            ftran.hide(fragmentList.get(currentBottomPosition));
            if (!fragmentList.get(targetBottomPosition).isAdded()) {
                ftran.add(R.id.fl, fragmentList.get(targetBottomPosition));
            }
            ftran.show(fragmentList.get(targetBottomPosition)).commit();
            currentBottomPosition = 2;
            mTl.setSelected(true);
//            mTl.setClipChildren(true);
            mTl.getTabAt(2).select();

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        mTl.addTab(mTl.newTab().setText("首页").setIcon(R.drawable.home));
        mTl.addTab(mTl.newTab().setText("分类").setIcon(R.drawable.classify));
        mTl.addTab(mTl.newTab().setText("订单").setIcon(R.drawable.indent));
        mTl.addTab(mTl.newTab().setText("我的").setIcon(R.drawable.mine));
        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        indentFragment = new IndentFragment();
        mineFragment = new MineFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(classifyFragment);
        fragmentList.add(indentFragment);
        fragmentList.add(mineFragment);


    }

    private void showFragment(int type) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        switch (type) {
            case 0:
                targetBottomPosition = 0;
                if (currentBottomPosition == 0) {
                    return;
                }
                fragmentTransaction.hide(fragmentList.get(currentBottomPosition));
                if (!fragmentList.get(targetBottomPosition).isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragmentList.get(targetBottomPosition));
                }
                fragmentTransaction.show(fragmentList.get(targetBottomPosition)).commit();
                currentBottomPosition = 0;
//                layoutSearch.setVisibility(View.VISIBLE);
                break;
            case 1:
                targetBottomPosition = 1;
                if (currentBottomPosition == 1) {
                    return;
                }
                fragmentTransaction.hide(fragmentList.get(currentBottomPosition));
                if (!fragmentList.get(targetBottomPosition).isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragmentList.get(targetBottomPosition));
                }
                fragmentTransaction.show(fragmentList.get(targetBottomPosition)).commit();
                currentBottomPosition = 1;
//                layoutSearch.setVisibility(View.VISIBLE);
                break;
            case 2:
                targetBottomPosition = 2;
                if (currentBottomPosition == 2) {
                    return;
                }
                fragmentTransaction.hide(fragmentList.get(currentBottomPosition));
                if (!fragmentList.get(targetBottomPosition).isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragmentList.get(targetBottomPosition));
                }
                fragmentTransaction.show(fragmentList.get(targetBottomPosition)).commit();
                currentBottomPosition = 2;
//                layoutSearch.setVisibility(View.GONE);
                break;
            case 3:
                targetBottomPosition = 3;
                if (currentBottomPosition == 3) {
                    return;
                }
                fragmentTransaction.hide(fragmentList.get(currentBottomPosition));
                if (!fragmentList.get(targetBottomPosition).isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragmentList.get(targetBottomPosition));
                }
                fragmentTransaction.show(fragmentList.get(targetBottomPosition)).commit();
                currentBottomPosition = 3;
//                layoutSearch.setVisibility(View.GONE);
                break;
        }
    }

}
