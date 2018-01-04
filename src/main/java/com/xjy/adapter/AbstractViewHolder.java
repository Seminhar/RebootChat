package com.xjy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xjy.entity.MsgInfo;

/**
 * Created by 徐静钰 on 2017/8/22.
 */
public abstract class AbstractViewHolder extends RecyclerView.ViewHolder {
    public AbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(MsgInfo info);
}
