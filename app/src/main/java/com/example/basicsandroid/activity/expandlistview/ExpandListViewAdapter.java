package com.example.basicsandroid.activity.expandlistview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.basicsandroid.R;

import java.util.List;

/**
 * @author MW
 * @date 2019/9/18
 * <p>
 * 描述： 适配器
 */
public class ExpandListViewAdapter extends BaseExpandableListAdapter {

    private List<BeanFirstItemBase> mFirstItemList;
    private Context mContext;

    public ExpandListViewAdapter(List<BeanFirstItemBase> mFirstItemList, Context mContext) {
        this.mFirstItemList = mFirstItemList;
        this.mContext = mContext;
    }

    //返回的是一级标签的数量
    @Override
    public int getGroupCount() {
        return mFirstItemList.size();
    }

    //返回的是子标签的数量
    @Override
    public int getChildrenCount(int groupPosition) {
        return mFirstItemList.get(groupPosition).getBeanSecondItem().size();
    }

    //获得某个一级标签的内容
    @Override
    public Object getGroup(int groupPosition) {
        return mFirstItemList.get(groupPosition);
    }

    //获得某个一级标签下的子标签
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mFirstItemList.get(groupPosition).getBeanSecondItem().get(childPosition);
    }

    //一级标签列表的Id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //二级标签列表的Id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    @Override
    public boolean hasStableIds() {
        return true;
    }

    //显示一级标签列表
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        FirstViewHolder firstViewHolder;
        if (convertView == null) {//第一次展示View 没有被创建
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_first_label, null);
            firstViewHolder = new FirstViewHolder(convertView);
            convertView.setTag(firstViewHolder);//创建之后，将firstViewHolder存到视图中
        } else {
            firstViewHolder = (FirstViewHolder) convertView.getTag();//将firstViewHolder 拿出来
        }
        firstViewHolder.tvName.setText(mFirstItemList.get(groupPosition).getName());
        if (isExpanded) {//表明此时已经展开
            firstViewHolder.ivState.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.icon_huanzhe_xiala3));
        } else {//表明此时已经关闭
            firstViewHolder.ivState.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.icon_huanzhe_xiala1));
        }
        return convertView;
    }

    //显示二级标签列表
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SecondViewHolder secondViewHolder;
        if (convertView == null) {//第一次展示View 没有被创建
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_second_label, null);
            secondViewHolder = new SecondViewHolder(convertView);
            convertView.setTag(secondViewHolder);//创建之后，将firstViewHolder存到View中
        } else {
            secondViewHolder = (SecondViewHolder) convertView.getTag();//将firstViewHolder从View拿出来
        }
        secondViewHolder.tvChildName.setText(mFirstItemList.get(groupPosition).getBeanSecondItem().get(childPosition).getName());

        return convertView;
    }

    //指定位置上的child能否被选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
       /* 下面我注释掉方法的表示二级标签名为张三  不响应点击事件  有兴趣可以试一下
                if (mFirstItemList.get(groupPosition).getBeanSecondItem().get(childPosition).getName().equals("张三")) {
            return false;
        } else {
            return true;
        }*/
        return true;
    }

    static class FirstViewHolder {
        TextView tvName;
        ImageView ivState;

        FirstViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            ivState = view.findViewById(R.id.iv_state);
        }
    }

    static class SecondViewHolder {

        TextView tvChildName;

        SecondViewHolder(View view) {

            tvChildName = view.findViewById(R.id.tv_child_name);
        }
    }
}
