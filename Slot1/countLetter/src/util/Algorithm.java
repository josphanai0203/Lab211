package util;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Algorithm {

    public int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int linearSearch(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void buddleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
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
