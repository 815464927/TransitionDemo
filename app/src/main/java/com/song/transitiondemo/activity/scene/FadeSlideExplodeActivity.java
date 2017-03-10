package com.song.transitiondemo.activity.scene;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.song.transitiondemo.R;

/**
 * 渐入，滑动，爆炸动画
 */
public class FadeSlideExplodeActivity extends AppCompatActivity {

    private Scene scene1;
    private Scene scene2;
    private boolean isScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_slide_explode);
        inittoolBar();
        initScene(R.id.scene_root,R.layout.fadeside_explode1,R.layout.fadeside_explode2);
    }

    /**
     * 初始化Toolbar
     */
    private void inittoolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView title = (TextView) findViewById(R.id.tv_toolsBar_title);
        title.setText("FadeSlideExplodeActivity");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * 初始化动画场景
     * @param rootView 动画场景
     * @param scene_layout1 场景1
     * @param scene_layout2 场景2
     */
    private void initScene(@IdRes int rootView ,
                           @LayoutRes int scene_layout1,@LayoutRes int scene_layout2) {
        ViewGroup viewGroup = (ViewGroup) findViewById(rootView);
        scene1 = Scene.getSceneForLayout(viewGroup,scene_layout1,this);
        scene2 = Scene.getSceneForLayout(viewGroup,scene_layout2,this);
        TransitionManager.go(scene1);
    }


    /**
     * 点击事件
     * @param view
     */
    public void fadeSlideExplode(View view){
        Slide slide = new Slide();
        TransitionManager.go(isScene2?scene1:scene2,slide);
        isScene2 = !isScene2;
    }
}
