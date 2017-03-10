package com.song.transitiondemo.activity.scene;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.transition.ChangeClipBounds;
import android.transition.Scene;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.song.transitiondemo.R;

/**
 * 剪切区域的位置边界
 */
public class ChangeclipBoundsActivity extends AppCompatActivity {

    private Scene scene1;
    private Scene scene2;
    private boolean isScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeclip_bounds);
        initToolBar();
        initScene(R.id.scene_root,R.layout.change_clip_bounds_scene,R.layout.change_bounds_scene2);
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
        title.setText("ChangeclipBoundsActivity");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * 初始化动画场景
     *
     * @param rootView      动画场景
     * @param scene_layout1 场景1
     * @param scene_layout2 场景2
     */
    private void initScene(@IdRes int rootView,
                           @LayoutRes int scene_layout1, @LayoutRes int scene_layout2) {
        ViewGroup RootView = (ViewGroup) findViewById(rootView);
        View view = LayoutInflater.from(this).inflate(scene_layout1, null);
        View view2 = LayoutInflater.from(this).inflate(scene_layout2, null);
        ImageView iv1 = (ImageView) view.findViewById(R.id.iv_clip);
        ImageView iv2 = (ImageView) view2.findViewById(R.id.iv_clip);
        iv1.setClipBounds(new Rect(200, 200, 400, 400));
        iv2.setClipBounds(new Rect(400, 400, 600, 600));
        scene1 = new Scene(RootView, view);
        scene2 = new Scene(RootView, view2);
        TransitionManager.go(scene1);
    }

    //点击事件
    public void change(View view) {
        Transition transition = new ChangeClipBounds();
        TransitionManager.go(isScene2 ? scene1 : scene2, transition);
        isScene2 = !isScene2;
    }
}
