package com.example.basicsandroid.util;

/**
 * @author MW
 * @date 2019/7/7
 * <p>
 * 描述：定义一个延时操作类
 */

public class DelayOperator {

    public void  delay(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //    @Override
//    public void show() {
//        super.show();
//        /**
//         * 设置宽度全屏，要设置在show的后面
//         */
//        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
//        layoutParams.gravity = Gravity.CENTER;
//        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
//
//        mDialogView.setPadding(0, 0, 0, 0);
//        // getWindow().setWindowAnimations(R.style.ActionSheetDialogAnimation);  //动画  先不加
//     //   getWindow().setBackgroundDrawableResource(android.R.color.white);
//        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        getWindow().setAttributes(layoutParams);
//        getWindow().setDimAmount(0.5f);//设置dialog外部透明
//    }

}
