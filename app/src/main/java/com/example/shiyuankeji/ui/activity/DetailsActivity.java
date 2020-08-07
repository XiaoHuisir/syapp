package com.example.shiyuankeji.ui.activity;


import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.QueryLastWeekStockAdatper;
import com.example.shiyuankeji.adapter.QueryMinuteStockAdapter;
import com.example.shiyuankeji.adapter.QueryStockAdapter;
import com.example.shiyuankeji.adapter.QueryintegralAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.CashBean;
import com.example.shiyuankeji.bean.QueryIntegralBean;
import com.example.shiyuankeji.bean.QueryLastWeekStockBean;
import com.example.shiyuankeji.bean.QueryMinuteStockBean;
import com.example.shiyuankeji.bean.QueryStockBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.IntegralDetailsContract;
import com.example.shiyuankeji.presenter.HomePresenter;
import com.example.shiyuankeji.presenter.IntegraIBetailsPresenter;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

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

    @BindView(R.id.btn_cash)
    LinearLayout btnCash;
    @BindView(R.id.im_wbeak)
    ImageView imWbeak;
    @BindView(R.id.tv_tilte)
    TextView tvTilte;
    @BindView(R.id.lin_wbeak)
    RelativeLayout linWbeak;
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
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefres;
    @BindView(R.id.scrView)
    ScrollView scrView;
    private String jifen;
    private QueryintegralAdapter queryintegralAdapter;
    private QueryLastWeekStockAdatper queryLastWeekStockAdatper;
    private QueryStockAdapter queryStockAdapter;
    private QueryMinuteStockAdapter queryMinuteStockadapter;
    public ArrayList<QueryIntegralBean.UserAddLogListBean> list_queryIntegral = new ArrayList<>();
    public ArrayList<QueryStockBean.UserAddLogListBean> list_queryStock = new ArrayList<>();
    public ArrayList<QueryMinuteStockBean.UserAddLogListBean> list_queryMinuteStock = new ArrayList<>();
    public ArrayList<QueryLastWeekStockBean.UserAddLogListBean> list_queryLastWeekStock = new ArrayList<>();

    private String jine = "";

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
            tvTilte.setText(R.string.details_shopping_points_string);
            tvTilteName.setText("购物积分:" + score);
            reQueryIntegral.setVisibility(View.VISIBLE);
            reQueryIntegral.setLayoutManager(new LinearLayoutManager(context));
            queryintegralAdapter = new QueryintegralAdapter(list_queryIntegral);
            reQueryIntegral.setAdapter(queryintegralAdapter);
        } else if (jifen.equals("识缘股")) {
            tvTilte.setText(R.string.details_stock_string);
            tvTilteName.setText("识缘股:" + score4);
            reQueryLastWeekStock.setVisibility(View.VISIBLE);
            reQueryLastWeekStock.setLayoutManager(new LinearLayoutManager(context));
            queryLastWeekStockAdatper = new QueryLastWeekStockAdatper(list_queryLastWeekStock);
            reQueryLastWeekStock.setAdapter(queryLastWeekStockAdatper);
        } else if (jifen.equals("赠送积分")) {
            tvTilte.setText(R.string.details_heavy_away_string);
            tvTilteName.setText("重消积分:" + score2);
            reQueryStock.setVisibility(View.VISIBLE);
            reQueryStock.setLayoutManager(new LinearLayoutManager(context));
            queryStockAdapter = new QueryStockAdapter(list_queryStock);
            reQueryStock.setAdapter(queryStockAdapter);
        } else if (jifen.equals("收益积分")) {
            btnCash.setVisibility(View.VISIBLE);
            tvTilte.setText(R.string.details_earnings_string);
            tvTilteName.setText("收益积分:" + score3_1);
            reQueryMinuteStock.setVisibility(View.VISIBLE);
            reQueryMinuteStock.setLayoutManager(new LinearLayoutManager(context));
            queryMinuteStockadapter = new QueryMinuteStockAdapter(list_queryMinuteStock);
            reQueryMinuteStock.setAdapter(queryMinuteStockadapter);

            initFindViewById(); //提现
        }
        newshuxin(jifen);
    }

    private void newshuxin(final String jifen) {
        //设置刷新球颜色
        swipeRefres.setColorSchemeColors(Color.BLUE, Color.RED, Color.YELLOW);
        swipeRefres.setProgressBackgroundColorSchemeColor(Color.parseColor("#ffffff"));//#BBFFFF
        ViewTreeObserver obeser = swipeRefres.getViewTreeObserver();
        obeser.addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                swipeRefres.setRefreshing(true);
//                Toast.makeText(context, "刷新", Toast.LENGTH_SHORT).show();
                if (jifen.equals("购物积分")) {
                    ((IntegraIBetailsPresenter) mPresenter).queryIntegrals();
                }else if (jifen.equals("赠送积分")) {
                    ((IntegraIBetailsPresenter) mPresenter).queryStocks();
                }else if (jifen.equals("收益积分")) {

                ((IntegraIBetailsPresenter) mPresenter).queryMinuteStocks();
                }

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
                if (jifen.equals("购物积分")) {
                    ((IntegraIBetailsPresenter) mPresenter).queryIntegrals();
                }else if (jifen.equals("赠送积分")) {
                    ((IntegraIBetailsPresenter) mPresenter).queryStocks();
                }else if (jifen.equals("收益积分")) {
                    ((IntegraIBetailsPresenter) mPresenter).queryMinuteStocks();
                }

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

    private void initFindViewById() {
        btnCash.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                money();
            }
        });
    }

    private void money() {
        LayoutInflater inflater = getLayoutInflater();
        //引入自定义好的对话框.xml布局
        View layout = inflater.inflate(R.layout.money_layout, null);
        //实列提示对话框对象，并将加载的试图对象设置给对话框对象
        final AlertDialog alertDialog = new AlertDialog.Builder(this).setView(layout).show();
        final TextView tvTilte = alertDialog.findViewById(R.id.tv_tilte);
        final EditText edEdu = alertDialog.findViewById(R.id.ed_edu);//金额
        final LinearLayout btnCash = alertDialog.findViewById(R.id.btn_cash);//立即提现
        final LinearLayout imBack = alertDialog.findViewById(R.id.im_back);//关闭
        tvTilte.setText(R.string.cash_withdrawal_amount_string);
        imBack.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                alertDialog.dismiss();
            }
        });
        btnCash.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                String edjie = edEdu.getText().toString();

                if (edjie.equals("")) {
                    Toast.makeText(context, R.string.cash_import_money_string, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edjie.equals("0")) {
                    Toast.makeText(context, R.string.cash_import_money_ok_string, Toast.LENGTH_SHORT).show();
                    return;
                }
                alertDialog.dismiss();
                jine = edjie;
                qian();
            }
        });

    }

    private void qian() {
        LayoutInflater inflater = getLayoutInflater();
        //引入自定义好的对话框.xml布局
        View layout = inflater.inflate(R.layout.money_state, null);
        //实列提示对话框对象，并将加载的试图对象设置给对话框对象
        final AlertDialog alertDialog = new AlertDialog.Builder(context).setView(layout).show();
        TextView tvok = alertDialog.findViewById(R.id.tv_ok);
        TextView tvno = alertDialog.findViewById(R.id.tv_no);
        TextView txtqiang = alertDialog.findViewById(R.id.txt_qiang);
        int i = Integer.parseInt(jine);
        final int i1 = i * 100;
        txtqiang.setText("是否确认提现金额为：" + i1 + "元");
        tvno.setOnClickListener(new NoDoubleClickListener() { //取消
            @Override
            protected void onNoDoubleClick(View v) {
                alertDialog.dismiss();
            }
        });
        tvok.setOnClickListener(new NoDoubleClickListener() { //确定
            @Override
            protected void onNoDoubleClick(View v) {

                ((IntegraIBetailsPresenter) mPresenter).cashs(i1);

                alertDialog.dismiss();
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
                ((IntegraIBetailsPresenter) mPresenter).queryMinuteStocks();
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
                ((IntegraIBetailsPresenter) mPresenter).queryMinuteStocks();

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
    protected void initData() {
        if (jifen.equals("购物积分")) {
            ((IntegraIBetailsPresenter) mPresenter).queryIntegrals();
        } else if (jifen.equals("识缘股")) {
            ((IntegraIBetailsPresenter) mPresenter).queryLastWeekStocks();
        } else if (jifen.equals("赠送积分")) {
            ((IntegraIBetailsPresenter) mPresenter).queryStocks();
        } else if (jifen.equals("收益积分")) {
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
    public void queryMinuteStockRrean(QueryMinuteStockBean queryMinuteStockBean) { //周分红/现改为收益积分
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

    //提现返回值
    @Override
    public void cashRean(CashBean cashBean) {
        if (cashBean == null || cashBean.getData() == null) {
            return;
        }
        newrefres();//刷新
        Toast.makeText(context, cashBean.getMsg(), Toast.LENGTH_SHORT).show();
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
