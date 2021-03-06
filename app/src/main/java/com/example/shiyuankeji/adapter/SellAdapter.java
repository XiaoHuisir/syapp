package com.example.shiyuankeji.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.SynergicBean;
import com.example.shiyuankeji.utils.UtilsClicktime;

import java.util.List;

public class SellAdapter extends BaseAdapter {
    public SellClick sellClick;

    public SellAdapter(List<SynergicBean.TeamListLV3Bean> mDatas) {
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
        SynergicBean.TeamListLV3Bean lists = (SynergicBean.TeamListLV3Bean) mDatas.get(positon);
        if (lists.getId() == 0) {
            tvnon.setVisibility(View.VISIBLE);
            tvname.setVisibility(View.GONE);
            tvnon.setText(R.string.sell_string);
        } else {
            tvname.setText(lists.getNick_name());

            linearbtn.setTag(mDatas.get(positon));
            linearbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (UtilsClicktime.isFastDoubleClick()){
                        return;
                    }
                    SynergicBean.TeamListLV3Bean tag = (SynergicBean.TeamListLV3Bean) v.getTag();
                    if (sellClick != null) {
                        sellClick.selclick(tag);
                    }
                }
            });
        }

    }

    public interface SellClick {
        void selclick(SynergicBean.TeamListLV3Bean listxing);
    }
}
