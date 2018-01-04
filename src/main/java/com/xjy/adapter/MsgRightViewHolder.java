package com.xjy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xjy.entity.MsgInfo;
import com.xjy.myapplication.R;

/**
 * Created by 徐静钰 on 2017/8/22.
 */
public class MsgRightViewHolder extends AbstractViewHolder {

    private ImageView iv_right_head;
    private TextView tv_right_msg;

    public MsgRightViewHolder(View itemView) {
        super(itemView);
        iv_right_head = (ImageView) itemView.findViewById(R.id.iv_right_head);
        tv_right_msg = (TextView) itemView.findViewById(R.id.tv_right_msg);
    }

    @Override
    public void bindViewHolder(MsgInfo info) {
        tv_right_msg.setText(info.getText());
    }
}
