package com.bwie.zhaojunhui1203;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class TitleChildView extends LinearLayout {

    Context mContext;
    public TitleChildView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TitleChildView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.title_child_view, null);
        final EditText editText = view.findViewById(R.id.edit_name);
        //点击获取搜索框
        view.findViewById(R.id.title_child).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框
                if (mOnButtonLinear != null){
                    mOnButtonLinear.OnButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }

    //定义个接口回调搜索框
    //定义成员
    OnButtonLinear mOnButtonLinear;
    //设置set方法
    public void setOnButtonLinear(OnButtonLinear onButtonLinear){
        mOnButtonLinear = onButtonLinear;
    }
    //接口和方法
    public interface OnButtonLinear{
        void OnButtonClick(String str);
    }


}
