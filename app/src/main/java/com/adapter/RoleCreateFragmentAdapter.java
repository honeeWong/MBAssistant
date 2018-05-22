package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mb.assistant.R;
import com.model.RoleCreateText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghy on 2018/5/19.
 */

public class RoleCreateFragmentAdapter extends BaseAdapter {

    private Context context;
    private List<RoleCreateText> RoleCreateText = new ArrayList<>();


    public RoleCreateFragmentAdapter(Context context, List<RoleCreateText> RoleCreateText){

        this.RoleCreateText = RoleCreateText;
        this.context = context;
    }


    @Override
    public int getCount(){

        return RoleCreateText.size();
    }

    @Override
    public Object getItem(int position) {

        return RoleCreateText.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder hodler;

        if(convertView == null){

            hodler = new Holder();

            convertView = LayoutInflater.from(context).inflate(R.layout.role_create_text_item, null);

            hodler.tv = (TextView) convertView.findViewById(R.id.role_create_text_title);
            hodler.tv.setText(RoleCreateText.get(position).getTitle());

            String[] array = RoleCreateText.get(position).getListText();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,array);
            hodler.lv = (ListView) convertView.findViewById(R.id.role_create_text_list_view);
            hodler.lv.setAdapter(adapter);
            convertView.setTag(hodler);
        }
        return convertView;
    }

    class Holder {

        TextView tv;
        ListView lv;
    }


}
