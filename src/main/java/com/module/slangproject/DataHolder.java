package com.module.slangproject;

import java.util.List;
import java.util.Set;

public class DataHolder {
    private String sw;
    private Set<String> def;
    private static DataHolder holder = null;
    public static DataHolder getInstance() {
        if(holder == null)
            holder = new DataHolder();
        return holder;
    }
    public void setData(String sw,Set<String> def) {
        this.sw = sw;
        this.def = def;
    }
    public String getSlangWord() {
        return this.sw;
    }
    public Set<String> getDefinitions(){
        return this.def;
    }
}
