package com.salajim.musab.quotehub.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.quotehub.R;
import com.salajim.musab.quotehub.models.Quote;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddQuotesActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.quoteEditText)
    EditText mQuoteEdittext;
    @Bind(R.id.submitButton)
    Button mSubmitButton;
    @Bind(R.id.authorEditText) EditText mAuthorEditText;

    List<Quote> quotes;
    DatabaseReference quoteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quotes);
        ButterKnife.bind(this);

        quoteDatabase = FirebaseDatabase.getInstance().getReference("quotes");

        mSubmitButton.setOnClickListener(this);
        quotes = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmitButton) {
            addQuote();
        }

    }

    private void addQuote() {
        String quotes = mQuoteEdittext.getText().toString().trim();
        String author = mAuthorEditText.getText().toString().trim();

        if(!TextUtils.isEmpty(quotes)) {
            String id = quoteDatabase.push().getKey();

            Quote quote = new Quote(id, quotes, author);
            quoteDatabase.child(id).setValue(quote);

            mQuoteEdittext.setText("");
            mAuthorEditText.setText("");

            Toast.makeText(this, "Quote added!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Field cannot be empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
