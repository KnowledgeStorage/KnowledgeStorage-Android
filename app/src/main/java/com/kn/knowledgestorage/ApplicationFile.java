package com.kn.knowledgestorage;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Application file - is a superclass for every file inside of the app. It contains the logic every
 * file has and helps to maintain clean code without doubling it in derived classes.
 */
public class ApplicationFile implements Parcelable, Serializable {
    protected String mTitle;
    protected Date mTimestamp;

    /**
     * Parcelable object dedicated to creation of easy-to-process objects out of given
     */
    public static final Parcelable.Creator<ApplicationFile> CREATOR = new Parcelable.Creator<ApplicationFile>() {
        public ApplicationFile createFromParcel(Parcel in) {
            return new ApplicationFile(in);
        }

        public ApplicationFile[] newArray(int size) {
            return new ApplicationFile[size];
        }
    };

    /**
     * Constructor
     */
    public ApplicationFile() {

    }

    /**
     * Constructor
     * @param parcel parcel object to restore data from
     */
    public ApplicationFile(Parcel parcel) {
        readFromParcel(parcel);
    }

    /**
     * Set a new title of the file
     * @param title new title
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

    /**
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Write data to the dedicated object
     * @param parcel object which holds the data
     * @param flags special flags
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mTitle);
        parcel.writeSerializable(mTimestamp);
    }

    /**
     * Read data from the Parcel object
     * @param parcel object to read data from
     */
    @SuppressWarnings("unchecked")
    protected void readFromParcel(Parcel parcel) {
        mTitle = parcel.readString();
        mTimestamp = (java.util.Date) parcel.readSerializable();
    }
}
