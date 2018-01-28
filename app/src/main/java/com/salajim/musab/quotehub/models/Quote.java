package com.salajim.musab.quotehub.models;

import org.parceler.Parcel;


@Parcel
public class Quote {
    String mBody;
    String mAuthor;
    //String mCategory;

    public Quote() {
    }

    public Quote(String body, String author) {
        this.mBody = body;
        this.mAuthor = author;
    }

    public String getBody() {
        return mBody;
    }

    public String getAuthor() {
        return mAuthor;
    }
   /*
    public String getCategory() {
        return mCategory;
    }
    */
}