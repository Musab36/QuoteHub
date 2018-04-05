package com.salajim.musab.quotehub.fragments;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.ui.FriendshipActivity;
import com.salajim.musab.quotehub.ui.FunnyActivity;
import com.salajim.musab.quotehub.ui.HappinessActivity;
import com.salajim.musab.quotehub.ui.HopeActivity;
import com.salajim.musab.quotehub.ui.InspirationActivity;
import com.salajim.musab.quotehub.ui.LifeActivity;
import com.salajim.musab.quotehub.ui.LoaActivity;
import com.salajim.musab.quotehub.ui.LoveActivity;
import com.salajim.musab.quotehub.ui.PositiveActivity;
import com.salajim.musab.quotehub.ui.SuccessActivity;
import com.salajim.musab.quotehub.ui.WealthActivity;
import com.salajim.musab.quotehub.ui.WisdomActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements View.OnClickListener{
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

        // OnClick Listeners
        mInspiration.setOnClickListener(this);
        mLife.setOnClickListener(this);
        mLove.setOnClickListener(this);
        mFunny.setOnClickListener(this);
        mPositive.setOnClickListener(this);
        mWisdom.setOnClickListener(this);
        mMotivation.setOnClickListener(this);
        mMoney.setOnClickListener(this);
        mHappiness.setOnClickListener(this);
        mSuccess.setOnClickListener(this);
        mFriendship.setOnClickListener(this);
        mHope.setOnClickListener(this);

        return view;
    }

    // Intents to load different activities
    @Override
    public void onClick(View v) {
        if(v == mInspiration) {
            Intent intent = new Intent(getActivity(), InspirationActivity.class);
            startActivity(intent);
        }
        if(v == mLife) {
            Intent intent = new Intent(getActivity(), LifeActivity.class);
            startActivity(intent);
        }
        if(v == mLove) {
            Intent intent = new Intent(getActivity(), LoveActivity.class);
            startActivity(intent);
        }
        if(v == mFunny) {
            Intent intent = new Intent(getActivity(), FunnyActivity.class);
            startActivity(intent);
        }
        if(v == mPositive) {
            Intent intent = new Intent(getActivity(), PositiveActivity.class);
            startActivity(intent);
        }
        if(v == mWisdom) {
            Intent intent = new Intent(getActivity(), WisdomActivity.class);
            startActivity(intent);
        }
        if(v == mMotivation) {
            Intent intent = new Intent(getActivity(), LoaActivity.class);
            startActivity(intent);
        }
        if(v == mMoney) {
            Intent intent = new Intent(getActivity(), WealthActivity.class);
            startActivity(intent);
        }
        if(v == mSuccess) {
            Intent intent = new Intent(getActivity(), SuccessActivity.class);
            startActivity(intent);
        }
        if(v == mFriendship) {
            Intent intent = new Intent(getActivity(), FriendshipActivity.class);
            startActivity(intent);
        }
        if(v == mHappiness) {
            Intent intent = new Intent(getActivity(), HappinessActivity.class);
            startActivity(intent);
        }
        if(v == mHope) {
            Intent intent = new Intent(getActivity(), HopeActivity.class);
            startActivity(intent);
        }
    }

}
