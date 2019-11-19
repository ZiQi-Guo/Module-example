package com.base;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * @author guozq
 * @date 2019/7/4 0004下午 16:30
 * @desc
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    View itemView;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public  <T extends View> T getView(@IdRes int id) {
        return itemView.findViewById(id);
    }

    public void setText(@IdRes int id, CharSequence text) {
        View view = getView(id);
        if (view instanceof TextView) {
            ((TextView) view).setText(text);
        } else {
            throw new ClassCastException();
        }
    }

    public void addOnClickListener(@IdRes int id, View.OnClickListener onClickListener) {
        View view = getView(id);
        view.setOnClickListener(onClickListener);
    }

}
