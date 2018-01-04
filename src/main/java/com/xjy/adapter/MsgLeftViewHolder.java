package com.xjy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xjy.entity.MsgInfo;
import com.xjy.myapplication.R;

/**
 * Created by 徐静钰 on 2017/8/22.
 */
public class MsgLeftViewHolder extends AbstractViewHolder {

    private ImageView iv_left_head;
    private TextView tv_left_msg;

    public MsgLeftViewHolder(View itemView) {
        super(itemView);
        iv_left_head = (ImageView) itemView.findViewById(R.id.iv_left_head);
        tv_left_msg = (TextView) itemView.findViewById(R.id.tv_left_msg);
    }

    @Override
    public void bindViewHolder(MsgInfo info) {
        tv_left_msg.setText(info.getText());
    }
}
