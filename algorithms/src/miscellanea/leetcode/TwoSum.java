package miscellanea.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 12, 0, 13, 12, 1, 4};
        for (int i : twoSum(nums, 5)) {
            System.out.println(i);
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
}
