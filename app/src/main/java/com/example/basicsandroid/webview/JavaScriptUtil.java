package com.example.basicsandroid.webview;


import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.basicsandroid.MainActivity;

/**
 * @author MW
 * @date 2019/9/2
 * <p>
 * 描述：  js调用原生的工具类
 */
public class JavaScriptUtil {

    private Context mContext;

    public JavaScriptUtil(Context mContext) {
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void receiveByJs(String text, int count) {//receiveByJs 这个方法是接收来自H5的点击事件，同样方法名自定义，但是要和前端商定
        Toast.makeText(mContext, count + text + "", Toast.LENGTH_SHORT).show();//这一句，就是测试从H5页面带来的数据
        mContext.startActivity(new Intent(mContext, MainActivity.class));//Activity跳转
    }
}
