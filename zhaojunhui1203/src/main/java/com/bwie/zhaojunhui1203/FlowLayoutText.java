package com.bwie.zhaojunhui1203;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FlowLayoutText extends LinearLayout {
    //text内容最高的
    private int mChildMaxHeight;
    //每个text的左上间距
    private int mHspace = 20;
    private int mVspace = 20;

    public FlowLayoutText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        //测量子text的宽高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //定义个方法存放最高的text
        findMaxChildHeight();
        //left top初始化
        int left = 0, top = 0;
        int child = getChildCount();
        for (int i = 0; i < child; i++) {
            View view = getChildAt(i);
            if (left != 0){
                //换行
                if ((left + view.getMeasuredWidth()) > sizeWidth){
                    top += mChildMaxHeight + mVspace;
                    left = 0;
                }
            }
            left += view.getMeasuredWidth() + mHspace;
        }
        setMeasuredDimension(sizeWidth, (top + mChildMaxHeight) > sizeHeight ? sizeHeight : top + mChildMaxHeight);

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildHeight();
        //left top初始化
        int left = 0, top = 0;
        int child = getChildCount();
        for (int i = 0; i < child; i++) {
            View view = getChildAt(i);
            if (left != 0){
                //换行
                if ((left + view.getMeasuredWidth()) > getWidth()){
                    top += mChildMaxHeight + mVspace;
                    left = 0;
                }
            }
            //放置text位置
            view.layout(left, top, left + view.getMeasuredWidth(), top + mChildMaxHeight);
            left += view.getMeasuredWidth() + mHspace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //存放text中最高的一个
    private void findMaxChildHeight() {
        mChildMaxHeight = 0;
        int child = getChildCount();
        for (int i = 0; i < child; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredHeight() > mChildMaxHeight){
                mChildMaxHeight = view.getMeasuredHeight();
            }
        }

    }

}
