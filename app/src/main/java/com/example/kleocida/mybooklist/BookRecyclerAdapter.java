package com.example.kleocida.mybooklist;

/**
 * Created by Kleocida on 2017. 06. 02..
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.ViewHolder> {

    ArrayList<Book> mBook;
    MainActivity mContext;

    private static OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public BookRecyclerAdapter(MainActivity context, ArrayList<Book> book, OnItemClickListener listener) {
        mContext = context;
        mBook = book;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookRecyclerAdapter.ViewHolder holder, int position) {
        Book book = mBook.get(position);
        holder.bookTitleTextView.setText(book.getTitleId());
        holder.bookAuthorTextView.setText(book.getAuthorId());
        Picasso.with(mContext).load(book.getThumbnailId()).into(holder.bookThumbnailImageView);
        holder.bind(mBook.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mBook.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bookThumbnailImageView;
        TextView bookTitleTextView;
        TextView bookAuthorTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            bookThumbnailImageView = (ImageView) itemView.findViewById(R.id.BookCover);
            bookTitleTextView = (TextView) itemView.findViewById(R.id.BookTitle);
            bookAuthorTextView = (TextView) itemView.findViewById(R.id.BookAuthor);
        }

        public void bind(final Book book, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(book);
                }
            });
        }
    }

    public void clear() {
        mBook.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Book> book) {
        mBook.addAll(book);
        notifyDataSetChanged();
    }
}
