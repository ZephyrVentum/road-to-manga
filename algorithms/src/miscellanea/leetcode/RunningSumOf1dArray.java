package miscellanea.leetcode;

public class RunningSumOf1dArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        for (int i : new RunningSumOf1dArray().runningSum(nums)) {
            System.out.println(i);
        }
    }

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                result[i] = nums[i];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }
        return result;
    }
}
