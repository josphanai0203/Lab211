package util;

import java.util.Scanner;

public class Library {
    private static Scanner inputScanner = new Scanner(System.in);

    public static float getFloatInput(String prompt) {
        float value = 0;
        boolean valid = false;
        do {
            System.out.print(prompt);
            if (inputScanner.hasNextFloat()) {
                value = inputScanner.nextFloat();
                valid = true;
            } else {
                inputScanner.next(); 
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!valid);
        return value;
    }
}
