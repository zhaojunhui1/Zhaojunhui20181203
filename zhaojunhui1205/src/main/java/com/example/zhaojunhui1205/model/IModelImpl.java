package com.example.zhaojunhui1205.model;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.example.zhaojunhui1205.bean.UserBean;
import com.example.zhaojunhui1205.callback.CallBack;
import com.example.zhaojunhui1205.utils.HttpUtils;
import com.example.zhaojunhui1205.bean.VideoBean;
import com.google.gson.Gson;

public class IModelImpl {

    public void login(String username, String pwd, final IModel iModel){
        HttpUtils.getRequest("http://www.xieast.com/api/user/login.php?username="+username+"&password="+pwd,
                UserBean.class, new HttpUtils.CallBack<UserBean>() {
                    @Override
                    public void getdata(UserBean userBean) {
                        int code = userBean.getCode();
                        if(code==100){
                            iModel.success(userBean.getMsg());
                        }else if(code==101){
                            iModel.success(userBean.getMsg());
                        }else if(code==102){
                            iModel.success(userBean.getMsg());
                        }else if(code==103){
                            iModel.success(userBean.getMsg());
                        }
                    }
                });
    }

    public void show(final IModel iModel){
        HttpUtils.getRequest("http://www.xieast.com/api/news/news.php",
                VideoBean.class, new HttpUtils.CallBack<VideoBean>() {
                    @Override
                    public void getdata(VideoBean newsBean) {
                        iModel.success(newsBean);
                    }

                });
    }
}
