package com.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wanghy on 2018/5/12.
 */

public class ViewPagerFragmentAdapter extends PagerAdapter {
    // viewPager 填充的视图
    private List<View> views;
    // tab 导航内容
    private List<String> tabStrs;

    private String TAG_PAGE_ADAPTER = "PagerAdapter";

    public ViewPagerFragmentAdapter(List<View> views, List<String> tabStr)
    {
        this.views = views;
        this.tabStrs = tabStr;
        Log.e(TAG_PAGE_ADAPTER,"SIZE OF views "+ views.size()+ "size of tabstr = "+tabStr.size());

    }

    @Override
    public int getCount(){
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view,Object obj){
        return view == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
    //    这个是和tablelayout相关的
    @Override
    public CharSequence getPageTitle(int position) {
        if(position >= this.tabStrs.size() ) {
            Log.e(TAG_PAGE_ADAPTER,"out of views");
        }
        else {
            Log.e(TAG_PAGE_ADAPTER, "position == " + position);
            return tabStrs.get(position);
        }
        return  tabStrs.get(0);
    }
}
