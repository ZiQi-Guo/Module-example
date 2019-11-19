package com.base;


import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozq
 * @date 2019/7/4 0004下午 16:26
 * @desc
 */
public abstract class BaseAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {

    protected int mLayout;
    protected List<T> list;

    public BaseAdapter(@LayoutRes int layout, List<T> list) {

        this.list = list == null ? new ArrayList<T>() : list;
        if (layout != 0) {
            mLayout = layout;
        }
    }

    @NonNull
    @Override
    public K onCreateViewHolder(@NonNull ViewGroup viewGroup, int layoutId) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, null);
        return (K) new BaseViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
