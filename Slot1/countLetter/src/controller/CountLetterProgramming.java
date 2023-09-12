package controller;

import model.Element;
import util.Library;
import util.Algorithm;
import view.Menu;

public class CountLetterProgramming extends Menu<String> {

    static String[] menuChoice = {"Count Letter and Character", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected Element element;

    public CountLetterProgramming(Element element1) {
        super("PROGRAMMING", menuChoice);
        library = new Library();
        algorithm = new Algorithm();
        element = element1;
        
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                countLAndC(element.input);
                break;
            case 2:
                System.exit(0);
        }
    }
    public void countLAndC(String str){
        algorithm.output(str);
    }
}
