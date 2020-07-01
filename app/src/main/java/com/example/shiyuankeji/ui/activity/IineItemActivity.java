package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.LineItemBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.LineItemConreact;
import com.example.shiyuankeji.presenter.LineItemPresenter;
import com.example.shiyuankeji.utils.GlideRoundTransform;

import butterknife.BindView;
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
    private String indent_id;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        indent_id = intent.getStringExtra("indent_id");

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
            int order_state = lineItemBean.getOrder_list().getOrder_state();
            initOrderState(order_state);

            tvOrderNum.setText("订单号：" + lineItemBean.getOrder_list().getOrder_num());
            txtName.setText("收货人：" + lineItemBean.getUser_address().getName());
            tvUserPhone.setText(lineItemBean.getUser_address().getPhone());
            tvUserAdd.setText(lineItemBean.getUser_address().getAddress());
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.no_banner) //预加载图片
                    .error(R.drawable.no_banner) //加载失败图片
                    .priority(Priority.HIGH) //优先级
                    .diskCacheStrategy(DiskCacheStrategy.NONE) //缓存
                    .transform(new GlideRoundTransform(3)); //圆角
            Glide.with(context).load(lineItemBean.getItems().getImg()).apply(options).into(imItemImg);
            tvItemName.setText(lineItemBean.getItems().getName());
            tvItemPrice.setText(lineItemBean.getItems().getCode_price() + "积分");
            tvNum.setText("X" + lineItemBean.getOrder_list().getNum());
            tvItemFreight.setText(lineItemBean.getItems().getFreight() + "积分");
            tvOrderPrice.setText(lineItemBean.getOrder_list().getOrder_price() + "");

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
