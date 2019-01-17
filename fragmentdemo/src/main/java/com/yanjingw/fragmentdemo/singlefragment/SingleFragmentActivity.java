package com.yanjingw.fragmentdemo.singlefragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.yanjingw.fragmentdemo.R;
import com.yanjingw.utils.LogUitls;

public class SingleFragmentActivity extends AppCompatActivity {

    public static final String TAG = SingleFragmentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        LogUitls.i(TAG, "onCreate", this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SingleLifeCycleFragment fragment = new SingleLifeCycleFragment();
        fragmentTransaction.add(R.id.rootView, fragment);
        fragmentTransaction.commit();
        LogUitls.i(TAG, "onCreate_after", this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUitls.i(TAG, "onStart", this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUitls.i(TAG, "onResume", this);


    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUitls.i(TAG, "onPause", this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUitls.i(TAG, "onStop", this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUitls.i(TAG, "onDestroy", this);
    }

}
