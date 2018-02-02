package com.salajim.musab.quotehub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.fragments.FavoritesFragment;
import com.salajim.musab.quotehub.fragments.HomeFragment;
import com.salajim.musab.quotehub.fragments.NewFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private ActionBar toolbar;

/*
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ArrayList<Quote> mQuote = new ArrayList<>();
    private QuotePagerAdapter mAdapter;

    FirebaseDatabase database;
    DatabaseReference mRef;
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Home");
        loadFragment(new HomeFragment());

        //mQuote = Parcels.unwrap(getIntent().getParcelableExtra("quote"));

        /*
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("quotes");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    mQuote.add(dataSnapshot1.getValue(Quote.class));
                }

                //int startingPosition = getIntent().getIntExtra("position", 0);
                mAdapter = new QuotePagerAdapter(getSupportFragmentManager(), mQuote);
                mViewPager.setAdapter(mAdapter);
                //mViewPager.setCurrentItem(startingPosition);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_home:
                    toolbar.setTitle("Home");
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_new:
                    toolbar.setTitle("New");
                    fragment = new NewFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_favorite:
                    toolbar.setTitle("Favorites");
                    fragment = new FavoritesFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add) {
            Intent intent = new Intent(MainActivity.this, AddQuotesActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
