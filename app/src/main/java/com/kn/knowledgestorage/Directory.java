package com.kn.knowledgestorage;

import java.util.Vector;

/**
 * The class is dedicated to holding data about documents and other directories. Directory class
 * was created to maintain a simple hierarchy of documents in the app. It can store files and remove
 * them.
 */
public class Directory extends ApplicationFile {
    protected Vector<ApplicationFile> mFileVector = new Vector<>();        //

    /**
     * Constructor
     */
    public Directory() {
        super();
    }

    /**
     * Add file to the vector of files
     * @param fileObject new file to add
     */
    public void addFile(ApplicationFile fileObject) {
        if (fileObject == null)
            throw new NullPointerException("File object is null");

        mFileVector.add(fileObject);
    }

    /**
     * Remove a file from the vector
     * @param fileObject file to remove
     */
    public void removeFile(ApplicationFile fileObject) {
        if (fileObject == null)
            throw new NullPointerException("File object is null");

        mFileVector.remove(fileObject);
    }
}
