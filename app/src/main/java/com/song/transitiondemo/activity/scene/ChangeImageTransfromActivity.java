package com.song.transitiondemo.activity.scene;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeImageTransform;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.song.transitiondemo.R;

/**
 * 图片的尺寸，位置以及ScaleType变化
 */
public class ChangeImageTransfromActivity extends AppCompatActivity {

    private Scene scene1;
    private Scene scene2;
    private boolean isScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_image_transfrom);
        initToolBar();
        initScene(R.id.scene_root,R.layout.change_image_transform1,R.layout.change_image_transform2);
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
        title.setText("ChangeImageTransfromActivity");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * 点击事件
     * @param view
     */
    public void changeImageTransfrom(View view){
        ChangeImageTransform changeImageTransform = new ChangeImageTransform();
        TransitionManager.go(isScene2?scene1:scene2,changeImageTransform);
        isScene2 = !isScene2;
    }

    /**
     * 初始化场景
     * @param rootView 动画场景
     * @param scene_layout1 场景1
     * @param scene_layout2 场景2
     */
    private void initScene(@IdRes int rootView ,
                           @LayoutRes int scene_layout1,@LayoutRes int scene_layout2){
        ViewGroup RootVeiw = (ViewGroup) findViewById(rootView);
        scene1 = Scene.getSceneForLayout(RootVeiw,scene_layout1,this);
        scene2 = Scene.getSceneForLayout(RootVeiw,scene_layout2,this);
        TransitionManager.go(scene1);
    }
}
