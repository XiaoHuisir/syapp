package com.example.shiyuankeji.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.SynergicAdapter;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.JoinBean;
import com.example.shiyuankeji.bean.SynergicBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.SynergiContract;
import com.example.shiyuankeji.presenter.JoinPresenter;
import com.example.shiyuankeji.presenter.SynergicPersenter;
import com.example.shiyuankeji.utils.NoDoubleClickListener;
import com.example.shiyuankeji.utils.UtilsClicktime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SynergicActivity extends BaseActivity implements SynergiContract.View, SynergicAdapter.SynergicClick {
    @BindView(R.id.lin_wbeak)
    LinearLayout linWbeak;
    @BindView(R.id.recyc_synergic)
    RecyclerView recycSynergic;
    @BindView(R.id.scroll_show)
    ScrollView scrollShow;
    //    @BindView(R.id.on_shuju)
//    ImageView onShuju;
    @BindView(R.id.tv_place)
    TextView tvPlace;
    @BindView(R.id.tv_suozai)
    TextView tvsuozai;
    @BindView(R.id.tv_on)
    TextView tvon;
    private List<SynergicBean.TeamListLV1Bean> teamListLV1;
    private ArrayList<SynergicBean.TeamListLV1Bean> list;
    private SynergicAdapter synergicAdapter;


    @Override
    protected IBasePresenter getPresenter() {
        return new SynergicPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_synergic;
    }


    @OnClick({R.id.lin_wbeak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_wbeak:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
        recycSynergic.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        synergicAdapter = new SynergicAdapter(list);
        synergicAdapter.synitemClick = this;
        recycSynergic.setAdapter(synergicAdapter);
    }

    @Override
    protected void initData() {
        ((SynergicPersenter) mPresenter).synergics();
    }

    @Override
    public void synergicRean(SynergicBean synergicBean) {
        if (synergicBean != null) {
            SynergicBean.InTeamVL1Bean inTeamVL11 = synergicBean.getInTeamVL1();
            if (inTeamVL11 == null) {
                return;
            }
            int id = inTeamVL11.getId();
            if (id == 0) {
                tvPlace.setVisibility(View.GONE);
                tvsuozai.setVisibility(View.VISIBLE);
                tvon.setVisibility(View.VISIBLE);
                recycSynergic.setVisibility(View.GONE);
                money();
                return;
            } else {
                tvsuozai.setVisibility(View.GONE);
                tvPlace.setVisibility(View.VISIBLE);
                SynergicBean.InTeamVL1Bean inTeamVL1 = synergicBean.getInTeamVL1();
                if (inTeamVL1 == null) {
                    tvPlace.setVisibility(View.GONE);
                    tvsuozai.setVisibility(View.VISIBLE);
                    return;
                }
                final String nick_name = synergicBean.getInTeamVL1().getNick_name();
                if (nick_name.equals("")) {
                    tvon.setVisibility(View.VISIBLE);
                    recycSynergic.setVisibility(View.GONE);
                } else {
                    tvPlace.setText(nick_name);
                }
                final int id1 = synergicBean.getInTeamVL1().getId();
                tvPlace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (UtilsClicktime.isFastDoubleClick()) {
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(context, SynergicXingActivity.class);
                        intent.putExtra("e_id", id1);
                        intent.putExtra("nic_name", nick_name);
                        startActivity(intent);
                    }
                });
                if (synergicBean.getTeamListLV1().size() > 0) {

                    teamListLV1 = synergicBean.getTeamListLV1();
                    list.clear();
                    list.addAll(teamListLV1);
                    synergicAdapter.notifyDataSetChanged();


                } else {//无合作数据

                }
            }
        } else {
            return;
        }
    }

    private void money() {
        LayoutInflater inflater = getLayoutInflater();
        //引入自定义好的对话框.xml布局
        View layout = inflater.inflate(R.layout.layout_inxtend, null);
        //实列提示对话框对象，并将加载的试图对象设置给对话框对象
        final AlertDialog alertDialog = new AlertDialog.Builder(this).setView(layout).show();
        final TextView tvTilte = alertDialog.findViewById(R.id.tv_tilte);
        final EditText edEdu = alertDialog.findViewById(R.id.ed_edu);//兑换码
        final LinearLayout btnCash = alertDialog.findViewById(R.id.btn_cash);//确定
        final LinearLayout imBack = alertDialog.findViewById(R.id.im_back);//关闭
        tvTilte.setText(R.string.not_to_join_string);
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
                if (edjie.equals("")) {
                    Toast.makeText(context, R.string.invitation_code_string, Toast.LENGTH_SHORT).show();
                    return;
                }
                alertDialog.dismiss();
                ((SynergicPersenter) mPresenter).isjoin(edjie);

            }
        });


    }

    @Override
    public void synergicxingRean(SynergicBean synergicBean) {

    }

    @Override
    public void isjoinRrean(JoinBean joinBean) {
        if (joinBean != null) {
            final int id = joinBean.getId();
//      "nick_name": "N号初级合作组",
//    "level": 1,
//    "affiliated_userid": 8,
//    "people_num": 4,
            if (id == 0) {
                Toast.makeText(context, R.string.invitation_code_error_string, Toast.LENGTH_SHORT).show();
                money();
            }else  {
                String nick_name = joinBean.getNick_name(); //合作团名称
                int people_num = joinBean.getPeople_num();//团人数
                new AlertDialog.Builder(this).setTitle(nick_name + "  " + "当前人数：" + people_num + "人")
                        .setPositiveButton("加入", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((SynergicPersenter) mPresenter).joins(id);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                }).create().show();

            }
        }
    }

    @Override
    public void joinRrean(JoinBean joinBean) {
//           /**
//     * status : 500
//     * data :
//     * msg : 您已经加入其它的合作组！
//     */
        if (joinBean != null) {
            int status = joinBean.getStatus();

            Intent intent = new Intent();
            if (status == 200) {//加入成功
//                Toast toast = Toast.makeText(context, "成功：" + joinBean.getMsg(), Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
                Toast.makeText(context, R.string.ok_string + joinBean.getMsg(), Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal,  "成功：" + joinBean.getMsg());
//                toastUtil2.show();
//                intent.setClass(context, SynergicActivity.class);
//                finish();
                ((SynergicPersenter) mPresenter).synergics();
            } else {//加入失败、已加入其他组
//                Toast toast = Toast.makeText(context, joinBean.getMsg(), Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
                Toast.makeText(context, R.string.no_string + joinBean.getMsg(), Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal,  "失败：" + joinBean.getMsg());
//                toastUtil2.show();
//                intent.setClass(context, SynergicActivity.class);
//                finish();
                money();
            }

//            startActivity(intent);
        } else {
            return;
        }
    }


    @Override
    public void synergiclick(SynergicBean.TeamListLV1Bean listxing) { //回调
        if (listxing == null) {
            return;
        }
        int id = listxing.getId();
        String nick_name = listxing.getNick_name();
        Intent intent = new Intent();
        intent.setClass(context, SynergicXingActivity.class);
        intent.putExtra("e_id", id);
        intent.putExtra("nic_name", nick_name);
        startActivity(intent);

    }
}
