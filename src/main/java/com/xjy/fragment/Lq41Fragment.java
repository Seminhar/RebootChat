package com.xjy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xjy.myapplication.R;

/**
 * Created by 徐静钰 on 2017/9/19.
 */
public class Lq41Fragment extends Fragment{

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_lq41,null);
        return view;
    }
}
