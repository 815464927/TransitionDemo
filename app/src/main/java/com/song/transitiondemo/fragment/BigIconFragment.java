package com.song.transitiondemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.transition.ChangeBounds;
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
 */

public class BigIconFragment extends Fragment {

    /**
     * 空的构造方法
     */
    public BigIconFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bigfragment_layout,container,false);
        final ImageView iv = (ImageView) view.findViewById(R.id.iv_small_fragment);
        CardView cardView = (CardView) view.findViewById(R.id.cardView_secondFragment);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmallIconFragment smallIconFragment = new SmallIconFragment();
                //设置共享元素的进入动画
                smallIconFragment.setSharedElementEnterTransition(new ChangeBounds());
                //设置Fragment的进入动画
                smallIconFragment.setEnterTransition(new Slide(Gravity.LEFT));
                //设置Fragment的退出动画
                smallIconFragment.setExitTransition(new Slide(Gravity.LEFT));

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,smallIconFragment);
                fragmentTransaction.addSharedElement(iv,"iv_share");
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
