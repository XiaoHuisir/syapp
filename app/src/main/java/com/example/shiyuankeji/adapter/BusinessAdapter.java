package com.example.shiyuankeji.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseAdapter;
import com.example.shiyuankeji.bean.SynergicBean;
import com.example.shiyuankeji.utils.UtilsClicktime;

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
        TextView tvnon = (TextView) holder.getView(R.id.tv_non);
        LinearLayout linearbtn = (LinearLayout) holder.getView(R.id.linear_btn);
        SynergicBean.TeamListLV2Bean lists = (SynergicBean.TeamListLV2Bean) mDatas.get(positon);
        int id = lists.getId();
        if (id==0){
            tvnon.setVisibility(View.VISIBLE);
            tvname.setVisibility(View.GONE);
            tvnon.setText("你还没拥有商务拼团，请继续努力！");
        }else {
        tvname.setText(lists.getNick_name());
            linearbtn.setTag(mDatas.get(positon));
            linearbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (UtilsClicktime.isFastDoubleClick()){
                        return;
                    }
                    SynergicBean.TeamListLV2Bean tag = (SynergicBean.TeamListLV2Bean) v.getTag();
                    if (busitemClick != null) {
                        busitemClick.busclick(tag);
                    }
                }
            });
        }


    }

    public interface BusinesClick {
        void busclick(SynergicBean.TeamListLV2Bean listxing);
    }
}
