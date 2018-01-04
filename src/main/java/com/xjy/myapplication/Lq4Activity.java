package com.xjy.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xjy.fragment.Lq41Fragment;
import com.xjy.fragment.Lq42Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 徐静钰 on 2017/9/19.
 */
public class Lq4Activity extends FragmentActivity {
    @butterknife.Bind(R.id.tv_title)
    TextView tvTitle;
    @butterknife.Bind(R.id.line1)
    View line1;
    @butterknife.Bind(R.id.ll1)
    LinearLayout ll1;
    @butterknife.Bind(R.id.line2)
    View line2;
    @butterknife.Bind(R.id.ll2)
    LinearLayout ll2;
    @butterknife.Bind(R.id.vp_rent)
    ViewPager vpRent;

    private LinearLayout[] ll_rent_type;
    private List<Fragment> fragments;
    private int preVpPos = 0;
    private int curVpPos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lq4);
        butterknife.ButterKnife.bind(this);
        fragments = new ArrayList<Fragment>(2);
        Lq41Fragment fragment1 = new Lq41Fragment();
        Lq42Fragment fragment2 = new Lq42Fragment();
        fragments.add(fragment1);
        fragments.add(fragment2);
        ll_rent_type = new LinearLayout[2];
        ll_rent_type[0] = ll1;
        ll_rent_type[1] = ll2;
        ll_rent_type[0].setSelected(true);
        vpRent.setAdapter(new NewsPagerAdapter(getSupportFragmentManager(), fragments));
        vpRent.setOnPageChangeListener(new mOnPageChangeListener());
        vpRent.setCurrentItem(curVpPos);
    }

    private void resetTabLayout() {
        if (curVpPos != preVpPos) {
            ll_rent_type[preVpPos].setSelected(false);
            ll_rent_type[preVpPos].getChildAt(1).setBackgroundColor(getResources().getColor(R.color.white));
            ll_rent_type[curVpPos].setSelected(true);
            ll_rent_type[curVpPos].getChildAt(1).setBackgroundColor(getResources().getColor(R.color.red));
            preVpPos = curVpPos;
        }
    }

    private class mOnPageChangeListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            curVpPos = arg0;
            resetTabLayout();
            vpRent.setCurrentItem(arg0);
        }

    }

    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                curVpPos = 0;
                break;
            case R.id.ll2:
                curVpPos = 1;
                break;
        }
        if (curVpPos != preVpPos) {
            resetTabLayout();
            vpRent.setCurrentItem(curVpPos);
        }
    }
}
