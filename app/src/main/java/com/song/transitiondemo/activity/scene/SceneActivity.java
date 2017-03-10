package com.song.transitiondemo.activity.scene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.song.transitiondemo.R;

/**
 * 场景动画
 */
public class SceneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        //toolbar不填充Them的title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //设置有返回键按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    /**
     * 改变图片的移动位置
     * @param view
     */
    public void changeBounds(View view){
        startActivity(new Intent(this,SceneBoundsActivity.class));
    }

    /**
     * 给变图片的旋转和缩放
     * @param view
     */
    public void ChangeTransfrom(View view){
        startActivity(new Intent(this,SceneTransfromActivity.class));
    }

    /**
     * 改变图片的剪切位置
     * @param view
     */
    public void ChangeclipBounds(View view){
        startActivity(new Intent(this,ChangeclipBoundsActivity.class));
    }

    /**
     * 改变图片的尺寸，位置以及ScaleType
     * @param view
     */
    public void ChangeImageTransfrom(View view){
        startActivity(new Intent(this,ChangeImageTransfromActivity.class));
    }

    /**
     * 渐入，滑动，爆炸动画
     * @param view
     */
    public void fadeSlideExplode(View view){
        startActivity(new Intent(this,FadeSlideExplodeActivity.class));
    }

}
