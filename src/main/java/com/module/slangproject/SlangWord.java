package com.module.slangproject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SlangWord {
    private TreeMap<String, Set<String>> slangWords;
    private static SlangWord instance = null;
    public SlangWord() {
        this.slangWords = new TreeMap<String, Set<String>>();
    }

    public static SlangWord getInstance() {
        if (instance == null) {
            instance = new SlangWord();
        }
        return instance;
    }

    public void addSlangWord(String slang, Set<String> definitions) {
        this.slangWords.put(slang, definitions);
    }

    public Set<String> getDefinitions(String slang) {
        return this.slangWords.get(slang);
    }

    public void loadSlangWordsFromFile(String filePath) {
        try {
            Files.lines(Paths.get(filePath)).forEach(line -> {
                String[] parts = line.split("`");
                if (parts.length == 2) { //Make sure datalines have 2 parts': word and meaning
                    String slang = parts[0].trim();
                    Set<String> meanings = new TreeSet<>();
                    for (String meaning : parts[1].split("\\|")) {
                        meanings.add(meaning.trim());
                    }
                    addSlangWord(slang, meanings);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isWordExist(String slang) {
        return this.slangWords.containsKey(slang);
    }

    public Set<String> getSlangWordsWithDefinition(String definition) {
        Set<String> result = new HashSet<String>();
        for (Map.Entry<String, Set<String>> entry : this.slangWords.entrySet()) {
            for (String def : entry.getValue()) {
                if (def.toLowerCase().contains(definition.toLowerCase())) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }
        return result;
    }

    public void overwriteValue(String key, Set<String> newValue) {
        if (slangWords.containsKey(key)) {
            slangWords.put(key, newValue);
        } else {
            System.out.println("Key not found in the TreeMap.");
        }
    }

    public void printFirstTwenty() {
        int count = 0;
        for (Map.Entry<String, Set<String>> entry : this.slangWords.entrySet()) {
            System.out.println("Slang: " + entry.getKey() + ", Definitions: " + entry.getValue());
            count++;
            if (count >= 20) {
                break;
            }
        }
    }



}
