package com.yanjingw.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yanjingw.fragmentdemo.singlefragment.SingleFragmentActivity;
import com.yanjingw.fragmentdemo.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fragment_lifecycle = findViewById(R.id.fragment_single);
        fragment_lifecycle.setOnClickListener(this);
        View fragment_viewpager = findViewById(R.id.fragment_viewpager);
        fragment_viewpager.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fragment_single:
                startActivity(new Intent(this, SingleFragmentActivity.class));
                break;
            case R.id.fragment_viewpager:
                startActivity(new Intent(this, ViewPagerActivity.class));
                break;
        }
    }
}
