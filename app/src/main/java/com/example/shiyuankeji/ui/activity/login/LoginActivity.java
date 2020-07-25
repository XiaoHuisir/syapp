package com.example.shiyuankeji.ui.activity.login;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.LoginsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.LoginsContract;
import com.example.shiyuankeji.presenter.login.LoginsPresenter;
import com.example.shiyuankeji.ui.activity.UpdatePasswrdActivity;
import com.example.shiyuankeji.ui.activity.VerifyAccountActivity;
import com.example.shiyuankeji.utils.CardUtils;
import com.example.shiyuankeji.utils.NoDoubleClickListener;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.OnClick;

//http://198.168.124.14:8080/user_login
public class LoginActivity extends BaseActivity implements LoginsContract.Views {
    private static final int REQUEST_READ_PHONE_STATE = 1;
    private static final String TAG = "t";
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pw)
    EditText edPw;
    @BindView(R.id.re)
    RelativeLayout re;
    @BindView(R.id.lins_break)
    ImageView linsBreak;
//    @BindView(R.id.btn_login)
//    LinearLayout btnLogin;
    @BindView(R.id.btn_show)
    ImageView btnShow;
    @BindView(R.id.wxlogin)
    LinearLayout wxlogin;
//    @BindView(R.id.tv_register)
//    TextView tvRegister;
    @BindView(R.id.c1)
    CardView card;
    private String mobile;
    private String password;
    private int code;
    IWXAPI api; //微信api

    public static int REGISTER = 146;
    private String pho = "";
    private String user_id = "";
    private String pwdss = "";
    private LinearLayout btnLogin;
    private TextView tvRegister;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
//        CardUtils.setCardShadowColor(card, getResources().getColor(R.color.newnew_bg), getResources().getColor(R.color.newnew_bg));
        //判断是否有登录过
        String username = SharedPreferencesUtil.getUserName(MyApp.mApp);
        String pw = SharedPreferencesUtil.getPw(MyApp.mApp);
        if (!TextUtils.isEmpty(username)) {
            edPhone.setText(username);
            if (!TextUtils.isEmpty(pw)) {
                edPw.setText(pw);
            }
        }
//        edPhone.setText("sf003");
//        edPw.setText("456789");
//        edPhone.setFocusable(false);
//        edPw.setFocusable(false);

//        edPw.setSelection(edPw.getText().length());
        edPw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);//设置密码不可见
            initFindViewById();
    }

    private void initFindViewById() {
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new NoDoubleClickListener() { //登录
            @Override
            protected void onNoDoubleClick(View v) {
                mobile = edPhone.getText().toString();
                password = edPw.getText().toString();
                closeKeyboard();
                closeKeyboardedPhone();

//                edPw.setInputType(EditorInfo.TYPE_CLASS_PHONE);//设置数字键盘显示
                Constant.mobiles = mobile;
                Constant.passwords = password;
                if (TextUtils.isEmpty(mobile) || TextUtils.isEmpty(password)) {
                    Toast.makeText(context, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                    if (!TextUtils.isEmpty(mobile) && TextUtils.isEmpty(password)) {
                        Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(password)) {
                        Toast.makeText(context, "请输入用户名", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                ((LoginsPresenter) mPresenter).logins(mobile, password);

            }
        });
        tvRegister = findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(new NoDoubleClickListener() { //去注册
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, RegisterActivity.class);
                intent.putExtra("type_", REGISTER);
                startActivityForResult(intent, REGISTER);
            }
        });
    }

    @Override
    protected IBasePresenter getPresenter() {
        return new LoginsPresenter();
    }


    @OnClick({ R.id.btn_show, R.id.ed_pw, R.id.ed_phone, R.id.wxlogin,R.id.lins_break})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.tv_register: //去注册
//                Intent intent = new Intent();
//                intent.setClass(context, RegisterActivity.class);
//                intent.putExtra("type_", REGISTER);
//                startActivityForResult(intent, REGISTER);
//                break;
            case R.id.lins_break:
                Intent intent = new Intent();
                intent.setClass(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);//设置栈顶模式
                intent.putExtra("id", Constant.ONE_TYPE_1);
                startActivityForResult(intent, Constant.ONE_TYPE_1);
                finish();
                break;
            case R.id.wxlogin://微信登录
                loginWX();
                Toast.makeText(context, "欢迎使用微信三方登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ed_pw:

//                edPhone.setInputType(InputType.TYPE_CLASS_NUMBER);
//                edPhone.setInputType(EditorInfo.TYPE_CLASS_PHONE);//设置数字键盘显示
                break;
//            case R.id.btn_login:
//                mobile = edPhone.getText().toString();
//                password = edPw.getText().toString();
//                closeKeyboard();
//                closeKeyboardedPhone();
//
////                edPw.setInputType(EditorInfo.TYPE_CLASS_PHONE);//设置数字键盘显示
//                Constant.mobiles = mobile;
//                Constant.passwords = password;
//                if (TextUtils.isEmpty(mobile) || TextUtils.isEmpty(password)) {
//                    Toast.makeText(context, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
//                    if (!TextUtils.isEmpty(mobile) && TextUtils.isEmpty(password)) {
//                        Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
//                    }
//                    if (TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(password)) {
//                        Toast.makeText(context, "请输入用户名", Toast.LENGTH_SHORT).show();
//                    }
//                    return;
//                }
//
//                ((LoginsPresenter) mPresenter).logins(mobile, password);
//
//
//                break;
            case R.id.btn_show:
                if (btnShow.isSelected()) {
                    btnShow.setSelected(false);
                    edPw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);//设置密码不可见
                    edPw.setSelection(edPw.getText().length());//设置光标的位置到末尾
                } else {
                    btnShow.setSelected(true);
                    edPw.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//设置密码可见                }
                    edPw.setSelection(edPw.getText().length());//设置光标的位置到末尾
                    break;
                }


                edPw.setSelection(edPw.getText().length());//设置光标的位置到末尾

        }
    }

    private void loginWX() {

        api = WXAPIFactory.createWXAPI(this, "wxf03d722bd25a1519", true);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wx_login_duzun";
        api.sendReq(req);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void loginsReturn(LoginsBean result) {
        String message = result.getMsg();


        int code = Integer.parseInt(message);
        if (code == 200) {
            LoginsBean.DataBean data = result.getData();

            pho = data.getData1();
            user_id = data.getData2();
            pwdss = data.getData3();

            if (pwdss.equals("123456")) {
                LayoutInflater inflater = getLayoutInflater();
                //引入自定义好的对话框.xml布局
                View layout = inflater.inflate(R.layout.login_sk_verfiy, null);
                //实列提示对话框对象，并将加载的试图对象设置给对话框对象
                final AlertDialog alertDialog = new AlertDialog.Builder(this).setView(layout).show();
                final TextView yes = layout.findViewById(R.id.tv_ok);
                final TextView no = layout.findViewById(R.id.tv_no);
                final TextView tvTilte = layout.findViewById(R.id.tv_tilte);
                tvTilte.setText("您的密码为默认密码，为了您的账号安全；请修改密码。");
                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        skverfiytishi();
//                        Toast.makeText(context, addOrderistBean.getMsg(), Toast.LENGTH_SHORT).show();
//                        int permissionCheck = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_PHONE_STATE);
//                        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
//                            ActivityCompat.requestPermissions(LoginActivity.this, new String[]
//                                    {Manifest.permission.READ_PHONE_STATE
//                                    }, REQUEST_READ_PHONE_STATE);
//                        } else {
//                            sms(); //电话权限
//                        }
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();

                    }
                });
                //-------------
//                new AlertDialog.Builder(this).setTitle("为默认密码，请修改密码,并且同意权限，否则无法登录")
//                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                int permissionCheck = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_PHONE_STATE);
//                                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
//                                    ActivityCompat.requestPermissions(LoginActivity.this, new String[]
//                                            {Manifest.permission.READ_PHONE_STATE
//                                            }, REQUEST_READ_PHONE_STATE);
//                                } else {
//                                    sms(); //电话权限
//                                }
//                            }
//                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).create().show();

            } else {
                SharedPreferencesUtil.addUserToken(context, data.getToken());// 添加保存token TODO
                Constant.token = result.getData().getToken();
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(context, "登录成功！", Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "登录成功！");
//                toastUtil2.show();
            }
        } else {
            Toast.makeText(context, "用户名或密码不正确！", Toast.LENGTH_SHORT).show();
//            ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "登录失败！");
//            toastUtil2.show();
        }


    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void skverfiytishi() {
        LayoutInflater inflater = getLayoutInflater();
        //引入自定义好的对话框.xml布局
        View layout = inflater.inflate(R.layout.login_sk_verfiy, null);
        //实列提示对话框对象，并将加载的试图对象设置给对话框对象
        final AlertDialog alertDialog = new AlertDialog.Builder(this).setView(layout).show();
        final TextView yes = layout.findViewById(R.id.tv_ok);
        final TextView no = layout.findViewById(R.id.tv_no);
        final TextView tvTilte = layout.findViewById(R.id.tv_tilte);
        tvTilte.setText("请您同意权限，否则无法修改密码。");
        yes.setOnClickListener(new View.OnClickListener() {  //是
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

//                        Toast.makeText(context, addOrderistBean.getMsg(), Toast.LENGTH_SHORT).show();
                int permissionCheck = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_PHONE_STATE);
                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(LoginActivity.this, new String[]
                            {Manifest.permission.READ_PHONE_STATE
                            }, REQUEST_READ_PHONE_STATE);
                } else {
                    sms(); //电话权限
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {  //否
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //TODO
                    sms();
                }
                break;

            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void sms() {

        TelephonyManager tm = (TelephonyManager) this.getSystemService(getApplication().TELEPHONY_SERVICE);

        if (checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        String line1Number = tm.getLine1Number(); //本机手机号
        Intent intent = new Intent();
        if (line1Number==null){
            Toast.makeText(context, "无SD卡无法登录！", Toast.LENGTH_SHORT).show();
//            ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "无SD卡无法登录！");
//            toastUtil2.show();
            return;
        }
        if (line1Number.equals("") || line1Number.equals("+86") || !line1Number.equals("+86" + pho) ) {
//            Toast.makeText(this, "匹配失败(获取失败！)" + line1Number, Toast.LENGTH_SHORT).show();
            //匹配失败 跳转到校验界面
            intent.setClass(this, VerifyAccountActivity.class);
            //TODO mobile
            if (mobile!=null){
                SharedPreferencesUtil.addPhone(context,mobile); //保存手机号
            }
        } else {
            //匹配成功 (修改密码)
            intent.setClass(this, UpdatePasswrdActivity.class);
// pwdss
            intent.putExtra("pho_", pho);
//            Constant.DYNAMIC_PRICE = 123;
        }
        startActivity(intent);


    }

    //关闭指定文本输入框的软键盘
    private void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edPw.getWindowToken(), 0);
    }

    private void closeKeyboardedPhone() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edPhone.getWindowToken(), 0);
    }


    //注册回调


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTER) {
            if (data == null) {
                return;
            }
            String phone = data.getStringExtra("uname_");
            String pawd = data.getStringExtra("pawd_");
            edPhone.setText(phone);
            edPw.setText(pawd);

        }
    }
}
