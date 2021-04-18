package com.example.basicsandroid.util;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.basicsandroid.R;

/**
 * @author MW
 * @date 2019/7/1
 * <p>
 * 描述： 圆形进度条
 */
public class CirclePrBar extends View {

    private Paint mBackPaint;//背景的画笔
    private Paint mFrontPaint;//颜色的画笔
    private Paint mRedFrontPaint;//红颜色的画笔
    private Paint mTextPaint;//中间字体的画笔
    private float mStrokeWidth = 10;//画笔的粗细
    private float mRadius;//应该是40dp
    private RectF mRect;
    private int mProgress = 0;
    private int mFontSize;//字体大小
    private float mHalfStrokeWidth = mStrokeWidth / 2;
    //目标值，想改多少就改多少
    private int mTargetProgress;
    private int mMax = 1000;
    private int mWidth;
    private int mHeight;

    public CirclePrBar(Context context) {
        super(context);
        initView();
    }

    public CirclePrBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CirclePrBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    //初始化haul画笔
    private void initView() {
        //dp转px
        mFontSize=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getContext().getResources().getDisplayMetrics());
        mRadius=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getContext().getResources().getDisplayMetrics());


        //画布的
        mBackPaint = new Paint();//画笔
        mBackPaint.setColor(getResources().getColor(R.color.backgroudring));//颜色
        mBackPaint.setAntiAlias(true);//抗锯齿
        mBackPaint.setStyle(Paint.Style.STROKE);
        mBackPaint.setStrokeWidth(mStrokeWidth);//画笔的宽度


        mFrontPaint = new Paint();
        mFrontPaint.setColor(getResources().getColor(R.color.paint1));
        mFrontPaint.setAntiAlias(true);
        mFrontPaint.setStyle(Paint.Style.STROKE);
        mFrontPaint.setStrokeWidth(mStrokeWidth);


        mRedFrontPaint = new Paint();//报红画笔
        mRedFrontPaint.setColor(getResources().getColor(R.color.red));
        mRedFrontPaint.setAntiAlias(true);
        mRedFrontPaint.setStyle(Paint.Style.STROKE);
        mRedFrontPaint.setStrokeWidth(mStrokeWidth);


        mTextPaint = new Paint();//字体画笔
        mTextPaint.setColor(Color.GREEN);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mFontSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);




    }

    //重写测量大小的onMeasure方法和绘制View的核心方法onDraw()
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getRealSize(widthMeasureSpec);
        mHeight = getRealSize(heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);//表示自定义的宽度  长度
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initRect();//设置位置
        canvas.drawCircle(mWidth / 2, mHeight / 2, mRadius, mBackPaint);//画布
        //1.小于-1000   2.大于-1000 小于-500   3.大于0 小于-500   4.大于0小于500  5.大于500小于1000  6.大于1000
        canvas.drawText(mTargetProgress + "", mWidth / 2 + mHalfStrokeWidth, mHeight / 2 + mHalfStrokeWidth, mTextPaint);
        canvas.drawText("ml", mWidth / 2 + mHalfStrokeWidth, mHeight / 2 + mHalfStrokeWidth+mFontSize, mTextPaint);

        if(-1000<mTargetProgress && mTargetProgress<=-500){//逆时针报红
            mTargetProgress=-mTargetProgress;//变成正数
            float angle = mTargetProgress / (float) mMax * 360;
            canvas.drawArc(mRect, -270, angle, false, mRedFrontPaint);

        }else if(-500<mTargetProgress && mTargetProgress<=0){//逆时针正常
            mTargetProgress=-mTargetProgress;//变成正数
            float angle = mTargetProgress / (float) mMax * 360;
            canvas.drawArc(mRect, -270, angle, false, mFrontPaint);

        }else if(0<mTargetProgress && mTargetProgress<500){//顺时针正常
            float angle = mTargetProgress / (float) mMax * 360;
            canvas.drawArc(mRect, -90, angle, false, mFrontPaint);
        }else if(500<=mTargetProgress && mTargetProgress<1000){//顺时针报红
            float angle = mTargetProgress / (float) mMax * 360;
            canvas.drawArc(mRect, -90, angle, false, mRedFrontPaint);
        }else{//小于-1000   大于1000  全部报红
            if(mTargetProgress<0){
                mTargetProgress=-mTargetProgress;//变成正数
            }
            canvas.drawArc(mRect, -270, 360, false, mRedFrontPaint);
        }

     /*   if (mProgress < mTargetProgress) {
            mProgress += 1;
            invalidate();//刷新View
        }*/

    }


    //设置圆该所在的位置
    private void initRect() {
        if (mRect == null) {
            mRect = new RectF();
            int viewSize = (int) (mRadius * 2);
            int left = (mWidth - viewSize) / 2;
            int top = (mHeight - viewSize) / 2;
            int right = left + viewSize;
            int bottom = top + viewSize;
            mRect.set(left, top, right, bottom);
        }
    }

    public int getRealSize(int measureSpec) {
        int result = 1;
        int mode = MeasureSpec.getMode(measureSpec);//获得测量模式
        int size = MeasureSpec.getSize(measureSpec);//获得大小

        if (mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED) {
            //自己计算
            result = (int) (mRadius * 2 + mStrokeWidth);
        } else {//固定尺寸
            result = size;
        }

        return result;
    }


    public int getmTargetProgress() {
        return mTargetProgress;
    }

    public void setmTargetProgress(int mTargetProgress) {
        this.mTargetProgress = mTargetProgress;
        //dp 转px
    }
}
