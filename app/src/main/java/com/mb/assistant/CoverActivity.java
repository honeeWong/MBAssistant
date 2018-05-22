package com.mb.assistant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import com.adapter.CoverAdapter;
import com.model.CoverImage;

import java.lang.String;

/**
 * Created by wanghy on 2018/5/8.
 */

public class CoverActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private String IMAGE_ITEM = "imgage_item";
    private String TEXT_ITEM = "text_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cover);
        Toolbar toolbar = (Toolbar) findViewById(R.id.grid_view_all_toolbar);
        toolbar.setTitle("");

        mGridView = (GridView) findViewById(R.id.grid_view);


        CoverAdapter saImageItems = new CoverAdapter(this, mGridView);

        // 设置GridView的adapter。GridView继承于AbsListView。
        mGridView.setAdapter(saImageItems);
        mGridView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

        // 根据元素位置获取对应的值
        CoverImage textView = (CoverImage) adapter.getItemAtPosition(position);
        String itemText = this.getString(textView.getTitle());
        if (this.getString(R.string.role).equals(itemText)) {

            //Toast.makeText(this,"我是"+this.getString(R.string.role),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CoverActivity.this, RoleActivity.class));
        }
        if (this.getString(R.string.attribute_skill).equals(itemText)) {

            //Toast.makeText(this,"我是"+this.getString(R.string.attribute_skill),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CoverActivity.this, PropertyAndSkillActivity.class));
         }
        if (this.getString(R.string.item).equals(itemText)) {

            Toast.makeText(this,"我是"+this.getString(R.string.item),Toast.LENGTH_SHORT).show();
        }
        if (this.getString(R.string.follower).equals(itemText)) {

            Toast.makeText(this,"我是"+this.getString(R.string.follower),Toast.LENGTH_SHORT).show();
        }
        if (this.getString(R.string.country_army).equals(itemText)) {

            Toast.makeText(this,"我是"+this.getString(R.string.country_army),Toast.LENGTH_SHORT).show();
        }
        if (this.getString(R.string.fight).equals(itemText)) {

            Toast.makeText(this,"我是"+this.getString(R.string.fight),Toast.LENGTH_SHORT).show();
        }
        if (this.getString(R.string.quest_honor).equals(itemText)) {

            Toast.makeText(this,"我是"+this.getString(R.string.quest_honor),Toast.LENGTH_SHORT).show();
        }
        if (this.getString(R.string.guide).equals(itemText)) {

            Toast.makeText(this,"我是"+this.getString(R.string.guide),Toast.LENGTH_SHORT).show();
        }
        if (this.getString(R.string.about).equals(itemText)) {

            Toast.makeText(this,"我是"+this.getString(R.string.about),Toast.LENGTH_SHORT).show();
        }


    }

}




