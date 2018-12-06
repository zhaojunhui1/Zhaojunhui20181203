package com.example.mvpdemo02.presenter;

import com.example.mvpdemo02.model.IModel;
import com.example.mvpdemo02.model.IModelImpl;
import com.example.mvpdemo02.myview.CallBack;
import com.example.mvpdemo02.myview.IViewBack;

public class PresenterImpl implements LogPresenter {
    private IModelImpl model;
    private IViewBack iViewBack;

    public PresenterImpl(IViewBack iViewBack) {
        this.iViewBack = iViewBack;
        model = new IModelImpl();
    }

    @Override
    public void startRequest(String urlStr, String params) {
         model.requestData(urlStr, params, new CallBack() {
             @Override
             public void Onsuccess(Object data) {
                 iViewBack.showResponseData(data);
             }
         });
    }
    public void onDetach(){
        if (model != null){
            model = null;
        }
        if (iViewBack != null){
            iViewBack = null;
        }
    }

}
