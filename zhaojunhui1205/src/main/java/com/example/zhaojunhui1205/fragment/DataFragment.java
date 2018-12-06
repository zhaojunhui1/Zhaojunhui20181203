package com.example.zhaojunhui1205.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhaojunhui1205.R;
import com.example.zhaojunhui1205.adapter.DataAdapter;
import com.example.zhaojunhui1205.presenter.DataPresenterImpl;
import com.example.zhaojunhui1205.bean.VideoBean;
import com.example.zhaojunhui1205.view.IView;

public class DataFragment extends Fragment implements IView {
    private DataPresenterImpl mPresenter;
    private ListView listView;
    private DataAdapter mAdapter;
    private VideoBean videoBean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.datafragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new DataPresenterImpl(this);
        listView = view.findViewById(R.id.listView);

        mAdapter = new DataAdapter(getActivity());
        listView.setAdapter(mAdapter);

        mPresenter.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.onDetach();
        }
    }

    @Override
    public void success(Object data) {
        videoBean = (VideoBean) data;
        mAdapter.setDatas(videoBean.getData());
        Toast.makeText(getActivity(), videoBean.getData()+"",Toast.LENGTH_SHORT).show();
    }
}
