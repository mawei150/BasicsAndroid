package com.example.basicsandroid.activity.Tablayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.basicsandroid.R;
import com.example.basicsandroid.util.FloatViewRatingBarView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.star)
    FloatViewRatingBarView mStar;
    @BindView(R.id.tv_add)
    TextView mTvAdd;

    private float mount = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);

        initView();


    }


    private void initView() {

        mStar.setMark(3.1f);

        mTvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mount = (float) (mount + 0.6);
                mStar.setMark(mount);
            }
        });

    }
}
