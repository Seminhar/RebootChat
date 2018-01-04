package com.xjy.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xjy.entity.MsgInfo;
import com.xjy.myapplication.Mapplication;
import com.xjy.myapplication.R;

import java.util.List;


/**
 * Created by 徐静钰 on 2017/8/22.
 */
public class MsgChatAdapter extends RecyclerView.Adapter<AbstractViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<MsgInfo> infos;

    public MsgChatAdapter(Context context,List<MsgInfo> infos){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.infos = infos;
    }
    @Override
    public AbstractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case Mapplication.MSG_LEFT:
                return new MsgLeftViewHolder(inflater.inflate(R.layout.lv_msg_left_item,null));
            case Mapplication.MSG_RIGHT:
                return new MsgRightViewHolder(inflater.inflate(R.layout.lv_msg_right_item,null));

        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return infos.get(position).getType();
    }

    @Override
    public void onBindViewHolder(AbstractViewHolder holder, int position) {

        holder.bindViewHolder(infos.get(position));
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }
}
