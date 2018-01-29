package com.salajim.musab.quotehub.models;

import org.parceler.Parcel;


@Parcel
public class Quote {
    String quoteId;
    String quote;

    public Quote() {
    }

    public Quote(String quoteId, String quote) {
        this.quoteId = quoteId;
        this.quote = quote;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public String getQuote() {
        return quote;
    }
}