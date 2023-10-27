package view;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("======== Dictionary program ========");
        System.out.println("1. Add Word");
        System.out.println("2. Delete Word");
        System.out.println("3. Translate");
        System.out.println("4. Exit");
        return getIntInput("Select an option: ");
    }

    public String getEnglishWordFromUser() {
        return getStringInput("Enter English: ");
    }

    public String getVietnameseWordFromUser() {
        return getStringInput("Enter Vietnamese: ");
    }

    public void showResultMessage(boolean success) {
        if (success) {
            System.out.println("Successful");
        } else {
            System.out.println("Operation failed");
        }
    }

    public void showTranslation(String eng, String translation) {
        System.out.println("English: " + eng);
        System.out.println("Vietnamese: " + translation);
    }

    public void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public void invalidChoice() {
        System.out.println("Invalid choice. Please try again.");
    }

    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
