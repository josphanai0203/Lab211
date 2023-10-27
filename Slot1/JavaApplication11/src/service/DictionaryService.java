package service;

import java.util.HashMap;

public class DictionaryService {
    private HashMap<String, String> dictionary;

    public DictionaryService(HashMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean addWord(String eng, String vi) {
        if (!dictionary.containsKey(eng)) {
            dictionary.put(eng, vi);
            return true;
        }
        return false;
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            return true;
        }
        return false;
    }

    public String translate(String eng) {
        return dictionary.getOrDefault(eng, "Word not found in the dictionary.");
    }
}
