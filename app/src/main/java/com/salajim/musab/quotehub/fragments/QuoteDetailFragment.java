package com.salajim.musab.quotehub.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.models.Quote;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuoteDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.quoteTextView) TextView mQuoteText;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;
    @Bind(R.id.heartQuote) ImageView mHeart;

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

        // Setting quotes and authors to the textviews
        mQuoteText.setText(mQuote.getQuote());
        mAuthorTextView.setText(mQuote.getAuthor());

        // Onclick listeners
        mHeart.setOnClickListener(this);

        // Settingup fonts
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Chunkfive.otf");
        mAuthorTextView.setTypeface(font);
        mQuoteText.setTypeface(font);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == mHeart) {
            DatabaseReference mRef = FirebaseDatabase
                    .getInstance()
                    .getReference("favorites");
            mRef.push().setValue(mQuote);
            Toast.makeText(getContext(), "Added to favorites", Toast.LENGTH_SHORT).show();
        }
    }

}
