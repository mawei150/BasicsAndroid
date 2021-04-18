package com.example.basicsandroid.util;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.basicsandroid.R;


/**
 * @author MW
 * @date  2019/8/14
 * <p>
 * 描述：分组标签
 */
public class PacketLabelDialog  extends Dialog implements View.OnClickListener {


    private TextView mTvSelect;//确定
    private TextView mTvCancel;//取消
    private EditText mContent;//内容
    private PacketLabelDialogLister mPacketLabelDialogLister;
    private String  content;//内容

    public interface PacketLabelDialogLister {

        void onSelect(String text);//选择

        void onCancel();//取消

    }

    public  PacketLabelDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置Dialog背景透明
        getWindow().setDimAmount(0f);//设置外部Dialog的透明度
        setContentView(R.layout.dialog_packet_label);
        setCanceledOnTouchOutside(true);

        mTvSelect=findViewById(R.id.yes);
        mTvCancel=findViewById(R.id.no);
        mContent=findViewById(R.id.et_content);

        mTvCancel.setOnClickListener(this);
        mTvSelect.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yes:
                if(mPacketLabelDialogLister !=null){
                    content=mContent.getText().toString();
                    mPacketLabelDialogLister.onSelect(content);
                }
                break;
            case R.id.no:
                if(mPacketLabelDialogLister !=null){
                    mPacketLabelDialogLister.onCancel();
                }
                break;
            default:
                break;
        }
    }

    public PacketLabelDialogLister getmPacketLabelDialogLister() {
        return mPacketLabelDialogLister;
    }

    public void setmPacketLabelDialogLister(PacketLabelDialogLister mPacketLabelDialogLister) {
        this.mPacketLabelDialogLister = mPacketLabelDialogLister;
    }
}
