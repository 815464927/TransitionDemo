package com.song.transitiondemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.song.transitiondemo.R;

/**
 * Created by song on 2017/3/10.
 * Email：815464927@qq.com
 * Shared Element Transition要注意：
 * fragmentTransaction.addSharedElement(iv,"xxx_xxx");
 * 在这里设置第一个参数是传递要分享的元素的View，
 * 第二个参数是transitionName
 * 第二个参数必须在原View里面声明：           android:transitionName="xxx_xxx"
 * 还要在传递的目标Fragment的View里面声明：   android:transitionName="xxx_xxx"
 */

public class SmallIconFragment extends Fragment {

    private ImageView iv;

    /**
     * 空的构造方法
     */
    public SmallIconFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.small_fragment,container,false);

        iv = (ImageView) view.findViewById(R.id.iv_small_fragment);
        CardView nextFragment = (CardView) view.findViewById(R.id.cardView_firstFragment);
        nextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigIconFragment bigIconFragment = new BigIconFragment();
                //设置共享元素的进入动画
                bigIconFragment.setSharedElementEnterTransition(new ChangeBounds());
                //设置fragment的进入动画
                bigIconFragment.setEnterTransition(new Slide(Gravity.RIGHT));
                //设置fragment的退出动画
                bigIconFragment.setExitTransition(new Slide(Gravity.RIGHT));

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,bigIconFragment);
                //设置分享元素为iv
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.addSharedElement(iv,"iv_share");
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
