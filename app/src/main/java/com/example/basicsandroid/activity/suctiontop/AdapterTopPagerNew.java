package com.example.basicsandroid.activity.suctiontop;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class AdapterTopPagerNew extends FragmentStatePagerAdapter {
    private List<String> titles;
    private List<Fragment> fragmentLists;

    public AdapterTopPagerNew(FragmentManager fm, List<Fragment> fragmentLists, List<String> titles){
        super(fm);
        this.fragmentLists = fragmentLists;
        this.titles=titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && position <= titles.size()) {
            return titles.get(position);
        }
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentLists.get(position);
    }

    @Override
    public int getCount() {
        return fragmentLists.size();
    }

    // 动态设置我们标题的方法
    public void setPageTitle(int position, String title) {
        if (position >= 0 && position < titles.size()) {
            titles.set(position, title);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
