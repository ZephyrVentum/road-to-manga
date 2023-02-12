package miscellanea.leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,3,1,4,5,6}));
    }

    public boolean containsDuplicate(int[] nums) {
        boolean answer = false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                answer = true;
                break;
            } else {
                set.add(num);
            }
        }
        return answer;
    }
}
