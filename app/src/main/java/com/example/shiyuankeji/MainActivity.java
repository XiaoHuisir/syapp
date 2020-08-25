package com.example.shiyuankeji;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

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

                //设置字体颜色
                changeTabSelect(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                changeTabNormal(tab);
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
    // Tab自定义view
    public View getTabView(String title, int image_src) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_item_view, null);
        TextView textView = (TextView) v.findViewById(R.id.textview);
        textView.setText(title);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageview);
        imageView.setImageResource(image_src);
        return v;
    }
    private void initFragment() {
        manager = getSupportFragmentManager();
        mTl.addTab(mTl.newTab().setText("首页").setIcon(R.drawable.home));
        mTl.addTab(mTl.newTab().setText("分类").setIcon(R.drawable.classify));
        mTl.addTab(mTl.newTab().setText("订单").setIcon(R.drawable.indent));
        mTl.addTab(mTl.newTab().setText("我的").setIcon(R.drawable.mine));
// 修改样式，主要是调近了图标与文字之间的距离
        mTl.getTabAt(0).setCustomView(getTabView("首页",R.drawable.home));
        mTl.getTabAt(1).setCustomView(getTabView("分类",R.drawable.classify));
        mTl.getTabAt(2).setCustomView(getTabView("订单",R.drawable.indent));
        mTl.getTabAt(3).setCustomView(getTabView("我的",R.drawable.mine));

        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        indentFragment = new IndentFragment();
        mineFragment = new MineFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(classifyFragment);
        fragmentList.add(indentFragment);
        fragmentList.add(mineFragment);


    }
    // 切换颜色
    private void changeTabSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        ImageView img_title = (ImageView) view.findViewById(R.id.imageview);
        TextView txt_title = (TextView) view.findViewById(R.id.textview);
        txt_title.setTextColor(getResources().getColor(R.color.tabbg));
        if (txt_title.getText().toString().equals("首页")) {

            img_title.setImageResource(R.drawable.home);
        } else if (txt_title.getText().toString().equals("分类")) {
            img_title.setImageResource(R.drawable.classify);
        }  else if (txt_title.getText().toString().equals("订单")) {
            img_title.setImageResource(R.drawable.indent);
        }  else if (txt_title.getText().toString().equals("我的")) {
            img_title.setImageResource(R.drawable.mine);
        }
    }
    private void changeTabNormal(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        ImageView img_title = (ImageView) view.findViewById(R.id.imageview);
        TextView txt_title = (TextView) view.findViewById(R.id.textview);
        txt_title.setTextColor(getResources().getColor(R.color.tabhei));
        if (txt_title.getText().toString().equals("首页")) {
            img_title.setImageResource(R.drawable.home);
        } else if (txt_title.getText().toString().equals("分类")) {
            img_title.setImageResource(R.drawable.classify);
        }  else if (txt_title.getText().toString().equals("订单")) {
            img_title.setImageResource(R.drawable.indent);
        }  else if (txt_title.getText().toString().equals("我的")) {
            img_title.setImageResource(R.drawable.mine);
        }
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
    /**
     * 连续按两次返回键，退出应用
     */
    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        doubleBackQuit();
    }

    private void doubleBackQuit() {

        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
