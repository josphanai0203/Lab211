package view;

import controller.DictionaryController;
import model.DictionaryModel;

public class Main {
    public static void main(String[] args) {
        DictionaryModel model = new DictionaryModel();
        DictionaryController controller = new DictionaryController(model);
        controller.start();
    }
}
