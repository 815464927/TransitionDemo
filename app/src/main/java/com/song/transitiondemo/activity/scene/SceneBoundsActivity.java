package com.song.transitiondemo.activity.scene;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.song.transitiondemo.R;

/**
 * 位置边界创建移动和缩放动画
 */
public class SceneBoundsActivity extends AppCompatActivity {

    protected Scene scene1;
    protected Scene scene2;
    protected boolean isScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_bounds);
        initToolBar();
        initScene(R.id.scene_root,R.layout.change_bounds_scene1,R.layout.change_bounds_scene2);
    }

    /**
     * 左上角返回键监听
     * @return true
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    /**初始化ToolBar*/
    private void initToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView mtitle = (TextView)findViewById(R.id.tv_toolsBar_title);
        mtitle.setText("SceneBoundsActivity");
    }

    /**
     * 初始化场景 说明：如果scene_layout1和scene_layout2里面的View没加id的话没有移动的效果
     * @param rootView 动画运动的场景
     * @param scene_layout1 场景1
     * @param scene_layout2 场景2
     */
    private void initScene(@IdRes int rootView,
                           @LayoutRes int scene_layout1, @LayoutRes int scene_layout2){

        ViewGroup sceneRoot = (ViewGroup) findViewById(rootView);
        scene1 = Scene.getSceneForLayout(sceneRoot,scene_layout1,this);
        scene2 = Scene.getSceneForLayout(sceneRoot,scene_layout2,this);
        TransitionManager.go(scene1);
    }

    /**点击事件 */
    public void change(View view){
        //位置边界创建移动和缩放动画
        Transition transition = new ChangeBounds();
        TransitionManager.go(isScene2?scene1:scene2,transition);
        isScene2 = !isScene2;
    }

}
