package com.salajim.musab.quotehub.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class QuotesArrayAdapter extends ArrayAdapter {
private Context mContext;
private String[] mQuotes;
private String[] mAuthors;

    // ArrayAdapter constructor
    public QuotesArrayAdapter(Context mContext, int resource, String[] mQuotes, String[] mAuthors) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mQuotes = mQuotes;
        this.mAuthors = mAuthors;
    }

    // Getting the Quote and the Authors
    @Override
    public Object getItem(int position) {
        String quote = mQuotes[position];
        String author = mAuthors[position];
        return String.format("%s \n By: %s", quote, author); // Formatting the string and breaking the line between the Quote and the author
    }

    // Returning all the Quote
    @Override
    public int getCount() {
        return mQuotes.length;
    }
}
