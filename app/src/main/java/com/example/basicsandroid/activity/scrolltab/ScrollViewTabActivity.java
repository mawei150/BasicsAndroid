package com.example.basicsandroid.activity.scrolltab;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.basicsandroid.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author MW
 * @date 2019/9/9
 * <p>
 * 描述：   ScrollView和TabLayout联合使用
 */

public class ScrollViewTabActivity extends AppCompatActivity {

    @BindView(R.id.tv_item1)
    TextView tvItem1;
    @BindView(R.id.tv_item2)
    TextView tvItem2;
    @BindView(R.id.tv_item3)
    TextView tvItem3;
    @BindView(R.id.tv_item4)
    TextView tvItem4;
    @BindView(R.id.tv_item5)
    TextView tvItem5;
    @BindView(R.id.sc_view)
    ScrollView scView;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tab_name)
    TabLayout tabName;

    private  int height1;
    private  int height2;
    private  int height3;
    private  int height4;
    private  int height5;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_tab);
        ButterKnife.bind(this);
        addTab();//添加标签
        initView();
    }

    private void addTab() {

        tabName.addTab(tabName.newTab().setText("张三"));
        tabName.addTab(tabName.newTab().setText("李四"));
        tabName.addTab(tabName.newTab().setText("王五"));
        tabName.addTab(tabName.newTab().setText("赵六"));
        tabName.addTab(tabName.newTab().setText("刘七"));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private boolean IsSlide = false;//默认不是滑动操作
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
        tabName.setSelectedTabIndicatorHeight(0);//去掉标签隐藏的下划线

        //ScrollView的滑动监听
        scView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                //第一个参数:View对象
                //第二个参数:目前的x轴坐标
                //第三个参数:目前的y轴坐标
                //第四个参数:上一个x轴坐标
                //第五个参数:上一个y轴坐标
                IsSlide = true;//表名此时正在滑动

                if (scrollY < height1) {//表明此时在Item1范围内，所以第一个Item应该被选择

                    Objects.requireNonNull(tabName.getTabAt(0)).select();
                } else if (scrollY >= height1 && scrollY < height2) {//表明此时在Item2范围内，所以第二个Item应该被选择

                    Objects.requireNonNull(tabName.getTabAt(1)).select();
                } else if (scrollY >= height2 && scrollY < height3) {//表明此时在Item3范围内，所以第三个Item应该被选择


                    Objects.requireNonNull(tabName.getTabAt(2)).select();
                } else if (scrollY >= height3 && scrollY < height4) {//表明此时在Item4范围内，所以第四个Item应该被选择

                    Objects.requireNonNull(tabName.getTabAt(3)).select();//表明此时在Item5范围内，所以第五个Item应该被选择
                } else {

                    Objects.requireNonNull(tabName.getTabAt(4)).select();////表明此时在Item6范围内，所以第六个Item应该被选择
                }
                IsSlide = false;//表明滑动结束
            }
        });

        //这个方法的作用是点击标签的特定的位置
        tabName.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //当标签处于选中的状态   此时有两种情况 1.直接点击tabLayout标签会走   2.当ScrollView滑动时，因为我们在滑动里面设置了选择标签，所以此时这个方法也会走
                //现在有个问题，当滑动的时候，tabLayout标签也会被选择，所以此时会产生冲突，我们要排除滑动的操作
                if (IsSlide) {//表示此时正在滑动  不走这个方法
                    return;
                }
                int position = tab.getPosition();
                if (position == 0) {

                    scView.smoothScrollTo(0, 0);//滑到对应的View顶部
                    Toast.makeText(ScrollViewTabActivity.this, "张三", Toast.LENGTH_SHORT).show();

                } else if (position == 1) {

                    scView.smoothScrollTo(0, height1);//滑到对应的View顶部

                    Toast.makeText(ScrollViewTabActivity.this, "李四", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    scView.smoothScrollTo(0, height2);//滑到对应的View顶部
                    Toast.makeText(ScrollViewTabActivity.this, "王五", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    scView.smoothScrollTo(0, height3);//滑到对应的View顶部
                    Toast.makeText(ScrollViewTabActivity.this, "赵六", Toast.LENGTH_SHORT).show();
                } else {
                    scView.smoothScrollTo(0, height4);//滑到对应的View顶部
                    Toast.makeText(ScrollViewTabActivity.this, "刘七", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        height1 = tvItem1.getMeasuredHeight();//表示第一个item的高度,这是高度
        height2 = tvItem1.getMeasuredHeight() + tvItem2.getMeasuredHeight();//这个是第一个item加第二个item的高度  下面同理
        height3 = tvItem1.getMeasuredHeight() + tvItem2.getMeasuredHeight() + tvItem3.getMeasuredHeight();
        height4 = tvItem1.getMeasuredHeight() + tvItem2.getMeasuredHeight() + tvItem3.getMeasuredHeight() + tvItem4.getMeasuredHeight();
        height5 = tvItem1.getMeasuredHeight() + tvItem2.getMeasuredHeight() + tvItem3.getMeasuredHeight() + tvItem4.getMeasuredHeight() + tvItem5.getMeasuredHeight();

    }
}
