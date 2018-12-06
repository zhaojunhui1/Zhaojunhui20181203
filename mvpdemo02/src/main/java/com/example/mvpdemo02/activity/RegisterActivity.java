package com.example.mvpdemo02.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mvpdemo02.myview.IViewBack;
import com.example.mvpdemo02.presenter.PresenterImpl;
import com.example.mvpdemo02.utils.NetUtils;
import com.example.mvpdemo02.R;
import com.example.mvpdemo02.utils.bean;

public class RegisterActivity extends AppCompatActivity implements IViewBack, View.OnClickListener {
    private PresenterImpl mPresenter;

    private EditText name, pass;
    private Button goon, back;
    private String username;
    private String password;
   // private String urlStr = "http://120.27.23.105/user/reg?mobile="+username+"&password="+password+"";
    private String urlStr = "http://120.27.23.105/user/reg?mobile=12345678901&password=123456";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mPresenter = new PresenterImpl(this);

        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        back = findViewById(R.id.back);
        goon = findViewById(R.id.goon);

//        username = name.getText().toString();
//        password = pass.getText().toString();

        back.setOnClickListener(this);
        goon.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDetach();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                break;
            case R.id.gone:
                Toast.makeText(RegisterActivity.this, "立即注册", Toast.LENGTH_SHORT).show();
                checkPermission();
                break;
            default:
                break;
        }
    }


    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 100);
            } else {
                startRequest();
            }
        } else {
            startRequest();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //如果requestCode匹配，切权限申请通过
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startRequest();
        }
    }

    /**
     * 调用presenter方法，开始请求数据
     */
    private void startRequest() {
        mPresenter.startRequest(urlStr, null);
    }

    @Override
    public void showResponseData(Object data) {
        bean regBean = (bean) data;

        //Get_Text.setText(String.valueOf(regBean.getData()));
        Toast.makeText(this, String.valueOf(regBean.getData()), Toast.LENGTH_SHORT).show();
    }

}
