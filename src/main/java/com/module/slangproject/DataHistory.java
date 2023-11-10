package com.module.slangproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class DataHistory {
    private ArrayList<String> history;
    private static DataHistory datahistory = null;
    public static DataHistory getInstance() {
        if(datahistory == null)
            datahistory = new DataHistory();
        return datahistory;
    }

    public static void getDataFromFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        datahistory.history = lines;
    }

    public ArrayList<String> getHistory(){
        return this.history;
    }
    public void addData(String sw) {
        this.history.add(sw);
    }
}
