
package util;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;


public class Library {
    static Scanner sc = new Scanner(System.in);
    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }
    public int getInt(String promt) {
        Integer a = null;
    
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
               if(a != null){
                   break;
               }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number" );
            }
        }
        return a;
    }
    public int getId(String promt,Predicate<Integer> p,String fiterString){
        Integer a = null;
    
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
               if(a != null){
                   if(p.test(a)){
                       break;
                   }else{
                       System.out.println(fiterString);
                   }
               }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number" );
            }
        }
        return a;
    }
    public String getString(String promt){
        String result ="";
        while (true) {
            System.out.print(promt + ": ");
            try {
               result  = sc.nextLine().trim();
                
               if(!result.isEmpty()){
                   break;
               }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a String" );
            }
        }
        return result;
        
    }
    public int[] createArray(int size_Array) {
        int[] array = new int[size_Array];
        Random rd = new Random();
        for (int i = 0; i < size_Array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }
    public void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }

}
