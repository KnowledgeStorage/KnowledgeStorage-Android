package com.kn.knowledgestorage;

import java.util.Date;

/**
 * Application file - is a superclass for every file inside of the app. It contains the logic every
 * file has and helps to maintain clean code without doubling it in derived classes.
 */
public class ApplicationFile {
    protected String mTitle;
    protected Date mTimestamp;

    /**
     * Constructor
     */
    public ApplicationFile() {

    }

    /**
     * Set a new title of the file
     * @param title
     */
    public void setTitle(String title) {
        if (title.equals("") || title == null)
            throw new IllegalArgumentException("New title is not correct");

        mTitle = title;

        // Update the timestamp of the file
        updateTimestamp();
    }

    /**
     * Get the title
     * @return the title
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Update the timestamp of access to the file
     */
    public void updateTimestamp() {
        mTimestamp = new Date();
    }
}
