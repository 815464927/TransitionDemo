package com.song.transitiondemo.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.widget.TextView;

import com.song.transitiondemo.R;

public class FragmentTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transition);
        initToolBar();
        loadFragment();
    }

    /**
     * 加载Fragment
     */
    private void loadFragment() {
        SmallIconFragment smallFragent = new SmallIconFragment();
        smallFragent.setExitTransition(new Slide());//设置Fragm退出动画
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, smallFragent);
        fragmentTransaction.commit();
    }

    /**
     * 初始化toolBar
     */
    private void initToolBar() {
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView title = (TextView) findViewById(R.id.tv_toolsBar_title);
        title.setText("FragmentTransitionActivity");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
