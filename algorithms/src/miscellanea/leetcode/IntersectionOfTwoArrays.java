package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] result = new IntersectionOfTwoArrays().intersection(new int[]{4, 9, 5, 0}, new int[]{9, 4, 9, 8, 4, 1});
        for (int number : result) {
            System.out.println(number);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length; i++) {
            int currentI = nums1[i];
            boolean isIntersection = false;
            while (j < nums2.length && nums2[j] <= currentI) {
                isIntersection |= currentI == nums2[j++];
            }
            if (isIntersection) {
                result.add(currentI);
            }
        }
        final int[] out = new int[result.size()];
        Arrays.setAll(out, result::get);
        return out;
    }
}
