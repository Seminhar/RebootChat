package com.xjy.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class NewsPagerAdapter extends FragmentPagerAdapter {
	
	private FragmentManager fm;
	private List<Fragment> fragments;
	
	public NewsPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.fm = fm;
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}}
