package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        for (Integer answer : new FindAllAnagramsInAString().findAnagrams("abacbabc", "abc")) {
            System.out.println(answer);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> defaultPMap = getPMap(p);
        Map<Character, Integer> pMap = new HashMap<>(defaultPMap);
        char[] sChars = s.toCharArray();
        int anchor = 0;
        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            Integer remainingSChars = pMap.get(sChar);
            if (remainingSChars != null) {
                if (remainingSChars > 0) {
                    anchor++;
                    updatePMap(pMap, sChar, false);
                    if (anchor >= p.length()) {
                        answer.add(i - (p.length() - 1));
                    }
                } else if (anchor > 0) {
                    char lastChar = sChars[i - anchor];
                    updatePMap(pMap, lastChar, true);
                    anchor--;
                    i--;
                }
            } else {
                anchor = 0;
                pMap = new HashMap<>(defaultPMap);
            }
        }
        return answer;
    }

    private Map<Character, Integer> getPMap(String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        char[] pChars = p.toCharArray();
        for (char pChar : pChars) {
            int numberOfChar = pMap.getOrDefault(pChar, 0);
            pMap.put(pChar, ++numberOfChar);
        }
        return pMap;
    }

    private void updatePMap(Map<Character, Integer> pMap, char sChar, boolean isAdd) {
        int numberOfPChars = pMap.getOrDefault(sChar, 0);
        pMap.put(sChar, isAdd ? ++numberOfPChars : --numberOfPChars);
    }
}
