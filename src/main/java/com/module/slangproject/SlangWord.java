package com.module.slangproject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SlangWord {
    private TreeMap<String, Set<String>> slangWords;

    public SlangWord() {
        this.slangWords = new TreeMap<String, Set<String>>();
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
                    String slang = parts[0];
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

    public Set<String> getMeaningsOfSlangWord(String slang) {
        return getDefinitions(slang);
    }




}
