package com.salajim.musab.quotehub.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.adapters.QuotePagerAdapter;
import com.salajim.musab.quotehub.models.Quote;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HopeActivity extends AppCompatActivity {
    public static final String TAG = HopeActivity.class.getName();
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private QuotePagerAdapter mAdapter;
    private ArrayList<Quote> mQuote = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference mRef;

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hope);
        ButterKnife.bind(this);

        // Changing the actionbar name
        toolbar = getSupportActionBar();
        toolbar.setTitle("Hope");

        // Retrieving hope quotes from Firebase database
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("hope");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    mQuote.add(dataSnapshot1.getValue(Quote.class));
                }

                // Displaying the data and setting the adapter with ViewPager
                mAdapter = new QuotePagerAdapter(getSupportFragmentManager(), mQuote);
                mViewPager.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
