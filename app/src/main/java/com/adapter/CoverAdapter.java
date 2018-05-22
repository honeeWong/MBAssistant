package com.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.model.CoverImage;
import com.mb.assistant.R;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by wanghy on 2018/5/8.
 */

public class CoverAdapter extends BaseAdapter {

    private Context contx;
    private GridView gridV;
    private List<CoverImage> CoverImages;
    private static int ROW_NUMBER = 3 ;


    /*  资源：标题和图片 */

    private int[] titles = new int[] {
            R.string.role,R.string.attribute_skill,R.string.item,
            R.string.follower,R.string.country_army,R.string.fight,
            R.string.quest_honor,R.string.guide,R.string.about
    };

    private int[] images = new int[]{
            R.drawable.cover_role,R.drawable.cover_skills,R.drawable.cover_item,
            R.drawable.cover_follower,R.drawable.cover_countrys,R.drawable.cover_battle,
            R.drawable.cover_quest,R.drawable.cover_notes,R.drawable.cover_about
    };

    public CoverAdapter(Context context, GridView gv) {
        this.contx = context;
        this.gridV =gv;
        CoverImages = new ArrayList<>();
        for (int i = 0; i < 3*ROW_NUMBER; i++) {
            CoverImage cI = new CoverImage(titles[i], images[i]);
            CoverImages.add(cI);
        }
    }

    @Override
    public int getCount() {
        if (null != CoverImages) {
            return CoverImages.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return CoverImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(contx).inflate(R.layout.cover_item, null);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv_item);
            //设置显示图片
            holder.iv.setBackgroundResource(images[position]);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_item);
            //设置标题
            holder.tv.setText(titles[position]);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        //高度计算
        AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                gridV.getHeight() / ROW_NUMBER);

        convertView.setLayoutParams(param);
        return convertView;
    }

    class Holder {
        ImageView iv;
        TextView tv;
    }

}
