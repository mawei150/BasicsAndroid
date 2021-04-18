package com.example.basicsandroid.activity.test;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.example.basicsandroid.R;

public class TestActivity extends AppCompatActivity {

    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        mTvContent = findViewById(R.id.tv_content);
        SpannableString spannableString = new SpannableString("今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错今天天气不错");
//        spannableString.setSpan(new AbsoluteSizeSpan(60), 2, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 2, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#2ac8c2")), 4, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#222222")), 10, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#999999")), 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mTvContent.setText(spannableString);


    }
}
