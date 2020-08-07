package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.UpdatePwdtBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.UpdatePwdContract;
import com.example.shiyuankeji.presenter.UpdatePwdPresenter;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.utils.UtilsClicktime;
import com.example.shiyuankeji.utils.Validator;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdatePasswrdActivity extends BaseActivity implements UpdatePwdContract.View {

    @BindView(R.id.lin_reset)
    LinearLayout linReset;
    @BindView(R.id.ed_new_pwd)
    EditText edNew_pwd;
    private String pw_ = "";
    private String new_pwd = "";
    private String pho_ = "";

    @Override
    protected IBasePresenter getPresenter() {
        return new UpdatePwdPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_update_passwrd;
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
//        //初始化
//        if (Constant.DYNAMIC_PRICE == 123) {
//            pw_ = getIntent().getStringExtra("pw_");
//            edNew_pwd.setText(pw_);
//        }
//        if (Constant.DYNAMIC_PRICE == 123){
        pho_ = getIntent().getStringExtra("pho_");
//        }
    }


    @OnClick({R.id.lin_reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_reset:
                if (UtilsClicktime.isFastDoubleClick()) {
                    return;
                }
                new_pwd = edNew_pwd.getText().toString();
                if (TextUtils.isEmpty(new_pwd)) {
                    Toast.makeText(context, R.string.no_pwd_null_string, Toast.LENGTH_SHORT).show();
                    return;
                }

                    if (!Validator.isPwd(new_pwd) == true) {
//                    tvPwd01.setText("请输入最少6位最多12位的数字加字母组合的密码");
                        Toast.makeText(context, R.string.regoster_ok_string, Toast.LENGTH_SHORT).show();
                        return;
                    }
                if (Validator.shuziss(new_pwd) == true) {
                    Toast.makeText(context, R.string.regoster_ok_string, Toast.LENGTH_SHORT).show();
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
//                    toastUtil2.show();
                    return;
                }
                if (Validator.isPwd(new_pwd) == true) {
                    ((UpdatePwdPresenter) mPresenter).updatepwds(pho_, new_pwd);
                }
                break;
        }
    }

    @Override
    public void updatepwdRean(UpdatePwdtBean updatePwdtBean) {
        int status = updatePwdtBean.getStatus();
        String msg = updatePwdtBean.getMsg();
        if (status == 200) {
            if (msg.equals("1")) { //修改成功
                Toast.makeText(context,R.string.up_pwd_ok_string,Toast.LENGTH_SHORT).show();
//                new ToastUtil(context, R.layout.ok_toast_center_horizontal, "密码修改成功").show();
                String tokens = updatePwdtBean.getData().getToken();
                SharedPreferencesUtil.addUserToken(context, tokens);// 添加保存token TODO
                Constant.token = tokens;
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(context,R.string.up_pwd_no_string,Toast.LENGTH_SHORT).show();
//                new ToastUtil(context, R.layout.toast_center_horizontal, "密码修改失败").show();
            }

        }
    }
}
