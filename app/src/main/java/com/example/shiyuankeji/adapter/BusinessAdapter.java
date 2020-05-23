package com.example.shiyuankeji.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.SynergicBean;

import java.util.List;

public class BusinessAdapter extends BaseAdapter {
    public BusinesClick busitemClick;

    public BusinessAdapter(List<SynergicBean.TeamListLV2Bean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_synergic;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        TextView tvname = (TextView) holder.getView(R.id.tv_daoyuan_name);
        LinearLayout linearbtn = (LinearLayout) holder.getView(R.id.linear_btn);
        SynergicBean.TeamListLV2Bean lists = (SynergicBean.TeamListLV2Bean) mDatas.get(positon);
        tvname.setText(lists.getNick_name());

        linearbtn.setTag(mDatas.get(positon));
        linearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SynergicBean.TeamListLV2Bean tag = (SynergicBean.TeamListLV2Bean) v.getTag();
                if (busitemClick != null) {
                    busitemClick.busclick(tag);
                }
            }
        });
    }

    public interface BusinesClick {
        void busclick(SynergicBean.TeamListLV2Bean listxing);
    }
}
