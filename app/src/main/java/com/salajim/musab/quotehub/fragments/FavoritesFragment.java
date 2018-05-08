package com.salajim.musab.quotehub.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.adapters.QuotePagerAdapter;
import com.salajim.musab.quotehub.models.Quote;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {
    public static final String TAG = "FavoritesFragment";
    //@Bind(R.id.viewPager) ViewPager mViewPager;
    @Bind({R.id.quoteTextView})
    TextView mQuoteTextView;
    private QuotePagerAdapter mAdapter;
    private ArrayList<Quote> mQuote = new ArrayList<>();
    SharedPreferences sp;
    public static final String KEY_PREF = "KEY_PREF";
    public static final String MY_QUOTE = "KEY_QUOTE";
    public static final String KEY_AUTHOR = "KEY_AUTHOR";


    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        ButterKnife.bind(this, view);

        sp = getActivity().getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);

        return view;
    }

    public void display(View view) {
        StringBuilder str = new StringBuilder();
        if(sp.contains(MY_QUOTE)) {
            mQuoteTextView.setText(MY_QUOTE);
        }
    }

}
