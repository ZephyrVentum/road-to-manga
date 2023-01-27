package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -3, 2, 0, 3, 1, 5, -1, 7};
        for (List<Integer> i : twoSumAll(nums,0, 4)) {
            System.out.print("[");
            for (int j : i) {
                System.out.print(" " + j + " ");
            }
            System.out.println("]");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> addons = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (addons.get(current) != null) {
                return new int[]{addons.get(current), i};
            } else {
                addons.put(target - current, i);
            }
        }
        return new int[]{};
    }

    public static List<List<Integer>> twoSumAll(int[] nums, int from, int target) {
        final Map<Integer, Integer> addons = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = from; i < nums.length; i++) {
            int current = nums[i];
            if (addons.get(current) != null) {
                ArrayList<Integer> twoSum = new ArrayList<>();
                twoSum.add(nums[addons.get(current)]);
                twoSum.add(nums[i]);
                result.add(twoSum);
            } else {
                addons.put(target - current, i);
            }
        }
        return result;
    }
}
