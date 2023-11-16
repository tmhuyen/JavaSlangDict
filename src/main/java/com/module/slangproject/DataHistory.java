package com.module.slangproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class DataHistory {
    private ArrayList<String> history = new ArrayList<>();
    private static DataHistory datahistory = null;
    public static DataHistory getInstance() {
        if(datahistory == null)
            datahistory = new DataHistory();
        return datahistory;
    }
    public static DataHistory empty(){
        datahistory = new DataHistory();
        return datahistory;
    }
    public static void getDataFromFile() {
        String filename = "data/history.txt";
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
    public void addHistory(String s){
        this.history.add(s);
    }
    public void writeToFile() {
        try (FileWriter writer = new FileWriter("data/history.txt")) {
            for (String str : this.history) {
                writer.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
