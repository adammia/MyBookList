package com.example.kleocida.mybooklist;

/**
 * Created by Kleocida on 2017. 06. 02..
 */

import java.util.ArrayList;

/**
 * An book object contains information related to a book.
 */

public class Book {

    private String mThumbnail;
    private String mTitle;
    private ArrayList<String> mAuthor;
    private String mInfoLinkUrl;


    /**
     * Constructs a new {@link Book} object.
     *
     * @param thumbnail   is the cover imagage of the book
     * @param title       is the title of the book
     * @param author      is author of the book
     * @param infoLinkUrl is the website URL to find more information about the book
     */
    public Book(String thumbnail, String title, ArrayList<String> author, String infoLinkUrl) {
        mThumbnail = thumbnail;
        mTitle = title;
        mAuthor = author;
        mInfoLinkUrl = infoLinkUrl;
    }

    public String getThumbnailId() {
        return mThumbnail;
    }

    public String getTitleId() {
        return mTitle;
    }


    public String getAuthorId() {
        String authors = checkAuthors();
        return authors;
    }


    public String checkAuthors() {
        String authors = mAuthor.get(0);
        if (mAuthor.size() > 1) {
            for (int i = 1; i < mAuthor.size(); i++) {
                authors += "\n" + mAuthor.get(i);
            }
        }
        return authors;
    }

    public String getInfoLinkId() {
        return mInfoLinkUrl;
    }
}

