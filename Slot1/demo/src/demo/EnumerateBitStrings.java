
package demo;

import java.util.Scanner;

public class EnumerateBitStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        enumerateBitStrings(n);
    }
    public static void enumerateBitStrings(int n){
        int maxCombinations = (int)Math.pow(2, n);
        String bitString = "";
        for(int i =0;i<maxCombinations;i++){
            bitString = Integer.toBinaryString(i);
            while (bitString.length() <n) {                
                bitString = "0"+ bitString;
            }
            System.out.println(bitString);
        }
    }
}
