package com.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mb.assistant.R;

import com.adapter.ViewPagerFragmentAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghy on 2018/5/18.
 */

public class RoleCreateFragment extends Fragment {

    private View viewContent;
    private List<View> viewList = new ArrayList<>();
    private TabLayout tab_essence;
    private ViewPager vp_essence;
    private String TAG_ROLE_CREATE_FRAGMENT = "Role Create Fragment";

    private int[] create_title_msg = new int[]{

            R.string.roleCreate_init_msg,R.string.roleCreate_gender_msg,
            R.string.roleCreate_father,R.string.roleCreate_young,
            R.string.roleCreate_once,R.string.roleCreate_whyHere
    };

    private int[] create_title_context = new int[] {

            R.array.list_roleCreate_init_value,R.array.list_roleCreate_gender_effect_property,
            R.array.list_roleCreate_father_effect,R.array.list_roleCreate_young,
            R.array.list_roleCreate_once,R.array.list_roleCreate_whyHere
    };


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        if( viewContent == null ) {

            Log.d(TAG_ROLE_CREATE_FRAGMENT,"create views and init ！！！！");
            viewContent = inflater.inflate(R.layout.role_create_fragment, container, false);
            // all text view
            setupPageView(inflater);
            initData();
            initContentView();
        }
        return viewContent;

    }


    private void setupPageView(LayoutInflater inflater){

       for(int i = 0; i < create_title_msg.length ; i++){

           viewList.add(initPageView(inflater,getResources().getString(create_title_msg[i]),
                   getResources().getStringArray(create_title_context[i])));
       }

    }







    private View initPageView(LayoutInflater inflater,String title,String[] context){

        // init 页面布局
        View view= inflater.inflate(R.layout.role_create_init, null);

        LinearLayout initLayout = (LinearLayout)view.findViewById(R.id.layout_role_create_fragment_viewPager);

        // add TextViews
        TextView tv_initmsg= new TextView(inflater.getContext());
        tv_initmsg.setText(title);
        tv_initmsg.setTextColor(getResources().getColor(R.color.colorRoleTabText));
        tv_initmsg.setPadding(15,15,5,0);
        initLayout.addView(tv_initmsg);
        /*
        View line = new View(inflater.getContext());
        view.setBackgroundColor(getResources().getColor(R.color.colorRoleBackground));
        initLayout.addView(line);

        LinearLayout.LayoutParams lp = new  LinearLayout.LayoutParams(line.getLayoutParams());
        lp.height = 3;
        line.setLayoutParams(lp);
        */
        for (int i = 0; i < context.length;i++)
        {
            TextView tmp = new TextView(inflater.getContext());
            tmp.setText(context[i]);
            tmp.setTextColor(getResources().getColor(R.color.colorRoleTabText));
            tmp.setPadding(15,15,15,0);
            tmp.setTextSize(14);
            TextPaint paint = tmp.getPaint();
            paint.setFakeBoldText(true);
            initLayout.addView(tmp);
        }
        return  view;
    }





    private void initData() {
        this.tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }

    private void initContentView() {
        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.list_createRole);

        //创建一个viewpager的adapter
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(viewList, Arrays.asList(titles));
        this.vp_essence.setAdapter(adapter);

        //将TabLayout和ViewPager关联起来
        this.tab_essence.setupWithViewPager(this.vp_essence);
    }


}
