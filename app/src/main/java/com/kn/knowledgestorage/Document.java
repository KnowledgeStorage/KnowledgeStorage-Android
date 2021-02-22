package com.kn.knowledgestorage;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Vector;

public class Document extends ApplicationFile implements Parcelable, Serializable {
    protected Vector<String> mContent = new Vector<>();

    /**
     * Parcelable object dedicated to creation of easy-to-process objects out of given
     */
    public static final Parcelable.Creator<Document> CREATOR = new Parcelable.Creator<Document>() {
        public Document createFromParcel(Parcel in) {
            return new Document(in);
        }

        public Document[] newArray(int size) {
            return new Document[size];
        }
    };

    /**
     * Constructor
     */
    Document(){

    }

    /**
     * Constructor
     * @param parcel parcel object to restore data from
     */
    public Document(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override
    protected void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);

        mContent = (Vector<String>) parcel.readSerializable();
    }

    /**
     *
     * @param parcel
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        super.readFromParcel(parcel);

        parcel.writeSerializable(mContent);
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    /**
     * Get element with a given index
     * @param index index of an element to get
     * @return the element
     */
    public String getContentString(int index) {
        if (index < 0 || mContent.size() < index)
            throw new IllegalArgumentException("Index is out of range");

        return mContent.get(index);
    }

    /**
     * Remove element with a given index
     * @param string the element to remove
     */
    public void removeContentString(String string) {
        if (string.equals("") || string == null)
            throw new IllegalArgumentException("String is not correct");

        mContent.remove(string);

        // Update the timestamp of the file
        updateTimestamp();
    }

    /**
     * Replace the element with a new one
     * @param string the new element
     * @param index an index of the file to replace
     */
    public void replaceContentString(String string, int index) {
        if (string.equals("") || string == null)
            throw new IllegalArgumentException("String is not correct");

        if (index < 0 || mContent.size() < index)
            throw new IllegalArgumentException("Index is out of range");

        mContent.insertElementAt(string, index);

        // Update the timestamp of the file
        updateTimestamp();
    }
}
