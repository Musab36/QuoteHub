package com.salajim.musab.quotehub.services;

public class FavqsService {
    /*
    // The following method builds, signs, and sends an OAuth API request using OkHttp and Signpost:
    public static void findQuotes(String quotes, Callback callback) {

        // Here we are creating OKHttpClient to create and send request
        OkHttpClient client = new OkHttpClient();

        // Building the request URL with OKHttp
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.FAVQS_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MY_QUERY_PARAMETER, quotes);

        String url = urlBuilder.build().toString();// Turns the finished URL into a String
        Log.d("url",url);
        // Creating a new Request with OKHttp using the new URL
        Request request = new Request.Builder()
                .header("Authorization", Constants.ApiKey)
                .url(url)
                .build();

        // Here we are excuting our request
        Call call = client.newCall(request);// We created a Call object and placed our request in it
        call.enqueue(callback);// Then we excute our request
        Log.d("after request","yes");
    }

    // This method will return an array list of Quote objects which we can then display.
    public ArrayList<Quote> processResults(Response response) {
        ArrayList<Quote> quotes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            Log.d("json",jsonData);
            if(response.isSuccessful()) {
                JSONObject favqsJson = new JSONObject(jsonData);
                Log.d("jsonData", jsonData);
                JSONArray quotesJSON = favqsJson.getJSONArray("quotes");
                for(int i = 0; i < quotesJSON.length(); i ++) {
                    JSONObject quoteJSON = quotesJSON.getJSONObject(i);
                    String body = quoteJSON.getString("body");
                    String author = quoteJSON.getString("author");

                    Quote quote = new Quote(body, author);
                    quotes.add(quote);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return quotes;
    }
    */
}
