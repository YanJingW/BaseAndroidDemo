package com.yanjingw.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yanjingw.fragmentdemo.lifecycle.SingleFragmentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fragment_lifecycle = findViewById(R.id.fragment_single);
        fragment_lifecycle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fragment_single:
                startActivity(new Intent(this, SingleFragmentActivity.class));
                break;
        }
    }
}
