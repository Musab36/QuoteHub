package com.salajim.musab.quotehub.adapters;

public class QuoteListAdapter {
    /*
    private ArrayList<Quote> mQoutes = new ArrayList<>();
    private Context mContext;

    public QuoteListAdapter(Context context, ArrayList<Quote> quotes) {
        mContext = context;
        mQoutes = quotes;
    }

    @Override
    public QuoteListAdapter.QuotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_list, parent, false);
        QuotesViewHolder viewHolder = new QuotesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuoteListAdapter.QuotesViewHolder holder, int position) {
        holder.bindQuotes(mQoutes.get(position));
    }

    @Override
    public int getItemCount() {
        return mQoutes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.quoteTextView) TextView mQuoteTextView;
        @Bind(R.id.author) TextView mAuthor;
        @Bind(R.id.category) TextView mCategory;
        private Context mContext;

        public QuotesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, QuoteDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("quotes", Parcels.wrap(mQoutes));
            mContext.startActivity(intent);
        }

        public void bindQuotes(Quote quotes) {
            mQuoteTextView.setText(quotes.getBody());
            mAuthor.setText(quotes.getAuthor());
            //mCategory.setText(quote.getCategory());
        }
    }
    */

}
