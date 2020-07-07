package com.example.shiyuankeji.ui.fragment;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.ShowClassAdapter;
import com.example.shiyuankeji.base.BaseFragment;
import com.example.shiyuankeji.bean.ClassListBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.ClassListifyContract;
import com.example.shiyuankeji.presenter.ClassListifyPresenter;
import com.example.shiyuankeji.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class ShowClassfyFragment extends BaseFragment implements ClassListifyContract.View {

    @BindView(R.id.recycler_showclassfy)
    RecyclerView recyclerShowclassfy;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefr;


    private ArrayList<ClassListBean.ItemsListBean> list;
    private int type;
    private ShowClassAdapter showClassAdapter;

    public ShowClassfyFragment(int cateid) {
        super();
        this.type = cateid;
    }


    @Override
    protected IBasePresenter getPresenter() {
        return new ClassListifyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_showclass;
    }

    @Override
    protected void initView() {
//        initbun();

        initrecycler();
        //刷新
        swipeRefr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((ClassListifyPresenter) mPresenter).cifyList(type);

                swipeRefr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefr != null) {
                            swipeRefr.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
    }

    private void initrecycler() {
        recyclerShowclassfy.setHasFixedSize(true);
        recyclerShowclassfy.setNestedScrollingEnabled(false);
        recyclerShowclassfy.setLayoutManager(new GridLayoutManager(context, 2));
        list = new ArrayList<>();


        showClassAdapter = new ShowClassAdapter(context, list);
        recyclerShowclassfy.setAdapter(showClassAdapter);
    }


    @Override
    public void classListReturn(ClassListBean result) {
        if (result != null) {
            List<ClassListBean.ItemsListBean> itemsList = result.getItemsList();
            list.clear();
            list.addAll(itemsList);
            showClassAdapter.notifyDataSetChanged();
        } else {
            ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "分类列表请求失败！");
            toastUtil2.show();

        }
    }

    @Override
    protected void initData() {
        ((ClassListifyPresenter) mPresenter).cifyList(type);
    }
}
