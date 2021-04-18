package com.example.basicsandroid.activity.suctiontop;


import android.app.Fragment;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.basicsandroid.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


/**
 * @author MW
 * @date 2020/3/29
 * <p>
 * 描述：研究吸顶
 */

public class SuctionTopActivity extends AppCompatActivity {


    private ViewPager mVpPatient;
    private TabLayout mTbPatient;
    List<Fragment> fragments = new ArrayList<>();
    List<String> strs = new ArrayList<>();
    public AdapterTopPagerNew adapterTopPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suction_top);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
//        mVpPatient = findViewById(R.id.vp_patient);
//        mTbPatient = findViewById(R.id.tb_patient);
//
////        mTbPatient.setTabIndicatorFullWidth(false);
//        fragments.add(new MyPatientListFragment());//我的患者列表
//        fragments.add(new PatientGroupFragment());//患者分组
//
//        mTbPatient.post(new Runnable() {
//            @Override
//            public void run() {
//                TabLayoutUtil.setIndicator(mTbPatient, 50, 50);
//            }
//        });
//
//        strs.add("我的患者");
//        strs.add("患者分组");
//        mTbPatient.setupWithViewPager(mVpPatient);
//        adapterTopPager = new AdapterTopPagerNew(getSupportFragmentManager(), fragments, strs);
//        mVpPatient.setOffscreenPageLimit(2);//预加载
//        mVpPatient.setAdapter(adapterTopPager);
//        setPagerTitle(0, "我的患者");
//        setPagerTitle(1, "患者分组");


    }


    protected void initData() {
//        doGetMyPatientList();
//        mTbPatient.addOnTabSelectedListener(listener);
    }

    private TabLayout.OnTabSelectedListener listener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            //选择的tab
            Log.e("TT", "onTabSelected:" + tab.getText().toString());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            //离开的那个tab
            Log.e("TT", "onTabUnselected" + tab.getText().toString());
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            //再次选择tab
            Log.e("TT", "onTabReselected" + tab.getText().toString());
        }
    };


    public void setPagerTitle(int postion, String title) {

        adapterTopPager.setPageTitle(postion, title);
    }
}
