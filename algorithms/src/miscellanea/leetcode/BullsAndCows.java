package miscellanea.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> secretMap = convertToMapSavingRecurringElements(secret);
        Map<Character, Integer> guessMap = new HashMap<>();
        char[] guessChars = guess.toCharArray();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guessChars.length; i++) {
            char currentGuessChar = guessChars[i];
            Set<Integer> positions = secretMap.get(currentGuessChar);
            if (positions != null) {
                int numberOfGuessCharacter = updateGuessMap(guessMap, currentGuessChar);
                if (positions.contains(i)) {
                    bulls++;
                    if (numberOfGuessCharacter >= positions.size()) {
                        cows--;
                    }
                } else if (numberOfGuessCharacter < positions.size()) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    private int updateGuessMap(Map<Character, Integer> guessMap, char guessChar) {
        int numberOfGuessChar = guessMap.getOrDefault(guessChar, 0);
        Integer lastValue = guessMap.put(guessChar, ++numberOfGuessChar);
        return lastValue != null ? lastValue : 0;
    }

    private Map<Character, Set<Integer>> convertToMapSavingRecurringElements(String secret) {
        final Map<Character, Set<Integer>> result = new HashMap<>();
        char[] input = secret.toCharArray();
        for (int i = 0; i < input.length; i++) {
            char element = input[i];
            Set<Integer> existingEntryValue = result.getOrDefault(element, new HashSet<>());
            final boolean wasEmpty = existingEntryValue.isEmpty();
            existingEntryValue.add(i);
            if (wasEmpty) {
                result.put(element, existingEntryValue);
            }
        }
        return result;
    }
}
