package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.bean.BankBean;
import com.example.project.bean.IdentityBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.BankIdentityContract;
import com.example.project.presenter.BankIdentityPresenter;
import com.example.project.utils.IDCard;

import java.text.ParseException;

import butterknife.BindView;

import butterknife.OnClick;

//http://192.168.124.14:8080/update_identity  //身份证号
//http://192.168.124.14:8080/update_bank   //银行卡号
public class ClickOnAddActivity extends BaseActivity implements BankIdentityContract.View {
    @BindView(R.id.im_break)
    ImageView imBreak;
    @BindView(R.id.txt_tlite)
    TextView txtTlite;
    @BindView(R.id.text_update)
    TextView textUpdate;
    @BindView(R.id.ed_IDnumber)
    EditText edIDnumber;
    @BindView(R.id.relative_IDnumber)
    RelativeLayout relativeIDnumber;
    @BindView(R.id.ed_account_name)
    EditText edAccountName;
    @BindView(R.id.ed_credit_card_numbers)
    EditText edCreditCardNumbers;
    @BindView(R.id.ed_deposit_bank)
    EditText edDepositBank;
    @BindView(R.id.linear_bank_card)
    LinearLayout linearBankCard;
    @BindView(R.id.linear_save)
    LinearLayout linearSave;
    private int type;
    public String returnValue = "";
    private String identityNum;
    private String bank_nums_;
    private String bank_names_;
    private String bank_addres_;

    @Override
    protected IBasePresenter getPresenter() {
        return new BankIdentityPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_clickonadd;
    }

    @Override
    protected void initView() {
        //初始化
        oneditable();
        linearSave.setVisibility(View.GONE);
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 0);
        //身份证号
        identityNum = intent.getStringExtra("identityNum_");
        //银行卡号
        bank_nums_ = intent.getStringExtra("bank_nums_");
        //开户名
        bank_names_ = intent.getStringExtra("bank_names_");
        //开户地址
        bank_addres_ = intent.getStringExtra("bank_addres_");
        if (type == 10) {
            txtTlite.setText("身份证号");
            linearBankCard.setVisibility(View.GONE);
            edIDnumber.setText(identityNum);
        }
        if (type == 20) {
            txtTlite.setText("银行信息");
            relativeIDnumber.setVisibility(View.GONE);
            edAccountName.setText(bank_names_);
            edCreditCardNumbers.setText(bank_nums_);
            edDepositBank.setText(bank_addres_);
        }

    }

    @Override
    protected void initData() {


    }

    @OnClick({R.id.im_break, R.id.linear_save, R.id.text_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_break:
                saves();
                finish();
                break;
            case R.id.linear_save: //保存
                linearSave.setVisibility(View.GONE);
                textUpdate.setVisibility(View.VISIBLE);
                oneditable();
                saves();
                break;
            case R.id.text_update: //修改
                linearSave.setVisibility(View.VISIBLE);
                textUpdate.setVisibility(View.GONE);
                editable();
                break;
        }
    }

    private void oneditable() {
        edIDnumber.setFocusable(false);
        edIDnumber.setFocusableInTouchMode(false);
        edAccountName.setFocusable(false);
        edAccountName.setFocusableInTouchMode(false);
        edCreditCardNumbers.setFocusable(false);
        edCreditCardNumbers.setFocusableInTouchMode(false);
        edDepositBank.setFocusable(false);
        edDepositBank.setFocusableInTouchMode(false);
    }

    private void editable() {
        edIDnumber.setFocusable(true);
        edIDnumber.setFocusableInTouchMode(true);
        edAccountName.setFocusable(true);
        edAccountName.setFocusableInTouchMode(true);
        edCreditCardNumbers.setFocusable(true);
        edCreditCardNumbers.setFocusableInTouchMode(true);
        edDepositBank.setFocusable(true);
        edDepositBank.setFocusableInTouchMode(true);
    }

    private void saves() {
        if (type == 10) {  //身份证号
            returnValue = edIDnumber.getText().toString();
            try {
                String s = IDCard.IDCardValidate(returnValue);  //验证身份证号 (工具类：IDCard)
                if (s.equals("")) {
                    Toast.makeText(context, "保存成功！" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.putExtra("value", returnValue);
                    setResult(type, intent);
                    ((BankIdentityPresenter) mPresenter).identitys(returnValue);
                } else {
                    linearSave.setVisibility(View.VISIBLE);
                    textUpdate.setVisibility(View.GONE);
                    editable();
                    Toast.makeText(context, "保存失败：" + s, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.putExtra("value", identityNum);
                    setResult(type, intent);

                }
//

            } catch (ParseException e) {
                e.printStackTrace();

            }


        }
        if (type == 20) {  //银行卡号
//                 edAccountName.setText(bank_names_);
//            edCreditCardNumbers.setText(bank_nums_);
//            edDepositBank.setText(bank_addres_);
            String names = edAccountName.getText().toString();
            String nums = edCreditCardNumbers.getText().toString();
            String adds = edDepositBank.getText().toString();
        if (!TextUtils.isEmpty(names)&&!TextUtils.isEmpty(nums)&&!TextUtils.isEmpty(adds)){
            boolean b = IDCard.checkBankCard(nums);  //验证银行卡号
            if (b==true){
                Toast.makeText(context,"保存成功！",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("names_", names);
                intent.putExtra("nums_", nums);
                intent.putExtra("adds_", adds);
                setResult(type, intent);
                ((BankIdentityPresenter) mPresenter).banks(names, nums, adds);
            }else {
                Toast.makeText(context,"保存失败！",Toast.LENGTH_SHORT).show();
//                 //银行卡号
//        bank_nums_ = intent.getStringExtra("bank_nums_");
//        //开户名
//        bank_names_ = intent.getStringExtra("bank_names_");
//        //开户地址
//        bank_addres_ = intent.getStringExtra("bank_addres_");
                linearSave.setVisibility(View.VISIBLE);
                textUpdate.setVisibility(View.GONE);
                editable();
                Intent intent = new Intent();
                intent.putExtra("names_", bank_names_);
                intent.putExtra("nums_", bank_nums_);
                intent.putExtra("adds_", bank_addres_);
                setResult(type, intent);
            }
        }else {
            linearSave.setVisibility(View.VISIBLE);
            textUpdate.setVisibility(View.GONE);
            editable();
            Toast.makeText(context,"信息不能为空",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra("names_", bank_names_);
            intent.putExtra("nums_", bank_nums_);
            intent.putExtra("adds_", bank_addres_);
            setResult(type, intent);
        }


        }

    }

    @Override
    public void identityRrean(IdentityBean identityBean) {
        if (identityBean != null) {
            String identity_num = identityBean.getIdentity_num();
            String bank_name = identityBean.getBank_name();
        }
    }

    @Override
    public void BankRrean(BankBean bankBean) {
        String bank_address = bankBean.getBank_address();
        String bank_name = bankBean.getBank_name();
        String bank_num = bankBean.getBank_num();

    }
}