package com.example.basicsandroid.activity.itemtype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.basicsandroid.R;
import com.example.basicsandroid.activity.ManyItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author MW
 * @date 2019/8/2
 * <p>
 * 描述： 一个Adapter实现多个Item
 */
public class ManyItemActivity extends AppCompatActivity {


    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.sideBar)
    WaveSideBar mSideBar;

    private ManyItemAdapter mAdapter;
    private List<BeanItemBase> mItemList = new ArrayList<>();
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_item);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        mItemList.add(new BeanItemBase("张三", 1, "Z"));
        mItemList.add(new BeanItemBase("张三", 1, "Z"));

        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));


        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));
        mItemList.add(new BeanItemBase("李四", 1, "L"));


        mItemList.add(new BeanItemBase("王五", 1, "W"));
        mItemList.add(new BeanItemBase("王五", 1, "W"));
        mItemList.add(new BeanItemBase("王五", 1, "W"));
        mItemList.add(new BeanItemBase("王五", 1, "W"));

        mItemList.add(new BeanItemBase("田六", 1, "T"));
        mItemList.add(new BeanItemBase("田六", 1, "T"));

        mItemList.add(new BeanItemBase("孙七", 1, "S"));

        mItemList.add(new BeanItemBase("孙七", 1, "S"));

        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));
        mItemList.add(new BeanItemBase("马八", 1, "M"));




        mAdapter = new ManyItemAdapter(mItemList, getBaseContext());
        manager = new LinearLayoutManager(getBaseContext());
//        rvList.setLayoutManager(LinearLayoutManager.VERTICAL);//设置线性布局
        rvList.addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL));//分隔线
        rvList.setAdapter(mAdapter);

        mSideBar.setOnTouchLetterChangeListener(new WaveSideBar.OnTouchLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {
                //该字母首次出现的位置
                int position = mAdapter.getPositionForSection(letter.charAt(0));
                if (position != -1) {
//                    manager.scrollToPositionWithOffset(position, 0);
                    ((LinearLayoutManager) rvList.getLayoutManager()).scrollToPositionWithOffset(position, 0);
                }
//                Toast.makeText(getBaseContext(), letter, Toast.LENGTH_LONG).show();
            }
        });


    }


}
