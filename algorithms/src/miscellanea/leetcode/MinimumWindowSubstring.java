package miscellanea.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = convertToMapSavingRecurringElements(t);
        Map<Character, Queue<Integer>> tUsageMap = new HashMap<>();
        LinkedList<Integer> answer = new LinkedList<>();
        LinkedList<Integer> window = new LinkedList<>();
        char[] sChars = s.toCharArray();
        for (int indexOfCurrentChar = 0; indexOfCurrentChar < sChars.length; indexOfCurrentChar++) {
            char currentChar = sChars[indexOfCurrentChar];
            Integer numberOfExistingChars = tMap.getOrDefault(currentChar, -1);
            if (numberOfExistingChars != -1) {
                if (numberOfExistingChars == 0) {
                    int firstUsageOfCurrentChar = tUsageMap.get(currentChar).poll();
                    while (!window.isEmpty() && window.peek() <= firstUsageOfCurrentChar) {
                        int indexOfCharToRestore = window.poll();
                        char charToRestore = sChars[indexOfCharToRestore];
                        tUsageMap.get(charToRestore).poll();
                        int numberOfRemainingChars = tMap.get(charToRestore);
                        numberOfRemainingChars++;
                        tMap.put(charToRestore, numberOfRemainingChars);
                    }
                    int numberOfRemainingChars = tMap.get(currentChar);
                    numberOfRemainingChars--;
                    tMap.put(currentChar, numberOfRemainingChars);
                    tUsageMap.get(currentChar).add(indexOfCurrentChar);
                } else {
                    Queue<Integer> currentCharIndexes = tUsageMap.getOrDefault(currentChar, new LinkedList<>());
                    currentCharIndexes.add(indexOfCurrentChar);
                    tUsageMap.put(currentChar, currentCharIndexes);
                    int numberOfRemainingChars = tMap.get(currentChar);
                    numberOfRemainingChars--;
                    tMap.put(currentChar, numberOfRemainingChars);
                }
                window.add(indexOfCurrentChar);
                updateAnswerIfNeed(window, answer, t);
            }
        }
        return answer.size() == t.length() ? s.substring(answer.getFirst(), answer.getLast() + 1) : "";
    }

    void updateAnswerIfNeed(LinkedList<Integer> window, LinkedList<Integer> answer, String t) {
        if (window.size() == t.length()) {
            if (!answer.isEmpty()) {
                int startOfAnswer = answer.getFirst();
                int endOfAnswer = answer.getLast();
                int lengthOfAnswer = endOfAnswer - startOfAnswer;

                int startOfWindow = window.getFirst();
                int endOfWindow = window.getLast();
                int lengthOfWindow = endOfWindow - startOfWindow;

                if (lengthOfWindow < lengthOfAnswer) {
                    answer.clear();
                    answer.addAll(window);
                }
            } else {
                answer.addAll(window);
            }
        }
    }

    private static Map<Character, Integer> convertToMapSavingRecurringElements(String t) {
        char[] input = t.toCharArray();
        Map<Character, Integer> result = new HashMap<>();
        for (char currentChar : input) {
            Integer existingEntryValue = result.getOrDefault(currentChar, 0);
            existingEntryValue++;
            result.put(currentChar, existingEntryValue);
        }
        return result;
    }

//    private Map<Character, Queue<Integer>> convertToMapSavingRecurringElements(String t) {
//        final Map<Character, Queue<Integer>> result = new HashMap<>();
//        char[] input = t.toCharArray();
//        for (int i = 0; i < input.length; i++) {
//            char element = input[i];
//            Queue<Integer> existingEntryValue = result.getOrDefault(element, new LinkedList<>());
//            final boolean wasEmpty = existingEntryValue.isEmpty();
//            existingEntryValue.add(i);
//            if (wasEmpty) {
//                result.put(element, existingEntryValue);
//            }
//        }
//        return result;
//    }
}
