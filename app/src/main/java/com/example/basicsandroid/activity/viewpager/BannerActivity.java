package com.example.basicsandroid.activity.viewpager;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.basicsandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author MW
 * @date 2021/4/18
 * <p>
 * 描述：轮播图
 */

public class BannerActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.indicator_line)
    ViewPagerIndicator mIndicatorLine;

    private TimeCount time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);
        initView();

    }

    private BannerAdapter mBannerAdapter;


    public void initView() {


        initFirstBanner();
//        initSecondBanner();
    }


    private void initFirstBanner() {

        time = new TimeCount(3000, 1000);   //3秒倒计时


        mBannerAdapter = new BannerAdapter(this, mViewpager);
        mViewpager.setAdapter(mBannerAdapter);
        mViewpager.setOffscreenPageLimit(2);//预加载2个
//        mViewpager.setPageMargin(30);//设置viewpage之间的间距
//        mViewpager.setClipChildren(false);
        mViewpager.setPageTransformer(true, new CardTransformer());
        mIndicatorLine.setViewPager(mViewpager, 6);
        mBannerAdapter.setItemClickListener(new BannerAdapter.ItemClickListener() {

            @Override
            public void onItemClick(int index) {
//                ToastUtils.showToast("点击了图片" + index);
            }
        });
        mViewpager.setCurrentItem(0);


        //触摸的时候停止定时器，松开就开始计时
        mViewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    time.start();
                } else {
                    time.cancel();
                }
                return false;
            }
        });
        time.start();
    }

    Handler handler = new Handler() {    //时间到就自动进行轮播
        @Override
        public void handleMessage(Message msg) {
            mViewpager.setCurrentItem(mViewpager.getCurrentItem() + 1);
            time.start();
        }
    };


    /* 定义一个倒计时的内部类 */
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {// 计时完毕时触发
            time.cancel();
            handler.sendEmptyMessage(0);   //简单发了个消息过去
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程显示
        }

    }


}
