package com.example.mvpdemo02.model;

import com.example.mvpdemo02.myview.CallBack;

public interface IModel {
    void requestData(String urlStr, String params, CallBack callBack);
}
