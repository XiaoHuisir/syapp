package com.example.shiyuankeji.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.SynergicBean;

import java.util.List;

public class SynergicAdapter extends BaseAdapter {
    public SynergicClick synitemClick;

    public SynergicAdapter(List<SynergicBean.TeamListLV1Bean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_synergic;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        TextView tvname = (TextView) holder.getView(R.id.tv_daoyuan_name);
        TextView tvnon = (TextView) holder.getView(R.id.tv_non);
        LinearLayout linearbtn = (LinearLayout) holder.getView(R.id.linear_btn);
        SynergicBean.TeamListLV1Bean lists = (SynergicBean.TeamListLV1Bean) mDatas.get(positon);
        if (lists.getId()==0){
            tvname.setVisibility(View.GONE);
            tvnon.setVisibility(View.VISIBLE);
            tvnon.setText("你还没拥有初级合作组，请继续努力！");
        }else {

        tvname.setText(lists.getNick_name());

        linearbtn.setTag(mDatas.get(positon));
        linearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SynergicBean.TeamListLV1Bean tag = (SynergicBean.TeamListLV1Bean) v.getTag();
                if (synitemClick != null) {
                    synitemClick.synergiclick(tag);
                }
            }
        });
        }
    }

    public interface SynergicClick {
        void synergiclick(SynergicBean.TeamListLV1Bean listxing);
    }
}
