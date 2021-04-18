package com.example.basicsandroid.guide.lifecycle;

import android.app.Fragment;

import com.example.basicsandroid.guide.util.LogUtil;


public class ListenerFragment extends Fragment {

    FragmentLifecycle mFragmentLifecycle;

    public void setFragmentLifecycle(FragmentLifecycle lifecycle) {
        mFragmentLifecycle = lifecycle;
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("onStart: ");
        mFragmentLifecycle.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mFragmentLifecycle.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFragmentLifecycle.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy: ");
        mFragmentLifecycle.onDestroy();
    }
}
