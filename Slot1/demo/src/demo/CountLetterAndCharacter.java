package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountLetterAndCharacter {

    public void input() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content : ");
        String input = scanner.nextLine().trim();
        output(input);
    }

    public void output(String str) {
        System.out.println(handleCountLetter(str));
        System.out.println(handleCountCharacter(str));
    }

    public String handleCountLetter(String str) {
        Map<String, Integer> letterMap = new HashMap<>();
        StringTokenizer strArr = new StringTokenizer(str, " ,.");
        while (strArr.hasMoreTokens()) {
            String current = strArr.nextToken();
            letterMap.put(current, letterMap.get(current) != null ? letterMap.get(current) + 1 : 1);

        }
       
        return letterMap.toString();
    }

    public String handleCountCharacter(String str) {
        Map<String, Integer> characterMap = new HashMap<>();
        StringTokenizer strArr = new StringTokenizer(str, " ,.");
        while(strArr.hasMoreTokens()){
            String letterCurrent = strArr.nextToken();
            String[] characterArr = letterCurrent.split("");
            for(String s : characterArr){
                characterMap.put(s, characterMap.get(s) != null ? characterMap.get(s) + 1 : 1);
            }
        }
        return characterMap.toString();
    }
}
