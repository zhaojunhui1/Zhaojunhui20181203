package com.bwie.zhaojunhui1203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    //获取View
    private void initView() {
        final FlowLayoutText flow_one = findViewById(R.id.flow_one);
        FlowLayoutText flow_two = findViewById(R.id.flow_two);
        FlowLayoutText flow_three = findViewById(R.id.flow_three);

        final TitleChildView titleChildView = findViewById(R.id.title_child_view);
        titleChildView.setOnButtonLinear(new TitleChildView.OnButtonLinear() {
            @Override
            public void OnButtonClick(String str) {
                final TextView textView = new TextView(MainActivity.this);
                textView.setText(str);
                flow_one.addView(textView);

                Dao.getInstance(MainActivity.this).add(str);

                flow_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dao.getInstance(MainActivity.this).delAll();
            }
        });

        for (int i = 0; i < 30; i++) {
            final TextView textView = new TextView(MainActivity.this);
            textView.setText("电动牙刷"+i);
            flow_two.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        for (int i = 0; i < 30; i++) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText("基础护肤"+i);
            flow_three.addView(textView);
        }

    }

}
