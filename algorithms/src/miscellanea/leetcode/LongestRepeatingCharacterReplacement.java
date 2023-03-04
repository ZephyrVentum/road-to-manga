package miscellanea.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("BAXXXAZAAZZAAXX", 2));
    }

    public int characterReplacement(String s, int k) {
        Map<Character, LinkedList<Integer>> sMap = new HashMap<>();
        int max = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char currentChar = sChars[i];
            LinkedList<Integer> charIndices = sMap.getOrDefault(currentChar, new LinkedList<>());
            if (!charIndices.isEmpty()) {
                int remainingK = getRemainingK(charIndices, k);
                int lastIndex = charIndices.getLast();
                int newRemainingK = remainingK - (i - (lastIndex + 1));
                if (newRemainingK >= 0) {
                    int newMax = newRemainingK + (i - (charIndices.getFirst() - 1));
                    max = Math.max(newMax, max);
                    charIndices.add(i);
                } else {
                    charIndices.removeFirst();
                    i--;
                }
            } else {
                int newMax = k + 1;
                max = Math.max(newMax, max);
                charIndices.add(i);
            }
            sMap.put(currentChar, charIndices);
        }
        return Math.min(max, s.length());
    }

    int getRemainingK(LinkedList<Integer> charIndices, int k) {
        int usedK = 0;
        if (charIndices.size() > 1) {
            int pivot = charIndices.peek() - 1;
            for (int index : charIndices) {
                int difference = index - (pivot + 1);
                usedK += difference;
                pivot = index;
            }
        }
        return k - usedK;
    }
}
