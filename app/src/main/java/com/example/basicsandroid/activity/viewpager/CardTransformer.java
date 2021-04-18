package com.example.basicsandroid.activity.viewpager;

import android.support.v4.view.ViewPager;

import android.view.View;

public class CardTransformer implements ViewPager.PageTransformer {
//    private static final float MAX_SCALE = 1.2f;
//    private static final float MIN_SCALE = 1.0f;//0.85f
//    private static final float MAX_SCALE = 0.7f;
//    private static final float MIN_SCALE = 0.5f;//0.85f
    //    private static final float MIN_SCALE = 0.70f;
//    private static final float MIN_ALPHA = 0.5f;
//    @Override
//    public void transformPage(View page, float position) {//第一个参数是即将要滑动的View  第二个是前一个为-1  当前为0  后一个为1
//        if (position <= 1) {
//            //   1.2f + (1-1)*(1.2-1.0)
//            float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
//
//            page.setScaleX(scaleFactor);  //按X轴缩放
//
//            if (position > 0) {
//                page.setTranslationX(-scaleFactor * 2);
//            } else if (position < 0) {
//                page.setTranslationX(scaleFactor * 2);
//            }
//            page.setScaleY(scaleFactor);//按Y轴缩放
//        } else {
//
//            page.setScaleX(MIN_SCALE);
//            page.setScaleY(MIN_SCALE);
//        }
//    }

    private static final float MIN_SCALE = 0.70f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) {
            page.setAlpha(MIN_ALPHA);
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        } else if (position <= 1) { // [-1,1]
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            if (position < 0) {
                float scaleX = 1 + 0.3f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);
            } else {
                float scaleX = 1 - 0.3f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);
            }
            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }
    }



}
