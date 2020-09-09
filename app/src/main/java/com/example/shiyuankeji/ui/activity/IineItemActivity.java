package com.example.shiyuankeji.ui.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.shiyuankeji.utils.NoDoubleClickListener;

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
    @BindView(R.id.tv_way)
    TextView tvWay;
    @BindView(R.id.t1)
    TextView tzhuangtai;
    @BindView(R.id.tv_express)
    TextView tvExpress;
    @BindView(R.id.tv_fuzhi)
    TextView tvFuzhi;
    @BindView(R.id.tv_kuandi_name)
    TextView tvKuandiName;
    @BindView(R.id.btn_chaxun)
    Button btnChaXun;
    private String indent_id;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        indent_id = intent.getStringExtra("indent_id");
        tvFuzhi.setText(Html.fromHtml("<u>"+"复制单号"+"</u>"));
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
    public void lineitemReant(final LineItemBean lineItemBean) {
        if (lineItemBean != null) {
            // order_state //订单状态
            int order_state = lineItemBean.getOrder_list().getOrder_state();
            initOrderState(order_state);

            tvOrderNum.setText("订单号：" + lineItemBean.getOrder_list().getOrder_num());
            txtName.setText("收货人：" + lineItemBean.getUser_address().getName());
            tvUserPhone.setText(lineItemBean.getUser_address().getPhone());
            tvUserAdd.setText("收货地址:" + lineItemBean.getUser_address().getAddress());
            String logistics = lineItemBean.getOrder_list().getLogistics();
            if (logistics != null && !logistics.equals("")) {

                tvKuandiName.setText(logistics);
            } else {
                tvKuandiName.setText("快递公司:暂无物流信息");

            }
            final String link = lineItemBean.getOrder_list().getLink();
            String logistics_num = lineItemBean.getOrder_list().getLogistics_num();
            if (logistics_num != null && !logistics_num.equals("")) {
                tvExpress.setText(logistics_num);
                tvFuzhi.setOnClickListener(new NoDoubleClickListener() {//复制快递编号
                    @Override
                    protected void onNoDoubleClick(View v) {
                        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        cm.setText(lineItemBean.getOrder_list().getLogistics_num());
                        Toast.makeText(context, R.string.copy_string, Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                tvExpress.setText("快递编号:暂无物流信息");
            }
            if (!link.equals("") && link != null) {
                btnChaXun.setOnClickListener(new NoDoubleClickListener() {//快递查询
                    @Override
                    protected void onNoDoubleClick(View v) {
                        WebView webView = new WebView(context);
                        webView.loadUrl(link);
                    }
                });
            } else {
                return;
            }
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.no_banner) //预加载图片
                    .error(R.drawable.no_banner) //加载失败图片
                    .priority(Priority.HIGH) //优先级
                    .diskCacheStrategy(DiskCacheStrategy.NONE) //缓存
                    .transform(new GlideRoundTransform(3)); //圆角
            Glide.with(context).load(lineItemBean.getItems().getImg()).apply(options).into(imItemImg);
            int inxdler = lineItemBean.getOrder_list().getPaymentMethod();
            if (inxdler == 1) {
                tvWay.setText("支付方式：支付宝支付");
                tvItemName.setText(lineItemBean.getItems().getName());
                tvItemPrice.setText(lineItemBean.getItems().getCode_price() + "元");
                tvNum.setText("X" + lineItemBean.getOrder_list().getNum());
                tvItemFreight.setText(lineItemBean.getOrder_list().getFreight() + "元"); //运费
                tvOrderPrice.setText(lineItemBean.getOrder_list().getPaymentPrice() + ""); //TODO
                tzhuangtai.setText("元");
            } else if (inxdler == 2) {
                tvWay.setText("支付方式：微信支付");
                tvItemName.setText(lineItemBean.getItems().getName());
                tvItemPrice.setText(lineItemBean.getItems().getCode_price() + "元");
                tvNum.setText("X" + lineItemBean.getOrder_list().getNum());
                tvItemFreight.setText(lineItemBean.getOrder_list().getFreight() + "元");
                tvOrderPrice.setText(lineItemBean.getOrder_list().getPaymentPrice() + ""); //TODO
                tzhuangtai.setText("元");
            } else if (inxdler == 3) {
                tvWay.setText(R.string.lineltem_integral_string);
                tvItemName.setText(lineItemBean.getItems().getName());
                tvItemPrice.setText(lineItemBean.getItems().getCode_price() + "积分");
                tvNum.setText("X" + lineItemBean.getOrder_list().getNum());
                tvItemFreight.setText(lineItemBean.getOrder_list().getFreight() + "积分");
                tvOrderPrice.setText(lineItemBean.getOrder_list().getPayPoints() + ""); //TODO
                tzhuangtai.setText(R.string.lineltem_integral);
            } else if (inxdler == 4) {
                //TODO  支付宝+积分

            } else if (inxdler == 5) {
                //TODO  .微信+积分

            } else if (inxdler == 0) {
                tvWay.setText("支付方式：默认值订单没有支付");
                tvItemName.setText(lineItemBean.getItems().getName());
                tvItemPrice.setText(lineItemBean.getItems().getCode_price() + "积分");
                tvNum.setText("X" + lineItemBean.getOrder_list().getNum());
                tvItemFreight.setText(lineItemBean.getOrder_list().getFreight() + "积分");
                tvOrderPrice.setText("0");
                tzhuangtai.setText("");
            }


        }
    }

    private void initOrderState(int order_state) {
        if (order_state == Constant.ORDER_STATE_0) {
            tvOrderState.setText(R.string.non_payment);
        } else if (order_state == Constant.ORDER_STATE_1) {
            tvOrderState.setText(R.string.to_send_the_goods);
        } else if (order_state == Constant.ORDER_STATE_2) {
            tvOrderState.setText(R.string.wait_for_receiving);
        } else if (order_state == Constant.ORDER_STATE_3) {
            tvOrderState.setText(R.string.performance);
        } else if (order_state == Constant.ORDER_STATE_4) {
            tvOrderState.setText(R.string.data_exception);
        } else {
            tvOrderState.setText(R.string.order_to_be_confirmed);
        }
    }


}
