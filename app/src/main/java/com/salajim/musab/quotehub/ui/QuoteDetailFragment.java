package com.salajim.musab.quotehub.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.models.Quote;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuoteDetailFragment extends Fragment {
    @Bind(R.id.quoteTextView) TextView mQuoteText;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;

    private Quote mQuote;

    // newInstance(), is used instead of a constructor and returns a new instance of QuoteDetailFragment
    public static QuoteDetailFragment newInstance(Quote quote) {
        QuoteDetailFragment quoteDetailFragment = new QuoteDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("quote", Parcels.wrap(quote));
        quoteDetailFragment.setArguments(args);
        return quoteDetailFragment;
    }
    //onCreate(), is called when the fragment is created. Here, we unwrap our quote object from the arguments we added in the newInstance()
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQuote = Parcels.unwrap(getArguments().getParcelable("quote"));
    }

    // onCreateView(), this quote object is then used to set our TextViews
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_quote_detail, container, false);
        ButterKnife.bind(this, view);

        mQuoteText.setText(mQuote.getQuote());
        mAuthorTextView.setText(mQuote.getAuthor());

        return view;
    }

}
