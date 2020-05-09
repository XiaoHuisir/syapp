package com.example.project.ui.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.adapter.QueryLastWeekStockAdatper;
import com.example.project.adapter.QueryMinuteStockAdapter;
import com.example.project.adapter.QueryStockAdapter;
import com.example.project.adapter.QueryintegralAdapter;
import com.example.project.base.BaseActivity;
import com.example.project.bean.QueryIntegralBean;
import com.example.project.bean.QueryLastWeekStockBean;
import com.example.project.bean.QueryMinuteStockBean;
import com.example.project.bean.QueryStockBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.IntegralDetailsContract;
import com.example.project.presenter.IntegraIBetailsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


//根据用户名查询购物积分明细: http://192.168.124.14:8080/queryIntegral
//
//根据用户名查询识缘股明细: http://192.168.124.14:8080/queryStock
//
//根据用户名查询分红识缘股明细: http://192.168.124.14:8080/queryMinuteStock
//
//根据用户名查询赠送积分: http://192.168.124.14:8080/queryLastWeekStock
public class DetailsActivity extends BaseActivity implements IntegralDetailsContract.View {


    @BindView(R.id.im_wbeak)
    ImageView imWbeak;
    @BindView(R.id.tv_tilte)
    TextView tvTilte;
    @BindView(R.id.lin_wbeak)
    LinearLayout linWbeak;
    @BindView(R.id.tv_tilte_name)
    TextView tvTilteName;
    @BindView(R.id.re_queryIntegral)
    RecyclerView reQueryIntegral;
    @BindView(R.id.re_queryStock)
    RecyclerView reQueryStock;
    @BindView(R.id.re_queryMinuteStock)
    RecyclerView reQueryMinuteStock;
    @BindView(R.id.re_queryLastWeekStock)
    RecyclerView reQueryLastWeekStock;
    private String jifen;
    private QueryintegralAdapter queryintegralAdapter;
    private QueryLastWeekStockAdatper queryLastWeekStockAdatper;
    private QueryStockAdapter queryStockAdapter;
    private QueryMinuteStockAdapter queryMinuteStockadapter;
    public ArrayList<QueryIntegralBean.UserAddLogListBean>  list_queryIntegral=new ArrayList<>();
    public ArrayList<QueryStockBean.UserAddLogListBean>  list_queryStock=new ArrayList<>();
    public ArrayList<QueryMinuteStockBean.UserAddLogListBean>  list_queryMinuteStock=new ArrayList<>();
    public ArrayList<QueryLastWeekStockBean.UserAddLogListBean>  list_queryLastWeekStock=new ArrayList<>();

    @Override
    protected IBasePresenter getPresenter() {
        return new IntegraIBetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
//        jifen
        reQueryIntegral.setHasFixedSize(true);
        reQueryIntegral.setNestedScrollingEnabled(false);
        reQueryLastWeekStock.setHasFixedSize(true);
        reQueryLastWeekStock.setNestedScrollingEnabled(false);
        reQueryStock.setHasFixedSize(true);
        reQueryStock.setNestedScrollingEnabled(false);
        reQueryMinuteStock.setHasFixedSize(true);
        reQueryMinuteStock.setNestedScrollingEnabled(false);
        jifen = getIntent().getStringExtra("jifen");
        String score = getIntent().getStringExtra("score_");
        String score4 = getIntent().getStringExtra("score4_");
        String score2 = getIntent().getStringExtra("score2_");
        String score3_1 = getIntent().getStringExtra("score3_1_");
        if (jifen.equals("购物积分")) {
            tvTilte.setText("购物积分");
            tvTilteName.setText("购物积分:" + score);
            reQueryIntegral.setVisibility(View.VISIBLE);
            reQueryIntegral.setLayoutManager(new LinearLayoutManager(context));
            queryintegralAdapter = new QueryintegralAdapter(list_queryIntegral);
            reQueryIntegral.setAdapter(queryintegralAdapter);
        } else if (jifen.equals("赠送积分")) {
            tvTilte.setText("赠送积分");
            tvTilteName.setText("购物积分:" + score4);
            reQueryLastWeekStock.setVisibility(View.VISIBLE);
            reQueryLastWeekStock.setLayoutManager(new LinearLayoutManager(context));
            queryLastWeekStockAdatper = new QueryLastWeekStockAdatper(list_queryLastWeekStock);
            reQueryLastWeekStock.setAdapter(queryLastWeekStockAdatper);
        } else if (jifen.equals("识缘股")) {
            tvTilte.setText("识缘股");
            tvTilteName.setText("识缘股:" + score2);
            reQueryStock.setVisibility(View.VISIBLE);
            reQueryStock.setLayoutManager(new LinearLayoutManager(context));
            queryStockAdapter = new QueryStockAdapter(list_queryStock);
            reQueryStock.setAdapter(queryStockAdapter);
        } else if (jifen.equals("周分红")) {
            tvTilte.setText("周分红");
            tvTilteName.setText("周分红:" + score3_1);
            reQueryMinuteStock.setVisibility(View.VISIBLE);
            reQueryMinuteStock.setLayoutManager(new LinearLayoutManager(context));
            queryMinuteStockadapter = new QueryMinuteStockAdapter(list_queryMinuteStock);
            reQueryMinuteStock.setAdapter(queryMinuteStockadapter);
        }
    }

    @Override
    protected void initData() {
        if (jifen.equals("购物积分")) {
            ((IntegraIBetailsPresenter) mPresenter).queryIntegrals();
        } else if (jifen.equals("赠送积分")) {
            ((IntegraIBetailsPresenter) mPresenter).queryLastWeekStocks();
        } else if (jifen.equals("识缘股")) {
            ((IntegraIBetailsPresenter) mPresenter).queryStocks();
        } else if (jifen.equals("周分红")) {
            ((IntegraIBetailsPresenter) mPresenter).queryMinuteStocks();
        }
    }

    @OnClick({R.id.lin_wbeak})
    public void onViewClicked() {
        finish();
    }

    @Override
    public void queryIntegralRrean(QueryIntegralBean queryIntegralBean) { //购物积分
        List<QueryIntegralBean.UserAddLogListBean> user_add_logList = queryIntegralBean.getUser_add_logList();
        list_queryIntegral.clear();
        list_queryIntegral.addAll(user_add_logList);
        queryintegralAdapter.notifyDataSetChanged();
    }

    @Override
    public void queryStockRrean(QueryStockBean queryStockBean) { //识缘股
        List<QueryStockBean.UserAddLogListBean> user_add_logList = queryStockBean.getUser_add_logList();
        list_queryStock.clear();
        list_queryStock.addAll(user_add_logList);
        queryStockAdapter.notifyDataSetChanged();
    }

    @Override
    public void queryMinuteStockRrean(QueryMinuteStockBean queryMinuteStockBean) { //周分红
        List<QueryMinuteStockBean.UserAddLogListBean> user_add_logList = queryMinuteStockBean.getUser_add_logList();
        list_queryMinuteStock.clear();
        list_queryMinuteStock.addAll(user_add_logList);
        queryMinuteStockadapter.notifyDataSetChanged();


    }

    @Override
    public void queryLastWeekStockRrean(QueryLastWeekStockBean queryLastWeekStockBean) { //赠送积分
        List<QueryLastWeekStockBean.UserAddLogListBean> user_add_logList = queryLastWeekStockBean.getUser_add_logList();
        list_queryLastWeekStock.clear();
        list_queryLastWeekStock.addAll(user_add_logList);
        queryLastWeekStockAdatper.notifyDataSetChanged();
    }

//    @OnClick({R.id.lin_wbeak, R.id.lin_WD, R.id.tv_record})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.lin_wbeak:
//                finish();
//                break;
//            case R.id.lin_WD:  //提现
//                startActivity(new Intent(context, ShopWBActivity.class));
//                finish();
//                break;
//            case R.id.tv_record: //提现记录
//                startActivity(new Intent(context, RecordListActivity.class));
//                finish();
//                break;
//        }
//    }
}
