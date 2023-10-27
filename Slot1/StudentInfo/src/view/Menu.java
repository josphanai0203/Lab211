package view;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("====== Collection Sort Program ======");
        System.out.println("1. Enter student information");
        System.out.println("2. Display student information");
        System.out.println("3. Exit");
    }

    public int getUserChoice(int min, int max) {
        int choice;
        do {
            System.out.print("Please enter your choice: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < min || choice > max);
        return choice;
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public boolean askYesNoQuestion(String question) {
        char response;
        do {
            System.out.print(question);
            response = scanner.next().toUpperCase().charAt(0);
        } while (response != 'Y' && response != 'N');
        return response == 'Y';
    }
}
