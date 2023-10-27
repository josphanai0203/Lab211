package model;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryModel {
    private HashMap<String, String> dictionary;
    private static final String DATA_FILE = "\\src\\data\\D1.txt";
    private final String BASE_PATH = new File("").getAbsolutePath();

    public DictionaryModel() {
        dictionary = loadData();
    }

    private HashMap<String, String> loadData() {
        HashMap<String, String> loadedData = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(BASE_PATH+DATA_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    loadedData.put(parts[0], parts[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return loadedData;
    }

    public boolean addWord(String eng, String vi) {
        dictionary.put(eng, vi);
        if (updateData()) {
            return true;
        }
        return false;
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            if (updateData()) {
                return true;
            }
        }
        return false;
    }

    public String translate(String eng) {
        return dictionary.getOrDefault(eng, "Word not found in the dictionary.");
    }

    private boolean updateData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (HashMap.Entry<String, String> entry : dictionary.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
