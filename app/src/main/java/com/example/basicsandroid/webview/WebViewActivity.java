package com.example.basicsandroid.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


import com.example.basicsandroid.R;

import butterknife.ButterKnife;

/**
 * @author MW
 * @date 2019/9/2
 * <p>
 * 描述： webView详解
 */
public class WebViewActivity extends AppCompatActivity {

    //    @Bind(R.id.web_view)
//    WebView webView;
    private JavaScriptUtil mJavaScriptUtil;//Js调用原生的工具类，可以将项目中所有调原生的方法都写在一起  当然这里我们只举一个例子

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);//支持Js
        mJavaScriptUtil = new JavaScriptUtil(WebViewActivity.this);//只是为了将当前Activity的上下文环境，传入工具类，为了在工具类中启动一个Activity(当然这个根据实际情况去加)
        webView.addJavascriptInterface(mJavaScriptUtil, "jsAlias");//这个是上面工具类对象的实例  第二个是在js中调用的别名，这个需要和前端人员商定
        // webView.loadUrl("https://www.baidu.com/");
        webView.loadUrl("file:///android_asset/webview.html");//加载本地url
    }


}
