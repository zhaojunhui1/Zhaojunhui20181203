package com.example.mvpdemo02.presenter;

import android.text.TextUtils;

import com.example.mvpdemo02.utils.NetUtils;
import com.example.mvpdemo02.utils.bean;
import com.example.mvpdemo02.myview.IViewBack;

public interface LogPresenter {
    void startRequest(String urlStr, String params);
}
