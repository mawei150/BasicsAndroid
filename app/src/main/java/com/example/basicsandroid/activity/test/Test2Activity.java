package com.example.basicsandroid.activity.test;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.basicsandroid.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test2Activity extends AppCompatActivity {

    @BindView(R.id.rv_count_list)
    RecyclerView mRvCountList;
    @BindView(R.id.tv_all_irrigation_volume)
    TextView mTvAllIrrigationVolume;

    private List<BeanLabelBase> mCountBeanLabelList = new ArrayList<>();
    private String discountStr;
    private PeritonealCountAdapter mPeritonealCountAdapter;
    private EditText mEtCount;
    private final int RC_SEARCH = 1;
    private final int INTERVAL = 600; //输入时间间隔为1000毫秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {


        mEtCount = findViewById(R.id.et_count);
        mRvCountList.setNestedScrollingEnabled(false);
        mRvCountList.setLayoutManager(new LinearLayoutManager(Test2Activity.this, LinearLayoutManager.VERTICAL, false));
        mPeritonealCountAdapter = new PeritonealCountAdapter(R.layout.item_peritoneal_count_list, mCountBeanLabelList);
        mRvCountList.setAdapter(mPeritonealCountAdapter);


        //腹透次数监听
        mEtCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String trim = s.toString().trim();
                if ("0".equals(trim)) {
                    mEtCount.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (mHandler.hasMessages(RC_SEARCH)) {//检查消息队列中是否有包含what属性为指定值的消息。
                    mHandler.removeMessages(RC_SEARCH);
                }
                mHandler.sendEmptyMessageDelayed(RC_SEARCH, INTERVAL);//在一定时间内发送消息。

            }

        });


        mPeritonealCountAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                BeanLabelBase beanLabelBase = mCountBeanLabelList.get(position);
                if (beanLabelBase == null) {
                    return;
                }

                switch (view.getId()) {
                    case R.id.tv_concentration://选择
                        String trim = beanLabelBase.getConcentration();

                        mCountBeanLabelList.get(position).setConcentration(position + "小样");

                        mPeritonealCountAdapter.notifyItemChanged(position);
                        break;
                    default:
                        break;
                }
            }
        });


    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == RC_SEARCH) {
                handlerSearch();
            }
        }

    };

    //每次对数据源的处理
    private void handlerSearch() {
        String trim = mEtCount.getText().toString().trim();

        if (!TextUtils.isEmpty(trim)) {
            int count = Integer.parseInt(trim);
            if (mCountBeanLabelList.size() == 0) {
                mCountBeanLabelList.add(new BeanLabelBase("换液", "浓度", "灌入量(ml)", "留存时间(小时)"));
            }
            if (mCountBeanLabelList.size() < count + 1) {
                for (int i = mCountBeanLabelList.size(); i < count + 1; i++) {
                    mCountBeanLabelList.add(new BeanLabelBase("第" + (i) + "次"));
                }
            } else {//移除后面项
                for (int i = 0; i < mCountBeanLabelList.size(); i++) {
                    if (i > count) {
                        mCountBeanLabelList.remove(i);
                        i--;
                    }
                }

//                List<BeanLabelBase> beanLabelBaseList = new ArrayList<>();
//                for (int i = 0; i < mCountBeanLabelList.size(); i++) {
//                    if (i < count+1) {
//                        beanLabelBaseList.add(new BeanLabelBase(mCountBeanLabelList.get(i).getName(),
//                                mCountBeanLabelList.get(i).getConcentration(), mCountBeanLabelList.get(i).getIrrigationVolume(), mCountBeanLabelList.get(i).getRetentionTime()));
//                    }
//                }
//                mCountBeanLabelList.clear();
//                mCountBeanLabelList.addAll(beanLabelBaseList);
            }

            setChanges();
            mPeritonealCountAdapter.setNewData(mCountBeanLabelList);
        }

    }

    private static final int DECIMAL_DIGITS = 1;//小数的位数

    private class PeritonealCountAdapter extends BaseQuickAdapter<BeanLabelBase, BaseViewHolder> {

        public PeritonealCountAdapter(int layoutResId, @Nullable List<BeanLabelBase> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(final BaseViewHolder helper, BeanLabelBase item) {
            helper.addOnClickListener(R.id.tv_concentration);
            final EditText et_volume = helper.getView(R.id.et_volume);
            final EditText et_hour = helper.getView(R.id.et_hour);
            TextView tv_count = helper.getView(R.id.tv_count);
            TextView tv_concentration = helper.getView(R.id.tv_concentration);


            helper.setText(R.id.tv_count, item.getName());//次数
            helper.setText(R.id.tv_concentration, item.getConcentration());
            helper.setText(R.id.et_volume, item.getIrrigationVolume());
            helper.setText(R.id.et_hour, item.getRetentionTime());

            if ("换液".equals(item.getName())) {
                tv_count.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                tv_concentration.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                et_hour.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                et_volume.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                et_hour.setKeyListener(null);
                et_volume.setKeyListener(null);

            } else {//只改变一次  不能每次都改变
//                if (helper.getAdapterPosition() == 1) {
                tv_count.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tv_concentration.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                et_hour.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                et_volume.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                }

                et_hour.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        discountStr = s.toString();
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        String trim = s.toString().trim();
//                        if (!TextUtils.isEmpty(trim)) {
//                            Double currentInput = 0.0;
//                            if (trim.contains(".")) {
//                                String[] split = trim.split("\\.");
//                                if (split.length > 1) {
//                                    String s1 = split[1];
//                                    if (!TextUtils.isEmpty(s1)) {
//                                        if (s1.length() == 2) {
//                                            et_hour.setText(discountStr);
//                                            try {
//                                                String trim1 = et_hour.getText().toString().trim();
//                                                et_hour.setSelection(trim1.length());//设置光标所在位置
//                                            } catch (Exception e) {
//                                                e.printStackTrace();
//                                            }
//                                            return;
//                                        }
//                                    }
//                                }
//                            }
//
//
//                        }

                        if (s.toString().contains(".")) {
                            if (s.length() - 1 - s.toString().indexOf(".") > DECIMAL_DIGITS) {
                                s = s.toString().subSequence(0,
                                        s.toString().indexOf(".") + DECIMAL_DIGITS+1);
                                et_hour.setText(s);
                                et_hour.setSelection(s.length());
                            }
                        }
                        if (s.toString().trim().substring(0).equals(".")) {
                            s = "0" + s;
                            et_hour.setText(s);
                            et_hour.setSelection(2);
                        }
                        if (s.toString().startsWith("0")
                                && s.toString().trim().length() > 1) {
                            if (!s.toString().substring(1, 2).equals(".")) {
                                et_hour.setText(s.subSequence(0, 1));
                                et_hour.setSelection(1);
                                return;
                            }
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (TextUtils.isEmpty(s)) {
                            return;
                        }

                        if (!s.toString().equals(mCountBeanLabelList.get(helper.getAdapterPosition()).getRetentionTime())) {
                            mCountBeanLabelList.get(helper.getAdapterPosition()).setRetentionTime(s.toString());
                        }
                        mCountBeanLabelList.get(helper.getAdapterPosition()).setRetentionTime(s.toString());
                        setChanges();
                    }
                });

                //灌入量的监听事件
                et_volume.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (TextUtils.isEmpty(s)) {
                            return;
                        }
                        mCountBeanLabelList.get(helper.getAdapterPosition()).setIrrigationVolume(s.toString());
                        setChanges();
                    }
                });


            }
        }

    }


    //记录 总灌入量的数值
    private void setChanges() {
        if (mCountBeanLabelList.size() == 0) {
            mTvAllIrrigationVolume.setVisibility(View.GONE);
        } else {
            mTvAllIrrigationVolume.setVisibility(View.VISIBLE);
        }
        int allCount = 0;
        for (int i = 1; i < mCountBeanLabelList.size(); i++) {
            int count = 0;
            if (!TextUtils.isEmpty(mCountBeanLabelList.get(i).getIrrigationVolume())) {
                count = Integer.parseInt(mCountBeanLabelList.get(i).getIrrigationVolume());
            }
            allCount += count;
        }
        mTvAllIrrigationVolume.setText("总灌入量: " + allCount + "ml");


//        //还要记录现在是否满足 设置为在用处方条件
//        String count = mTvCount.getText().toString().trim();
//        if (TextUtils.isEmpty(count)) {
//            mTvSend.setSelected(true);
//        } else {
//            boolean isDisplay = false;
//            for (int i = 1; i < mCountBeanLabelList.size(); i++) {
//                if (TextUtils.isEmpty(mCountBeanLabelList.get(i).getConcentration()) || TextUtils.isEmpty(mCountBeanLabelList.get(i).getIrrigationVolume())
//                        || TextUtils.isEmpty(mCountBeanLabelList.get(i).getRetentionTime())) {
//                    isDisplay = true;
//                    break;
//                }
//            }
//            mTvSend.setSelected(isDisplay);
//        }


    }
}
