package com.song.transitiondemo.activity.scene;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeTransform;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.song.transitiondemo.R;

/**
 * scale和rotation创建缩放和旋转动画
 */
public class SceneTransfromActivity extends AppCompatActivity {

    private Scene scene1;
    private Scene scene2;
    private boolean isScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_transfrom);
        initToolBar();
        initScene(R.id.scene_root,R.layout.transfrom_scene1,R.layout.transfrom_scene2);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**初始化toolBar*/
    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView mtitle = (TextView)findViewById(R.id.tv_toolsBar_title);
        mtitle.setText("SceneTransfromActivity");
    }

    /**
     * 初始化场景
     * @param rootView 动画运动的场景
     * @param scene_layout1 场景1
     * @param scene_layout2 场景2
     */
    private void initScene(@IdRes int rootView ,
                           @LayoutRes int scene_layout1,@LayoutRes int scene_layout2){
        ViewGroup sceneRoot = (ViewGroup) findViewById(rootView);
        scene1 = Scene.getSceneForLayout(sceneRoot,scene_layout1,this);
        scene2 = Scene.getSceneForLayout(sceneRoot,scene_layout2,this);
        TransitionManager.go(scene1);
    }

    /**点击事件*/
    public void change(View view){
        //scale和rotation创建缩放和旋转动画
        ChangeTransform changeTransform = new ChangeTransform();
        TransitionManager.go(isScene2?scene1:scene2,changeTransform);
        isScene2 = !isScene2;
    }
}
