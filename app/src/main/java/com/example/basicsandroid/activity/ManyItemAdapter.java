package com.example.basicsandroid.activity;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.basicsandroid.R;
import com.example.basicsandroid.activity.itemtype.BeanItemBase;

import java.util.List;


/**
 * @author MW
 * @date 2019/8/2
 * <p>
 * 描述： 多个Item的Adapter
 */
public class ManyItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BeanItemBase> mItemList;
    private Context mContext;
    private final static int FIRST_VIEW_TYPE = 1;//第一种布局标识
    private final static int SECOND_VIEW_TYPE = 2;//第二种布局标识


    public ManyItemAdapter(List<BeanItemBase> mItemList, Context mContext) {
        this.mItemList = mItemList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       /*这一点需要说明，viewType是怎么来的，每次进入这个Adapter,getItemViewType会先执行，
         每执行一次getItemViewType就会走一次onCrateViewHolder,然后载入对应的布局，有多少条数据，
         就会执行多少次，这一块我们使用时可以打个断点看一下，非常清晰
       */
        if (viewType == FIRST_VIEW_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first_adapter, parent, false);
            FirstHolder viewHolder = new FirstHolder(view);
            return viewHolder;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second_adapter, parent, false);
            SecondHolder secondHolder = new SecondHolder(view);
            return secondHolder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BeanItemBase beanItemBase = mItemList.get(position);
        if (holder instanceof FirstHolder) {
            ((FirstHolder) holder).tvName.setText(beanItemBase.getName());
        } else {
            ((SecondHolder) holder).mButtonName.setText(beanItemBase.getName());
        }
    }


    @Override
    public int getItemViewType(int position) {
        //根据 BeanItemBase类中的字段type 来判断，传入的这个数据应该使用哪种布局
        BeanItemBase beanItemBase = mItemList.get(position);
        return beanItemBase.getType() == 1 ? FIRST_VIEW_TYPE : SECOND_VIEW_TYPE;
        //return super.getItemViewType(position);

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    static class FirstHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public FirstHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
        }
    }

    static class SecondHolder extends RecyclerView.ViewHolder {
        Button mButtonName;

        public SecondHolder(View view) {
            super(view);
            mButtonName = view.findViewById(R.id.bt_button);
        }
    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < getItemCount(); i++) {
            String sortStr = mItemList.get(i).getItem();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

}
