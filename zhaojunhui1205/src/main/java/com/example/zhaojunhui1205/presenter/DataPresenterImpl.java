package com.example.zhaojunhui1205.presenter;

import com.example.zhaojunhui1205.callback.CallBack;
import com.example.zhaojunhui1205.model.IModel;
import com.example.zhaojunhui1205.model.IModelImpl;
import com.example.zhaojunhui1205.view.IView;

public class DataPresenterImpl implements IPresenter {

    private IView mIViewdata;
    private IModelImpl model;

    public DataPresenterImpl(IView mIView) {
        this.mIViewdata = mIView;
        model = new IModelImpl();
    }
    public void login(String username,String pwd){
        model.login(username, pwd, new IModel() {
            @Override
            public void success(Object data) {
                mIViewdata.success(data);
            }
        });
    }

    public void show(){
        model.show(new IModel() {
            @Override
            public void success(Object data) {
                mIViewdata.success(data);
            }

        });
    }


    public void onDetach(){
        if (model!=null){
            model = null;
        }

        if (mIViewdata != null){
            mIViewdata = null;
        }

    }
}
