package com.example.basicsandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.basicsandroid.activity.Tablayout.TabLayoutActivity;
import com.example.basicsandroid.activity.chart.PiePolylineChartActivity;
import com.example.basicsandroid.activity.suctiontop.SuctionTopActivity;
import com.example.basicsandroid.activity.test.Test2Activity;
import com.example.basicsandroid.activity.test.TestActivity;
import com.example.basicsandroid.activity.viewpager.BannerActivity;
import com.example.basicsandroid.bean.BeanUsername;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author MW
 * @date 2019/6/29
 * <p>
 * 描述： 重新学习基础
 *
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_name_test)
    TextView mTvNameTest;


    //    @BindView(R.id.tv_dialog)
//    TextView mTvDialog;
//  public   int arr[] = new int[]{1, 3, 5, 7, 9, 10,18};//有序的数据  这里我们声明是递增的

    private BeanUsername beanUsername;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }


    private void initView() {
//        BinarySearch(arr,10);
        mTvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BannerActivity.class));
            }
        });


    }

}
