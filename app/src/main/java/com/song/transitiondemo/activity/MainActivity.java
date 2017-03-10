package com.song.transitiondemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.View;

import com.song.transitiondemo.R;
import com.song.transitiondemo.activity.scene.SceneActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //设置Activity移除动画
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide));

    }

    /**
     * 场景动画
     */
    public void goSceneExample(View view){
        startActivity(new Intent(this,SceneActivity.class));
    }

    /**
     * beginDelayTransition
     */
    public void beginDelay(View view){
        startActivity(new Intent(this,BeginDelayActivity.class));
    }

    /**
     * contentTransition
     */
    public void contentTransition(View view){
        Intent intent = new Intent(this,ContentTransitionActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        startActivity(intent,activityOptionsCompat.toBundle());
    }

    /**
     * Content和SharedTransition
     */
    public void transition(View view){
        startActivity(new Intent(this,ContentAndSharedTransitionActivity.class));
    }
}
