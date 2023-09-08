package controller;

import model.Element;
import util.Library;
import util.SearchAlgorithm;
import view.Menu;

public class SearchProgramming extends Menu<String> {

    static String[] menuChoice = {"Search", "Exit"};

    protected Library library;
    protected SearchAlgorithm algorithm;
    protected int[] array;
    protected int size_array;

    public SearchProgramming(Element element) {
        super("PROGRAMMING", menuChoice);
        library = new Library();
        algorithm = new SearchAlgorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                search();
                break;
            case 2:
                System.exit(0);
        }
    }

    public void search() {
        final String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("Search Option", mcSearch);
            }

            @Override
            public void execute(int n) {
                int value;
                int index ;
                switch (n) {
                    case 1 -> {
                        value = library.getInt("Enter your value you want to search :");
                        algorithm.buddleSort(array);
                        System.out.println("\nSorted array by Buddle Sort: ");
                        library.display(array);
                        index = algorithm.linearSearch(array, value);
                        if (index == -1) {
                            System.out.println("The value " + value + " not found");
                        } else {
                            System.out.println("Found " + value + " at index : " + index);

                        }
                        System.out.println("");
                    }
                    case 2 -> {
                        value = library.getInt("Enter your value you want to search :");
                        algorithm.buddleSort(array);
                        System.out.println("\nSorted array by Buddle Sort: ");
                        library.display(array);
                        index = algorithm.linearSearch(array, value);
                        if (index == -1) {
                            System.out.println("The value " + value + " not found");
                        } else {
                            System.out.println("Found " + value + " at index : " + index);

                        }
                        System.out.println("");
                    }
                    case 3 -> System.exit(0);
                }
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
    }
}
