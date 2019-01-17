package com.yanjingw.fragmentdemo.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.yanjingw.fragmentdemo.singlefragment.SingleLifeCycleFragment;
import com.yanjingw.frame.BaseLazyFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private final FragmentManager fm;
    private final BaseLazyFragment parent;
    private Context mContext;
    private List<Fragment> mFragmentTab = new ArrayList<>();
    private List<String> tableTitle = new ArrayList<>();

    public FragmentAdapter(BaseLazyFragment parent, FragmentManager fm, Context context) {
        super(fm);
        this.parent = parent;
        this.fm = fm;
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentTab.get(position);
    }

    @Override
    public int getCount() {
        return tableTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tableTitle.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    public void setData(List<String> secondTabData) {
        for (int i = 0; i < secondTabData.size(); i++) {
            SingleLifeCycleFragment deviceFragment = new SingleLifeCycleFragment();
            deviceFragment.setData(secondTabData.get(i));
            mFragmentTab.add(deviceFragment);
            tableTitle.add("第" + i + "页");
        }
    }
}