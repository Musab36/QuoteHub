package com.salajim.musab.quotehub.models;

import org.parceler.Parcel;


@Parcel
public class Quote {
    String quoteId;
    String quote;
    String author;

    public Quote() {
    }

    public Quote(String quoteId, String quote, String author) {
        this.quoteId = quoteId;
        this.quote = quote;
        this.author = author;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}