package com.example.mvpdemo02.model;

import android.annotation.SuppressLint;
import android.os.Message;

import com.example.mvpdemo02.myview.CallBack;
import com.example.mvpdemo02.utils.NetUtils;
import com.example.mvpdemo02.utils.bean;
import com.google.gson.Gson;

import java.util.logging.Handler;

public class IModelImpl implements IModel{
    private CallBack callBack;

    @SuppressLint("HandlerLeak")
    private android.os.Handler mHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case 0:
                   bean bean = (com.example.mvpdemo02.utils.bean) msg.obj;
                   if (callBack != null){
                       callBack.Onsuccess(bean);
                   }
                   break;
               case 1:
                   break;
               default:
                       break;
           }
        }
    };
    @Override
    public void requestData(final String urlStr, String params, CallBack callBack) {
        this.callBack = callBack;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //执行网络请求
                    String jsonString = NetUtils.getRequest(urlStr);
                    Gson gson = new Gson();
                    bean fromJson = gson.fromJson(jsonString, bean.class);

                    //成功返回数据后，通过handler讲消息回给主线程
                    mHandler.sendMessage(mHandler.obtainMessage(0, fromJson));
                }catch (Exception e){
                    e.printStackTrace();

                }

            }
        }).start();
    }

}
