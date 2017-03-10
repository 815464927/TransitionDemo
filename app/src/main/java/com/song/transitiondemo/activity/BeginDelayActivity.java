package com.song.transitiondemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.song.transitiondemo.R;

public class BeginDelayActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup viewGroup;
    private ImageView iv1, iv2, iv3, iv4;
    private int widthParamSize;//图片的宽
    private int heightParamSize;//图片的高
    private boolean isBigview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_delay);
        initToolBar();
        initview();
    }

    private void initview() {

        viewGroup = (ViewGroup) findViewById(R.id.scene_root);
        iv1 = (ImageView) findViewById(R.id.iv_image1);
        iv2 = (ImageView) findViewById(R.id.iv_image2);
        iv3 = (ImageView) findViewById(R.id.iv_image3);
        iv4 = (ImageView) findViewById(R.id.iv_image4);

        widthParamSize = iv1.getLayoutParams().width;
        heightParamSize = iv1.getLayoutParams().height;

        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView title = (TextView) findViewById(R.id.tv_toolsBar_title);
        title.setText("BeginDelayActivity");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(viewGroup,
                TransitionInflater.from(this).inflateTransition(R.transition.begin_delay));
        //开始改变尺寸
        changeSize(v);
        changeVisible(iv1, iv2, iv3, iv4);
        v.setVisibility(View.VISIBLE);
    }

    /**
     * 改变view的大小改变为原来的1.5倍
     *
     * @param view
     */
    private void changeSize(View view) {
        isBigview = !isBigview;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (isBigview) {
            layoutParams.width = (int) (1.5 * widthParamSize);
            layoutParams.height = (int) (1.5 * heightParamSize);
        } else {
            layoutParams.width = widthParamSize;
            layoutParams.height = heightParamSize;
        }
        view.setLayoutParams(layoutParams);
    }

    /**
     * 改变View的Visible和InVisible
     *
     * @param veiws
     */
    private void changeVisible(View... veiws) {
        for (View veiw : veiws) {
            veiw.setVisibility(veiw.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
        }
    }
}
