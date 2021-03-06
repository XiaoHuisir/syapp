package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.SubmitListAdapter;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.SubmitListBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.SubmitListContract;
import com.example.shiyuankeji.presenter.SubmitListPresenter;
import com.example.shiyuankeji.utils.NoDoubleClickListener;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.utils.UtilsClicktime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//toUser_AddressIndex?user_name=sf003
public class SelectAddressActivity extends BaseActivity implements SubmitListContract.View, SubmitListAdapter.AddressItemClick, SubmitListAdapter.Submit0rdersItemClick {

    @BindView(R.id.tv_add_site)
    TextView tvAddSite;
    @BindView(R.id.im_break_select)
    ImageView imBreakSelect;
    @BindView(R.id.re_submitList)
    RecyclerView reSubmitList;
    @BindView(R.id.recyclerefresh)
    SwipeRefreshLayout recycleRefresh;
    @BindView(R.id.re_no_data)
    RelativeLayout reNoData;
    @BindView(R.id.re_okdata)
    RelativeLayout reOkData;
    @BindView(R.id.text_add_dizhi)
    TextView textAddDiZhi;
    private ArrayList<SubmitListBean.UserAddressLIstBean> list;
    private SubmitListAdapter submitListAdapter;
    private int typeid_;
    private int num_;
    private String mines = "";


    @Override
    protected IBasePresenter getPresenter() {
        return new SubmitListPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_selectaddress;
    }

    @Override
    protected void initView() {
//        if (Constant.IS_MINE_IS=true) {
//            //用于判断是个人中心（收货地址）跳转至此
//            mines  = getIntent().getStringExtra("mine_");
//        }
        typeid_ = getIntent().getIntExtra("typeid_", 0);
        num_ = getIntent().getIntExtra("num_", 0);
        reSubmitList.setHasFixedSize(true);
        reSubmitList.setNestedScrollingEnabled(false);
        list = new ArrayList<>();
        reSubmitList.setLayoutManager(new LinearLayoutManager(context));//管理器
        submitListAdapter = new SubmitListAdapter(list);
        submitListAdapter.itemClick = this;
        submitListAdapter.submitordersClick = this;

        reSubmitList.setAdapter(submitListAdapter);
        shuaxin();

    }

    private void shuaxin() {
        //刷新
        recycleRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((SubmitListPresenter) mPresenter).submitList(typeid_, num_);

                recycleRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (recycleRefresh != null) {
                            recycleRefresh.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });
    }

    @OnClick({R.id.tv_add_site, R.id.im_break_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.btn_exchang:
//                Intent intent1 = new Intent(context, Submit0rdersActivity.class);
//                startActivity(intent1);
//                finish();
//                break;
            case R.id.tv_add_site:
                if (UtilsClicktime.isFastDoubleClick()) {
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(context, AddressMessage.class);
                Constant.CURTYPE = "添加";
                intent.putExtra("id_s", typeid_);
                intent.putExtra("nu_m", num_);
//                intent.putExtra("is_mine_is", Constant.IS_MINE_IS);
//                Constant.IS_MINE_IS=true;
                startActivity(intent);
                finish();
                break;
            case R.id.im_break_select:
                finish();
                break;
        }
    }

    @Override
    public void submitlistReane(SubmitListBean submitListBean) {
        List<SubmitListBean.UserAddressLIstBean> user_addressLIst = submitListBean.getUser_addressLIst();
        if (user_addressLIst != null && user_addressLIst.size() > 0) {
            reNoData.setVisibility(View.GONE);
            reOkData.setVisibility(View.VISIBLE);
            list.clear();
            list.addAll(user_addressLIst);
            submitListAdapter.notifyDataSetChanged();
        } else {
            reNoData.setVisibility(View.VISIBLE);
            reOkData.setVisibility(View.GONE);
            Toast.makeText(context, R.string.new_site_string, Toast.LENGTH_SHORT).show();
//            ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请添加新地址！");
//            toastUtil2.show();
            textAddDiZhi.setOnClickListener(new NoDoubleClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(context, AddressMessage.class);
                    Constant.CURTYPE = "添加";
                    intent.putExtra("id_s", typeid_);
                    intent.putExtra("nu_m", num_);
//                intent.putExtra("is_mine_is", Constant.IS_MINE_IS);
//                Constant.IS_MINE_IS=true;
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    @Override
    protected void initData() {
        ((SubmitListPresenter) mPresenter).submitList(typeid_, num_);
    }


    //submitlistadapter AddressMessage 回调方法（回调订单提交页）
    @Override
    public void addressclick(SubmitListBean.UserAddressLIstBean listSubmit) {

        int is_default = listSubmit.getIs_default();
        Intent intent = new Intent();
        intent.setClass(context, AddressMessage.class);
        intent.putExtra("add_ress", listSubmit.getAddress());
        intent.putExtra("names", listSubmit.getName());
        intent.putExtra("id_dizhi", listSubmit.getId());
        intent.putExtra("is_defaults", is_default); //判断是否设置成默认收货地址
        intent.putExtra("phone", listSubmit.getPhone());
        intent.putExtra("id_s", typeid_);
        intent.putExtra("nu_m", num_);
//        intent.putExtra("is_mine_is", Constant.IS_MINE_IS);
        Constant.CURTYPE = "编辑";
        startActivity(intent);
        finish();

    }

    //submitlistadapter Submit0rders 回调方法
    @Override
    public void Submit0rdersclick(SubmitListBean.UserAddressLIstBean listSubmit) {
        if (Constant.IS_MINE == false) {
            SharedPreferencesUtil.setDeliveryAddress(context, true); //保存有、无 地址状态
//            Toast.makeText(context,"-----------",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(context, Submit0rdersActivity.class);
            intent.putExtra("getaddress", listSubmit.getAddress());
            intent.putExtra("getname", listSubmit.getName());
            intent.putExtra("getphone", listSubmit.getPhone());
            intent.putExtra("indx_0", 100);
            intent.putExtra("type_id", typeid_);
            intent.putExtra("onid", String.valueOf(listSubmit.getId()));
            Constant.INXDLER = true;
            intent.putExtra("num", num_);
            startActivity(intent);
            finish();
        } else {
////            Toast.makeText(context, "个人中心", Toast.LENGTH_LONG).show();
//            ToastUtil toastUtil2 = new ToastUtil(context, R.layout.putong_toast_center_horizontal, "个人中心！");
//            toastUtil2.show();
        }
    }
}
