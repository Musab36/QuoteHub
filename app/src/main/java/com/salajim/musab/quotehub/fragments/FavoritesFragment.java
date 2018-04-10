package com.salajim.musab.quotehub.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salajim.musab.quotehub.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {
    SharedPreferences sp;
    public static final String USER_PREF = "USER_PREF";
    public static final String MY_QUOTE = "MY_QUOTE";


    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        sp = getActivity().getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);

        return view;
    }

    public void display(View view) {
        StringBuilder str = new StringBuilder();
        if(sp.contains(MY_QUOTE)) {

        }
    }

}
