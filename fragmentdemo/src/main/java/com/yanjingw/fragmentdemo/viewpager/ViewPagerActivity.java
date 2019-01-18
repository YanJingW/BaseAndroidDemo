package com.yanjingw.fragmentdemo.viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.yanjingw.fragmentdemo.DataUtils;
import com.yanjingw.fragmentdemo.R;

/**
 * viewpager嵌套Fragment的demo
 */
public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setData(DataUtils.getDetailpageData(5));
        fragmentTransaction.add(R.id.rootView, fragment);
        fragmentTransaction.commit();
    }
}
