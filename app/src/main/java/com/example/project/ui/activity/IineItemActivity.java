package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.bean.LineItemBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.LineItemConreact;
import com.example.project.presenter.LineItemPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//        http://localhost:8080/detailOrder_listById?id=3
public class IineItemActivity extends BaseActivity implements LineItemConreact.View {

    @BindView(R.id.lin_return)
    RelativeLayout linreturn;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.tv_order_state)
    TextView tvOrderState;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.tv_user_phone)
    TextView tvUserPhone;
    @BindView(R.id.tv_user_add)
    TextView tvUserAdd;
    @BindView(R.id.im_item_img)
    ImageView imItemImg;
    @BindView(R.id.tv_item_name)
    TextView tvItemName;
    @BindView(R.id.tv_item_price)
    TextView tvItemPrice;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_item_freight)
    TextView tvItemFreight;
    @BindView(R.id.tv_leave_word)
    TextView tvLeaveWord;
    @BindView(R.id.tv_order_price)
    TextView tvOrderPrice;
    private int indent_id;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        indent_id = intent.getIntExtra("indent_id", 0);

    }

    @Override
    protected void initData() {
        ((LineItemPresenter) mPresenter).lineitems(indent_id);
    }

    @Override
    protected IBasePresenter getPresenter() {
        return new LineItemPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lineltem;
    }


    @OnClick({R.id.lin_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_return:
                finish();
                break;

        }
    }


    @Override
    public void lineitemReant(LineItemBean lineItemBean) {
        if (lineItemBean != null) {
            // order_state //订单状态
            int order_state = lineItemBean.getOrder_state();
            initOrderState(order_state);

            tvOrderNum.setText("订单号：" + lineItemBean.getOrder_num());
            txtName.setText("收货人：" + lineItemBean.getUser_name());
            tvUserPhone.setText(lineItemBean.getUser_phone());
            tvUserAdd.setText(lineItemBean.getUser_add());
            Glide.with(context).load(lineItemBean.getItem_img()).into(imItemImg);
            tvItemName.setText(lineItemBean.getItem_name());
            tvItemPrice.setText(lineItemBean.getItem_price() + "积分");
            tvNum.setText("X" + lineItemBean.getNum());
            tvItemFreight.setText(lineItemBean.getItem_freight() + "积分");
            tvOrderPrice.setText(lineItemBean.getOrder_price() + "积分");

        }
    }

    private void initOrderState(int order_state) {
        if (order_state == Constant.ORDER_STATE_0) {
            tvOrderState.setText("订单待确认");
        } else if (order_state == Constant.ORDER_STATE_1) {
            tvOrderState.setText("待发货");
        } else if (order_state == Constant.ORDER_STATE_2) {
            tvOrderState.setText("待收货");
        } else if (order_state == Constant.ORDER_STATE_3) {
            tvOrderState.setText("兑换完成");
        } else {
            tvOrderState.setText("积分不够");
        }
    }


}
