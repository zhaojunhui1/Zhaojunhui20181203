package com.bwie.zhaojunhui1203;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class TitleName extends LinearLayout {

    Context mContext;

    public TitleName(Context context) {
        super(context);
        mContext = context;
    }

    public TitleName(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View view  = View.inflate(mContext, R.layout.title_name, null);

    }


}
