package com.song.transitiondemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.TextView;

import com.song.transitiondemo.R;

public class ContentTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transition);
        initToolBar();
        initTransition();
    }

    /**
     * 初始化动画
     */
    private void initTransition() {
        Slide slide = new Slide();
        slide.setDuration(500);
        slide.setSlideEdge(Gravity.LEFT);
        getWindow().setEnterTransition(slide);
        getWindow().setReenterTransition(new Explode().setDuration(600));

    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView title = (TextView) findViewById(R.id.tv_toolsBar_title);
        title.setText("ContentTransitionActivity");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
