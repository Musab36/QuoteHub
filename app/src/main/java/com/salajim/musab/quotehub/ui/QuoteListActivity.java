package com.salajim.musab.quotehub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.adapters.QuoteListAdapter;
import com.salajim.musab.quotehub.adapters.QuotesArrayAdapter;
import com.salajim.musab.quotehub.models.Quote;
import com.salajim.musab.quotehub.services.FavqsService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class QuoteListActivity extends AppCompatActivity {
    public static final String TAG = QuoteListActivity.class.getSimpleName();
    @Bind(R.id.quotesTextView) TextView mQuotesTextView;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private QuoteListAdapter mAdapter;
    private QuotesArrayAdapter adapter;
    public ArrayList<Quote> mQuotes = new ArrayList<>();
    @Bind(R.id.listView) ListView mListView;
    /*
    private String[] quotes = new String[] {"Never give up, always keep pushing and believe in yourself", "Don't cry because it's over, smile because it happened.", "Be yourself; everyone else is already taken.",
    "Be the change that you wish to see in the world.", "If you tell the truth, you don't have to remember anything.", "A friend is someone who knows all about you and still loves you.",
    "Always forgive your enemies; nothing annoys them so much.", "Live as if you were to die tomorrow. Learn as if you were to live forever.",
    "To live is the rarest thing in the world. Most people exist, that is all.", "Let us always meet each other with smile, for the smile is the beginning of love.",
    "If you can't excel with talent, triumph with effort.", "Mistakes are the portals of discovery.", "Good words bring good feelings to the heart. Speak with kindness, always.",
    "An investment in knowledge always pays the best interest.", "It's not that I'm so smart, it's just that I stay with problems longer.",
    "Success is the sum of small efforts, repeated day in and day out.", "Be somebody who makes everybody feel like a somebody.", "The best way to cheer yourself up is to try to cheer somebody else up.",
    "Where hope grows, miracles blossom.", "Consult not your fears, but your hopes and your dreams.", "Our greatest glory is not in never falling, but in rising every time we fall.",
    "I am always doing that which I cannot do, in order that I may learn how to do it.", "To succeed in your mission, you must have single-minded devotion to your goal.",
    "Law is easy, but the application requires wisdom!"};

    private String[] authors = new String[] {"Musab Abdirahman", "Dr. Seuss", " Oscar Wilde", " Mahatma Gandhi", " Mark Twain", " Elbert Hubbard", " Oscar Wilde",
    "Mahatma Gandhi", " Oscar Wilde", "Mother Teresa", "Stephen G. Weinbaum", "James Joyce", "Rod Williams", "Benjamin Franklin", "Albert Einstein",
    "Robert J. Collier", "Kid President (Robby Novak)", "Mark Twain", "Elna Rae", "Pope John XXIII", "Confucius", "Pablo Picasso", "A. P. J. Abdul Kalam", "LT Abdullahi Dahir"};
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        ButterKnife.bind(this);

        /*
        // Setting the ArrayAdapter to work with ListView
        QuotesArrayAdapter adapter = new QuotesArrayAdapter(this, android.R.layout.simple_list_item_1, quotes, authors);
        mListView.setAdapter(adapter);
        */


        Intent intent = getIntent(); // Getting the Intent from the MainActivity
        String quotes = intent.getStringExtra("quotes"); // Pulling the data from the Intent

        getQuotes(quotes);
    }


    // Callback method for desplaying response data
    private void getQuotes(String quotes) {
        final FavqsService favqsService = new FavqsService(); //// Creating new instance of Favourite Quotes
        favqsService.findQuotes(quotes, new Callback() {// new Callback represents the second argument in findQuotes() method

            // This method is run when our request fails
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("callback","yes");
                e.printStackTrace();// prints details of the error to the output console
            }

            // This method is run if our request is successful
            @Override
            public void onResponse(Call call, Response response) {
                  Log.d("response", "yes");

                mQuotes = favqsService.processResults(response);// We are triggering .processResults() and collect its return value

                QuoteListActivity.this.runOnUiThread(new Runnable() {//We are switching to UI thread, Runnable helps sharing code between threads
                    //Runnable method which contains the code for the UI thread
                    @Override
                    public void run() {
                        mAdapter = new QuoteListAdapter(getApplicationContext(), mQuotes);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(QuoteListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });


    }
}
