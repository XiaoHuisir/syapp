package com.example.shiyuankeji.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.FragmentApader;
import com.example.shiyuankeji.base.BaseFragment;
import com.example.shiyuankeji.bean.ClassBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.ClassifyContract;
import com.example.shiyuankeji.presenter.ClassifyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//toCateIndex
public class ClassifyFragment extends BaseFragment implements ClassifyContract.View {
    @BindView(R.id.tab_classfy)
    TabLayout tabClassfy;
    @BindView(R.id.vp_classfy)
    ViewPager vpClassfy;

    ArrayList<String> strlist = new ArrayList<>(); //tab

    List<Fragment> mFragmentList = new ArrayList<>();

    List<String> mList = new ArrayList<>();
    private String name;
    private List<ClassBean.CateListBean> cateList;

    @Override
    protected IBasePresenter getPresenter() {
        return new ClassifyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.classify_fragment;
    }

    @Override
    protected void initView() {

    }





    @Override
    protected void initData() {
        ((ClassifyPresenter) mPresenter).classify();

    }

    @Override
    public void classifyReturn(ClassBean result) {
        if (result != null) {
            Toast.makeText(context, "成功", Toast.LENGTH_SHORT).show();
//            //TODO ??
            cateList = result.getCateList();

            for (int i = 0; i < cateList.size(); i++) {
                String name = cateList.get(i).getName();
                strlist.add(name);
            }
            for (int i = 0; i < cateList.size(); i++) {
                int cateid = cateList.get(i).getCateid();
//                tabClassfy.addTab(tabClassfy.newTab().setText(cateList.get(i).getName()).setTag(i));

                ShowClassfyFragment showClassfyFragment = new ShowClassfyFragment(cateid);
                mFragmentList.add(showClassfyFragment);
            }
            //getChildFragmentManager()
            FragmentApader apader =
                    new FragmentApader(getFragmentManager(), mFragmentList, strlist);
            vpClassfy.setAdapter(apader);
            tabClassfy.setupWithViewPager(vpClassfy);
        } else {
            Toast.makeText(context, "失败", Toast.LENGTH_SHORT).show();
        }
    }


    //List
//    @Override
//    public void classListReturn(ClassListBean result) {
//        if (result != null) {
//            List<ClassListBean.ItemsListBean> itemsList = result.getItemsList();
//
//        }
//    }
}
