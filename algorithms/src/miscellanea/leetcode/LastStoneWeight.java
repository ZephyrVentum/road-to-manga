package miscellanea.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }
        while (heap.size() > 1) {
            int firstStone = heap.poll();
            int secondStone = heap.poll();
            int difference = firstStone - secondStone;
            if (difference != 0) {
                heap.add(difference);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
