package com.module.slangproject;

public class DataHolder {
    private String data;
    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() { return holder; }
    public void setData(String data) { this.data = data; }
    public String getData() { return data; }
}
