package com.salajim.musab.quotehub.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.salajim.musab.quotehub.ui.QuoteDetailFragment;
import com.salajim.musab.quotehub.models.Quote;

import java.util.ArrayList;

public class QuotePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Quote> mQuote;

    //A constructor where we set the required FragmentManager and array list of quotes we will be swiping through.
    public QuotePagerAdapter(FragmentManager fm, ArrayList<Quote> quote) {
        super(fm);
        mQuote = quote;
    }

    //Returns an instance of the QuoteDetailFragment for the quote in the position provided as an argument
    @Override
    public Fragment getItem(int position) {
        return QuoteDetailFragment.newInstance(mQuote.get(position));
    }

    //Determines how many quotes are in our Array List. This lets our adapter know how many fragments it must create.
    @Override
    public int getCount() {
        return mQuote.size();
    }

}
