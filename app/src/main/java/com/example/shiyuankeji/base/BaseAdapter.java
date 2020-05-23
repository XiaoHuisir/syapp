package com.example.shiyuankeji.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    private OnItemClickListener onItemClickListener;
    protected List<T> mDatas; //列表数据
    protected Context mContext;

    public BaseAdapter(List<T> mDatas){
        this.mDatas = mDatas;
        //设置局部刷新
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(getLayoutId(),viewGroup,false);
        final BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(v,baseViewHolder.getLayoutPosition());
                }
            }
        });
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder viewHolder, int i) {
        T t = mDatas.get(i);
        bindData(viewHolder,i,t);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    /**
     * 刷新数据
     * @param list
     */
    public void refresh(List<T> list){
        this.mDatas.clear();
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     * @param list
     */
    public void addData(List<T> list){
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 添加数据（局部刷新，重写getItemId方法，同时setHasStableIds(true)）
     * @param datas
     */
    public void addDataWithoutAnim(List<T> datas){
        if(datas == null) return;
        int size = datas.size();
        this.mDatas.addAll(datas);
        notifyItemChanged(size,datas.size());
    }


    /**
     * 局部刷新需要实现的方法
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract int getLayoutId();

    protected abstract void bindData(BaseViewHolder holder,int positon,T t);

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 条目点击接口
     */
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder{

        private SparseArray<View> myViewSparseArray;
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            myViewSparseArray = new SparseArray<>();
        }

        public View getView(int id){
            View view = myViewSparseArray.get(id);
            if(view == null){
                view = itemView.findViewById(id);
                myViewSparseArray.put(id,view);
            }
            return view;
        }
    }
}
