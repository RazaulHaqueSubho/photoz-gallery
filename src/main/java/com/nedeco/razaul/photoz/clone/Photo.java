package com.nedeco.razaul.photoz.clone;

public class Photo {
    public Photo() {
    }

    public Photo(String fileName, String id) {
        this.fileName = fileName;
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String fileName;
    public String id;
    //raw data


}
