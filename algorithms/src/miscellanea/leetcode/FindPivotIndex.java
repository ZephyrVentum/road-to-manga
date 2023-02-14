package miscellanea.leetcode;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(new FindPivotIndex().pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int answer = -1;

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        int leftSideSum = 0;
        int rightSideSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int rightSideIndex = nums.length - 1 - i;
            leftSideSum += nums[i];
            rightSideSum += nums[rightSideIndex];
            leftSum[i] = leftSideSum;
            rightSum[i] = rightSideSum;
        }

        for (int i = 0; i < nums.length; i++) {
            int rightSideIndex = nums.length - 1 - i;
            if (leftSum[i] == rightSum[rightSideIndex]) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
