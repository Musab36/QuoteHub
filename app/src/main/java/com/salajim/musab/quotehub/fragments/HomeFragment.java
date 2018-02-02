package com.salajim.musab.quotehub.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.quotehub.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";
    @Bind(R.id.inspiration) TextView mInspiration;
    @Bind(R.id.life) TextView mLife;
    @Bind(R.id.love) TextView mLove;
    @Bind(R.id.wisdom) TextView mWisdom;
    @Bind(R.id.funny) TextView mFunny;
    @Bind(R.id.motivation) TextView mMotivation;
    @Bind(R.id.money) TextView mMoney;
    @Bind(R.id.happiness) TextView mHappiness;
    @Bind(R.id.success) TextView mSuccess;
    @Bind(R.id.friendship) TextView mFriendship;
    @Bind(R.id.positve) TextView mPositive;
    @Bind(R.id.hope) TextView mHope;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        // Setting fonts
        Typeface fonts = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Chunkfive.otf");
        mInspiration.setTypeface(fonts);
        mLife.setTypeface(fonts);
        mLove.setTypeface(fonts);
        mWisdom.setTypeface(fonts);
        mFunny.setTypeface(fonts);
        mMotivation.setTypeface(fonts);
        mMoney.setTypeface(fonts);
        mHappiness.setTypeface(fonts);
        mSuccess.setTypeface(fonts);
        mFriendship.setTypeface(fonts);
        mPositive.setTypeface(fonts);
        mHope.setTypeface(fonts);

        return view;
    }

}
