package controller;

import model.DictionaryModel;
import view.Menu;

public class DictionaryController extends Menu {
    private DictionaryModel model;

    public DictionaryController(DictionaryModel model) {
        this.model = model;
    }

    public void start() {
        int choice;
        do {
            choice = showMainMenu();  
            switch (choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    deleteWord();
                    break;
                case 3:
                    translateWord();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    invalidChoice();
            }
        } while (choice != 4);
    }

    private void addWord() {
        String eng = getEnglishWordFromUser();
        String vi = getVietnameseWordFromUser();
        boolean success = model.addWord(eng, vi);
        showResultMessage(success);
    }

    private void deleteWord() {
        String eng = getEnglishWordFromUser();
        boolean success = model.removeWord(eng);
        showResultMessage(success);
    }

    private void translateWord() {
        String eng = getEnglishWordFromUser();
        String translation = model.translate(eng);
        showTranslation(eng, translation);
    }
}
