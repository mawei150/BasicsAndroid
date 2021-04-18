package com.example.basicsandroid.util;


import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * @author MW
 * @date 2019/7/7
 * <p>
 * 描述： 测试异步类AsyncTask
 */

public class MyAsyncTask  extends AsyncTask<Integer,Integer,String> {

    private TextView tvTitle;
    private ProgressBar mProBar;

    public MyAsyncTask(TextView tvTitle, ProgressBar mProBar) {
        this.tvTitle = tvTitle;
        this.mProBar = mProBar;
    }

    @Override
    protected String doInBackground(Integer... integers) {//传来的参数
        DelayOperator delayOperator=new DelayOperator();
        int i=0;
        for(i=10;i<100;i++){
            delayOperator.delay();
            publishProgress(i);
        }
        return  i+integers[0]+"";
    }

    @Override
    protected void onPreExecute() {
        tvTitle.setText("开始执行异步线程");
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        int value= values[0];
        mProBar.setProgress(value);
    }
}
