package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.base.BaseActivity;
import com.example.project.bean.MineBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.MineContract;
import com.example.project.presenter.MinePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalCenterActivity extends BaseActivity implements MineContract.View {
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_names)
    TextView tvNames;
    @BindView(R.id.tv_phonenumber)
    TextView tvPhonenumber;
    @BindView(R.id.tv_IDnumber)
    TextView tvIDnumber;
    @BindView(R.id.tv_bank_card)
    TextView tvBankCard;
    @BindView(R.id.re_indent)
    RelativeLayout reIndent;
    @BindView(R.id.re_bank)
    RelativeLayout reBank;
    @BindView(R.id.image_2)
    ImageView image2;
    @BindView(R.id.image_1)
    ImageView image1;
    @BindView(R.id.text_bank)
    TextView textBank;
    @BindView(R.id.text_indent)
    TextView textIndent;
    @BindView(R.id.line_break)
    LinearLayout lineBreak;
    @BindView(R.id.tv_bank_address)
    TextView tv_bank_address;
    @BindView(R.id.tv_bank_name)
    TextView tv_bank_name;
    public static int ID_NUMBER = 10;
    public static int BANK_CARD = 20;
    public String ins = "";
    private String identityNum;
    private String bank_num;
    private String bank_address;
    private String bank_name;
   private String identity_numName="";
    @Override
    protected IBasePresenter getPresenter() {
        return new MinePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personalcenter;
    }

    @Override
    protected void initView() {
        //初始化
//        Intent intent = getIntent();
//        String user_name = intent.getStringExtra("user_name_");
//        String name = intent.getStringExtra("name_");
//        String phone_number = intent.getStringExtra("phone_number_");
////        String identity_num = intent.getStringExtra("identity_num_"); //银行卡号
//        tvUsername.setText(user_name);
//        tvNames.setText(name);
//        tvPhonenumber.setText(phone_number);
//        if (!identityNum.equals(ins)){
//            tvIDnumber.setVisibility(View.GONE);
//            textIndent.setText(identityNum);
//        }else {
//            tvIDnumber.setVisibility(View.VISIBLE);
//            reIndent.setVisibility(View.GONE);
//        }
    }

    @Override
    protected void initData() {
        ((MinePresenter) mPresenter).mines();
    }


    @OnClick({R.id.tv_IDnumber, R.id.tv_bank_card, R.id.re_indent, R.id.line_break,R.id.re_bank})
    public void onViewClicked(View view) {
        String indentnum = textIndent.getText().toString();
        String banknums = textBank.getText().toString();
        String banknames = tv_bank_name.getText().toString();
        String bankaddres = tv_bank_address.getText().toString();
        switch (view.getId()) {

            case R.id.line_break:
                finish();
                break;
            case R.id.tv_IDnumber: //身份证号（无）
                Intent intentIDnumber = new Intent();
                intentIDnumber.setClass(context, ClickOnAddActivity.class);
                intentIDnumber.putExtra("identityNum_", identity_numName);
                intentIDnumber.putExtra("type", ID_NUMBER);
                startActivityForResult(intentIDnumber, ID_NUMBER);

                break;
            case R.id.re_indent: //身份证号(有)
                Intent intentbankcard1 = new Intent();
                intentbankcard1.setClass(context, ClickOnAddActivity.class);
//                  identityNum = mineBean.getIdentity_num();//身份证号

                intentbankcard1.putExtra("identityNum_", identity_numName);
                intentbankcard1.putExtra("type", ID_NUMBER);
                startActivityForResult(intentbankcard1, ID_NUMBER);
                break;
            case R.id.tv_bank_card: //银行卡号(无)
                Intent bankcard = new Intent();
                bankcard.setClass(context, ClickOnAddActivity.class);
                bankcard.putExtra("bank_nums_", banknums);
                bankcard.putExtra("bank_names_", banknames);
                bankcard.putExtra("bank_addres_", bankaddres);
                bankcard.putExtra("type", BANK_CARD);
                startActivityForResult(bankcard, BANK_CARD);
                break;
            case R.id.re_bank://银行卡号(有)
                Intent bankcard2 = new Intent();
                bankcard2.setClass(context, ClickOnAddActivity.class);
                //            bank_num = mineBean.getBank_num();  // 银行卡号
//            bank_address = mineBean.getBank_address();     //开户地址
//            bank_name = mineBean.getBank_name();    //开户姓名
                bankcard2.putExtra("bank_nums_", banknums);
                bankcard2.putExtra("bank_names_", banknames);
                bankcard2.putExtra("bank_addres_", bankaddres);
                bankcard2.putExtra("type", BANK_CARD);
                startActivityForResult(bankcard2, BANK_CARD);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ID_NUMBER) {
            String idnumber = data.getStringExtra("value");
            if (!TextUtils.isEmpty(idnumber)) {
                String show_id = idnumber.substring(0, 3) + "********" + idnumber.substring(11);
                textIndent.setText(show_id);
                identity_numName=idnumber;
                tvIDnumber.setVisibility(View.GONE);
                reIndent.setVisibility(View.VISIBLE);

            }
        } else if (requestCode == BANK_CARD) {
//              intent.putExtra("names_", names);
//            intent.putExtra("nums_", nums);
//            intent.putExtra("adds_", adds);
            String names_ = data.getStringExtra("names_");
            String nums_ = data.getStringExtra("nums_");
            String adds_ = data.getStringExtra("adds_");
            textBank.setText(nums_);
            tv_bank_address.setText(adds_);
            tv_bank_name.setText(names_);
            tvBankCard.setVisibility(View.GONE);
            reBank.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void mineReand(MineBean mineBean) {
        if (mineBean != null) {
            tvUsername.setText(mineBean.getUser_name());
            tvNames.setText(mineBean.getName());
            tvPhonenumber.setText(mineBean.getPhone_number());
            identityNum = mineBean.getIdentity_num();//身份证号
            bank_num = mineBean.getBank_num();  // 银行卡号
            bank_address = mineBean.getBank_address();     //开户地址
            bank_name = mineBean.getBank_name();    //开户姓名

//初始化
            if (!identityNum.equals(ins)) {
                tvIDnumber.setVisibility(View.GONE);
                reIndent.setVisibility(View.VISIBLE);
                String show_id1 = identityNum.substring(0, 3) + "********" + identityNum.substring(11);
                textIndent.setText(show_id1);
                tv_bank_address.setText(bank_address);
                tv_bank_name.setText(bank_name);
                identity_numName=identityNum;
            } else {
                tvIDnumber.setVisibility(View.VISIBLE);
                reIndent.setVisibility(View.GONE);
            }
            if (!bank_num.equals(ins)) {
                tvBankCard.setVisibility(View.GONE);
                reBank.setVisibility(View.VISIBLE);
                textBank.setText(bank_num);
            } else {
                tvBankCard.setVisibility(View.VISIBLE);
                reBank.setVisibility(View.GONE);
            }
        }
    }
}
