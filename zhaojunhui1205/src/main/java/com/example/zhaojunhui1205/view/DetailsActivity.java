package com.example.zhaojunhui1205.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.zhaojunhui1205.R;
import com.example.zhaojunhui1205.fragment.CallFragment;
import com.example.zhaojunhui1205.fragment.DataFragment;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends FragmentActivity {
    ViewPager pager;
    RadioGroup group;
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        pager = findViewById(R.id.pager);
        group = findViewById(R.id.group);
        fragments = new ArrayList<Fragment>();
        fragments.add(new DataFragment());
        fragments.add(new CallFragment());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }
            @Override
            public void onPageSelected(int i) {
                 switch (i){
                     case 0:
                         group.check(R.id.data);
                         break;
                     case 1:
                         group.check(R.id.call);
                         break;
                     default:
                             break;
                 }
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.data:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.call:
                        pager.setCurrentItem(1);
                        break;
                    default:
                            break;
                }
            }
        });
    }
}
