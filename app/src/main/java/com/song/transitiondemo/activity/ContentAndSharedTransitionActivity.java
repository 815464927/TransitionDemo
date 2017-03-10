package com.song.transitiondemo.activity;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.song.transitiondemo.R;
import com.song.transitiondemo.fragment.FragmentTransitionActivity;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

/**
 * 注意：ActivityOptionsCompat.makeSceneTransitionAnimation(Activity activity,
 * Pair<View, String>... sharedElements)
 *
 * 第一个参数是Activity，也就是需要给另一个Activity共享元素的源Activity
 * 第二个参数是可变参数，Pair<View,String> (view,"xxx_xxx)
 *
 * 在Pair里面第一个参数是传递要分享的元素的View，
 * 第二个参数是transitionName 有点不不同于Fragment
 * 在Activity里传递只需目标Activity的View里面声明：   android:transitionName="xxx_xxx"
 */

public class ContentAndSharedTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_and_shared_transition);
        initToolBar();
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
        title.setText("Fragment和Activity切换动画");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * Fragment的Transition
     *
     * @param view
     */
    public void clickFragment(View view) {
        startActivity(new Intent(this, FragmentTransitionActivity.class));
    }

    /**
     * Activity的Transition
     *
     * @param view
     */
    public void shareInActivity(View view) {
        ImageView iv = (ImageView) findViewById(R.id.iv_element);
        TextView tv = (TextView) findViewById(R.id.tv_element);

        Intent intent = new Intent(this, SharedElementTransitionsActivity.class);
        ActivityOptionsCompat activityOptionsCompat =
                makeSceneTransitionAnimation(this,
                        new Pair<View, String>(iv, "iv_element"),
                        new Pair<View, String>(tv, "tv_element"));
        startActivity(intent,activityOptionsCompat.toBundle());
    }
}
