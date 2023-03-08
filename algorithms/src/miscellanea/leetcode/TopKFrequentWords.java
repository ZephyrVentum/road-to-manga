package miscellanea.leetcode;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> frequency = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (String word : words) {
            Integer currentFrequency = frequency.getOrDefault(word, 0);
            currentFrequency++;
            frequency.put(word, currentFrequency);
            priorityQueue.add(word);
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
        return answer;
    }
}
