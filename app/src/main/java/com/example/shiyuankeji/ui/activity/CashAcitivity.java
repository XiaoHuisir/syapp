package com.example.shiyuankeji.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.utils.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.OnClick;

public class CashAcitivity extends BaseActivity {
    @BindView(R.id.im_wbeak)
    ImageView imWbeak;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.btn_cash)
    LinearLayout btnCash;
    @BindView(R.id.re_cash_detail)
    RecyclerView reCashDetail;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cash;
    }

    @Override
    protected void initView() {

    }


    @OnClick({R.id.im_wbeak, R.id.btn_cash})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_wbeak:
                finish();
                break;
            case R.id.btn_cash:

                money();
                break;
        }
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
                if (edjie.equals("")){
                    Toast.makeText(context,R.string.cash_import_money_string,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edjie.equals("0")){
                    Toast.makeText(context,R.string.cash_import_money_ok_string,Toast.LENGTH_SHORT).show();
                    return;
                }
                    alertDialog.dismiss();
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
        tvno.setOnClickListener(new NoDoubleClickListener() { //取消
            @Override
            protected void onNoDoubleClick(View v) {
                alertDialog.dismiss();
            }
        });
        tvok.setOnClickListener(new NoDoubleClickListener() { //确定
            @Override
            protected void onNoDoubleClick(View v) {
                alertDialog.dismiss();
            }
        });

    }
}
