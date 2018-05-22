package com.mb.assistant;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import com.fragment.RoleCreateSimulatorFragment;
import com.fragment.RoleCreateFragment;
import com.fragment.RoleGrowUpAdviseFragment;

/**
 * Created by wanghy on 2018/5/11.
 */

public class RoleActivity extends  AppCompatActivity {

    private List<TabItem> mTabItemList;
    private TextView tileView;
    private String TAG_ROLECREATE = "Create_role";

    @Override
    protected void onCreate( Bundle savedInstanceState ){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.role);
        Toolbar toolbar = (Toolbar) findViewById(R.id.role_all_toolbar);
        toolbar.setTitle("");
        tileView = (TextView) findViewById(R.id.role_all_toolbar_title);
        initTabData();
        initTabHost();

    }

    private void initTabData() {
        mTabItemList = new ArrayList<>();
        // tabs
        mTabItemList.add(new TabItem(R.drawable.role_create_normal,R.drawable.role_create_select,
                R.string.roleCreate_title,RoleCreateFragment.class));
        mTabItemList.add(new TabItem(R.drawable.role_guide_normal,R.drawable.role_guide_select,
                R.string.roleGrowUp_title,RoleGrowUpAdviseFragment.class));
        mTabItemList.add(new TabItem(R.drawable.role_create_sim_normal,R.drawable.role_create_sim_select,
                R.string.roleSimulator_title,RoleCreateSimulatorFragment.class));
    }

    private void initTabHost() {
        //实例化FragmentTabHost对象
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);

        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        Log.e(TAG_ROLECREATE,"=========size of mTabItemList = "+mTabItemList.size());

        for (int i = 0; i<mTabItemList.size(); i++) {
            TabItem tabItem = mTabItemList.get(i);
            //实例化一个TabSpec,设置tab的名称和视图
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabItem.getTitleString()).setIndicator(tabItem.getView());
            fragmentTabHost.addTab(tabSpec,tabItem.getFragmentClass(),null);

            //给Tab按钮设置背景
            //ragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.main_bottom_bg));

            //默认选中第一个tab
            if(i == 0) {
                tabItem.setChecked(true);
            }
        }

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                //重置Tab样式
                for (int i = 0; i< mTabItemList.size(); i++) {
                    TabItem tabitem = mTabItemList.get(i);
                    if (tabId.equals(tabitem.getTitleString())) {
                        tileView.setText(tabitem.getTitleString());
                        tabitem.setChecked(true);
                    }else {
                        tabitem.setChecked(false);
                    }
                }
            }
        });
    }


    private  class TabItem {
        //正常情况下显示的图片
        private int imageNormal;
        //选中情况下显示的图片
        private int imagePress;
        //tab的名字
        private int title;
        private String titleString;

        //tab对应的fragment
        public Class<? extends Fragment> fragmentClass;

        public View view;
        public ImageView imageView;
        public TextView textView;

        public TabItem(int imageNormal, int imagePress, int title,Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass =fragmentClass;
        }

        public Class<? extends  Fragment> getFragmentClass() {
            return fragmentClass;
        }
        public int getImageNormal() {
            return imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public int getTitle() {
            return  title;
        }

        public String getTitleString() {
            if (title == 0) {
                return "";
            }
            if(TextUtils.isEmpty(titleString)) {
                titleString = getString(title);
            }
            return titleString;
        }

        public View getView() {
            if(this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.tab_host_item, null);
                this.imageView = (ImageView) this.view.findViewById(R.id.tab_iv_image);
                this.textView = (TextView) this.view.findViewById(R.id.tab_tv_text);
                if(this.title == 0) {
                    this.textView.setVisibility(View.GONE);
                } else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }
                this.imageView.setImageResource(imageNormal);
            }
            return this.view;
        }

        //切换tab的方法
        public void setChecked(boolean isChecked) {
            if(imageView != null) {
                if(isChecked) {
                    imageView.setImageResource(imagePress);
                }else {
                    imageView.setImageResource(imageNormal);
                }
            }
            if(textView != null && title != 0) {
                if(isChecked) {
                    textView.setTextColor(getResources().getColor(R.color.role_bottom_text_select));
                } else {
                    textView.setTextColor(getResources().getColor(R.color.role_bottom_text_normal));
                }
            }
        }
    }


}
