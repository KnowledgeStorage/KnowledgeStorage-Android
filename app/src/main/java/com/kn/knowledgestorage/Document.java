package com.kn.knowledgestorage;

import java.util.Vector;

public class Document extends ApplicationFile {
    protected Vector<String> mContent = new Vector<>();

    /**
     * Constructor
     */
    Document(){

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
