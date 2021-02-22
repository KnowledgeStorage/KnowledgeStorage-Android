package com.kn.knowledgestorage;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Vector;

/**
 * The class is dedicated to holding data about documents and other directories. Directory class
 * was created to maintain a simple hierarchy of documents in the app. It can store files and remove
 * them.
 */
public class Directory extends ApplicationFile implements Serializable, Parcelable {
    protected Vector<ApplicationFile> mFileVector = new Vector<>();        //

    /**
     * Parcelable object dedicated to creation of easy-to-process objects out of given
     */
    public static final Parcelable.Creator<Directory> CREATOR = new Parcelable.Creator<Directory>() {
        public Directory createFromParcel(Parcel in) {
            return new Directory(in);
        }

        public Directory[] newArray(int size) {
            return new Directory[size];
        }
    };

    /**
     * Constructor
     */
    public Directory() {
        super();
    }

    /**
     * Constructor
     * @param parcel
     */
    public Directory(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override
    protected void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);

        mFileVector = (Vector<ApplicationFile>) parcel.readSerializable();
    }

    /**
     *
     * @param parcel
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        super.readFromParcel(parcel);

        parcel.writeSerializable(mFileVector);
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
