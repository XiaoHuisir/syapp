package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.bean.SubmitBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.SubmitContract;
import com.example.project.presenter.SubmitPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//http://192.168.124.13:8080/toConfirmOrderList?user_name=sf003&idsa=2011
public class Submit0rdersActivity extends BaseActivity implements SubmitContract.View {


    @BindView(R.id.re_on)
    RelativeLayout reOn;
    @BindView(R.id.re_site_ok)
    RelativeLayout reSiteOk;
    @BindView(R.id.relative_on_)
    RelativeLayout relativeOn_;
    @BindView(R.id.btn_exchangOn)
    Button btnExchangOn;
    @BindView(R.id.im_1)
    ImageView im_;
    @BindView(R.id.tv_iphone_name)
    TextView tvIphoneName;
    @BindView(R.id.text_jifen)
    TextView textJifen;
    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.tv_num)
    TextView tvNum;
    //    @BindView(R.id.tv_order_num)
//    TextView tvOrderNum;
    @BindView(R.id.text_zhong)
    TextView textZong;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.text_dahao)
    TextView textDahao;
    @BindView(R.id.text_dizhi)
    TextView textDizhi;
    @BindView(R.id.tv_jifenOn)
    TextView tvJifenOn;
    private int typeid;
    private int add_price;
    private int num;


    @Override
    protected IBasePresenter getPresenter() {
        return new SubmitPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_submitorder;
    }


    //TODO
    @OnClick({R.id.re_site_ok, R.id.btn_exchangOn, R.id.relative_on_, R.id.re_on})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re_site_ok: //有 地址管理
                Intent intent = new Intent(context, SelectAddressActivity.class);
                startActivity(intent);

                break;
            case R.id.re_on: //无 地址管理
                Intent intent1 = new Intent(context, SelectAddressActivity.class);
                startActivity(intent1);

                break;
            case R.id.btn_exchangOn: //有 提交订单
                Intent intent2 = new Intent(context, CompleteOrderActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.relative_on_:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
//        type_id
        typeid = getIntent().getIntExtra("type_id", 0);
        add_price = getIntent().getIntExtra("add_price", 0);//交易价格
        num = getIntent().getIntExtra("num", 0);//交易数量


    }

    @Override
    protected void initData() {//typeid
        ((SubmitPresenter) mPresenter).submit("sf003", typeid);
    }


    @Override
    public void submitRetrun(SubmitBean submitBean) {
        Integer is_id = submitBean.getUser_address().getId();
        if (is_id != Constant.IS_ID) {
            reOn.setVisibility(View.GONE);
            Toast.makeText(context, "有地址", Toast.LENGTH_SHORT).show();
        } else {
            reSiteOk.setVisibility(View.GONE);
            Toast.makeText(context, "无地址", Toast.LENGTH_SHORT).show();
        }
//        items
        SubmitBean.ItemsBean items = submitBean.getItems();
        if (items != null) {
            String name = items.getName(); //产品名称
            int freight = items.getFreight();//运费
            String img = items.getImg(); //图
            int src_price = items.getPrice(); //产品价格
            Glide.with(context).load(img).into(im_);
            tvIphoneName.setText(name);
            textJifen.setText(src_price + "积分");
            tvFreight.setText(freight + "积分");
            tvNum.setText("X" + num);
            //add_price
            textZong.setText(src_price * num + "积分");//总价钱
            tvJifenOn.setText(src_price * num + "积分");
        }
        SubmitBean.UserAddressBean user_address = submitBean.getUser_address();
        if (user_address != null) {
            String name = user_address.getName();//用户姓名
            String phone = user_address.getPhone();//订单号
            String user_name = user_address.getUser_name();//用户账号
            String address = user_address.getAddress();//用户地址
//            tvOrderNum.setText("订单号 "+phone);
            txtName.setText(name);
            textDahao.setText(phone);
            textDizhi.setText(address);

        }
    }
}
