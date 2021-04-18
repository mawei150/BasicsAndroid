package com.example.basicsandroid.util;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author MW
 * @date  2019/8/19
 * <p>
 * 描述： 自定义线性布局
 */
public class CustomLinearLayout extends LinearLayout {


    public boolean mIsIntercept=false;//是否拦截子项点击事件 默认不拦截

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return mIsIntercept;
    }




    public boolean ismIsIntercept() {
        return mIsIntercept;
    }

    public void setmIsIntercept(boolean mIsIntercept) {
        this.mIsIntercept = mIsIntercept;
    }
}
