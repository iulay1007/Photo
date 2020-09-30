package com.example.photo;

import java.io.Serializable;

public class ImageBean  {
    private String path;
    private long date ;

    public ImageBean(String path, long date) {
        this.path = path;
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getDate() {
        return date;
    }



    public void setDate(long date) {

        this.date = date;
    }
    @Override
    public String toString() {
        return "ImageBean{" +
                "path='" + path + '\'' +
                ", date=" + date +
                '}';
    }
}
