package com.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;


/**
 * Created by wanghy on 2018/5/8.
 */

public class CoverGridView extends GridView  {


    public CoverGridView(Context context){
        super(context);
    }

    public CoverGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CoverGridView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }

    /* 计算控件大小 */
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = measureWidth(widthMeasureSpec);
        int measureHeight = measureHeight(heightMeasureSpec);

        // 计算自定义的ViewGroup中所有子控件的大小
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        // 设置自定义的控件MyViewGroup的大小
        setMeasuredDimension(measureWidth, measureHeight);
    }

    private int measureWidth(int pWidthMeasureSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(pWidthMeasureSpec);// 得到模式
        int width = MeasureSpec.getSize(pWidthMeasureSpec);// 得到尺寸
        switch (mode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result = width;
            break;
        }
        return result;
    }

    private int measureHeight(int pHeigthMeasureSpec){
        int result = 0;
        int mode = MeasureSpec.getMode(pHeigthMeasureSpec);
        int heigth = MeasureSpec.getSize(pHeigthMeasureSpec);
        switch (mode){
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result =heigth;
            break;
        }
        return result;
    }

}
