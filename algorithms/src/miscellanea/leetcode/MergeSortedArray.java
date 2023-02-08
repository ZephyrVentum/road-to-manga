package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{5, 7, 8, 9, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{1, 6, 6, 8, 9};
        new MergeSortedArray().merge(nums1, 4, nums2, nums2.length);

        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> toBeMerged = new ArrayList<>();
        int nums2Iterator = 0;
        for (int i = 0; i < m; i++) {
            if (!toBeMerged.isEmpty() && toBeMerged.get(0) < nums1[i]) {
                toBeMerged.add(nums1[i]);
                nums1[i] = toBeMerged.get(0);
                toBeMerged.remove(0);
            }
            if (nums2Iterator < nums2.length && nums1[i] > nums2[nums2Iterator]) {
                toBeMerged.add(0, nums1[i]);
                nums1[i] = nums2[nums2Iterator++];
            }
        }
        for (int i = m; i < m + n; i++) {
            System.out.println(nums1[i]);
            if (!toBeMerged.isEmpty()) {
                if (nums2Iterator < n) {
                    if (toBeMerged.get(0) <= nums2[nums2Iterator]) {
                        nums1[i] = toBeMerged.get(0);
                        toBeMerged.remove(0);
                    } else {
                        nums1[i] = nums2[nums2Iterator++];
                    }
                } else {
                    nums1[i] = toBeMerged.get(0);
                    toBeMerged.remove(0);
                }
            } else if (nums2Iterator < n) {
                nums1[i] = nums2[nums2Iterator++];
            }
        }

    }
}
