package com.example.shiyuankeji.ui.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.AddOrderistBean;
import com.example.shiyuankeji.bean.AliPayBean;
import com.example.shiyuankeji.bean.SubmitBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.SubmitContract;
import com.example.shiyuankeji.presenter.SubmitPresenter;
import com.example.shiyuankeji.utils.NoDoubleClickListener;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.SubmitNoDoubleClickListener;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.widgets.alipay.util.PayResult;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

//http://192.168.124.13:8080/toConfirmOrderList?user_name=sf003&idsa=2011
public class Submit0rdersActivity extends BaseActivity implements SubmitContract.View {

    @BindView(R.id.wechat_check)
    CheckBox wechatCheck;
    @BindView(R.id.ali_ch)
    CheckBox jifenCheck;
    @BindView(R.id.ll_wechat)
    LinearLayout llWechat;
    @BindView(R.id.imageView14)
    ImageView imageView14;
    @BindView(R.id.ali_check)
    CheckBox aliCheck;
    @BindView(R.id.ll_ali)
    LinearLayout llAli;
    @BindView(R.id.ll_jifen)
    LinearLayout llJifen;

    //    private IWXAPI api;
    private static final int SDK_PAY_FLAG = 1;

//    @BindView(R.id.re_on)
//    RelativeLayout reOn;
//    @BindView(R.id.re_site_ok)
//    RelativeLayout reSiteOk;
    @BindView(R.id.relative_on_)
    RelativeLayout relativeOn_;
//    @BindView(R.id.btn_exchangOn)
//    Button btnExchangOn;
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
    private boolean indxler = true;
    private String get_name;
    private String get_phone;
    private String get_address;

    private String getname;
    private String getphone;
    private String getaddress;

    private int type = 0;
    private String img;
    private int idsas;
    private int src_price;
    private int freight;

    private String isid = "";
    private String onid = "";
    private RelativeLayout reSiteOk;
    private RelativeLayout reOn;
    private Button btnExchangOn;


    @Override
    protected IBasePresenter getPresenter() {
        return new SubmitPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_submitorder;
    }


    //TODO
    @OnClick({  R.id.relative_on_,  R.id.ll_wechat, R.id.ll_jifen, R.id.ll_ali})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_wechat:
                aliCheck.setChecked(false);
                jifenCheck.setChecked(false);
                wechatCheck.setChecked(!wechatCheck.isChecked());
                break;
            case R.id.ll_ali:
                wechatCheck.setChecked(false);
                jifenCheck.setChecked(false);
                aliCheck.setChecked(!aliCheck.isChecked());
                break;
            case R.id.ll_jifen:
                wechatCheck.setChecked(false);
                aliCheck.setChecked(false);
                jifenCheck.setChecked(!jifenCheck.isChecked());
                break;
//            case R.id.re_site_ok: //有 地址管理
//                Intent intent = new Intent();
//                intent.setClass(context, SelectAddressActivity.class);
//                intent.putExtra("typeid_", typeid);
//                intent.putExtra("num_", num);
//                Constant.IS_MINE = false;
//                Constant.IS_MINE_IS = "1";
//                startActivity(intent);
//                finish();
//                break;
//            case R.id.re_on: //无 地址管理
//                Intent intent1 = new Intent();
//                intent1.setClass(context, SelectAddressActivity.class);
//                intent1.putExtra("typeid_", typeid);
//                intent1.putExtra("num_", num);
//                Constant.IS_MINE = false;
//                Constant.IS_MINE_IS = "1";
//                startActivity(intent1);
//                finish();
//                break;
//            case R.id.btn_exchangOn: //有 立即兑换 提交订单
//                if (SharedPreferencesUtil.getDeliveryAddress(context) == true) {
//                    if (aliCheck.isChecked()) {
//                        Toast.makeText(this, "支付宝支付", Toast.LENGTH_SHORT).show();
//                        getAliPayResult();
//                    } else if (wechatCheck.isChecked()) {
//                        Toast.makeText(this, "微信支付", Toast.LENGTH_SHORT).show();
////                    weChatPay();
//                    } else if (jifenCheck.isChecked()) {
//                        Toast.makeText(this, "积分支付", Toast.LENGTH_SHORT).show();
//                        jifezhifu();
//                    } else {
//                        Toast.makeText(this, "请选择支付方式", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    new ToastUtil(context, R.layout.toast_center_horizontal, "请选择收货地址").show();
//
//                }
//
//
//                break;
            case R.id.relative_on_:
                finish();
                break;
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
//                        if(courseInfoBean != null){
//                            ZhuGeUtil.getmInstance().addEvent(ZGEventNameConfig.FINISH_BUY_COURSE,"课程标题",courseInfoBean.getCourse_name());
//                        }
                        Toast.makeText(Submit0rdersActivity.this, R.string.payment_success_string, Toast.LENGTH_SHORT).show();
//                        ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "支付成功！");
//                        toastUtil2.show();
                        Intent intent2 = new Intent();
                        intent2.setClass(context, MainActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent2.putExtra("id", Constant.TWO_TYPE_3);
                        startActivityForResult(intent2, Constant.TWO_TYPE_3);
                        finish();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(Submit0rdersActivity.this, R.string.no_payment_success_string, Toast.LENGTH_SHORT).show();
//                        ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "支付失败！");
//                        toastUtil2.show();
                        finish();
                    }
                    break;
                }
                default:
                    break;
            }
        }


    };

    public void getAliPayResult() {
        if (Constant.INXDLER == false) {
            HashMap<String, String> maps = new HashMap<>();
            maps.put("num", String.valueOf(Constant.NUM));//num
            maps.put("order_price", String.valueOf(Constant.ZONG_JIA));//tvZong
            maps.put("idsa", String.valueOf(Constant.IDSAS)); //商品编号idsas
            maps.put("addressid", isid);
            maps.put("paymentMethod", String.valueOf(1));
            ((SubmitPresenter) mPresenter).addOrders(maps);
        } else if (Constant.INXDLER == true) {
            HashMap<String, String> maps = new HashMap<>();
            maps.put("num", String.valueOf(Constant.NUM));//num
            maps.put("order_price", String.valueOf(Constant.ZONG_JIA));//tvZong
            maps.put("idsa", String.valueOf(Constant.IDSAS)); //商品编号idsas
            maps.put("addressid", onid);
            maps.put("paymentMethod", String.valueOf(1));
            ((SubmitPresenter) mPresenter).addOrders(maps);
        }
//        TODO
////        ((SubmitPresenter) mPresenter).alipay(String.valueOf(Constant.IDSAS), Double.valueOf(Constant.ZONG_JIA), Constant.NAME);
//
//        HashMap<String, String> maps = new HashMap<>();
////                maps.put("name", "sf003");
//        maps.put("num", String.valueOf(Constant.NUM));//num
////        maps.put("user_name", tvname);
////        maps.put("user_phone", tvDahao);
////        maps.put("user_add", tvDizhi);
////                maps.put("user_id", String.valueOf(15));//用户id
////        maps.put("item_img", Constant.IMG);//img
////        maps.put("item_name", Constant.NAME);//tviphoneName
////        maps.put("item_price", String.valueOf(Constant.SRC_PRICE));//src_price
////        maps.put("item_freight", String.valueOf(freight));
//        maps.put("order_price", String.valueOf(Constant.ZONG_JIA));//tvZong
//        maps.put("idsa", String.valueOf(Constant.IDSAS)); //商品编号idsas
//        maps.put("addressid", isid);
//        maps.put("paymentMethod", String.valueOf(1));
//        ((SubmitPresenter) mPresenter).addOrders(maps);
//        //TODO
////        String point = courseInfoBean.getCode_price();
////        String course_id = courseInfoBean.getCourse_id();
////        String course_name = courseInfoBean.getCourse_name();
////        CIOTimesNet.AliPay(course_id, point, course_name, new TextHttpResponseHandler() {
////            @Override
////            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
////            }
//
////            @Override
////            public void onSuccess(int statusCode, Header[] headers, String responseString) {
////                AliPayBean aliPayBean = JSON.parseObject(responseString, AliPayBean.class);
////                aliPay("<form name='punchout_form' method='post' action='https://openapi.alipay.com/gateway.do?charset=utf-8&method=alipay.trade.wap.pay&sign=ClkejmooRph4U1jlIXmK%2BWc14jr5v0EB5qt%2Fi7zQHfPNHHOvlWL9OxCBFkVnJ5cotafq61CUQoXAVS9pcrM%2B385eC5XN9EKVEyKZbsZTrHjfUHWlS7qu4K4j5JA%2BAKHDTEy9Betk%2B9yHZMKRi3ZgrwzglInM%2FQE425ptEsBIhekKliheoIFGqbCWAtyPCLzKlWpxutTDa24UpMutwSW7pr4u7ZDKMHCepJ%2Bh0wdoeOzEf4%2F6S1vfABP2g7fxE86w97jvpH0ssdjuc1uSyzBf6bIOSx0IWSXydygG7Ajsf0pkgPFBHZoLlJmwYktk199z%2FrgFptTs%2BMqAu17mL2Le1A%3D%3D&return_url=http%3A%2F%2Flocalhost%3A8080%2Falipay.trade.page.pay-JAVA-UTF-8%2Freturn_url.jsp&notify_url=http%3A%2F%2Flocalhost%3A8080%2Falipay.trade.page.pay-JAVA-UTF-8%2Fnotify_url.jsp&version=1.0&app_id=2021001165677698&sign_type=RSA2&timestamp=2020-06-04+17%3A01%3A18&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json'> <input type='hidden' name='biz_content' value='{&quot;body&quot;:&quot;商品名称&quot;,&quot;out_trade_no&quot;:&quot;122&quot;,&quot;product_code&quot;:&quot;QUICK_WAP_WAY&quot;,&quot;subject&quot;:&quot;12&quot;,&quot;timeout_express&quot;:&quot;2m&quot;,&quot;total_amount&quot;:&quot;1&quot;}'> <input type='submit' value='立即支付' style='display:none' > </form> <script>document.forms[0].submit();</script>");
//
////            }
////        });
    }

    private void aliPay(final String requestUrl) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(Submit0rdersActivity.this);
                Map<String, String> result = alipay.payV2(requestUrl, true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
        //TODO 积分支付
    private void jifezhifu() {
        if (Constant.INXDLER == false) {


            HashMap<String, String> maps = new HashMap<>();

            maps.put("num", String.valueOf(Constant.NUM));//num
            maps.put("order_price", String.valueOf(Constant.ZONG_JIA));//tvZong
            maps.put("idsa", String.valueOf(Constant.IDSAS)); //商品编号idsas
            maps.put("addressid", isid);
            maps.put("paymentMethod", String.valueOf(3));
            ((SubmitPresenter) mPresenter).addOrders(maps);
        } else if (Constant.INXDLER == true) {
            HashMap<String, String> maps = new HashMap<>();
            maps.put("num", String.valueOf(Constant.NUM));//num
            maps.put("order_price", String.valueOf(Constant.ZONG_JIA));//tvZong
            maps.put("idsa", String.valueOf(Constant.IDSAS)); //商品编号idsas
            maps.put("addressid", onid);
            maps.put("paymentMethod", String.valueOf(3));
            ((SubmitPresenter) mPresenter).addOrders(maps);
        }

    }

    @Override
    protected void initView() {
//        type_id

        typeid = getIntent().getIntExtra("type_id", 0);
//        add_price = getIntent().getIntExtra("add_price", 0);//交易价格
        num = getIntent().getIntExtra("num", 0);//交易数量
        Constant.NUM = num;

//        Intent intent = getIntent();
        boolean type_0 = getIntent().getBooleanExtra("type_0", true);
        get_name = getIntent().getStringExtra("get_name");
        get_phone = getIntent().getStringExtra("get_phone");
        get_address = getIntent().getStringExtra("get_address");
        indxler = type_0;


        getname = getIntent().getStringExtra("getname");
        getphone = getIntent().getStringExtra("getphone");
        getaddress = getIntent().getStringExtra("getaddress");
        int indx_0 = getIntent().getIntExtra("indx_0", 0);
        onid = getIntent().getStringExtra("onid");
        type = indx_0;
        initFindViewById();
    }

    private void initFindViewById() {
        reSiteOk = findViewById(R.id.re_site_ok);
        reOn = findViewById(R.id.re_on);
        btnExchangOn = findViewById(R.id.btn_exchangOn);
        btnExchangOn.setOnClickListener(new SubmitNoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                if (SharedPreferencesUtil.getDeliveryAddress(context) == true) {
                    if (aliCheck.isChecked()) {
                        Toast.makeText(context, R.string.alipay_string, Toast.LENGTH_SHORT).show();
                        getAliPayResult();
                    } else if (wechatCheck.isChecked()) {
                        Toast.makeText(context, R.string.wx_string, Toast.LENGTH_SHORT).show();
//                    weChatPay();
                    } else if (jifenCheck.isChecked()) {
                        Toast.makeText(context, R.string.integral_string, Toast.LENGTH_SHORT).show();
                        jifezhifu();
                    } else {
                        Toast.makeText(context, R.string.selet_way_string, Toast.LENGTH_SHORT).show();
//                        ToastUtil toastUtil2 = new ToastUtil(context, R.layout.putong_toast_center_horizontal, "请选择支付方式！");
//                        toastUtil2.show();
                    }
                } else {
//                    new ToastUtil(context, R.layout.toast_center_horizontal, "请选择收货地址").show();
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.putong_toast_center_horizontal, "请选择收货地址！");
//                    toastUtil2.show();
                    Toast.makeText(context,R.string.selet_site_string,Toast.LENGTH_SHORT).show();
                }
            }
        });
        reOn.setOnClickListener(new NoDoubleClickListener() {  //无 地址管理
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(context, SelectAddressActivity.class);
                intent1.putExtra("typeid_", typeid);
                intent1.putExtra("num_", num);
                Constant.IS_MINE = false;
                Constant.IS_MINE_IS = "1";
                startActivity(intent1);
                finish();
            }
        });
        reSiteOk.setOnClickListener(new NoDoubleClickListener() { //有 地址管理
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, SelectAddressActivity.class);
                intent.putExtra("typeid_", typeid);
                intent.putExtra("num_", num);
                Constant.IS_MINE = false;
                Constant.IS_MINE_IS = "1";
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void initData() {//typeid
        ((SubmitPresenter) mPresenter).submit(typeid);
    }


    @Override
    public void submitRetrun(SubmitBean submitBean) {


        isid = String.valueOf(submitBean.getUser_address().getId());
        Constant.INXDLER = false;
        if (submitBean.getUser_address().getId() != Constant.IS_ID) {
            SharedPreferencesUtil.setDeliveryAddress(context, true); //保存有、无 地址状态
            reOn.setVisibility(View.GONE);
//            Toast.makeText(context, "有地址", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferencesUtil.setDeliveryAddress(context, false);
            reSiteOk.setVisibility(View.GONE);
//            Toast.makeText(context, "无地址", Toast.LENGTH_SHORT).show();
        }
//        items
        SubmitBean.ItemsBean items = submitBean.getItems();
        if (items != null) {
            String namess = items.getName(); //产品名称
            //运费
            freight = items.getFreight();
            img = items.getImg(); //图
            //产品价格
            src_price = items.getCode_price();
            idsas = items.getIdsa(); //商品编号

            Constant.IMG = img; //图
            Constant.NAME = namess; //产品名
            Constant.FREIGHT = freight;
            Constant.SRC_PRICE = src_price;//产品价格
            Constant.IDSAS = idsas; //商品编号
            Constant.ZONG_JIA = src_price * num + freight; //总价
            Glide.with(context).load(Constant.IMG).into(im_); //img
            tvIphoneName.setText(Constant.NAME);//namess
            textJifen.setText(Constant.SRC_PRICE + "积分");//src_price
            tvFreight.setText(Constant.FREIGHT + "积分");//freight
            tvNum.setText("X" + Constant.NUM);//num
            //add_price
            textZong.setText(Constant.ZONG_JIA + "");//总价钱(src_price * num + freight)
            tvJifenOn.setText(Constant.ZONG_JIA + "");//(src_price * num + freight)

        }
        SubmitBean.UserAddressBean user_address = submitBean.getUser_address();
        if (user_address != null) {
            String name = user_address.getName();//用户姓名
            String phone = user_address.getPhone();//手机号
            String user_name = user_address.getUser_name();//用户账号
            String address = user_address.getAddress();//用户地址
//            tvOrderNum.setText("订单号 "+phone);
            if (indxler == true) {
                txtName.setText("收货人："+name);
                textDahao.setText(phone);
                textDizhi.setText("收货地址："+address);
            } else {
                txtName.setText("收货人："+get_name);
                textDahao.setText(get_phone);
                textDizhi.setText("收货地址："+get_address);
            }
            if (type == 100) {
                txtName.setText("收货人："+getname);
                textDahao.setText(getphone);
                textDizhi.setText("收货地址："+getaddress);
            }


        }
    }
//TODO 积分不足
    @Override
    public void addOrderRean(AddOrderistBean addOrderistBean) {
        if (addOrderistBean != null) {
            int order_state = addOrderistBean.getStatus();
            if (order_state == 200) {
                Toast.makeText(context, addOrderistBean.getMsg(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent();
                intent2.setClass(context, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putExtra("id", Constant.TWO_TYPE_3);
                startActivityForResult(intent2, Constant.TWO_TYPE_3);
                finish();
            } else if (order_state == 201) {
                String data = addOrderistBean.getData();
                if (!data.equals("") && data != null) {
                    aliPay(data);
                }
            } else if (order_state==206){
                Toast.makeText(context,R.string.understock_string,Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil = new ToastUtil(context, R.layout.toast_center_horizontal, "库存不足！");
//                toastUtil.show();
            }else if (order_state==204){
                LayoutInflater inflater = getLayoutInflater();
                //引入自定义好的对话框.xml布局
                View layout = inflater.inflate(R.layout.is_submit_layout, null);
                //实列提示对话框对象，并将加载的试图对象设置给对话框对象
                final AlertDialog alertDialog = new AlertDialog.Builder(this).setView(layout).show();
                final RelativeLayout yes = layout.findViewById(R.id.relative_update);
                final RelativeLayout no = layout.findViewById(R.id.relative_cancel);
                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
//                        Toast.makeText(context, addOrderistBean.getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(context, WebCallCenterActivity.class);
                        startActivity(intent);
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();

                    }
                });
            }
        }
    }

    //支付宝返回值
    @Override
    public void alipayRean(AliPayBean aliPayBean) {
//        if (aliPayBean != null) {
//            String resultStatus = aliPayBean.getBody();
//            if (resultStatus != null) {
//                aliPay(resultStatus);
//            } else {
//                return;
//            }
//        }
    }
}
