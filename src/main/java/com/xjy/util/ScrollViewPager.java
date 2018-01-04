package com.xjy.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
/**
 * 解决与ScrollView公用冲突问题
 * @author 徐静钰
 *
 */
public class ScrollViewPager extends ViewPager {

	private int expandSpec;
	private int minHeight;
	public ScrollViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public ScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void setMinHeight(int minHeight){
		 this.minHeight = minHeight;
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int height = 0;
		   for(int i = 0; i < getChildCount(); i++) {
		     View child = getChildAt(i);
		     child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		     int h = child.getMeasuredHeight();
		     if(h > height) height = h;
		   }
		   if (height < minHeight) {
			   
			   height = minHeight;
		   }
		   heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
		   super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
}
