package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IntersectionOfMultipleArrays {
    public static void main(String[] args) {
        List<Integer> result = new IntersectionOfMultipleArrays().intersection(new int[][]{
                        new int[]{7, 34, 45, 10, 12, 27, 13},
                        new int[]{27, 21, 45, 10, 12, 13}
                }
        );
        for (int number : result) {
            System.out.println(number);
        }
    }

    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int[] num : nums) {
            for (int i : num) {
                priorityQueue.add(i);
            }
        }
        int counter = 0;
        int target = -1;
        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll();
            if (current == target) {
                counter++;
            } else {
                target = current;
                counter = 1;
            }
            if (counter == nums.length) {
                result.add(current);
            }
        }
        return result;
    }
}
