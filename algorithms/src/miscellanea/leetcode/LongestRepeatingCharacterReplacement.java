package miscellanea.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("BAXXXAZAAZZAAXX", 2));
    }

    static class MetaChar {
        public MetaChar(int remainingK, int fromIndex, int toIndex) {
            this.remainingK = remainingK;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        public int remainingK;
        public int fromIndex;
        public int toIndex;
    }

    public int characterReplacement(String s, int k) {
        Map<Character, MetaChar> sMap = new HashMap<>();
        int max = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char currentChar = sChars[i];
            if (currentChar == 'S'){
                System.out.println("kek");
            }
            MetaChar metaChar = sMap.getOrDefault(currentChar, new MetaChar(k, i - 1, i - 1));
            int newRemainingK = metaChar.remainingK - (i - (metaChar.toIndex + 1));
            if (newRemainingK >= 0) {
                int newMax = newRemainingK + (i - metaChar.fromIndex);
                max = Math.max(newMax, max);
                metaChar.remainingK = newRemainingK;
            } else {
                metaChar.remainingK = k;
                metaChar.fromIndex = i - 1;
            }
            metaChar.toIndex = i;
            sMap.put(currentChar, metaChar);
        }
        return Math.min(max, s.length());
    }
}
