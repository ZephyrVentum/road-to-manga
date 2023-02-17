package miscellanea.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("aabccccddeee"));
    }

    public int longestPalindrome(String s) {
        int answer = 0;
        Map<Character, Integer> charsCounter = new HashMap<>();
        fillCharCounter(charsCounter, s);
        answer += findCharWithMaxOddCount(charsCounter);
        answer += findAllCharsWithEvenCount(charsCounter);
        answer += findOtherCharsWithOddCount(charsCounter);
        return answer;
    }

    //find remaining chars which odd number and take only even part of them
    // the odd part is redundant for final palindrome
    private int findOtherCharsWithOddCount(Map<Character, Integer> charsCounter){
        int numberOfRemainingOddChars = 0;
        for (Map.Entry<Character, Integer> entry : charsCounter.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 1){
                numberOfRemainingOddChars += value-1;
            }
        }
        return numberOfRemainingOddChars;
    }

    //Find and get the number of even chars
    private int findAllCharsWithEvenCount(Map<Character, Integer> charsCounter){
        int numberOfEvenChars = 0;
        Iterator<Map.Entry<Character, Integer>> it = charsCounter.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            char key = entry.getKey();
            int value = entry.getValue();
            if (value % 2 == 0) {
                numberOfEvenChars += value;
                it.remove();
            }
        }
        return numberOfEvenChars;
    }

    //find char with maximum times of occurrence in s
    //get its count and remove from the map
    //it would be the middle of palindrome
    private int findCharWithMaxOddCount(Map<Character, Integer> charsCounter) {
        int max = 0;
        char charToRemove = '?';
        for (Map.Entry<Character, Integer> entry : charsCounter.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value % 2 == 1 && value > max){
                max = value;
                charToRemove = key;
            }
        }
        charsCounter.remove(charToRemove);
        return max;
    }

    //fill the hash map with chars of s preserving the number of repeating chars.
    private void fillCharCounter(Map<Character, Integer> charsCounter, String s) {
        for (char symbol : s.toCharArray()) {
            Integer lastCountOfChar = charsCounter.get(symbol);
            if (lastCountOfChar != null) {
                charsCounter.put(symbol, ++lastCountOfChar);
            } else {
                charsCounter.put(symbol, 1);
            }
        }
    }

}
