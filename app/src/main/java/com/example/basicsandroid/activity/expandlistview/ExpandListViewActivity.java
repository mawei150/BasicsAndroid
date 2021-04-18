package com.example.basicsandroid.activity.expandlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;


import com.example.basicsandroid.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExpandListViewActivity extends AppCompatActivity {

    @BindView(R.id.el_list)
    ExpandableListView mElList;


    private List<BeanFirstItemBase> mBeanFirstItemBases = new ArrayList<>();//数据源
    private ExpandableListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        //初始化数据
        BeanFirstItemBase beanFirstItemBase1 = new BeanFirstItemBase();
        beanFirstItemBase1.setName("第一组");
        List<BeanFirstItemBase.BeanSecondItem> beanSecondItems1 = new ArrayList<>();
        //BeanFirstItemBase.BeanSecondItem b=new BeanFirstItemBase.BeanSecondItem("张三");
        beanSecondItems1.add(new BeanFirstItemBase.BeanSecondItem("张三"));
        beanSecondItems1.add(new BeanFirstItemBase.BeanSecondItem("李四"));
        beanSecondItems1.add(new BeanFirstItemBase.BeanSecondItem("王五"));
        beanFirstItemBase1.setBeanSecondItem(beanSecondItems1);


        BeanFirstItemBase beanFirstItemBase2 = new BeanFirstItemBase();
        beanFirstItemBase2.setName("第二组");
        List<BeanFirstItemBase.BeanSecondItem> beanSecondItems2 = new ArrayList<>();
        beanSecondItems2.add(new BeanFirstItemBase.BeanSecondItem("赵六"));
        beanSecondItems2.add(new BeanFirstItemBase.BeanSecondItem("孙七"));
        beanSecondItems2.add(new BeanFirstItemBase.BeanSecondItem("周八"));
        beanFirstItemBase2.setBeanSecondItem(beanSecondItems2);

        BeanFirstItemBase beanFirstItemBase3 = new BeanFirstItemBase();
        beanFirstItemBase3.setName("第三组");
        List<BeanFirstItemBase.BeanSecondItem> beanSecondItems3 = new ArrayList<>();
        beanSecondItems3.add(new BeanFirstItemBase.BeanSecondItem("吴九"));
        beanSecondItems3.add(new BeanFirstItemBase.BeanSecondItem("郑十"));
        beanFirstItemBase3.setBeanSecondItem(beanSecondItems3);

        mBeanFirstItemBases.add(beanFirstItemBase1);
        mBeanFirstItemBases.add(beanFirstItemBase2);
        mBeanFirstItemBases.add(beanFirstItemBase3);

        //上面一系列都是为了获得数据源  都是为了获得数据源


        mAdapter = new ExpandListViewAdapter(mBeanFirstItemBases, ExpandListViewActivity.this);//将数据源传到Adapter中
        mElList.setGroupIndicator(null);//去掉默认左边的图标
        mElList.setAdapter(mAdapter);


        //二级列表的点击事件
        mElList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(ExpandListViewActivity.this, mBeanFirstItemBases.get(groupPosition).getBeanSecondItem().get(childPosition).getName(), Toast.LENGTH_SHORT).show();

                return true;
            }
        });


    }
}
