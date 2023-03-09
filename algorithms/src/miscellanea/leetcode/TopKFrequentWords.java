package miscellanea.leetcode;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> frequency = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int frequencyDiff = o2.getValue() - o1.getValue();
            return frequencyDiff == 0 ? o1.getKey().compareTo(o2.getKey()) : frequencyDiff;
        });
        for (String word : words) {
            Integer currentFrequency = frequency.getOrDefault(word, 0);
            currentFrequency++;
            frequency.put(word, currentFrequency);
        }
        priorityQueue.addAll(frequency.entrySet());
        String distinctWord = "";
        while (!priorityQueue.isEmpty() && answer.size() < k) {
            String currentWord = priorityQueue.poll().getKey();
            if (!distinctWord.equals(currentWord)) {
                answer.add(currentWord);
                distinctWord = currentWord;
            }
        }
        return answer;
    }
}
